package yodarescue.transaction.ui;

import java.util.Collections;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import yodarescue.transaction.Transaction;
import yodarescue.transaction.Transaction.VegasGateway;
import yodarescue.util.DefaulBlockingTask;
import yodarescue.util.ResourceUtils;

public class RetrieveTransactionTask extends DefaulBlockingTask<Transaction> {

  private final NamedParameterJdbcTemplate jdbc;
  private final String selectVolagratisGatewaySQL;
  private final String selectVegasGatewaySQL;

  private int bookingID;
  
  public RetrieveTransactionTask(DataSource dataSource) {
    this(
        new NamedParameterJdbcTemplate(dataSource),
        ResourceUtils.loadText("/select-volagratis-gateway.sql"),
        ResourceUtils.loadText("/select-vegas-gateway.sql")
      );
  }
  
  public RetrieveTransactionTask(
      NamedParameterJdbcTemplate jdbc,
      String selectVolagratisGatewaySQL, 
      String selectVegasGatewaySQL) {
    super();
    this.jdbc = jdbc;
    this.selectVolagratisGatewaySQL = selectVolagratisGatewaySQL;
    this.selectVegasGatewaySQL = selectVegasGatewaySQL;
  }

  public void setBookingID(int bookingID) {
    this.bookingID = bookingID;
  }

  @Override
  protected Transaction call() throws Exception {
    Transaction.Status status = retrieveTransactionStatus();
    Transaction.VolagratisGateway volagratisGateway = retrieveVolagratisGateway();
    if (! Transaction.VolagratisGateway.vegas.equals(volagratisGateway))
      return Transaction.noVegas(status, volagratisGateway);
    
    // FIXME rsimoni implementare
    return Transaction.vegas(status, VegasGateway.globalcollect);
  }

  private Transaction.Status retrieveTransactionStatus() {
    int bookingsCount = jdbc.queryForObject(
        "select count(*) from volagratis.BOOKING where ID_BOOKING = :bookingID", 
        Collections.singletonMap("bookingID", Integer.toString(bookingID)),
        Integer.class
      );
    return bookingsCount > 0
        ? Transaction.Status.joined
        : Transaction.Status.not_joined;
  }

  private Transaction.VolagratisGateway retrieveVolagratisGateway() {
    try {
      String gatewayName = jdbc.queryForObject(
          selectVolagratisGatewaySQL, 
          Collections.singletonMap("bookingID", Integer.toString(bookingID)),
          String.class
          );
      return Transaction.VolagratisGateway.valueOf(gatewayName);
    } catch (EmptyResultDataAccessException e) {
      return Transaction.VolagratisGateway.unknown;
    }
  }
  
}
