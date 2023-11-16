package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static net.serenitybdd.rest.SerenityRest.given;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.*;
import static org.example.steps.GeneralStepDefinitions.baseURI;

public class SearchBookingsByInvalidFullnameStepDefinitions {
    @When("I request get  is made to search bookings by firstname {string} and lastname {string}")
    public void searchBookingsByFirstnameAndLastname(String firstname, String lastname) {
        given()
                .queryParam("firstname", firstname)
                .queryParam("lastname", lastname)
                .get(baseURI+"/booking");
    }
    @And("the response should contain a list of bookings with matching names")
    public void verifyResponseContainsMatchingBookings() {
        then().body("", hasSize(greaterThan(1)));

    }
    @And("the response should contain an empty list of bookings if no matching bookings are found")
    public void verifyResponseContainsEmptyList() {
        System.out.println("Response: " + then().extract().body().asString());
        then().body("", empty());
    }

}