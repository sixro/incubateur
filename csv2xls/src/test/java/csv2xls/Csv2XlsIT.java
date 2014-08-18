package csv2xls;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Before;
import org.junit.Test;
import util.ExcelAssert;

import java.io.*;

public class Csv2XlsIT {

    private File outputFile;

    @Before public void setup() {
        //outputFile = new File("target/output.xls");
        outputFile = new File(SystemUtils.USER_HOME + "/Desktop", "output.xls");
        if (outputFile.exists())
            outputFile.delete();
    }

    @Test public void render_expected_fields() {
        Settings settings = new Settings();
        settings.setXlsTemplateFile(new File("src/test/resources/template.xls"));
        settings.setInputs(new File[]{new File("src/test/resources/employees.csv")});
        settings.setOutput(outputFile);

        Csv2Xls csv2Xls = new Csv2Xls(settings);
        csv2Xls.run();

        ExcelAssert.assertCellEquals("Rossi", "B5", outputFile);
        ExcelAssert.assertCellEquals("Verdi carli", "B6", outputFile);
    }

}
