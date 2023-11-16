package org.example.steps;

import com.google.gson.JsonObject;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.core.Serenity.sessionVariableCalled;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.example.steps.GeneralStepDefinitions.baseURI;
import static org.hamcrest.Matchers.equalTo;

public class UpdateBookingStepDefinitions {

    @Given("there is an existing booking with ID {int}")
    public void getExistingBookingDetails(int bookingId) {
        given()
                .pathParam("id", bookingId)
                .when()
                .get(baseURI + "/booking/{id}");
    }

    @When("a {string} request is made to update the booking {int} details with the following data:")
    public void makePostRequest(String method, int bookingId, List<Map<String, String>> dataTable) {
        Map<String, String> item = dataTable.get(0);

        JsonObject bookingDetails = new JsonObject();
        if (item.containsKey("firstname")) bookingDetails.addProperty("firstname", item.get("firstname"));
        if (item.containsKey("lastname")) bookingDetails.addProperty("lastname", item.get("lastname"));
        if (item.containsKey("totalprice"))
            bookingDetails.addProperty("totalprice", Integer.parseInt(item.get("totalprice")));
        if (item.containsKey("depositpaid"))
            bookingDetails.addProperty("depositpaid", Boolean.parseBoolean(item.get("depositpaid")));
        JsonObject bookingDates = new JsonObject();
        if (item.containsKey("checkin")) bookingDates.addProperty("checkin", item.get("checkin"));
        if (item.containsKey("checkout")) bookingDates.addProperty("checkout", item.get("checkout"));
        if (item.containsKey("checkin") || item.containsKey("checkout"))
            bookingDetails.add("bookingdates", bookingDates);
        if (item.containsKey("additionalneeds"))
            bookingDetails.addProperty("additionalneeds", item.get("additionalneeds"));

        given()
                .contentType("application/json")
                .header("Cookie", "token=" + sessionVariableCalled("token"))
                .body(bookingDetails.toString())
                .pathParam("id", bookingId);

        if (method.equals("PUT")) {
            when().put(baseURI + "/booking/{id}");
        } else if (method.equals("PATCH")) {
            when().patch(baseURI + "/booking/{id}");
        } else {
            System.out.println("Invalid HTTP Method");
        }

    }

    @Then("the updated booking details should match the expected values")
    public void verifyUpdatedBookingDetails(List<Map<String, String>> expectedBookingDetails) {
        Map<String, String> item = expectedBookingDetails.get(0);

        if (item.containsKey("firstname")) then().body("firstname", equalTo(item.get("firstname")));
        if (item.containsKey("lastname")) then().body("lastname", equalTo(item.get("lastname")));
        if (item.containsKey("totalprice"))
            then().body("totalprice", equalTo(Integer.parseInt(item.get("totalprice"))));
        if (item.containsKey("depositpaid"))
            then().body("depositpaid", equalTo(Boolean.parseBoolean(item.get("depositpaid"))));
        if (item.containsKey("bookingdates")) then().body("bookingdates.checkin", equalTo(item.get("checkin")));
        if (item.containsKey("bookingdates")) then().body("bookingdates.checkout", equalTo(item.get("checkout")));
        if (item.containsKey("additionalneeds")) then().body("additionalneeds", equalTo(item.get("additionalneeds")));
    }
}