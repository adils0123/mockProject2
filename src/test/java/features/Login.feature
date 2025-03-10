Feature: Login with Excel Data

  Scenario: User logs in using credentials from Excel
    Given User is on the login page
    When User enters credentials from "LoginData.xlsx" and sheet "Sheet1"
    Then User should be logged in successfully
