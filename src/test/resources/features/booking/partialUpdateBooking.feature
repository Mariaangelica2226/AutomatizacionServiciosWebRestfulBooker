Feature: Partial Update Booking

  @smoke @happy-path
  Scenario Outline: Partially Update a booking with valid data
    When a "PATCH" request is made to update the booking <bookingId> details with the following data:
      | firstname   | lastname   |
      | <firstname> | <lastname> |
    Then the response status code should be 200
    And the updated booking details should match the expected values
      | firstname   | lastname   |
      | <firstname> | <lastname> |

    Examples:
      | bookingId | firstname | lastname |
      | 1         | Jim       | Brown    |
      | 2         | John      | Smith    |

  @smoke @unhappy-path
  Scenario Outline: Attempt to partial update a booking with invalid ID
    When a "PATCH" request is made to update the booking <bookingId> details with the following data:
      | firstname   | lastname   |
      | <firstname> | <lastname> |
    Then the response status code should be 405

    Examples:
      | bookingId | firstname | lastname |
      | -1000     | James     | Brown    |
      | 00        | John      | Smith    |

  @smoke @unhappy-path
  Scenario Outline: Attempt to partial update a booking with invalid field
    When a "PATCH" request is made to update the booking <bookingId> details with the following data:
      | nickname    | lastname   |
      | <firstname> | <lastname> |
    Then the response status code should be 405

    Examples:
      | bookingId | firstname | lastname |
      | -1000     | James     | Brown    |
      | 00        | John      | Smith    |



