package pageObjects;

public interface ProductsPageElements {

    String VIEW_PRODUCT_BUTTON = "(//a[contains(text(),'View Product')])[1]";
    String FIRST_PRODUCT_ADD_TO_CART_BUTTON = "(//a[contains(text(),'Add to cart')])[2]";
    String CONTINUE_SHOPPING_BUTTON = "//button[normalize-space()='Continue Shopping']";
    String SECOND_PRODUCT_ADD_TO_CART_BUTTON = "(//a[contains(text(),'Add to cart')])[4]";
    String VIEW_CART_BUTTON = "//p[@class='text-center']//a";
}