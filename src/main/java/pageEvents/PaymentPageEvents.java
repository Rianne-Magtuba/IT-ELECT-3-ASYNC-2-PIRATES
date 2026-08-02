package pageEvents;

import base.BaseTest;
import pageObjects.PaymentPageElements;

public class PaymentPageEvents extends BaseTest {

    public void enterPaymentDetails(String nameOnCard, String cardNumber, String cvc, String month, String year) {
        logger.info("Enter payment details: Name on Card, Card Number, CVC, Expiration date");
        clear(PaymentPageElements.NAME_ON_CARD);
        sendKeys(PaymentPageElements.NAME_ON_CARD, nameOnCard);

        clear(PaymentPageElements.CARD_NUMBER);
        sendKeys(PaymentPageElements.CARD_NUMBER, cardNumber);

        clear(PaymentPageElements.CVC);
        sendKeys(PaymentPageElements.CVC, cvc);

        clear(PaymentPageElements.EXPIRATION_MONTH);
        sendKeys(PaymentPageElements.EXPIRATION_MONTH, month);

        clear(PaymentPageElements.EXPIRATION_YEAR);
        sendKeys(PaymentPageElements.EXPIRATION_YEAR, year);
    }

    public void clickPayButton() {
        logger.info("Click 'Pay and Confirm Order' button");
        click(PaymentPageElements.PAY_BUTTON);
    }
}