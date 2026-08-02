package pageEvents;

import base.BaseTest;

import org.openqa.selenium.interactions.Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import pageObjects.ProductsPageElements;

public class ProductsPageEvents extends BaseTest {

     HomePageEvents homePageEvents = new HomePageEvents();
     HeaderPageEvents headerPageEvents = new HeaderPageEvents();
     
 public void productListIsVisible() {
        homePageEvents.homepageIsDisplayed();
          headerPageEvents.clickProductsButton();

        logInfo("Verify that user is navigated to ALL PRODUCTS page successfully");
        assertElementIsDisplayed(ProductsPageElements.SEARCH_BOX);

        logInfo("Verify that 'ALL PRODUCTS' is visible");
     
        verifyProductsListIsVisible();
        navigateToFirstProductDetailPage();
        verifyFirstProductDetailIsOpened();

    }

public void searchForProduct(String productName) {

    homePageEvents.homepageIsDisplayed();
    headerPageEvents.clickProductsButton();
    
    logInfo("Verify that user is navigated to ALL PRODUCTS page successfully");
    assertElementIsDisplayed(ProductsPageElements.SEARCH_BOX);

    // Step 6: Enter product name in search input and click search button
    logInfo("Searching for product: " + productName);
    clear(ProductsPageElements.SEARCH_BOX);
    sendKeys(ProductsPageElements.SEARCH_BOX, productName);
    click(ProductsPageElements.SEARCH_BUTTON);

    // Step 7: Verify 'SEARCHED PRODUCTS' is visible
    logInfo("Verify 'SEARCHED PRODUCTS' header is visible");
    assertElementIsDisplayed(ProductsPageElements.SEARCHED_PRODUCTS_HEADER);

    // Step 8: Verify all the products related to search are visible
    logInfo("Verify products related to the search are rendered on the page");
    verifyProductsListIsVisible(); 
}


    public void navigateToFirstProductDetailPage() {
        logInfo("Click on 'View Product' of the first product");
        click(ProductsPageElements.View_PRODUCT_BUTTON);
    }

    public void verifyFirstProductDetailIsOpened() {
        logInfo("Verify that product detail is opened");
    

        assertElementIsDisplayed(ProductsPageElements.PRODUCT_NAME);
        assertElementIsDisplayed(ProductsPageElements.PRODUCT_CATEGORY);
        assertElementIsDisplayed(ProductsPageElements.PRODUCT_PRICE);
        assertElementIsDisplayed(ProductsPageElements.PRODUCT_AVAILABILITY);
        assertElementIsDisplayed(ProductsPageElements.PRODUCT_CONDITION);
        assertElementIsDisplayed(ProductsPageElements.PRODUCT_BRAND);
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


    public void hoverAndAddFirstProductToCart() {
        logger.info("Hover over first product and click 'Add to cart'");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//div[@class='product-image-wrapper'])[1]"))).perform();
        click(ProductsPageElements.FIRST_PRODUCT_ADD_TO_CART_BUTTON);
    }

    public void clickContinueShoppingButton() {
        logger.info("Click 'Continue Shopping' button");
        click(ProductsPageElements.CONTINUE_SHOPPING_BUTTON);
    }

    public void hoverAndAddSecondProductToCart() {
        logger.info("Hover over second product and click 'Add to cart'");
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//div[@class='product-image-wrapper'])[2]"))).perform();
        click(ProductsPageElements.SECOND_PRODUCT_ADD_TO_CART_BUTTON);
    }

    public void clickViewCartButton() {
        logger.info("Click 'View Cart' button");
        click(ProductsPageElements.VIEW_CART_BUTTON);
    }

    public void clickViewProductForFirstProduct() {
        logger.info("Click 'View Product' for any product on home page");
        click(ProductsPageElements.VIEW_PRODUCT_BUTTON);
    }
}