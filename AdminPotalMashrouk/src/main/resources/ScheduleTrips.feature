Feature: Schedule trips
  Scenario: user can book scheduled trip
    Given user logs in with valid credentials to book schedule trip
    When user selects trips from the left menu to book schedule trip
    And user selects schedule trips from the left menu to book schedule trip
    And user set first name "Alaa" and set number of passenger "3 seats"
    And user select "pickup 2" at request pickup point and select drop off point from map
    And user set time hours 1 and minutes 15 at "am"
    And user set end time hours 7 and minutes 55 at "pm"
    And user confirm ride
    Then user book successfully
