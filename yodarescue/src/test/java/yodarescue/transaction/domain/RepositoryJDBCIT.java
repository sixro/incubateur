package yodarescue.transaction.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import yodarescue.util.DataSourceFactory;

public class RepositoryJDBCIT {

  private RepositoryJDBC repository;

  @Before public void setup() {
    repository = new RepositoryJDBC(DataSourceFactory.newDataSource("/volagratis-ds-development.properties"));
  }
  
  @Test public void returnsGlobalTransaction() {
    assertNotNull(repository.findGlobalCollectTransactions(BookingID.valueOf("103472763")));
  }

  @Test public void isJoined() {
    assertTrue(repository.isJoined(BookingID.valueOf("103472763")));
  }
  
}
