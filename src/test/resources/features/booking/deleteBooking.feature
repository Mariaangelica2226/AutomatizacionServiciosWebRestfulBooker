Feature: Booking API Tests

  @smoke @happy-path
  Scenario Outline: Delete a booking by ID
    Given there is an existing booking with ID <bookingId>
    When a DELETE request is made to delete the booking with ID <bookingId>
    Then the response status code should be 201

    Examples:
      | bookingId |
      | 48        |
      | 137       |

  @smoke @unhappy-path
  Scenario Outline: Attempt to delete a non-existent booking
    When a DELETE request is made to delete the booking with ID <bookingId>
    Then the response status code should be 405

    Examples:
      | bookingId |
      | -1000     |
      | 000       |