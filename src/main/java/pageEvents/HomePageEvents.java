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
  
    public void verifyRecommendedItemsSectionIsDisplayed() {
        logInfo("Verify that 'RECOMMENDED ITEMS' is visible");
        assertElementIsDisplayed(HomePageElements.RECOMENDED_ITEMS_LABEL);
    }

    public void clickAddToCartRecommendedItemButton() {
        logInfo("Click 'Add to cart' button for recommended item");
        click(HomePageElements.ADD_TO_CART_RECOMMENDED_ITEM_BUTTON);
        click(HomePageElements.CONTINUE_SHOPPING_BUTTON);
    }

    public void clickArrowUpButton() {
        logInfo("Click 'Arrow Up' button");
        click(HomePageElements.ARROW_UP_BUTTON);
    }

    public void verifyTopOfTheScreenTextIsVisible() {
        logInfo("Verify that 'Full-Fledged practice website for Automation Engineers' is visible");
        assertElementIsDisplayed(HomePageElements.TOP_OF_THE_SCREEN_TEXT);
    }

}
