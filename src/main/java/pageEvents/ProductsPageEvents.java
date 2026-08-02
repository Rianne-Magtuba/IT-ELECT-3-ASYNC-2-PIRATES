package pageEvents;

import base.BaseTest;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import pageObjects.ProductsPageElements;

public class ProductsPageEvents extends BaseTest {

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