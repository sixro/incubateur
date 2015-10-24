select 'globalcollect' as GATEWAY
    from volagratis.GLOBALCOLLECT_BANK_TRANSACTION
	where ID_BOOKING = :bookingID
union select 'netgiro' as GATEWAY
    from volagratis.NETGIRO_BANK_TRANSACTION
	where ORDER_ID = :bookingID
union select 'paypal' as GATEWAY
    from volagratis.PAYPAL_BANK_TRANSACTION
	where ID_BOOKING = :bookingID
union select 'vegas' as GATEWAY
    from volagratis.VEGAS_TRANSACTIONS join volagratis.TRANSACTION_ATTEMPTS using (ID_BOOKING)
    where ID_BOOKING = :bookingID;
