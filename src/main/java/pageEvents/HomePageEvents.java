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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(HomePageElements.NEXT_IMAGE_BUTTON)));
        assertElementIsDisplayed(HomePageElements.NEXT_IMAGE_BUTTON);
    }


 

    public void verifyUserIsDeleted() {
        logInfo("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
        assertElementIsDisplayed(HomePageElements.CONTINUE_DELETE_ACCOUNT_BUTTON);
        click(HomePageElements.CONTINUE_DELETE_ACCOUNT_BUTTON);
    }

       public void clickDeleteAccountButton() {
        logInfo("Click Delete Account button");
        click(HomePageElements.DELETE_ACCOUNT_BUTTON);
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
  
 

}
