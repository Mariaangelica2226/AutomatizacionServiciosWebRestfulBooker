Feature: Authentication API Testing


  @smoke @happy-path
  Scenario Outline: Successful user authentication
    When a POST request is made with username "<username>" and password "<password>"
    Then the response status code should be <status_code>
    And I validate the response with a JSON Schema "authCreateToken"
    And the response should contain a token
    Examples:
      | username | password    | status_code |
      | admin    | password123 | 200         |

  @smoke @unhappy-path
  Scenario Outline: Failed Authentication
    When a POST request is made with username "<username>" and password "<password>"
    Then the response status code should be <status_code>
    And the response should contain the text "Bad credentials"
    Examples:
      | username    | password    | status_code |
      | invaliduser | invalidpass | 400         |
