Feature: Design
  Scenario: Assert all element appear in home page
    Given user logs in with valid credentials to check design
    When navigation bar should displayed successfully
    And Icon at right side at navigation bar appear successfully
    Then all element should appear

  Scenario: Assert all element appear in left side menu in home page
    Given user logs in with valid credentials to check design
    When Logo appear as expected
    And left side menu should is opened and displayed successfully
    And logout  button appear
    Then all element should appear