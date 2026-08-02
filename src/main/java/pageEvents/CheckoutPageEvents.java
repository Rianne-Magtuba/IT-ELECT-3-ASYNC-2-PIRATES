package pageEvents;

import base.BaseTest;
import pageObjects.CheckoutPageElements;

public class CheckoutPageEvents extends BaseTest {

    public void verifyAddressDetailsAndReviewOrder() {
        logger.info("Verify Address Details and Review Your Order");
        assertElementIsDisplayed(CheckoutPageElements.ADDRESS_DETAILS);
    }

    public void enterOrderComment(String comment) {
        logger.info("Enter description in comment text area");
        clear(CheckoutPageElements.DESCRIPTION_COMMENT);
        sendKeys(CheckoutPageElements.DESCRIPTION_COMMENT, comment);
    }

    public void clickPlaceOrderButton() {
        logger.info("Click 'Place Order'");
        click(CheckoutPageElements.PLACE_ORDER_BUTTON);
    }

    public void verifyOrderSuccessMessage() {
        logger.info("Verify success message 'Your order has been placed successfully!'");
        assertElementIsDisplayed(CheckoutPageElements.ORDER_SUCCESS_MESSAGE);
    }
}