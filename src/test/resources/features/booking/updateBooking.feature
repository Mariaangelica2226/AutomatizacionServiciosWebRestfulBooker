Feature: Update Booking

  @smoke @happy-path
  Scenario Outline: Update a booking with valid details
    Given there is an existing booking with ID <bookingId>
    When a "PUT" request is made to update the booking <bookingId> details with the following data:
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Then the response status code should be 200
    And I validate the response with a JSON Schema "bookingDetail"
    And the updated booking details should match the expected values
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |

    Examples:
      | bookingId | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | 1         | James     | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
      | 2         | John      | Smith    | 150        | false       | 2022-03-15 | 2022-03-20 | Lunch           |

  @smoke @unhappy-path
  Scenario Outline: Attempt to update a booking with invalid ID
    When a "PUT" request is made to update the booking <bookingId> details with the following data:
      | firstname   | lastname   | totalprice   | depositpaid   | checkin   | checkout   | additionalneeds   |
      | <firstname> | <lastname> | <totalprice> | <depositpaid> | <checkin> | <checkout> | <additionalneeds> |
    Then the response status code should be 405

    Examples:
      | bookingId | firstname | lastname | totalprice | depositpaid | checkin    | checkout   | additionalneeds |
      | -1000     | James     | Brown    | 111        | true        | 2018-01-01 | 2019-01-01 | Breakfast       |
      | 00        | John      | Smith    | 150        | false       | 2022-03-15 | 2022-03-20 | Lunch           |



