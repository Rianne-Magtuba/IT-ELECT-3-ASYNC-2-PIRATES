package pageEvents;
import java.util.Dictionary;
import base.BaseTest;
import pageObjects.signUp_LoginPageElements;

public class signup_Login_PageEvents  extends BaseTest{

 HomePageEvents homePageEvents = new HomePageEvents();

    public void signUp(String name, String email){
        homePageEvents.homepageIsDisplayed();
        homePageEvents.clickSignUpLoginButton();

        enter_account_info_visible();

        //Fill Up Sign Up Form
        logInfo("Fill Up Sign Up Form");
        clear(signUp_LoginPageElements.NAME_INPUT);
        sendKeys(signUp_LoginPageElements.NAME_INPUT, name);

        clear(signUp_LoginPageElements.EMAIL_INPUT);
        sendKeys(signUp_LoginPageElements.EMAIL_INPUT, email);

        //Click Sign Up Button
logInfo("Click Sign Up button");
        click(signUp_LoginPageElements.SIGNUP_BUTTON);
    }
    

    public void signUpWithExistingEmail(String name, String email){
        signUp(name, email);
        logInfo("Verify error 'Email Address already exist!' is visible");
 assertElementIsDisplayed(signUp_LoginPageElements.SignUpWithExistingEmail_ERROR_POPUP);
    }



     public void enter_account_info_visible() {
        logInfo("Verify 'New User Signup!' is visible");

     assertElementIsDisplayed(signUp_LoginPageElements.NEW_USER_SIGNUP_TEXT);
    }

    public void enterLoginCredentialsAndSubmit(String email, String password) {
    homePageEvents.homepageIsDisplayedVer2();
    homePageEvents.clickSignUpLoginButton();

    logInfo("Fill Up Login Form with Email: " + email);
    clear(signUp_LoginPageElements.LOGIN_EMAIL_INPUT);
    sendKeys(signUp_LoginPageElements.LOGIN_EMAIL_INPUT, email);

    clear(signUp_LoginPageElements.LOGIN_PASSWORD_INPUT);
    sendKeys(signUp_LoginPageElements.LOGIN_PASSWORD_INPUT, password);

    logInfo("Click Login button");
    click(signUp_LoginPageElements.LOGIN_BUTTON);
}
    
    public void loginSuccessfully(String email, String password){
      enterLoginCredentialsAndSubmit(email, password);
    
    logInfo("Verify successful login redirect");
    }

public void loginExpectingError(String email, String password) {
    enterLoginCredentialsAndSubmit(email, password);
    
    logInfo("Verify error 'Your email or password is incorrect!' is visible");
    // Add your negative path assertion here
    assertElementIsDisplayed(signUp_LoginPageElements.LOGIN_ERROR_POPUP);
}

      public void enter_login_info_visible() {
        logInfo("Verify 'Login to your account' is visible");

     assertElementIsDisplayed(signUp_LoginPageElements .LOGIN_TO_YOUR_ACCOUNT_TEXT);
    }

      public void goToHomepage(){
      click(signUp_LoginPageElements.HOMEPAGE_BTN);
    }

public void fillSignUpForm(String name, String email){
    enter_account_info_visible();

    logInfo("Fill Up Sign Up Form");
    clear(signUp_LoginPageElements.NAME_INPUT);
    sendKeys(signUp_LoginPageElements.NAME_INPUT, name);

    clear(signUp_LoginPageElements.EMAIL_INPUT);
    sendKeys(signUp_LoginPageElements.EMAIL_INPUT, email);

    logInfo("Click Sign Up button");
    click(signUp_LoginPageElements.SIGNUP_BUTTON);
}


}
