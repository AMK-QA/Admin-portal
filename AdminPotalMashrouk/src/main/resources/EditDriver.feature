Feature: Edit driver profile

  Scenario: driver can update his profile
    Given driver login with his credentials
    When driver select driver from left side menu
    And driver open list of driver
    And driver select his email number 4 and click on edit profile icon
    And user change his first name "alaa" and last name "taher" at edit driver page
    And update his email and phone number at edit driver page
    And set id number and licence details "6656" and expiration date "2025-10-26"
    And update rider status "active" and select nationality
    And update gender "female" at edit driver page
    And update birthday to "1999-04-25" at edit driver page
    And upload profile photo
    And confirmation updated information at edit driver page
    Then changes updated successfully at edit driver page