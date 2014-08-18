SELECT dealer_code AS "Dealer code"
     , dealer_name AS "Name"
     , city AS "City"
     , province AS "Province"
     , insert_date AS "Registered"
     , old_dealer_code AS "Old code"
    FROM dealer_data
    WHERE channel = :channel
