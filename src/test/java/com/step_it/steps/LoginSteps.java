package com.step_it.steps;

import com.step_it.pages.LoginPage;
import com.step_it.pages.MainPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
public class LoginSteps {
    private LoginPage loginPage;
    private MainPage mainPage;

//    public LoginSteps(LoginPage loginPage, MainPage mainPage) {
//        this.loginPage = loginPage;
//        this.mainPage = mainPage;
//    }

    public void login(String username, String password) {
        log.info("User logs in to app with username: {} and password: {}", username, password);
        loginPage.login(username, password);
    }
    public void logout() {
        log.info("User logs out from app");
        mainPage.logout();
    }
}
