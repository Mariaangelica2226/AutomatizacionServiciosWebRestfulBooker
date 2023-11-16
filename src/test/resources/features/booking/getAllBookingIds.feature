Feature: Booking Ids

  @smoke @happy-path
  Scenario: Retrieve all booking IDs
    When a GET request is made to retrieve all booking IDs
    Then the response status code should be 200
    And I validate the response with a JSON Schema "getBookingsIds"
    And the response should contain a list of booking IDs
