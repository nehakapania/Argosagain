Feature: Trolley

  As a User
  I WANT to add product to trolley
  SO THAT I can shop my  prefered searched products

  Background:  Trolley
    Given      User is on Homepage
    When       User search for a "nike" on search box
    And        User select any product from resultPage
    And        User add product to the basket
    And        User add basket product to go to trolley

  @Trolley
  Scenario:  Increase Quantity
    And        User increase quantity "2"of selected product
    Then       User should be able to see products increased of selected product

    @Remove
  Scenario: Remove Product from basket
    And     User removed the product from basket
    Then    User should be able to see that product is removed from basket


      @UndoRemove
      Scenario: Undo remove the deleted product
        And     User removed the product from basket
        And     User select undo removed product on Trolley page
        Then    User should be able to  see that  same deleted product added again to trolley
