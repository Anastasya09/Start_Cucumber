package com.step_it.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.NoSuchElementException;

public class ProductPage extends BasePage {

    @FindBy(css = ".inventory_item_description")
    private List<WebElement> productNames;

    private By productDescription = By.cssSelector(".inventory_item_name");
    private By addRemoveBtn = By.tagName("button");

    public void waitUntilProductsAreDisplayed() {
        getPageLoader().isListVisible(productNames, 0);

    }
    public void addProductToCart(String productName) {
        getProduct(productName).findElement(addRemoveBtn).click();
    }

    private WebElement getProduct(String productName) {
        for (WebElement product: productNames) {
            WebElement description = product.findElement(productDescription);
            if(productName.equalsIgnoreCase(description.getText())) {
                return product;
            }

        }
        throw new NoSuchElementException("Couldn't find the element " + productName);
    }
}
