package pageObjects;

public interface CartPageElements {

    String CART_INFO = "//div[@id='cart_info']";
    String PRODUCT_PRICE = "//td[@class='cart_price']";
    String PRODUCT_QUANTITY = "//td[@class='cart_quantity']";
    String PRODUCT_TOTAL_PRICE = "//p[@class='cart_total_price']";
    String CHECKOUT_BUTTON = "//a[@class='btn btn-default check_out']";
    String REGISTER_LOGIN_BUTTON = "//div[@class='modal-body']//a";
    String DELETE_BUTTON = "//i[@class='fa fa-times']";
    String EMPTY_CART_MESSAGE = "//span[@id='empty_cart']";
}//a[@class='btn btn-default check_out']