Feature: Ping Health Check Validation

  @smoke @happy-path
  Scenario: Test PING endpoint
    Given do a "GET" request to the endpoint "/ping"
    Then the response status code should be 201
