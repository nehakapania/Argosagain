Feature: Login
  As a User
  I WANT to login to my argos account
  SO THAT I can shop from my argos account

  Background:Login User
    Given    User is on Homepage
    When     User click on account icon on homepage
  @Login
  Scenario: Login
    And    User enters their valid "kapania.saurabh@gmail.com" email address
    And    User enters valid "tannush07" password
    And    User click on SignIn button
    Then   User should be able to login to their account successfully

  @Login@Regression
  Scenario Outline: login user
    And    User enters their invalid "<email>" email address
    And    User enters invalid "<password>" password
    And    User click on SignIn button
    Then   User should not be able to login
    And    User should get a valid message successfully

    Examples:
    |email| password|
    |neha@gmail.com|asdfg|
    |Tanzuku@yahoo.com|qwet2333|

