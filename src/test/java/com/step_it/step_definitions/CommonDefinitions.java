package com.step_it.step_definitions;

import com.step_it.steps.CommonSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CommonDefinitions {
    private CommonSteps commonSteps;

//    public CommonDefinitions(CommonSteps commonSteps) {
//        this.commonSteps = commonSteps;
//    }

    @Given("the app login page is open")
    public void theAppLoginPageIsOpen() {
        commonSteps.checkLoginPageIsOpen();
    }
    @Then("the user is logged in")
    public void theUserIsLoggedIn() {
        commonSteps.checkUserLoggedIn();
    }
    @Then("the cart counter is updated by {int}")
    public void theCartCounterIsUpdatedBy(int counter) {
        commonSteps.checkCartCounterUpdated(counter);

    }
}
