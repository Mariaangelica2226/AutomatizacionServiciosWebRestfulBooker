Feature: Search Bookings by Checkin and Checkout Dates


  @smoke @happy-path
  Scenario Outline: Search bookings with valid checkin and checkout dates
    When a GET request is made to search bookings with the following criteria "<checkin>" and "<checkout>"
    Then the response status code should be 200
    And  I validate the response with a JSON Schema "getBookingsIds"
    And the response should contain a list of booking IDs

    Examples:
      | checkin    | checkout   |
      | 2018-01-01 | 2019-01-01 |

  @smoke @unhappy-path
  Scenario Outline: Search bookings with invalid checkin and valid checkout dates
    When a GET request is made to search bookings with the following criteria "<checkin>" and "<checkout>"
    And the response should be an empty list of bookings if no matching bookings are found


    Examples:
      | checkin    | checkout   |
      | 0500-10-21 | 0000-11-23 |

  @smoke @unhappy-path
  Scenario Outline: Search bookings with valid checkin and invalid checkout dates
    When a GET request is made to search bookings with the following criteria "<checkin>" and "<checkout>"
    Then the response status code should be 500

    Examples:
      | checkin    | checkout |
      | 0500-10-21 | invalid  |

  @smoke @unhappy-path
  Scenario Outline: Search bookings with both invalid checkin and checkout dates
    When a GET request is made to search bookings with the following criteria "<checkin>" and "<checkout>"
    Then the response status code should be 500

    Examples:
      | checkin | checkout |
      | invalid | invalid  |

