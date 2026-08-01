package pageObjects;

public interface HomePageElements {
    
    String SIGNUP_LOGIN_BUTTON = "//a[normalize-space()='Signup / Login']"; 

    String LOGIN_AS_USERNAME_HDR ="//li[10]//a[1]";
    String DELETE_ACCOUNT_BUTTON = "//a[normalize-space()='Delete Account']";

    String LOGOUT_BUTTON = "//a[normalize-space()='Logout']";

//CONFIRMATION PAGE
    String CONTINUE_DELETE_ACCOUNT_BUTTON = "//a[@class='btn btn-primary']";
    String NEXT_IMAGE_BUTTON ="//a[@class='right control-carousel hidden-xs']//i[@class='fa fa-angle-right']";
}
