@chatGPTValidation
Feature: Validate tabs on NAU Portal

  Background:
    Given User is on the main page

  @tabsAI
  Scenario: Verify the tabs in the NAU Portal
    When I am on the NAU Portal page
    Then I validate the tabs using AI

  @quickLinksAI
  Scenario: Verify the quickLinks in the NAU Portal
    When I am on the NAU Portal page
    Then I validate the quickLinks using AI