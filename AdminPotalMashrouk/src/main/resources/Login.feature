Feature: login
  Scenario: user can sign in with valid credentials
    Given Open website
    When Enter Registered Email
    And Enter password
    Then user can login successfully