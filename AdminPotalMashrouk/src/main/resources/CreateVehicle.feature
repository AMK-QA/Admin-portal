Feature: create vehicle
  Scenario: Admin can create vehicle
    Given user logs in with valid credentials to create vehicle
    When user selects vehicle from the left menu to create vehicle
    And  user selects create vehicle at create vehicle
    And user set brand name "Toyota" and model "gfjh"
    And user set plate number "1542" and licence type "driver"
    And user set driver "hhs" with status "verified"
    And user confirm creation
    Then vehicle is created successfully