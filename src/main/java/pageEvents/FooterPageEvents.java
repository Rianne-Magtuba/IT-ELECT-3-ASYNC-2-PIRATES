package pageEvents;

import base.BaseTest;
import org.openqa.selenium.JavascriptExecutor;
import pageObjects.FooterElements;

public class FooterPageEvents extends BaseTest {

    public void scrollToFooter() {
        logger.info("Scroll down to footer");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void verifySubscriptionTextVisible() {
        logger.info("Verify text 'SUBSCRIPTION'");
        assertElementIsDisplayed(FooterElements.SUBSCRIPTION_TEXT);
    }

    public void subscribeWithEmail(String email) {
        logger.info("Enter email address in input and click arrow button");
        clear(FooterElements.SUBSCRIPTION_EMAIL_INPUT);
        sendKeys(FooterElements.SUBSCRIPTION_EMAIL_INPUT, email);
        click(FooterElements.SUBSCRIBE_BUTTON);
    }

    public void verifySubscriptionSuccessMessage() {
        logger.info("Verify success message 'You have been successfully subscribed!' is visible");
        assertElementIsDisplayed(FooterElements.SUBSCRIPTION_SUCCESS_MESSAGE);
    }
}