Feature: Create rider page
  Scenario: User can sign in with valid credentials and create a driver
    Given user logs in with valid credentials to create driver
    When user selects driver from the left menu to create driver
    And  user selects create driver to create driver
    And user enter his first name "alaa" and last name "taher" at driver form
    And user enter his Id at driver form
    And user enter his email at driver form
    And user enter his driver licence "6656" and expiration date "2025-10-26"
    And user set his password and confirmation password at driver form
    And user set his phone number at driver form
    And user set gender "female" type and set his status "active" at driver form
    And user set nationality and his birthday "1999-01-26" at driver form
    And user enter his photo
    And click on create button at driver form
    Then driver created successfully