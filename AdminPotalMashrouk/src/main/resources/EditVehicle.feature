Feature: Edit vehicle profile

  Scenario: admin can update vehicle page
    Given user logs in with valid credentials to edit vehicle
    When user selects vehicle from the left menu to edit vehicle
    And  user selects list of vehicle and click on edit vehicle with number 6
    And user edit brand name "Toyota" and model "gfjh"
    And user edit plate number "1542" and licence type "driver"
    And user edit driver "hhs" with status "verified"
    And user confirm editing
    Then vehicle is edited successfully