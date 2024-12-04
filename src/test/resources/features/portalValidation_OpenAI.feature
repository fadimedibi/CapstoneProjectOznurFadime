@openAIValidation
Feature: Validate tabs on NAU Portal

  Background:
    Given User is on the main page

  @AIValidation
  Scenario Outline: Verify <contentType> in the NAU Portal
    When I am on the NAU Portal page
    Then I validate the "<contentType>" using AI

    Examples:
      | contentType    |
      | tabs           |
      | customContents |
      | quickLinks     |