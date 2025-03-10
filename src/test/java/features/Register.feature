Feature: User Registration on Demo Web Shop

  Scenario: Registering a new user
    Given User is on Demo Web Shop registration page
    When User enters valid details
    And User clicks register button
    Then User should be registered successfully
