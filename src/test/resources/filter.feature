@Filter
Feature: Filtered Products

  As a User
  I WANT to select filter for products
  SO THAT I can see my  prefered searched products

  Background:
    Given    User is on Homepage
    When     User search for a "nike" on search box

  @Price
  Scenario: Filter product by Price

    And      User select a filter by "£15 - £20" on result page products
    Then     User should see all product with min price "15.00" and max price "20.00"

  @Category
  Scenario: Filter product by category

    And    User select a filter category "Smart watches" on result page products
    Then   User should see all products according to the "Smart watches" selected category

  @Rating
  Scenario: Filter product by Rating

    And    User select a rating "3or more" on result page product
    Then   User should see all products according "3.00" to the selected rating

  @Sorting
  Scenario: Filter product by Sorting

    And    User select sort By "Price: Low - High" on resultPage
    Then   User should see all products according to the selected preference





