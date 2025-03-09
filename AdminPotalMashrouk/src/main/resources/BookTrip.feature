Feature: Book trips
  Scenario: user can book trip
    Given user logs in with valid credentials to book trip
    When user selects trips from the left menu to book trip
    And user selects schedule trips from the left menu to book trip
    And user set first name "Alaa" and set number of passenger "3 seats" to book trip
    And user select "pickup 2" at request pickup point and select drop off point from map to book trip
    And user confirm ride at book ride
    Then user book successfully to book trip