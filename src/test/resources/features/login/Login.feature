Feature: Login with valid credentials

  As a customer I want to be able to login to application providing valid credentials.

  @Login @Start
  Scenario Outline: Login to app
    Given the app login page is open
    When  the user enters correct <username> and <password>
    Then the user is logged in

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  @Logout @Stop
  Scenario: Logout from app
    Given the user is logged in
    When the user logs out
    Then the app login page is open