package util;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Assert;

import java.io.*;

public class ExcelAssert {

    private ExcelAssert() { }

    public static void assertCellEquals(Object expected, String cellref, File excel) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(excel);
            HSSFWorkbook workBook = new HSSFWorkbook(in);
            HSSFSheet sheet    = workBook.getSheetAt(0);
            CellReference cellReference = new CellReference(cellref);
            Row row = sheet.getRow(cellReference.getRow());
            if (row == null)
                throw new RuntimeException("no such cell " + cellref);
            Cell cell = row.getCell(cellReference.getCol());

            Object value = null;
            if (cell!=null) {
                switch (cell.getCellType()) {
                    case Cell.CELL_TYPE_BOOLEAN:
                        value = cell.getBooleanCellValue();
                        break;
                    case Cell.CELL_TYPE_NUMERIC:
                        value = cell.getNumericCellValue();
                        break;
                    case Cell.CELL_TYPE_STRING:
                        value = cell.getStringCellValue();
                        break;
                    case Cell.CELL_TYPE_BLANK:
                        break;
                    case Cell.CELL_TYPE_ERROR:
                        value = cell.getErrorCellValue();
                        break;
                    case Cell.CELL_TYPE_FORMULA:
                        value = cell.getCellFormula();
                        break;
                }
            }

            if (! value.equals(expected))
                Assert.fail("expected " + expected + " - got " + value);
        } catch (IOException e) {
            throw new RuntimeException("unable to read cell " + cellref, e);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }
}
