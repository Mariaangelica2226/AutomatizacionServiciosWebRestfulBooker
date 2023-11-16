package org.example.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.example.steps.GeneralStepDefinitions.baseURI;

public class ValidBookingIdSearchStepDefinitions {

    @Given("a booking with ID {string}")
    public void setBookingId(String bookingId) {
        given().pathParam("id", bookingId);
    }

    @When("a GET request is made to retrieve the booking details")
    public void getBookingDetails() {
        when()
        .get(baseURI+"/booking/{id}");
       then().log().all();
       lastResponse().prettyPrint();
    }
}