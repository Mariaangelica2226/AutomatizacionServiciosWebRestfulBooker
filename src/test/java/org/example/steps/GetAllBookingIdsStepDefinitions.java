package org.example.steps;

import io.cucumber.java.en.When;
import static org.example.steps.GeneralStepDefinitions.baseURI;
import static net.serenitybdd.rest.SerenityRest.given;

public class GetAllBookingIdsStepDefinitions {

    @When("a GET request is made to retrieve all booking IDs")
    public void makeGetRequestToRetrieveBookingIDs() {
        given().get(baseURI+"/booking");
    }
}