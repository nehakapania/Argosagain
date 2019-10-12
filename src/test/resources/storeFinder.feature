@StoreSearch
Feature: StoreFinder
  As a User
  I WANT to find a  store near me
  SO THAT I can do shopping in that particular located store

  Background:
    Given      User is on Homepage
    When       User click on Store icon on homepage


  Scenario: Store finder
    Then       User should able to see a sore finder result page with search box successfully


   Scenario: StoreFinder With Postcode
     And      User search for a store with "Braintree Argos"
     And      User click on search magnifier glass
     Then     User should able to see all nearer located stores successfully

