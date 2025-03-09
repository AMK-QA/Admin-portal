Feature: List of trips page

  Scenario: System should appear rider and driver email with valid format
    Given user logs in with valid credentials to get list of trips
    When user selects rider from the left menu and list of trips to get trips
    And  get list of rider email and driver email
    Then email of rider and driver should be in right format

  Scenario: Admin can delete trips from list of rider
    Given user logs in with valid credentials to get list of trips
    When user selects rider from the left menu and list of trips to get trips
    And Select trips delete email number 15 and click on delete button
    And Click on "yes" to confirm deleting to delete trip
    Then trip should be deleted

  Scenario: Admin can create trips from list of rider
    Given user logs in with valid credentials to get list of trips
    When user selects rider from the left menu and list of trips to get trips
    And Select book trip
    Then trip should be booked

  Scenario: Admin can view trips details from list of rider
    Given user logs in with valid credentials to get list of trips
    When user selects rider from the left menu and list of trips to get trips
    And Select view trip email number 15
    Then profile should be appear

  Scenario: Admin can open the trips list page and filter using a search value
    Given user logs in with valid credentials to get list of trips
    When user selects rider from the left menu and list of trips to get trips
    And user select search box and enter value "ahmed" at trips search box
    Then The filtered trips list should be displayed

  Scenario: Admin can open the trips list page and filter using date
    Given user logs in with valid credentials to get list of trips
    When user selects rider from the left menu and list of trips to get trips
    And user filtered with start date "2025-01-11" to end date "2025-02-22" at list of trips
    And user confirm filter by click on "apply" button at list of trips
    Then The filtered trips list should be displayed
