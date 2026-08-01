package pageEvents;
import base.BaseTest;
import pageObjects.HomePageElements;

public class HomePageEvents extends BaseTest {

    public void homepageIsDisplayed() {
        logger.info("Verify that home page is visible successfully");

      assertElementIsDisplayed(HomePageElements.NEXT_IMAGE_BUTTON);
    }

    public void clickSignUpLoginButton() {
        logger.info("Click Sign Up / Login button");
        click(HomePageElements.SIGNUP_LOGIN_BUTTON);
    }
    
    public void verifyUserIsLoggedIn() {
        logger.info("Verify user is logged in");
        assertElementIsDisplayed(HomePageElements.LOGIN_AS_USERNAME_HDR);
    }

    public void clickDeleteAccountButton() {
        logger.info("Click Delete Account button");
        click(HomePageElements.DELETE_ACCOUNT_BUTTON);
    }

    public void verifyUserIsDeleted() {
        logger.info("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
        assertElementIsDisplayed(HomePageElements.CONTINUE_DELETE_ACCOUNT_BUTTON);
        click(HomePageElements.CONTINUE_DELETE_ACCOUNT_BUTTON);
    }

  
}
