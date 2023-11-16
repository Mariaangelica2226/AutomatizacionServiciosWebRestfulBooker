Feature: Search Bookings by Fullname

  @smoke @happy-path
  Scenario Outline: Search Bookings by Fullname
    When I request get  is made to search bookings by firstname "<firstname>" and lastname "<lastname>"
    Then the response status code should be <status_code>
    And I validate the response with a JSON Schema "searchByFullname"
    And the response should contain a list of bookings with matching names

    Examples:
      | firstname | lastname | status_code |
      | John      | Smith    | 200         |

  @smoke @unhappy-path
  Scenario Outline: Search Bookings by invalid Fullname
    When I request get  is made to search bookings by firstname "<firstname>" and lastname "<lastname>"
    Then the response status code should be <status_code>
    And the response should contain an empty list of bookings if no matching bookings are found

    Examples:
      | firstname        | lastname        | status_code |
      | invalidfirstname | brown           | 200         |
      | sally            | invalidlastname | 200         |
      | invalidfirstname | invalidlastname | 200         |

