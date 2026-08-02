package pageEvents;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.HomePageElements;

public class HomePageEvents extends BaseTest {

   public void homepageIsDisplayed() {
        logInfo("Verify that home page is visible successfully");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(HomePageElements.NEXT_IMAGE_BUTTON)));
        assertElementIsDisplayed(HomePageElements.NEXT_IMAGE_BUTTON);
    }

public void homepageIsDisplayedVer2() {
    logInfo("Verify that home page is visible successfully");
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(HomePageElements.SIGNUP_LOGIN_BUTTON)));
    assertElementIsDisplayed(HomePageElements.SIGNUP_LOGIN_BUTTON);
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

    public void clickContactUsButton() {
        logInfo("Click Contact Us button");
        click(HomePageElements.CONTACT_US_BUTTON);
    }
  
    public void navigateToTestCasesPage() {
        logInfo("Click Test Cases button");
        click(HomePageElements.TEST_CASES_BUTTON);
    }
   public void navigateToProductPage() {
        logInfo("Click Products button");
        click(HomePageElements.PRODUCTS_BUTTON);
        
    }
 

}
