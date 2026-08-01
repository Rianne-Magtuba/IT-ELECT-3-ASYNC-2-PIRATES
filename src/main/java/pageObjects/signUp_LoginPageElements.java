package pageObjects;

public interface signUp_LoginPageElements {


     //Login FORM

     String LOGIN_EMAIL_INPUT = "//input[@data-qa='login-email']";
     String LOGIN_PASSWORD_INPUT = "//input[@placeholder='Password']";
     String LOGIN_BUTTON = "//button[normalize-space()='Login']";

     String LOGIN_TO_YOUR_ACCOUNT_TEXT = "//h2[normalize-space()='Login to your account']";
     String LOGIN_ERROR_POPUP = "//p[normalize-space()='Your email or password is incorrect!']";

    //Sign up FORM
     String NAME_INPUT = "//input[@placeholder='Name']";
     String EMAIL_INPUT = "//input[@data-qa='signup-email']";
     String SIGNUP_BUTTON = "//button[normalize-space()='Signup']";

     String NEW_USER_SIGNUP_TEXT = "//h2[normalize-space()='New User Signup!']";

     //NAV
     String HOMEPAGE_BTN = "//a[normalize-space()='Home']";

}
