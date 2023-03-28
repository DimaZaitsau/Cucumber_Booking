Feature: Booking search testing

  Background:
    Given I am at booking.com page

   Scenario Outline: Search the hotel and validate the rating
      When I set "<searchValue>" in the search bar
      And I click "<searchValue>" in the dropdown menu
      And I click the search button
      Then "<expectedResult>" should be present under index <index>
      Then The hotel under index <index> should have score "<hotelScore>"

     Examples:
       |searchValue|expectedResult|hotelScore|index|
       |Hilton Head Island|The Westin Hilton Head Island Resort & Spa|8.0|1|
       |Hilton Head Island|Grand Hilton Head Inn, Ascend Hotel Collection|7.3|2|