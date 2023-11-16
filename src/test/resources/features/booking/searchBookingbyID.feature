Feature: Search Booking by ID

  @smoke @happy-path
  Scenario Outline: Retrieve booking details by ID
    Given a booking with ID "<bookingId>"
    When a GET request is made to retrieve the booking details
    Then the response status code should be 200
    And I validate the response with a JSON Schema "bookingDetail"

    Examples:
      | bookingId |
      | 52        |
      | 73        |

  @smoke @unhappy-path
  Scenario Outline: Attempt to retrieve a booking with an invalid ID
    Given a booking with ID "<bookingId>"
    When a GET request is made to retrieve the booking details
    Then the response status code should be 404

    Examples:
      | bookingId  |
      | 6669999000 |
      | -78999999  |