package com.step_it.step_definitions;

import com.step_it.steps.LoginSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginDefinitions {
    private LoginSteps loginSteps;

//    public LoginDefinitions(LoginSteps loginSteps) {
//        this.loginSteps = loginSteps;
//    }

    @When("the user enters correct {word} and {word}")
    public void theUserEntersCorrectUsernameAndPassword(String username, String password) {
        loginSteps.login(username, password);
    }

    @When("the user logs out")
    public void theUserLogsOut() {
        loginSteps.logout();
    }
}
