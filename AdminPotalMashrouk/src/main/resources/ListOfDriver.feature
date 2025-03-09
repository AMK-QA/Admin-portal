Feature: List of driver page
  Scenario: System should appear email with in valid format
    Given user logs in with valid credentials to get list of driver
    When user selects driver from the left menu and list of driver to get driver
    And  get list of driver email
    Then email should be in right format at list of driver

  Scenario: Admin can delete driver from list of driver
    Given user logs in with valid credentials to get list of driver
    When user selects driver from the left menu and list of driver to get driver
    And Select driver delete email number 15 and click on delete button
    And Click on "yes" to confirm deleting at list of driver
    Then driver should be deleted

  Scenario: Admin can create driver from list of driver
    Given user logs in with valid credentials to get list of driver
    When user selects driver from the left menu and list of driver to get driver
    And Select create driver
    Then driver profile should be opened

  Scenario: Admin can view driver details from list of driver
    Given user logs in with valid credentials to get list of driver
    When user selects driver from the left menu and list of driver to get driver
    And Select view driver email number 15
    Then driver should be his profile


  Scenario: Admin can open the driver list page and filter using a search value
    Given user logs in with valid credentials to get list of driver
    When user selects driver from the left menu and list of driver to get driver
    And user select search box and enter value "ahmed" in search box at list of driver
    Then The filtered drivers list should be displayed

  Scenario: Admin can open the driver list page and filter using date
    Given user logs in with valid credentials to get list of driver
    When user selects driver from the left menu and list of driver to get driver
    And user filtered with start date "2025-01-11" to end date "2025-02-22" at list of driver page
    And user confirm filter by click on "apply" button at list of driver page
    Then The filtered drivers list should be displayed
