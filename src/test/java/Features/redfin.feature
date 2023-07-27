Feature: Apply the price filter

  @tc1103
  Scenario: Apply the price filter

    When user go to provided URL "https://www.redfin.com/"
    And user types a large city name "Chicago"
    Then  user clicks on the search button
    And User apply the price filter with values "100000" and "200000"
    Then verify the results within the specified range on the first 2 pages "100000" and "200000"