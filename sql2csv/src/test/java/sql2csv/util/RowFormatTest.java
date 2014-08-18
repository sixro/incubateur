package sql2csv.util;

import static org.junit.Assert.*;

import org.junit.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RowFormatTest {

	@Test public void use_separator() {
		RowFormat rowFormat = new RowFormat("|");
		assertEquals("1|2", rowFormat.format(new Object[]{ 1, 2 }));
	}

    @Test public void format_date_as_iso() {
        RowFormat rowFormat = new RowFormat("|");
        assertEquals("2010-02-03T21:22:23", rowFormat.format(new Object[]{ timestamp("2010-02-03 21:22:23") }));
    }

    @Test public void quote_quotes() {
        RowFormat rowFormat = new RowFormat("|");
        assertEquals("\"\"\"\"", rowFormat.format(new String[]{ "\"" }));
    }

    @Test public void quote_line_separators() {
        RowFormat rowFormat = new RowFormat("|");
        assertEquals("\"a\r\nb\"", rowFormat.format(new String[]{ "a\r\nb" }));
    }

    @Test public void quote_field_separators() {
        RowFormat rowFormat = new RowFormat("|");
        assertEquals("',' is not the separator and it isn't quoted", "a,b", rowFormat.format(new String[]{ "a,b" }));
        assertEquals("'|' is the separator and it is quoted", "\"a|b\"", rowFormat.format(new String[]{ "a|b" }));
    }

    private Timestamp timestamp(String datetime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse(datetime);
            return new Timestamp(date.getTime());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
