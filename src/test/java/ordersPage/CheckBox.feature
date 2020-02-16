Feature: Scenarios for the check boxes
  As an admin i want to successfully be logged in to admin page,
  go to orders page from catalog menu and check
  the check boxes from order list

  Scenario: Successful usage of the checkbox from head panel
    Given the admin is on the Admin home page
    When the admin goes to Orders page
    And the admin can see the check box from head panel
    Then the admin should click on the check box
    And all the check boxes below has to be checked