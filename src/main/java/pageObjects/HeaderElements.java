package pageObjects;

public interface HeaderElements {

    String SIGNUP_LOGIN_BUTTON = "//a[normalize-space()='Signup / Login']";
    String HOME_BUTTON = "//a[normalize-space()='Home']";
    String PRODUCTS_BUTTON = "//a[@href='/products']";
    String CART_BUTTON = "//a[normalize-space()='Cart']";
    String DELETE_ACCOUNT_BUTTON = "//a[normalize-space()='Delete Account']";
    String LOGOUT_BUTTON = "//a[normalize-space()='Logout']";
    String LOGGED_IN_AS_USERNAME = "//header[@id='header']//li[1]//a[1]";
}