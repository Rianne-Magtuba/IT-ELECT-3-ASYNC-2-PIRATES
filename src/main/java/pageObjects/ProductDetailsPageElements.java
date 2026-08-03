package pageObjects;

public interface ProductDetailsPageElements {

    String QUANTITY_INPUT = "//input[@id='quantity']";
    String ADD_TO_CART_BUTTON = "//button[normalize-space()='Add to cart']";
    String WRITE_A_REVIEW_LABEL = "//a[normalize-space()='Write Your Review']";
    String YOUR_NAME_INPUT = "//input[@id='name']";
    String EMAIL_ADDRESS_INPUT = "//input[@id='email']";
    String REVIEW_TEXTAREA = "//textarea[@id='review']";
    String SUBMIT_BUTTON = "//button[@id='button-review']";
    String REVIEW_SUCCESS_MESSAGE = "//span[normalize-space()='Thank you for your review.']";
}