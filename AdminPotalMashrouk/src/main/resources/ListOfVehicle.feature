Feature: List of vehicle page
  
  Scenario: Admin can delete vehicle from list of vehicle
    Given user logs in with valid credentials to get list of vehicle
    When user selects vehicle from the left menu and list of vehicle
    And Select vehicle delete with number 5 and click on delete button
    And Click on "yes" to confirm deleting vehicle
    Then vehicle should be deleted

  Scenario: Admin can create vehicle from list of vehicle
    Given user logs in with valid credentials to get list of vehicle
    When user selects vehicle from the left menu and list of vehicle
    And Select create vehicle
    Then create page should be opened

  Scenario: Admin can open the vehicle list page and filter using a search value
    Given user logs in with valid credentials to get list of vehicle
    When user selects vehicle from the left menu and list of vehicle
    And user select search box and enter value "toyota" in search box at vehicle search box
    Then The filtered vehicle list should be displayed

  Scenario: Admin can open the vehicle list page and filter using date
    Given user logs in with valid credentials to get list of vehicle
    When user selects vehicle from the left menu and list of vehicle
    And user filtered with start date "2025-01-11" to end date "2025-02-22"  at vehicle filter
    And user confirm filter by click on "apply" button at vehicle filter
    Then The filtered riders list should be displayed at vehicle filter