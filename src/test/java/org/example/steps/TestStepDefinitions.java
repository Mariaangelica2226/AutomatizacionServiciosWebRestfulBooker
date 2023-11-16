package org.example.steps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.hamcrest.Matchers;
import static org.example.steps.GeneralStepDefinitions.baseURI;

import static net.serenitybdd.rest.SerenityRest.*;


public class TestStepDefinitions extends UIInteractionSteps {

    @Step("Busca los elementos y realiza una accion por cada uno")
    public void useElements() {
        given().get(baseURI+"/booking");
    }

    @Step("Busca los elementos y realiza una accion por cada uno 2")
    public void useElements2() {
        then().statusCode(200).body("[0]", Matchers.hasKey("bookingid"));
    }
}