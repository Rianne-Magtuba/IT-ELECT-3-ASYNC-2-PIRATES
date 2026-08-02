package pageObjects;

public interface FooterElements {

    String SUBSCRIPTION_TEXT = "//h2[normalize-space()='Subscription']";
    String SUBSCRIPTION_EMAIL_INPUT = "//input[@id='susbscribe_email']";
    String SUBSCRIBE_BUTTON = "//button[@id='subscribe']";
    String SUBSCRIPTION_SUCCESS_MESSAGE = "//div[@class='alert-success alert']";
}