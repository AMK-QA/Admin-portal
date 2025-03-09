Feature: List of rider page
  Scenario: System should appear email with in valid format
    Given user logs in with valid credentials to get list of rider
    When user selects rider from the left menu and list of rider to get rider
    And  get list of rider email
    Then email should be in right format

    Scenario: Admin can delete rider from list of rider
      Given user logs in with valid credentials to get list of rider
      When user selects rider from the left menu and list of rider to get rider
      And Select rider delete email number 15 and click on delete button
      And Click on "yes" to confirm deleting
      Then rider should be deleted

  Scenario: Admin can create rider from list of rider
    Given user logs in with valid credentials to get list of rider
    When user selects rider from the left menu and list of rider to get rider
    And Select create rider
    Then rider should be deleted

  Scenario: Admin can view rider details from list of rider
    Given user logs in with valid credentials to get list of rider
    When user selects rider from the left menu and list of rider to get rider
    And Select view rider email number 15
    Then rider should be deleted


     Scenario: Admin can open the rider list page and filter using a search value
       Given user logs in with valid credentials to get list of rider
       When user selects rider from the left menu and list of rider to get rider
       And user select search box and enter value "ahmed" in search box
       Then The filtered riders list should be displayed

    Scenario: Admin can open the rider list page and filter using date
      Given user logs in with valid credentials to get list of rider
      When user selects rider from the left menu and list of rider to get rider
      And user filtered with start date "2025-01-11" to end date "2025-02-22"
      And user confirm filter by click on "apply" button
      Then The filtered riders list should be displayed
