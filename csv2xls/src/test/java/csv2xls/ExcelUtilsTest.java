package csv2xls;

import org.junit.Assert;
import org.junit.Test;

public class ExcelUtilsTest {

    @Test public void replaceCellReferencesOfSameRow_replace_one_cell_ref() {
        Assert.assertEquals("YEAR(NOW())-YEAR(D6)", ExcelUtils.replaceCellReferencesOfSameRow("YEAR(NOW())-YEAR(D5)", 5, 6));
    }

    @Test public void replaceCellReferencesOfSameRow_replace_multiple_cell_refs() {
        Assert.assertEquals("D6-E6-G6-F4", ExcelUtils.replaceCellReferencesOfSameRow("D5-E5-G5-F4", 5, 6));
        Assert.assertEquals("D5-E5-G80-F80", ExcelUtils.replaceCellReferencesOfSameRow("D5-E5-G4-F4", 4, 80));
        Assert.assertEquals("D5-E5-G40-F40", ExcelUtils.replaceCellReferencesOfSameRow("D5-E5-G4-F4", 4, 40));
    }

    @Test public void replaceCellReferencesOfSameRow_replace_cell_refs_with_row_starting_with_the_same_value() {
        Assert.assertEquals("D50", ExcelUtils.replaceCellReferencesOfSameRow("D50", 5, 6));
    }

}
