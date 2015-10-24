package yodarescue.transaction.domain;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class RepositoryJDBC implements Repository {

  private static final Logger LOG = LoggerFactory.getLogger(RepositoryJDBC.class);
  
  @SuppressWarnings("unused")
  private final DataSource dataSource;
  private final NamedParameterJdbcTemplate jdbc;
  
  public RepositoryJDBC(DataSource dataSource) {
    super();
    this.dataSource = dataSource;
    this.jdbc = new NamedParameterJdbcTemplate(dataSource);
  }

  @Override
  public boolean isJoined(BookingID bookingID) {
    LOG.debug("finding records in BOOKING_BANK_TRANSACTION for booking ID {}...", bookingID);
    
    int count = jdbc.queryForObject(
        "select count(*) from volagratis.BOOKING_BANK_TRANSACTION where ID_BOOKING = :id", 
        Collections.singletonMap("id", bookingID.getValue()), 
        Integer.class
    );
    boolean joined = count > 0;
    
    LOG.debug("found {} records in BOOKING_BANK_TRANSACTION, returning {}", count, joined);
    return joined;
  }

  @Override
  public GlobalCollectTransaction[] findGlobalCollectTransactions(BookingID bookingID) {
    List<GlobalCollectTransaction> list = jdbc.query(
        "select * from volagratis.GLOBALCOLLECT_BANK_TRANSACTION where ID_BOOKING = :id", 
        Collections.singletonMap("id", bookingID.getValue()), 
        RepositoryJDBC.GlobalCollectTransactionRowMapper.INSTANCE
    );
    return list.toArray(new GlobalCollectTransaction[0]);
  }

  public static class GlobalCollectTransactionRowMapper implements RowMapper<GlobalCollectTransaction> {

    public static final GlobalCollectTransactionRowMapper INSTANCE = new GlobalCollectTransactionRowMapper();

    @Override
    public GlobalCollectTransaction mapRow(ResultSet rs, int rownum) throws SQLException {
      BookingID bookingID = BookingID.valueOf(rs.getString("ID_BOOKING"));
      Timestamp transactionDate = rs.getTimestamp("TRANSACTION_DATE");
      LocalDateTime timestamp = transactionDate.toLocalDateTime();
      BigDecimal amount = rs.getBigDecimal("AMOUNT");
      BigDecimal authorizedAmount = rs.getBigDecimal("AUTH_AMOUNT");
      BigDecimal collectAmount = rs.getBigDecimal("COLLECT_AMOUNT");
      GlobalCollectTransaction transaction = new GlobalCollectTransaction(bookingID, timestamp, amount, authorizedAmount, collectAmount);
      
      LOG.debug("... returning: {}", transaction);
      return transaction;
    }
    
  }
  
}
