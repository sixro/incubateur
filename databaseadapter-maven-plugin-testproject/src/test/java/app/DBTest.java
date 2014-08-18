package app;

import static org.junit.Assert.*;

import org.junit.Test;

import app.database.DB;

import static app.database.DB.cdc_crociera.Column.*;

public class DBTest {

	private static final DB.cdc_crociera.Column[] COLUMNS =  new DB.cdc_crociera.Column[]{ c_ent_bsns_crociera, c_ent_bsns_nave };

	@Test public void generatedTableNamesContainsExpectedValues() {
		assertEquals("cdc_crociera", DB.cdc_crociera.TABLE_NAME);
		assertEquals("SELECT COUNT(*) FROM cdc_crociera", DB.cdc_crociera.SQL_SELECT_COUNT);
		assertEquals("SELECT c_ent_bsns_crociera, c_ent_bsns_nave FROM cdc_crociera", DB.cdc_crociera.newSelect(COLUMNS));
		assertEquals("INSERT INTO cdc_crociera(c_ent_bsns_crociera, c_ent_bsns_nave) VALUES (?, ?)", DB.cdc_crociera.newInsert(COLUMNS));
		assertEquals("UPDATE cdc_crociera SET c_ent_bsns_crociera = ?, c_ent_bsns_nave = ?", DB.cdc_crociera.newUpdate(COLUMNS));
		assertEquals("DELETE FROM cdc_crociera", DB.cdc_crociera.SQL_DELETE);
	}

}
