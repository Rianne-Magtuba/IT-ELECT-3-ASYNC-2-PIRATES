package pageObjects;

public interface HomePageElements {
    

    String TEST_CASES_BUTTON = "//a[contains(text(),'Test Cases')]";
    String LOGIN_AS_USERNAME_HDR ="//li[10]//a[1]";
    String DELETE_ACCOUNT_BUTTON = "//a[normalize-space()='Delete Account']";
  
    String LOGOUT_BUTTON = "//a[normalize-space()='Logout']";
    String CONTACT_US_BUTTON = "//a[normalize-space()='Contact us']";

//CONFIRMATION PAGE
    String CONTINUE_DELETE_ACCOUNT_BUTTON = "//a[@class='btn btn-primary']";
    String NEXT_IMAGE_BUTTON ="//a[@class='right control-carousel hidden-xs']//i[@class='fa fa-angle-right']";
    String CAROUSEL_SLIDER = "//div[@id='slider-carousel']";

    String RECOMENDED_ITEMS_LABEL = "//h2[normalize-space()='recommended items']";
    String ADD_TO_CART_RECOMMENDED_ITEM_BUTTON = "(//a[contains(text(),'Add to cart')])[74]";
    String CONTINUE_SHOPPING_BUTTON = "//button[normalize-space()='Continue Shopping']";

    String ARROW_UP_BUTTON = "//i[@class='fa fa-angle-up']";
    String TOP_OF_THE_SCREEN_TEXT = "//h2[normalize-space()='Full-Fledged practice website for Automation Engineers']";
}
