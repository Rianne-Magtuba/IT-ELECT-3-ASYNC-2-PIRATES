package pageObjects;

public interface CheckoutPageElements {

    String ADDRESS_DETAILS = "//div[@class='checkout-information']";
    String DESCRIPTION_COMMENT = "//textarea[@name='message']";
    String PLACE_ORDER_BUTTON = "//a[normalize-space()='Place Order']";
    String ORDER_SUCCESS_MESSAGE = "//p[contains(text(),'Congratulations')]";
    String DELIVERY_ADDRESS = "//ul[@id='address_delivery']";
    String BILLING_ADDRESS = "//ul[@id='address_invoice']";
    String DOWNLOAD_INVOICE_BUTTON = "//a[normalize-space()='Download Invoice']";
    String CONTINUE_BUTTON = "//a[normalize-space()='Continue']";
}
