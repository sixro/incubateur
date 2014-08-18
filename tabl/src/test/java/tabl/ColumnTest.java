package tabl;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import org.junit.Test;

public class ColumnTest {

	private static final Column NAME = new Column("name", Column.Type.TEXT);

	private static final Column AGE = new Column("age", Column.Type.NUMBER);
	private static final Column BIRTH_DATE = new Column("birthDate", Column.Type.DATETIME);
	private static final Column ENABLED = new Column("enabled", Column.Type.BOOLEAN);

	@Test public void equalityIsBasedOnlyOnName() {
		Column name2 = new Column("name", Column.Type.NUMBER);
		assertTrue(NAME.equals(name2));
	}
	
	@Test public void equalityIsCaseInsensitive() {
		Column ANOTHER_NAME = new Column("NAME", Column.Type.TEXT);
		assertTrue(NAME.equals(ANOTHER_NAME));
	}

	@Test public void toString_returnsARepresentationOfType() {
		assertEquals("name<T>", NAME.toString());
		assertEquals("age<N>", AGE.toString());
		assertEquals("birthDate<D>", BIRTH_DATE.toString());
		assertEquals("enabled<B>", ENABLED.toString());
	}

	@Test public void accept_returnsTrue() {
		assertTrue(NAME.accept("Hello World!"));
		assertTrue(AGE.accept(BigDecimal.ONE));
		assertTrue(BIRTH_DATE.accept(new Date()));
		assertTrue(BIRTH_DATE.accept(new Timestamp(new Date().getTime())));
		assertTrue(ENABLED.accept(true));
	}

	@Test public void accept_returnsFalse() {
		assertFalse(NAME.accept(BigDecimal.ONE));
		assertFalse(AGE.accept("Hello"));
		assertFalse(BIRTH_DATE.accept("Hello"));
		assertFalse(ENABLED.accept("Hello"));
	}

}
