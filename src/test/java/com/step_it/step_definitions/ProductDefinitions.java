package com.step_it.step_definitions;

import com.step_it.steps.CommonSteps;
import com.step_it.steps.ProductSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductDefinitions {

    private CommonSteps commonSteps;
    private ProductSteps productSteps;

    @Given("the app is on products page")
    public void theAppIsOnProductPage() {
        productSteps.checkProductsOnPageAreDisplayed();
    }

    @When("the user adds {} to cart")
    public void theUserAddsProductToCart(String product) {
        commonSteps.checkCartIsEmpty();
        productSteps.addProductToCart(product);
    }
}
