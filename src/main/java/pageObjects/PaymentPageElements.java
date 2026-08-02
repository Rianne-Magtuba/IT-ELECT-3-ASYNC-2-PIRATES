package pageObjects;

public interface PaymentPageElements {

    String NAME_ON_CARD = "//input[@name='name_on_card']";
    String CARD_NUMBER = "//input[@name='card_number']"; // fixed typo: had "///input"
    String CVC = "//input[@placeholder='ex. 311']";
    String EXPIRATION_MONTH = "//input[@placeholder='MM']";
    String EXPIRATION_YEAR = "//input[@placeholder='YYYY']";
    String PAY_BUTTON = "//button[@id='submit']";
}