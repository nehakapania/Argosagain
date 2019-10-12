@Help
Feature: HelpIcon
  As a User
  I WANT to take online help for compairing product
  SO THAT I can decide to buy product of my choice

  Background:  Help
    Given      User is on Homepage
    When       User click on help icon on homepage

  Scenario:   HelpIcon
    Then       User should able to see a help result page successfully


  Scenario:   HelpIcon
    And      User ask a  question in help search box"How many days of return policy you have"
    Then     User should be navigated to a help result page successfully


