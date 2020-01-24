package db4idlers;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.junit.*;

public class DBTest {

	private DataSource dataSource;
	private DB db;
	
	@Before public void setup() throws Exception {
		dataSource = DataSourceFactory.newOracleDataSource(
				"jdbc:oracle:thin:@icteam-ora05:1521:QDTTEST", 
				"NTGC_IT", 
				"NTGC_IT"
		);
		db = new DB(dataSource);
	}
	
	@Test public void return_array() {
		Dealer[] dealers = db.list(Dealer.class, "with-name-matching", "%penta%");
		assertTrue(dealers.length > 0);
	}

}
