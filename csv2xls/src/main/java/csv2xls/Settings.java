package csv2xls;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.File;

public class Settings {

    private File xlsTemplateFile;
    private int sheetIndex;
    private File[] inputs;
    private File output;

    public File getXlsTemplateFile() {
        return xlsTemplateFile;
    }

    public void setXlsTemplateFile(File xlsTemplateFile) {
        this.xlsTemplateFile = xlsTemplateFile;
    }

    public int getSheetIndex() {
        return sheetIndex;
    }

    public void setSheetIndex(int sheetIndex) {
        this.sheetIndex = sheetIndex;
    }

    public File[] getInputs() {
        return inputs;
    }

    public void setInputs(File[] inputs) {
        this.inputs = inputs;
    }

    public File getOutput() {
        return output;
    }

    public void setOutput(File output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
