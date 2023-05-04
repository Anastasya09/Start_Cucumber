package com.step_it.steps;

import com.step_it.pages.LoginPage;
import com.step_it.pages.MainPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
@Slf4j
@AllArgsConstructor
public class CommonSteps {
    private LoginPage loginPage;
    private MainPage mainPage;

//    public CommonSteps(LoginPage loginPage, MainPage mainPage) {
//        this.loginPage = loginPage;
//        this.mainPage = mainPage;
//    }
    public void checkLoginPageIsOpen() {
        log.info("Check login page is open");
        assertThat(loginPage.isLogoDisplayed()).as("The login page is not displayed").isTrue();
    }
    public void checkUserLoggedIn() {
        log.info("Check user is logged in");
        assertThat(mainPage.isTitleDisplayed()).as("The title is not displayed").isTrue();
    }

    public void checkCartIsEmpty() {
        log.info("Check cart is empty");
        checkCartCounter(0, "The cart is not empty");
    }

    public void checkCartCounterUpdated(int counter) {
        log.info("Check cart counter got updated");
        checkCartCounter(counter, "The counter was not updated");
    }

    private void checkCartCounter(int counter, String assertionMessage) {
        assertThat(mainPage.getProductCountsInCart()).as(assertionMessage).isEqualTo(counter);
    }

}
