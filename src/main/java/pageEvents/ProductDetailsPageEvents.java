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

    public void verifyWriteReviewLabelIsVisible() {
        logger.info("Verify 'Write Your Review' label is visible");
        assertElementIsDisplayed(ProductDetailsPageElements.WRITE_A_REVIEW_LABEL);
    }

    public void fillUpWriteReview(String name, String email, String review) {
        logInfo("Fill Up Review Form");
        clear(ProductDetailsPageElements.YOUR_NAME_INPUT);
        sendKeys(ProductDetailsPageElements.YOUR_NAME_INPUT, name);

        clear(ProductDetailsPageElements.EMAIL_ADDRESS_INPUT);
        sendKeys(ProductDetailsPageElements.EMAIL_ADDRESS_INPUT, email);

        clear(ProductDetailsPageElements.REVIEW_TEXTAREA);
        sendKeys(ProductDetailsPageElements.REVIEW_TEXTAREA, review);

        logInfo("Click Submit button");
        click(ProductDetailsPageElements.SUBMIT_BUTTON);

        assertElementIsDisplayed(ProductDetailsPageElements.REVIEW_SUCCESS_MESSAGE);
    }
}