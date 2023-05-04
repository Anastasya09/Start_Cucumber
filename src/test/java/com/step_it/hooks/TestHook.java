package com.step_it.hooks;

import com.step_it.utils.PropertyReader;
import io.cucumber.java.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.step_it.driver.LocalWebDriverManager.*;

@Slf4j
public class TestHook {

    @Before(value = "@Start")
    public void StartBrowser() {
        log.info("Opening the application login page");
        getDriver().get(PropertyReader.getConfigProperty("url"));
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        log.info("Starting scenario: {}", scenario.getName());
        log.info("Scenario tag {}", scenario.getSourceTagNames());
    }

    @After(order = 0)
    public void afterStep(Scenario scenario) {
        if(scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failed");
        }
    }
    @AfterStep
    public void addScreenshot(Scenario scenario){
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "image");
        }
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        log.info("Finished scenario: {}", scenario.getName());

    }

    @After(value = "@Stop")
    public void driverTearDown() {
        log.info("Quitting the browser");
        quitDriver();
    }
}
