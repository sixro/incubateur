package tabl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.junit.Test;
import static tabl.EmployeeColumns.*;
import static tabl.TableTest.MultipleColumns.*;

public class TableTest {

	private static final MultipleColumns MULTIPLE_COLUMNS = new MultipleColumns();
	
	private Table<EmployeeColumns> table = Table.of(EmployeeColumns.DEFINITION, SERIAL_NUMBER);

	@Test public void add_addOneRow() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234");
		
		table.add(row);
		
		assertEquals(1, table.count());
	}

	@Test public void add_throwAnErrorIfAnotherRowMatchingKeyColumnsExists() {
		table.add(Row.of(EmployeeColumns.DEFINITION)
				.with(SERIAL_NUMBER, "1234"));

		try {
			table.add(Row.of(EmployeeColumns.DEFINITION)
					.with(SERIAL_NUMBER, "1234"));
			fail("unexpected behaviour");
		} catch (IllegalStateException e) {
			// passed
		}
	}

	@Test public void update_updateOneRow() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234");
		table.add(row);
		
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

	@Test(expected=IllegalArgumentException.class)
	public void update_throwAnErrorIfNotAllKeysAreSpecified() {
		Table<TableTest.MultipleColumns> multiKeyTable = Table.of(MULTIPLE_COLUMNS,
			new Columns(FIRST, SECOND));
		Row<MultipleColumns> row = Row.of(MULTIPLE_COLUMNS)
			.with(FIRST, "1234")
			.with(SECOND, "5678");
		multiKeyTable.add(row);
			
		multiKeyTable.update(Row.of(MULTIPLE_COLUMNS)
			.with(FIRST, "XXXX"));
	}

	@SuppressWarnings("serial")
	@Test public void update_updateAllRowsMatching() {
		Table<TableTest.MultipleColumns> multiKeyTable = Table.of(MULTIPLE_COLUMNS,
			new Columns(FIRST, SECOND));
		multiKeyTable.add(Row.of(MULTIPLE_COLUMNS)
				.with(FIRST, "1234")
				.with(SECOND, "5678"));
		multiKeyTable.add(Row.of(MULTIPLE_COLUMNS)
				.with(FIRST, "1234")
				.with(SECOND, "9012"));
		
		multiKeyTable.update(
			new LinkedHashMap<Column,Object>() {{ put(SECOND, "XXXX"); }}, 
			new LinkedHashMap<Column,Object>() {{ put(FIRST, "1234"); }});
		
		assertEquals("XXXX", multiKeyTable.first().get(SECOND));
		assertEquals("XXXX", multiKeyTable.last().get(SECOND));
	}

	@Test public void remove_removeOneRow() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234");
		table.add(row);
		
		table.remove(row);
		assertEquals(0, table.count());
	}

	@SuppressWarnings("serial")
	@Test public void remove_removeAllRowsMatching() {
		Table<TableTest.MultipleColumns> multiKeyTable = Table.of(MULTIPLE_COLUMNS,
			new Columns(FIRST, SECOND));
		multiKeyTable.add(Row.of(MULTIPLE_COLUMNS)
			.with(FIRST, "1234")
			.with(SECOND, "5678"));
		multiKeyTable.add(Row.of(MULTIPLE_COLUMNS)
			.with(FIRST, "1234")
			.with(SECOND, "9012"));
		
		multiKeyTable.remove(new LinkedHashMap<Column,Object>() {{ put(FIRST, "1234"); }});
		
		assertEquals(0, multiKeyTable.count());
	}

	@Test(expected=IllegalStateException.class)
	public void remove_throwAnErrorIfARowWithThatKeysDoesNotExist() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234");
		
		table.remove(row);
	}

	@Test public void contains_returnsTrueWhenARowWithTheSameKeysAlreadyExists() {
		Row<EmployeeColumns> row = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234");
		table.add(row);
		
		Row<EmployeeColumns> anotherRow = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234")
			.with(LEVEL, BigDecimal.ONE);
		
		assertTrue(table.contains(anotherRow));
	}

	@Test public void iterable() {
		Row<EmployeeColumns> row1 = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "1234");
		table.add(row1);
		Row<EmployeeColumns> row2 = Row.of(EmployeeColumns.DEFINITION)
			.with(SERIAL_NUMBER, "5678");
		table.add(row2);
		
		Iterator<Row<EmployeeColumns>> it = table.iterator();
		assertEquals(row1, it.next());
		assertEquals(row2, it.next());
	}
	
	public static class MultipleColumns extends Columns {
		
		public static final Column FIRST = new Column("first", Column.Type.TEXT);
		public static final Column SECOND = new Column("second", Column.Type.TEXT);
		
		public MultipleColumns() {
			super(FIRST, SECOND);
		}
		
	}
	
}
