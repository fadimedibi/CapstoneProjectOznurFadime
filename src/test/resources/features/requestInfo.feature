@requestInfo
Feature: Request Info Module

  Background:
    Given User is on the main page
    When User clicks on the Request Info module

  @request_info_form_title
  Scenario:User should be able to see the request info form title
    Then Verify request info form title should be "Admissions Information Request"

  @request_info_Captcha_checkbox
  Scenario:User should be able to see Captcha checkbox
    Then verify Captcha checkbox is displayed

  @request_info_without_athlete
  Scenario:Verify captcha checkbox is displayed without filling athlete information
    When User fill out all information boxes excluding Athlete information
    Then verify Captcha checkbox is displayed

  @request_info_with_athlete
  Scenario:Verify captcha checkbox is displayed with filling athlete information
    When User fill out all information boxes including Athlete information
    Then verify Captcha checkbox is displayed

  @without_clicking_Captcha
  Scenario: User should not be able to submit request info without clicking Captcha box
    When User fill out all information boxes
    Then verify Submit button is not clickable
