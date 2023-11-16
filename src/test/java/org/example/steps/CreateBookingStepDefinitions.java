package org.example.steps;

import com.google.gson.JsonObject;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.given;
import static org.example.steps.GeneralStepDefinitions.baseURI;

public class CreateBookingStepDefinitions {

    @When("a POST request is made to {string} with the following details:")
    public void makePostRequest(String endpoint, List<Map<String, String>> dataTable) {

        JsonObject bookingDetails = new JsonObject();
        bookingDetails.addProperty("firstname", dataTable.get(0).get("firstname"));
        bookingDetails.addProperty("lastname", dataTable.get(0).get("lastname"));
        bookingDetails.addProperty("totalprice", Integer.parseInt(dataTable.get(0).get("totalprice")));
        bookingDetails.addProperty("depositpaid", Boolean.parseBoolean(dataTable.get(0).get("depositpaid")));
        JsonObject bookingDates = new JsonObject();
        bookingDates.addProperty("checkin", dataTable.get(0).get("checkin"));
        bookingDates.addProperty("checkout", dataTable.get(0).get("checkout"));
        bookingDetails.add("bookingdates", bookingDates);
        bookingDetails.addProperty("additionalneeds", dataTable.get(0).get("additionalneeds"));

        given()
                .contentType("application/json")
                .body(bookingDetails.toString())
                .when()
                .post(baseURI+endpoint);
    }
    @When("a GET request is made to {string}")
    public void makeGetRequest(String endpoint) {
        given().get(endpoint);
    }

}