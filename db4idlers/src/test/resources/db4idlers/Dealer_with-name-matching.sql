SELECT
      dealer_code
    , dealer_name
    , channel
    , address
    , city_code
    , city
    , province
    FROM dealer_data
    WHERE LOWER(dealer_name) LIKE ?