@Search
Feature: Search function

  As a User
  I WANT to search for a product
  SO THAT I can see respective product

  Background:
    Given    User is on Homepage

  @Smoke
  Scenario:
    When    User search for a "nike" on search box
    Then    User should get the respective product

  @Regression
  Scenario Outline:
    When   User search for a "<product>" on search box
    Then   User should get the respective "<product>"

    Examples:
      | product |
      | earring |
      | watch   |