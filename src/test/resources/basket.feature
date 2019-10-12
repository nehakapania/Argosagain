Feature: Basket
  As a User
  I WANT to add product to basket
  SO THAT I can shop my  prefered searched products


  Background:  Add product to the basket
    Given      User is on Homepage
    When       User search for a "nike" on search box
    And        User select any product from resultPage
    And        User add product to the basket

  @Wip
  Scenario:
    Then      User should see product been added to the basket