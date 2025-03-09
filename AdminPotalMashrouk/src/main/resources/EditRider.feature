Feature: Edit rider profile

  Scenario: Rider can change his first name
    Given rider login with his credentials
    When rider select rider from left side menu
    And rider open list of rider
    And rider select his email number 4 and click on edit profile icon
    And user change his first name "alaa" and last name "taher"
    And confirmation updated information
    Then changes updated successfully


  Scenario: Rider can update his profile0
    Given rider login with his credentials
    When rider select rider from left side menu
    And rider open list of rider
    And rider select his email number 4 and click on edit profile icon
    And user change his first name "alaa" and last name "taher"
    And update his email and phone number
    And update gender "female"
    And update rider status "inactive" and wheelchair accessibility "no"
    And update birthday to "1999-04-25"
    And confirmation updated information
    Then changes updated successfully