# yodarescue

An application useful to Team Yoda.


## User Stories & Specification Tests

  1. **As a Team Yoda member, I want to join tx for a booking so that we can let the booking proceed**
    * *Given an existing booking ID without a booked tx and assuming that the gateway used for payment is GlobalCollect, when the Team Yoda member searches for it, then an action is shown to give the possibility to generate SQL needed to join tx*
      * ~~Create a form with a textfield accepting the booking ID and a button to start the search of it and the gateway used and if it is in need of a join of the transaction~~
      * ~~on search execute the query to check if a tx is to join~~
      * ~~enable or disable action to generate SQL using the join~~
      * ~~on join button click open a dialog~~
      * ~~create the content of the dialog: a field with transaction IDs and transaction dates (combo), the amount, currency, cvv result and eci~~
      * load all data related to possible global collect tx to join
      * fill dialog fields with what loaded
      * on OK generate SQL using a template with specified transaction ID
  1. **Stylesheet (Tech tasks)**
      * ~~Change background of OutlineView~~
      * ~~Change font of first level menu in OutlineView~~

