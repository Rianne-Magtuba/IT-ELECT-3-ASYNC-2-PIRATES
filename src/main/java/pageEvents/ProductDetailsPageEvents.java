package pageEvents;

import base.BaseTest;
import pageObjects.ProductDetailsPageElements;

public class ProductDetailsPageEvents extends BaseTest {

    public void verifyProductDetailIsOpened() {
        logger.info("Verify product detail is opened");
        assertElementIsDisplayed(ProductDetailsPageElements.QUANTITY_INPUT);
    }

    public void setQuantity(String quantity) {
        logger.info("Increase quantity to " + quantity);
        clear(ProductDetailsPageElements.QUANTITY_INPUT);
        sendKeys(ProductDetailsPageElements.QUANTITY_INPUT, quantity);
    }

    public void clickAddToCartButton() {
        logger.info("Click 'Add to cart' button");
        click(ProductDetailsPageElements.ADD_TO_CART_BUTTON);
    }
}