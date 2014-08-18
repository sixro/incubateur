package csv2xls;

import au.com.bytecode.opencsv.CSVReader;
import csv2xls.cli.CommandLine;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFName;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.AreaReference;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class Csv2Xls {

    public static final String LAUNCHER = System.getProperty("application.launcher", "java -jar csv2xls.jar");
    public static final String UNKNOWN_VERSION = "?.?";

    private final Settings settings;

    public Csv2Xls(Settings settings) {
        this.settings = settings;
    }

    public void run() {
        System.out.println("Settings: " + settings);

        File tempFile = newTemporaryFileFromTemplate(settings.getXlsTemplateFile());

        FileInputStream in = null;
        FileOutputStream out = null;
        Map<String, org.apache.poi.ss.util.CellReference> cellrefs = new LinkedHashMap<>();
        try {
            in = new FileInputStream(tempFile);
            HSSFWorkbook workBook = new HSSFWorkbook(in);
            HSSFSheet sheet = workBook.getSheetAt(settings.getSheetIndex());

            File[] inputs = settings.getInputs();
            for (File input : inputs) {
                CSVReader reader = new CSVReader(new FileReader(input));
                String[] fields = null;
                String[] headers = null;
                int row = 0;
                while ((fields = reader.readNext()) != null) {
                    if (headers == null) {
                        headers = fields;

                        for (int i = 0; i < headers.length; i++) {
                            String header = headers[i];
                            System.out.println("header: " + header);

                            int nameIndex = workBook.getNameIndex(header);
                            HSSFName name = workBook.getNameAt(nameIndex);
                            AreaReference aref = new AreaReference(name.getRefersToFormula());
                            org.apache.poi.ss.util.CellReference crefs = aref.getAllReferencedCells()[0];
                            cellrefs.put(header, crefs);
                        }

                        continue;
                    }

                    int destinationRow = cellrefs.get(headers[0]).getRow() + row;
                    if (row > 0) {
                        ExcelUtils.copyRow(workBook, sheet, cellrefs.get(headers[0]).getRow(), destinationRow);
                    }

                    for (int i = 0; i < headers.length; i++) {
                        String header = headers[i];
                        System.out.println("header: " + header);

                        int nameIndex = workBook.getNameIndex(header);
                        HSSFName name = workBook.getNameAt(nameIndex);
                        AreaReference aref = new AreaReference(name.getRefersToFormula());
                        System.out.println("aref: " + aref);

                        org.apache.poi.ss.util.CellReference crefs = cellrefs.get(header);
                        Sheet s = workBook.getSheet(crefs.getSheetName());
                        Row r = sheet.getRow(destinationRow);
                        Cell cell = r.getCell(crefs.getCol());
                        String field = fields[i];
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_BOOLEAN:
                                cell.setCellValue(Boolean.parseBoolean(field));
                                break;
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
                                    try {
                                        cell.setCellValue(parser.parse(field));
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    cell.setCellValue(Double.parseDouble(field));
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                cell.setCellValue(field);
                                break;
                            case Cell.CELL_TYPE_BLANK:
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                break;
                        }
                    }

                    System.out.println(StringUtils.join(fields, ", "));

                    row++;
                }
            }

            HSSFFormulaEvaluator.evaluateAllFormulaCells(workBook);

            out = new FileOutputStream(settings.getOutput());
            workBook.write(out);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
            IOUtils.closeQuietly(out);
        }
    }

    private File newTemporaryFileFromTemplate(File templateFile) {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("csv2xls", "", new File(SystemUtils.JAVA_IO_TMPDIR));
        } catch (IOException e) {
            throw new RuntimeException("Unable to create temporary file", e);
        }

        try {
            FileUtils.copyFile(templateFile, tempFile);
        } catch (IOException e) {
            throw new RuntimeException("Unable to copy template to temporary file", e);
        }
        return tempFile;
    }

    public static void main(String... args) {
        final Settings settings = new Settings();

        String version = versionFrom("/META-INF/maven/csv2xls/csv2xls/pom.properties");
        new CommandLine(
                    LAUNCHER,
                    version,
                    LAUNCHER + " " + version + SystemUtils.LINE_SEPARATOR +
                        "Transform CSV to XLS. Input can be specified as files at the end of options, otherwise standard input is used.",
                    "Exit status:" + SystemUtils.LINE_SEPARATOR +
                        "0  : if OK" + SystemUtils.LINE_SEPARATOR +
                        "1  : if an error occurs" + SystemUtils.LINE_SEPARATOR +
                        "2  : on a syntax error" + SystemUtils.LINE_SEPARATOR
                )
                .withOption(
                        new CommandLine.Option('t', "Template of XLS to use")
                                .longOption("template")
                                .args(1),
                        new CommandLine.Option.Handler() {
                            @Override
                            public void onOption(CommandLine.Option option, String[] values) {
                                settings.setXlsTemplateFile(new File(values[0]));
                            }
                        }
                )
                .withOption(
                        new CommandLine.Option('s', "Sheet index to process (default is 1)")
                                .longOption("sheet")
                                .notRequired()
                                .args(1),
                        new CommandLine.Option.Handler() {
                            @Override
                            public void onOption(CommandLine.Option option, String[] values) {
                                settings.setSheetIndex(Integer.parseInt(values[0]) - 1);
                            }
                        }
                )
                .withOption(
                        new CommandLine.Option('o', "Excel output filepath")
                                .longOption("output")
                                .args(1),
                        new CommandLine.Option.Handler() {
                            @Override
                            public void onOption(CommandLine.Option option, String[] values) {
                                settings.setOutput(new File(values[0]));
                            }
                        }
                )
                .onAdditionalArgs(new CommandLine.Option.Handler() {
                    @Override
                    public void onOption(CommandLine.Option option, String[] values) {
                        File[] inputs = new File[values.length];
                        for (int i = 0; i < values.length; i++)
                            inputs[i] = new File(values[i]);

                        settings.setInputs(inputs);
                    }
                })
                .parse(args);

        Csv2Xls csv2Xls = new Csv2Xls(settings);
        csv2Xls.run();
    }

    private static String versionFrom(String resourceInClasspath) {
        InputStream in = null;
        try {
            in = Csv2Xls.class.getResourceAsStream(resourceInClasspath);
            Properties props = new Properties();
            props.load(in);
            return StringUtils.defaultString(props.getProperty("version"), UNKNOWN_VERSION);
        } catch (IOException e) {
            return UNKNOWN_VERSION;
        }
        finally {
            IOUtils.closeQuietly(in);
        }
    }

}
