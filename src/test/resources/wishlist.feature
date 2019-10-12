Feature: Wishlist
  As a User
  I WANT to add product to Wishlist
  SO THAT I can shop my saved products of Wishlist later

  Background:
    Given      User is on Homepage
    When       User search for a "nike" on search box
    And        User select any product from resultPage

  @Wishlist
  Scenario:
    And        User select on wishlist icon on result page
    Then       User should see product been added to the wishlist
