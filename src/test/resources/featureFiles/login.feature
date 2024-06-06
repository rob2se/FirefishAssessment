Feature: Login

  Background:
    Given I am on the login page

  Scenario Outline: Valid login
    When I accept the cookie policy
    And I enter an email address "<email address>"
    And I enter a password "<password>"
    And I click on the login button
    Then I am successfully logged in
    Examples:
    |email address          |password   |
    |joebloggs@testuser.dud |zyefszbb8  |


  Scenario Outline: invalid login
    When I accept the cookie policy
    And I enter an email address "<email address>"
    And I enter a password "<password>"
    And I click on the login button
    Then An error is displayed
    Examples:
      |email address          |password   |
      |xxxxxx@xxxxxx.com      |xxxxxxxxx  |