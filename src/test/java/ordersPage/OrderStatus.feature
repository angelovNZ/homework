Feature: Scenarios for Orders status
  As an admin i want to successfully be logged in to admin page,
  go to orders page from catalog menu and check
  for all order status

  Scenario Outline: Successfully find order status
    Given the admin is on the Admin home page
    When the admin goes to Orders page
    And the admin can see the filter panel
    Then the admin should find all the "<status>" which he want, select them
    And the admin has too see his "<selection>"
    Examples:
      | status            | selection         |
      | Missing Orders    | Missing Orders    |
      | Canceled          | Canceled          |
      | Canceled Reversal | Canceled Reversal |
#      | Chargeback        | Chargeback        |
#      | Complete          | Complete          |
#      | Denied            | Denied            |
#      | Expired           | Expired           |
#      | Failed            | Failed            |
#      | Pending           | Pending           |
#      | Processed         | Processed         |
#      | Processing        | Processing        |
#      | Refunded          | Refunded          |
#      | Reversed          | Reversed          |
#      | Shipped           | Shipped           |