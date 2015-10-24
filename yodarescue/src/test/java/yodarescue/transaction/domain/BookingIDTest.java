package yodarescue.transaction.domain;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BookingIDTest {

  @Rule public ExpectedException expectedException = ExpectedException.none();
  
  @Test public void throwsAnErrorWhenNoNumeric() {
    expectedException.expect(IllegalArgumentException.class);
    
    new BookingID("a");
  }

  @Test public void returnsValue() {
    assertEquals("123", new BookingID("123").getValue());
  }

}
