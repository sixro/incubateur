package yodarescue.transaction.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class GlobalCollectTransaction implements BookingTransaction {

  private final BookingID bookingID;
  private final LocalDateTime timestamp;
  private final BigDecimal amount;
  private final BigDecimal authorizedAmount;
  private final BigDecimal collectAmount;

  public GlobalCollectTransaction(BookingID bookingID, LocalDateTime timestamp,
      BigDecimal amount, BigDecimal authorizedAmount, BigDecimal collectAmount) {
    super();
    this.bookingID = bookingID;
    this.timestamp = timestamp;
    this.amount = amount;
    this.authorizedAmount = authorizedAmount;
    this.collectAmount = collectAmount;
  }

  public BookingID getBookingID() {
    return bookingID;
  }

  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public BigDecimal getAuthorizedAmount() {
    return authorizedAmount;
  }

  public BigDecimal getCollectAmount() {
    return collectAmount;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
  }

}
