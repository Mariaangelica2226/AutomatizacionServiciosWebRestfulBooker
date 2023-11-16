package org.example.steps;

import io.cucumber.java.en.When;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.rest.SerenityRest.given;
import static org.example.steps.GeneralStepDefinitions.baseURI;

public class DeleteBookingStepDefinitions {


    @When("a DELETE request is made to delete the booking with ID {int}")
    public void makeDeleteRequest(int bookingIdToDelete) {
        given()
                .pathParam("id", bookingIdToDelete)
                .header("Cookie", "token=" + sessionVariableCalled("token"))
                .contentType("application/json")
                .when()
                .delete(baseURI + "/booking/{id}");
    }
}