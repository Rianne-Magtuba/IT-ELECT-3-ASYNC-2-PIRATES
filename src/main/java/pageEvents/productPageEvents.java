package pageEvents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import pageObjects.productPageElements;
import org.testng.Assert;
public class productPageEvents extends BaseTest {
        
    HomePageEvents homePageEvents = new HomePageEvents();

    public void productListIsVisible() {
        homePageEvents.homepageIsDisplayed();
        homePageEvents.navigateToProductPage();

        logInfo("Verify that user is navigated to ALL PRODUCTS page successfully");
        assertElementIsDisplayed(productPageElements.SEARCH_BOX);

        logInfo("Verify that 'ALL PRODUCTS' is visible");
     
        verifyProductsListIsVisible();
        navigateToFirstProductDetailPage();
        verifyFirstProductDetailIsOpened();

    }

public void searchForProduct(String productName) {
    homePageEvents.homepageIsDisplayed();
    homePageEvents.navigateToProductPage();
    
    logInfo("Verify that user is navigated to ALL PRODUCTS page successfully");
    assertElementIsDisplayed(productPageElements.SEARCH_BOX);

    // Step 6: Enter product name in search input and click search button
    logInfo("Searching for product: " + productName);
    clear(productPageElements.SEARCH_BOX);
    sendKeys(productPageElements.SEARCH_BOX, productName);
    click(productPageElements.SEARCH_BUTTON);

    // Step 7: Verify 'SEARCHED PRODUCTS' is visible
    logInfo("Verify 'SEARCHED PRODUCTS' header is visible");
    assertElementIsDisplayed(productPageElements.SEARCHED_PRODUCTS_HEADER);

    // Step 8: Verify all the products related to search are visible
    logInfo("Verify products related to the search are rendered on the page");
    verifyProductsListIsVisible(); 
}


    public void navigateToFirstProductDetailPage() {
        logInfo("Click on 'View Product' of the first product");
        click(productPageElements.View_PRODUCT_BUTTON);
    }

    public void verifyFirstProductDetailIsOpened() {
        logInfo("Verify that product detail is opened");
    

        assertElementIsDisplayed(productPageElements.PRODUCT_NAME);
        assertElementIsDisplayed(productPageElements.PRODUCT_CATEGORY);
        assertElementIsDisplayed(productPageElements.PRODUCT_PRICE);
        assertElementIsDisplayed(productPageElements.PRODUCT_AVAILABILITY);
        assertElementIsDisplayed(productPageElements.PRODUCT_CONDITION);
        assertElementIsDisplayed(productPageElements.PRODUCT_BRAND);
    }
  public void verifyProductsListIsVisible() {
    logInfo("Checking if the product list is visible and populated");
    
    List<WebElement> products = driver.findElements(By.cssSelector(".features_items .single-products"));
    
    // 2. Dynamically count the size of the list
    int productCount = products.size();
    
    // 3. Log the exact number found for your Extent Report
    logInfo("Successfully loaded " + productCount + " products on the page.");
    
    // 4. Assert that at least one product loaded
    Assert.assertTrue(productCount > 0, "The product list is completely empty!");
}






}
