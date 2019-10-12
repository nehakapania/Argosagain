Feature: Register
  As a User
  I WANT to register to argos account
  SO THAT I can shop from my argos account

  Background:
    Given    User is on Homepage
    @Register
    Scenario: registration
      When   User click on account icon on homepage
      Then   User should be able to see Registration page successfully

