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
        logger.info("Fill Up Sign Up Form");
        clear(signUp_LoginPageElements.NAME_INPUT);
        sendKeys(signUp_LoginPageElements.NAME_INPUT, name);

        clear(signUp_LoginPageElements.EMAIL_INPUT);
        sendKeys(signUp_LoginPageElements.EMAIL_INPUT, email);

        //Click Sign Up Button
        logger.info("Click Sign Up button");
        click(signUp_LoginPageElements.SIGNUP_BUTTON);
    }
    

     public void enter_account_info_visible() {
        logger.info("Verify 'New User Signup!' is visible");

     assertElementIsDisplayed(signUp_LoginPageElements.NEW_USER_SIGNUP_TEXT);
    }

    public void Login(String email, String password){
        homePageEvents.homepageIsDisplayed();
        homePageEvents.clickSignUpLoginButton();

        //Fill Up Login Form
        logger.info("Fill Up Login Form");
        clear(signUp_LoginPageElements.LOGIN_EMAIL_INPUT);
        sendKeys(signUp_LoginPageElements.LOGIN_EMAIL_INPUT, email);

        clear(signUp_LoginPageElements.LOGIN_PASSWORD_INPUT);
        sendKeys(signUp_LoginPageElements.LOGIN_PASSWORD_INPUT, password);

        //Click Sign Up Button
        logger.info("Click Login button");
        click(signUp_LoginPageElements.LOGIN_BUTTON);
    }

      public void enter_login_info_visible() {
        logger.info("Verify 'Login to your account' is visible");

     assertElementIsDisplayed(signUp_LoginPageElements.LOGIN_TO_YOUR_ACCOUNT_TEXT);
    }
}
