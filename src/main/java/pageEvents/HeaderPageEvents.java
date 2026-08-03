package pageEvents;

import org.openqa.selenium.JavascriptExecutor;

import base.BaseTest;
import pageObjects.HeaderElements;

public class HeaderPageEvents extends BaseTest {

    public void clickHomeButton() {
        logger.info("Click 'Home' button");
        click(HeaderElements.HOME_BUTTON);
    }

    public void scrollToHeader() {
        logger.info("Scroll up to header");
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
    }

    public void clickProductsButton() {
        logger.info("Click 'Products' button");
        click(HeaderElements.PRODUCTS_BUTTON);
    }

    public void clickCartButton() {
        logger.info("Click 'Cart' button");
        click(HeaderElements.CART_BUTTON);
    }

    public void clickSignupLoginButton() {
        logger.info("Click 'Signup / Login' button");
        click(HeaderElements.SIGNUP_LOGIN_BUTTON);
    }

    public void verifyLoggedInAsUsername() {
        logger.info("Verify 'Logged in as username' at top");
        assertElementIsDisplayed(HeaderElements.LOGGED_IN_AS_USERNAME);
    }


    
}