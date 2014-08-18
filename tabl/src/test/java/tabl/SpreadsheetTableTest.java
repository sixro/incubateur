package tabl;

import static org.junit.Assert.*;
import static tabl.EmployeeColumns.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.SystemUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.AreaReference;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SpreadsheetTableTest {

	private Workbook workbook;
	private Sheet sheet;
	private SpreadsheetTable<EmployeeColumns> table;

	@Test(expected=IllegalArgumentException.class)
	public void throwAnErrorWhenAreaRefersToASingleCell() {
		String cell = "C5";
		AreaReference areaReferringOneCell = new AreaReference(cell + ":" + cell);
		SpreadsheetTable.of(EmployeeColumns.DEFINITION, EmployeeColumns.SERIAL_NUMBER, sheet, areaReferringOneCell);
	}

	@Test public void add_addOneRow() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234")
			.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
			.with(LEVEL, BigDecimal.ONE)
			.with(PROJECT_MANAGER, true);
		
		table.add(row);
		
		assertEquals(1, table.count());
	}

	@Test public void update_updateOneRow() {
		table.add(Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ZERO)
				.with(PROJECT_MANAGER, true));
		assertEquals(BigDecimal.ZERO, table.first().get(LEVEL));
		
		Row<EmployeeColumns> row2 = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234")
			.with(LEVEL, BigDecimal.ONE);
		table.update(row2);
		
		assertEquals(1, table.count());
		assertEquals(BigDecimal.ONE, table.first().get(LEVEL));
	}

	@Test(expected=IllegalStateException.class)
	public void update_throwAnErrorIfNoRowMatchesKeys() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234");
		table.add(row);
			
		table.update(Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "XXXX"));
	}

	@Test public void remove_removeOneRow() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234");
		table.add(row);
		
		table.remove(row);
		assertEquals(0, table.count());
	}

	@Test(expected=IllegalStateException.class)
	public void remove_throwAnErrorIfARowWithThatKeysDoesNotExist() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, date("2010-01-15"))
				.with(LEVEL, BigDecimal.ZERO)
				.with(PROJECT_MANAGER, true);
		
		table.remove(row);
	}

	@Before public void setup() throws IOException {
		InputStream spreadsheetSource = SpreadsheetTableTest.class.getResourceAsStream("/spreadsheet.xls");
		if (spreadsheetSource == null)
			throw new IllegalStateException("Unable to find spreadsheet source... have you changed its name?");
		
		File spreadsheet = new File(SystemUtils.JAVA_IO_TMPDIR, "spreadsheet.xls");
		if (spreadsheet.exists()) {
			if (! spreadsheet.delete())
				throw new IllegalStateException("Unable to delete spreadsheet " + spreadsheet);
		}
		
		FileOutputStream os = new FileOutputStream(spreadsheet);
		IOUtils.copy(spreadsheetSource, os);
		os.flush();
		os.close();
		
		workbook = new HSSFWorkbook(new FileInputStream(spreadsheet));
		sheet = workbook.getSheet("Unit test");
		table = SpreadsheetTable.of(EmployeeColumns.DEFINITION, EmployeeColumns.SERIAL_NUMBER, sheet, new AreaReference("C4:F29"));
	}
	
	@After public void teardown() throws IOException {
		File spreadsheet = new File(SystemUtils.JAVA_IO_TMPDIR, "spreadsheet_after.xls");
		if (spreadsheet.exists()) {
			if (! spreadsheet.delete())
				throw new IllegalStateException("Unable to delete spreadsheet after tests: " + spreadsheet);
		}
		
		FileOutputStream os = new FileOutputStream(spreadsheet);
		workbook.write(os);
		os.flush();
		os.close();
	}

	// TODO rs this is duplicated... see DBTable
	private Date date(String text) {
		try {
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
			return parser.parse(text);
		} catch (ParseException e) {
			throw new RuntimeException("unable to parse date '" + text + "'", e);
		}
	}

}
