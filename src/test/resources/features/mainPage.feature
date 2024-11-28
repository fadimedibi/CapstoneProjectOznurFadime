@dashboard
Feature: Verify main page

  Background: Verify main page
    Given User is on the main page

  @logo
  Scenario: Verify main page logo
    Then verify that logo is available


  @gift_shop
  Scenario: Verify Gift Shop
    Then verify that Gift Shop is clickable

  @contact_information
  Scenario: Verify NA contact information
    And User scrolls down the page
    Then User sees the contact information

  @search_box
  Scenario Outline: Verify Search Box works as expected
    When User searches "<searchValue>"
    Then Expected title "<expectedTitle>" should include search value

    Examples: Search values User want to search in Search Box
      | searchValue   | expectedTitle |
      | admissions    | admissions    |
      | tuition       | tuition       |
      | calendar      | calendar      |
      | courses       | courses       |
      | financial aid | financial aid |

  @warning_message
  Scenario Outline: Verify warning message appears when user search invalid value
    When User searches invalid "<searchText>"
    Then User should see "Oops!" as a warning message

    Examples: Search values User want to search in Search Box
      | searchText |
      | &tst*ve    |
      | k1l2m3     |
      | %&@        |