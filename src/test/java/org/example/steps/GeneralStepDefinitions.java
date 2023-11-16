package org.example.steps;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.parsing.Parser;
import org.junit.Assume;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

public class GeneralStepDefinitions {

    public static String baseURI = "https://restful-booker.herokuapp.com";

    @Before
    public void healthCheck() {
        registerParser("text/plain", Parser.JSON);
        doAnHTTPRequest("GET", "/ping");
        Assume.assumeTrue(then().extract().statusCode() == 201);
    }


    @Given("do a {string} request to the endpoint {string}")
    public void doAnHTTPRequest(String HTTPMethod, String endpoint) {
        switch (HTTPMethod) {
            case "GET" -> given().get(baseURI + endpoint);
            case "POST" -> given().post(baseURI + endpoint);
            case "PUT" -> given().put(baseURI + endpoint);
            case "DELETE" -> given().delete(baseURI + endpoint);
            default -> System.out.println("Invalid HTTP Method");
        }
    }

    @Then("the response status code should be {int}")
    public void verifyResponseStatusCode(int statusCode) {
        then().statusCode(statusCode);
    }

    @Then("I validate the response with a JSON Schema {string}")
    public void iValidateTheResponseWithAJSONSchema(String jsonSchema) {
        then().assertThat().body(matchesJsonSchemaInClasspath("jsonschemas/" + jsonSchema + ".json"));
    }

    @Then("the response should contain a list of booking IDs")
    public void verifyResponseContainsBookingIDs() {
        then().body("", hasSize(greaterThan(0)));
    }

}
