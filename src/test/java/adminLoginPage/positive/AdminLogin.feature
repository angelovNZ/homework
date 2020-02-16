Feature: Positive Scenarios For Admin Login
  As an admin user I want to successfully be able to
  login, check i am on a right place
  and logout from the admin panel

  Scenario: Admin user successfully logged in
    Given the user open chrome browser and "http://shop.pragmatic.bg/admin/" successfully
    When the user enter "admin" and "parola123!" on the required place
    And the user clicks on the login button
    Then the user should be log in successfully
    And the user is successfully logout
