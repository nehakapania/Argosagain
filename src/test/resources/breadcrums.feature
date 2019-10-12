Feature: Breadcrums
  As a User
  I WANT to click on items by breadcrum title
  SO THAT I can shop my  preffered  products

  @Breadcrum
  Scenario:
    Given      User is on Homepage
    When       User Click on any "Shop" breadcrum
    And        User Click on any "Appliances" department
    And        User click on any "Freezers" product
    Then       User should see respective products successfully
