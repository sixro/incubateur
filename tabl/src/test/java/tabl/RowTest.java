package tabl;

import static org.junit.Assert.*;
import static tabl.EmployeeColumns.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class RowTest {

	@Test(expected=IllegalArgumentException.class)
	public void with_throwAndErrorWhenColumnIsUnknown() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION);
		row.with(new Column("unexistant", Column.Type.TEXT), "ignore");
	}

	@Test public void with_throwAndErrorWhenValueDoesNotMatchColumnType() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION);
		
		assertFailsAdding(row, SERIAL_NUMBER, BigDecimal.ONE);
		assertFailsAdding(row, DATE_OF_EMPLOYMENT, "Hello");
		assertFailsAdding(row, LEVEL, "Hello");
		assertFailsAdding(row, PROJECT_MANAGER, "Hello");
	}

	private void assertFailsAdding(Row<EmployeeColumns> row, Column column, Object value) {
		try {
			row.with(column, value);
			fail("unexpected behaviour");
		}
		catch (IllegalArgumentException e) { /* passed */ }
	}

	@Test public void get_returnsValueOfAColumn() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234");
		assertEquals("1234", row.get(SERIAL_NUMBER));
	}

	@Test public void equality() {
		Row<EmployeeColumns> row1 = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234");
		Row<EmployeeColumns> row2 = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234");
		assertTrue(row1.equals(row2));
	}
	
	@Test public void matches_returnsTrueWhenARowMatchKeyColumnsOfTheOther() {
		Row<EmployeeColumns> row1 = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234");
		
		Row<EmployeeColumns> row2 = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234")
			.with(LEVEL, BigDecimal.ONE);
		
		assertTrue(row1.matches(row2, new Columns(SERIAL_NUMBER)));
	}

	@Test public void contains_returnsTrue() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234")
			.with(LEVEL, BigDecimal.ONE);
		assertTrue(row.contains(new Columns(SERIAL_NUMBER, LEVEL)));
	}

	@Test public void contains_returnsFalse() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234")
			.with(LEVEL, BigDecimal.ONE);
		assertFalse(row.contains(new Columns(PROJECT_MANAGER, DATE_OF_EMPLOYMENT)));
	}

	@SuppressWarnings("serial")
	@Test public void matchesMap_returnsTrue() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234")
			.with(LEVEL, BigDecimal.ONE);
		assertTrue(row.matches(new LinkedHashMap<Column, Object>() {{ put(SERIAL_NUMBER, "1234"); }}));
	}

	@Test public void getAll_returnsValuesForAllColumns() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234")
				.with(DATE_OF_EMPLOYMENT, new Date())
				.with(LEVEL, BigDecimal.ONE);
		
		Map<Column, Object> map = row.getAll(new Columns(SERIAL_NUMBER, LEVEL));
		assertEquals("1234", map.get(SERIAL_NUMBER));
		assertEquals(BigDecimal.ONE, map.get(LEVEL));
	}
	
}
