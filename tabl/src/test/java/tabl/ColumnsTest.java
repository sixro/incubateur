package tabl;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class ColumnsTest {

	private static final Column NAME = new Column("name", Column.Type.TEXT);
	private static final Column BIRTH_DATE = new Column("birth_date", Column.Type.DATETIME);

	@Test public void contains_returnsTrue() {
		Columns columns = new Columns(NAME, BIRTH_DATE);
		assertTrue(columns.contains(NAME));
		assertTrue(columns.contains(new Columns(NAME, BIRTH_DATE)));
	}

	@Test public void contains_returnsFalse() {
		Columns columns = new Columns(NAME);
		assertFalse(columns.contains(BIRTH_DATE));
		assertFalse(columns.contains(new Columns(
				new Column("unexistant", Column.Type.BOOLEAN),
				new Column("unexistant2", Column.Type.DATETIME))));
	}

	@Test public void iterable() {
		Columns columns = new Columns(NAME, BIRTH_DATE);
		Iterator<Column> it = columns.iterator();
		assertEquals(NAME, it.next());
		assertEquals(BIRTH_DATE, it.next());
	}
	
	@Test public void count_returnsTheNumberOfColumns() {
		assertEquals(2, new Columns(NAME, BIRTH_DATE).count());
		assertEquals(0, new Columns().count());
	}
	
	@Test public void namesJoint_returnsTwoNamesSeparatedByComma() {
		assertEquals("name,birth_date", new Columns(NAME, BIRTH_DATE).namesJoint(","));
	}

	@Test public void namesJoint_returnsOnlyOneName() {
		assertEquals("name", new Columns(NAME).namesJoint(","));
	}

	@Test public void namesJoint_returnsNameMatchingTemplate() {
		assertEquals("name = ?,birth_date = ?", new Columns(NAME, BIRTH_DATE).namesJoint("${name} = ?", ","));
	}

	@Test public void exclude_returnsName() {
		Columns all = new Columns(NAME, BIRTH_DATE);
		assertEquals(new Columns(NAME), all.exclude(new Columns(BIRTH_DATE)));
	}

	@Test public void toString_returnsExpectedText() {
		assertEquals("MyColumns[name<T>, birth_date<D>]", new MyColumns().toString());
	}

	public static class MyColumns extends Columns {

		public MyColumns() {
			super(NAME, BIRTH_DATE);
		}
		
	}
	
}
