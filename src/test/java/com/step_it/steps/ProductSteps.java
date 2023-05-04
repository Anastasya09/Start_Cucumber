package com.step_it.steps;

import com.step_it.pages.ProductPage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@Slf4j
@AllArgsConstructor
public class ProductSteps {
    private ProductPage productPage;

    public void checkProductsOnPageAreDisplayed() {
        log.info("Check products are displayed");
        productPage.waitUntilProductsAreDisplayed();

    }
    public void addProductToCart(String product) {
        productPage.addProductToCart(product);
    }
}
