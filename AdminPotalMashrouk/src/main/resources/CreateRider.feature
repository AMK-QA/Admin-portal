Feature: Create rider page

  Scenario: User can sign in with valid credentials and create a rider
    Given user logs in with valid credentials to create rider
    When user selects rider from the left menu to create rider
    And  user selects create rider to create rider
    And user enter his first name "alaa" and last name "taher"
    And user enter his email
    And user set his password and confirmation password
    And user set his phone number
    And user set gender "female" type and set his status "inactive"
    And user set wheelchair accessibility "no" and his birthday "26/01/1999"
    And user add nationality "egypt" and religion "islam"
    And click on create button
    Then rider created successfully