package yodarescue.transaction.domain;

public interface Repository {

  boolean isJoined(BookingID bookingID);
  
  GlobalCollectTransaction[] findGlobalCollectTransactions(BookingID bookingID);
  
}
