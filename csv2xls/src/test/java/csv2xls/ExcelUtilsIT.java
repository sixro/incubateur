package csv2xls;

import org.apache.commons.lang3.SystemUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import util.ExcelAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtilsIT {

    private FileInputStream in;
    private HSSFWorkbook workBook;
    private HSSFSheet sheet;
    private File outputFile;

    @Before
    public void setup() throws IOException {
        in = new FileInputStream("src/test/resources/template.xls");
        workBook = new HSSFWorkbook(in);
        sheet = workBook.getSheetAt(0);

        outputFile = new File(SystemUtils.USER_HOME + "/Desktop", "excelutils-output.xls");
        if (outputFile.exists())
            outputFile.delete();
    }

    @Test public void duplicate_rows() throws IOException {
        ExcelUtils.copyRow(workBook, sheet, 4, 5);

        ExcelUtils.save(workBook, outputFile);

        ExcelAssert.assertCellEquals("Rossi", "B6", outputFile);
        ExcelAssert.assertCellEquals("YEAR(NOW())-YEAR(D6)", "E6", outputFile);
    }

}
