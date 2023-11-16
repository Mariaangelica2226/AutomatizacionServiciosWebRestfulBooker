package org.example.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static net.serenitybdd.core.Serenity.setSessionVariable;
import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.example.steps.GeneralStepDefinitions.baseURI;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class AuthenticationStepDefinitions {

    @When("a POST request is made with username {string} and password {string}")
    public void makePostRequest(String username, String password) {
        given()
                .header("Content-Type", "application/json")
                .body("{\"username\":\"" + username + "\",\"password\":\"" + password + "\"}")
                .when()
                .post(baseURI + "/auth");
    }

    @And("the response should contain a token")
    public void verifyResponseContainsToken() {
        setSessionVariable("token").to(then().extract().path("token"));
        then().body("token", notNullValue());
    }

    @And("the response should contain the text {string}")
    public void verifyResponseContainsText(String expectedText) {
        then().body("reason", equalTo(expectedText));
    }
}

