Feature: List of driver page
  Scenario: System should appear email with in valid format
    Given user logs in with valid credentials to get list of driver
    When user selects driver from the left menu and list of driver to get driver
    And  get list of driver email
    Then email should be in right format at list of driver


  Scenario: Admin can create driver from list of driver
    Given user logs in with valid credentials to get list of driver
    When user selects driver from the left menu and list of driver to get driver
    And Select create driver
    Then driver profile should be opened

  Scenario: Admin can view driver details from list of driver
    Given user logs in with valid credentials to get list of driver
    When user selects driver from the left menu and list of driver to get driver
    And Select view driver email number 1
    Then driver should be his profile


  Scenario: Admin can open the driver list page and filter using a search value
    Given user logs in with valid credentials to get list of driver
    When user selects driver from the left menu and list of driver to get driver
    And user select search box and enter value "aliaa" in search box at list of driver
    Then The filtered drivers list should be displayed

  Scenario: Admin can open the driver list page and filter using date
    Given user logs in with valid credentials to get list of driver
    When user selects driver from the left menu and list of driver to get driver
    And user filtered with start date "2025-01-22" to end date "2025-03-19" to driver number 1 at list of driver page
    Then The filtered drivers list should be displayed
