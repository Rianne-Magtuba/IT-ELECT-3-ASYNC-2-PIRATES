package pageEvents;
import base.BaseTest;
import pageObjects.HomePageElements;

public class HomePageEvents extends BaseTest {

    public void homepageIsDisplayed() {
        logInfo("Verify that home page is visible successfully");

      assertElementIsDisplayed(HomePageElements.NEXT_IMAGE_BUTTON);
    }

    public void clickSignUpLoginButton() {
        logInfo("Click Sign Up / Login button");
        click(HomePageElements.SIGNUP_LOGIN_BUTTON);
    }
    
    public void verifyUserIsLoggedIn() {
        logInfo("Verify user is logged in");
        assertElementIsDisplayed(HomePageElements.LOGIN_AS_USERNAME_HDR);
    }

    public void clickDeleteAccountButton() {
        logInfo("Click Delete Account button");
        click(HomePageElements.DELETE_ACCOUNT_BUTTON);
    }

    public void verifyUserIsDeleted() {
        logInfo("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
        assertElementIsDisplayed(HomePageElements.CONTINUE_DELETE_ACCOUNT_BUTTON);
        click(HomePageElements.CONTINUE_DELETE_ACCOUNT_BUTTON);
    }

    public void logoutUser() {
        logInfo("Click Logout button");
        click(HomePageElements.LOGOUT_BUTTON);
    }

  
}
