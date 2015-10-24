select lower(gw.GATEWAY_NAME)
    from vegas.TRANSACTION tx
        inner join vegas.GATEWAY_ACCOUNT a on (tx.GATEWAY_ACCOUNT_ID = a.GATEWAY_ACCOUNT_ID)
        inner join vegas.GATEWAY gw on (a.GATEWAY_ID = gw.GATEWAY_ID)
    where tx.REFERENCE like :bookingID || '%';
