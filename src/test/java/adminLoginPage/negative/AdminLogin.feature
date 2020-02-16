Feature: Negative Scenarios For Admin Login
  As an admin user I want to successfully be able to
  see an alert message if i enter wrong username or password

  Scenario Outline: Unsuccessful admin login and right alert message
    Given the user open chrome browser and "http://shop.pragmatic.bg/admin/" successfully
    When the user enter "<username>" and "<password>" on the required place
    And the user clicks on the login button
    Then the user should see the right alert message
    Examples:
      | username  | password      |
      | admin     | blablabla     |
      | blablabla | parola123!    |
      | notadmin  | notparola123! |
