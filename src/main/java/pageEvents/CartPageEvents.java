package pageEvents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.CartPageElements;

public class CartPageEvents extends BaseTest {

    public void verifyCartPageIsDisplayed() {
        logger.info("Verify that cart page is displayed");
        assertElementIsDisplayed(CartPageElements.CART_INFO);
    }

    public void verifyProductsInCart(int expectedCount) {
        logger.info("Verify both products are added to Cart");
        int actualCount = driver.findElements(org.openqa.selenium.By.xpath(CartPageElements.PRODUCT_PRICE)).size();
        assertTrueCartCount(actualCount, expectedCount);
    }

    private void assertTrueCartCount(int actual, int expected) {
        org.testng.Assert.assertEquals(actual, expected, "Cart product count mismatch.");
    }

    public void verifyPricesQuantityAndTotal() {
        logger.info("Verify their prices, quantity and total price");
        assertElementIsDisplayed(CartPageElements.PRODUCT_PRICE);
        assertElementIsDisplayed(CartPageElements.PRODUCT_QUANTITY);
        assertElementIsDisplayed(CartPageElements.PRODUCT_TOTAL_PRICE);
    }

    public void verifyProductQuantityInCart(String expectedQuantity) {
        logger.info("Verify that product is displayed in cart page with exact quantity");
        org.openqa.selenium.WebElement qtyElement = driver.findElement(org.openqa.selenium.By.xpath(CartPageElements.PRODUCT_QUANTITY));
        org.testng.Assert.assertEquals(qtyElement.getText().trim(), expectedQuantity, "Quantity in cart does not match.");
    }

    public void clickProceedToCheckoutButton() {
        logger.info("Click 'Proceed To Checkout' button");
        click(CartPageElements.CHECKOUT_BUTTON);
    }

    public void clickRegisterLoginButton() {
        logger.info("Click 'Register / Login' button");
        click(CartPageElements.REGISTER_LOGIN_BUTTON);
    }

    public void removeFirstProductFromCart() {
        logger.info("Click 'X' button corresponding to particular product");
        click(CartPageElements.DELETE_BUTTON);
    }

 public void verifyProductRemovedFromCart() {
    logger.info("Verify that product is removed from the cart");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CartPageElements.EMPTY_CART_MESSAGE)));
}
}