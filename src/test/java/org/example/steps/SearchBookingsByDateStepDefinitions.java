package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.Matchers.empty;
import static org.example.steps.GeneralStepDefinitions.baseURI;

public class SearchBookingsByDateStepDefinitions {

        @When("a GET request is made to search bookings with the following criteria {string} and {string}")
        public void makeGetRequestToSearchBookingsWithCriteria(String checkin, String checkout) {
                Map<String, String> requestParams = new HashMap<>();

                requestParams.put("checkin", checkin);
                requestParams.put("checkout", checkout);

                given()
                .queryParams(requestParams)
                .get(baseURI+"/booking");

        }


        @And("the response should be an empty list of bookings if no matching bookings are found")
        public void verifyResponseContainsEmptyList() {
                then().body("", empty());
        }

}
