Feature: Create Booking

  @smoke @happy-path

  Scenario: Create a booking with valid details
    When a POST request is made to "/booking" with the following details:
      | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Jim       | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    Then the response status code should be 200
    And  I validate the response with a JSON Schema "createBooking"

  @smoke  @unhappy-path

  Scenario: Attempt to create a booking with invalid details
    When a POST request is made to "/booking" with the following details:
      | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
    Then the response status code should be 500



