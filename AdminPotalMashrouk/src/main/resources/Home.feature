Feature: Home page
  Scenario: User can open create rider page
    Given user logs in with valid credentials
    When user selects rider from the left menu
    And  user selects create rider
    Then user can open the rider creation page

  Scenario: User can open list of rider page
    Given user logs in with valid credentials
    When user selects rider from the left menu
    And  user selects list rider
    Then user can open list of rider page

  Scenario: Admin can open create driver page
    Given user logs in with valid credentials
    When user selects driver from the left menu
    And  user selects create driver
    Then user can open the driver creation page


  Scenario: Admin can open list of driver page
    Given user logs in with valid credentials
    When user selects driver from the left menu
    And  user selects list of driver
    Then user can open the list Of driver page

  Scenario: Admin can open book trip page
    Given user logs in with valid credentials
    When user selects trips from the left menu
    And  user selects book trip
    Then user can open the book trip page

  Scenario: Admin can open List of trips page
    Given user logs in with valid credentials
    When user selects trips from the left menu
    And  user selects list of trip
    Then user can open the list of trips page

  Scenario: Admin can open schedule trips page
    Given user logs in with valid credentials
    When user selects trips from the left menu
    And  user selects schedule trip
    Then user can open the schedule trips page

  Scenario: Admin can open list of vehicle page
    Given user logs in with valid credentials
    When user selects vehicle from the left menu
    And  user selects list of vehicle
    Then user can open the list of vehicle page


  Scenario: Admin can open create vehicle page
    Given user logs in with valid credentials
    When user selects vehicle from the left menu
    And  user selects create vehicle
    Then user can open the create vehicle page

  Scenario: Admin can open drivers settings page
    Given user logs in with valid credentials
    When user selects configurations from the left menu
    And  user selects drivers setting
    Then user can open the drivers settings page

  Scenario: Admin can open riders settings page
    Given user logs in with valid credentials
    When user selects configurations from the left menu
    And  user selects riders setting
    Then user can open the riders settings page

  Scenario: Admin can open trips settings page
    Given user logs in with valid credentials
    When user selects configurations from the left menu
    And  user selects trips setting
    Then user can open the trips settings page