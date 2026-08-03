package pageEvents;

import java.util.Dictionary;
import java.util.Enumeration;

import org.testng.Assert;
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

    public void clickDownloadInvoiceButton() {
        logger.info("Click 'Download Invoice' button");
        click(CheckoutPageElements.DOWNLOAD_INVOICE_BUTTON);
    }

    public void clickContinueButton() {
        logger.info("Click 'Continue' button");
        click(CheckoutPageElements.CONTINUE_BUTTON);
    }

    public void verifyInvoiceDownloaded() {
    logger.info("Verify invoice downloaded");

    Assert.assertTrue(
            isFileDownloaded("invoice.txt"),
            "Invoice was not downloaded."
    );
}


    public void verifyDeliveryAddress(Dictionary<String, String> expectedAddress) {
    logger.info("Verify Delivery Address");

    String actualAddress = getText(CheckoutPageElements.DELIVERY_ADDRESS);

    String[] fields = {
        "firstName",
        "lastName",
        "company",
        "address1",
        "address2",
        "city",
        "state",
        "zipcode",
        "country",
        "mobileNumber"
    };

    for (String field : fields) {
        String expectedValue = expectedAddress.get(field);

        if (expectedValue != null && !actualAddress.contains(expectedValue)) {
            throw new AssertionError(
                "Expected delivery address to contain '" + field +
                "' = '" + expectedValue + "' but it was not found."
            );
        }
    }
}

public void verifyBillingAddress(Dictionary<String, String> expectedAddress) {
    logger.info("Verify Billing Address");

    String actualAddress = getText(CheckoutPageElements.BILLING_ADDRESS);

    String[] fields = {
        "firstName",
        "lastName",
        "company",
        "address1",
        "address2",
        "city",
        "state",
        "zipcode",
        "country",
        "mobileNumber"
    };

    for (String field : fields) {
        String expectedValue = expectedAddress.get(field);

        if (expectedValue != null && !actualAddress.contains(expectedValue)) {
            throw new AssertionError(
                "Expected delivery address to contain '" + field +
                "' = '" + expectedValue + "' but it was not found."
            );
        }
    }
}
}