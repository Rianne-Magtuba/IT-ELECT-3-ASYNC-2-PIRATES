package regression;

import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeoutException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.*;




public class DemoGuruTestCases extends BaseTest{
    String browser;

    Dictionary<String, String> signupDetails;
        Dictionary<String,String> contactUsDetails;


    // registerPageEvents registerPage = new registerPageEvents();
    
      HomePageEvents homePageEvents = new HomePageEvents();
       signup_Login_PageEvents signUp_Login_PageEvents = new signup_Login_PageEvents();
       signupPageEvents signupPageEvents = new signupPageEvents();
       contactUsPageEvents contactUsPageEvents = new contactUsPageEvents();
        testCasePageEvents testCasePageEvents = new testCasePageEvents();
        productPageEvents productPageEvents = new productPageEvents();
            
    @BeforeTest(alwaysRun = true)
    @Parameters({"browser"})
    public void prepareReport(@Optional("chrome")String browser){
        this.browser = browser;
        beforeTestMethod(browser);
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(Method testMethod) throws TimeoutException{
        initializeBrowser(browser, testMethod);
    }

    public void createAccount(String name, String email){
 signUp_Login_PageEvents.signUp(name,email);
        signupDetails = new Hashtable<>();

        signupDetails.put("password", "Password123@asda2");
        signupDetails.put("day", "1");
        signupDetails.put("month", "January");
        signupDetails.put("year", "1990");
        signupDetails.put("firstName", "Rianne");
        signupDetails.put("lastName", "Magtuba");
        signupDetails.put("company", "Test Company");
        signupDetails.put("address1", "123 Test Way");
        signupDetails.put("address2", "456 Test Street");
        signupDetails.put("country", "India");
        signupDetails.put("state", "Test State");
        signupDetails.put("city", "Test City");
        signupDetails.put("zipcode", "1234");
        signupDetails.put("mobileNumber", "09123456789");
        signupPageEvents.fillUpSignUpForm(signupDetails);
      
       
    }

   public void createAccountAndLogout(String name, String email) {
    
    BaseTest.enableLogging = false; 
    
    try {
        
        createAccount(name, email);
        homePageEvents.logoutUser();
        signUp_Login_PageEvents.goToHomepage();
    } finally {
        
        BaseTest.enableLogging = true; 
    }
}

    @Test(priority = 1)
    public void tc_01_registerUser(){
        createAccount("Rianne", "ghoulllgohasdauldas"+generate4Digit()+"@gmaisl.com" );
        homePageEvents.verifyUserIsLoggedIn();
        homePageEvents.clickDeleteAccountButton(); 
      
        

    }


    @Test(priority = 2)
    public void tc_02_LoginSuccesfully(){
        String email = "ghoulllgohasdauldsasdasas@gmaislasds.com";
      createAccountAndLogout("Rianne", email);
        signUp_Login_PageEvents.loginSuccessfully(email, "Password123@asda2");
   homePageEvents.verifyUserIsLoggedIn();
   homePageEvents.clickDeleteAccountButton(); 
    }
    @Test(priority = 3)
    public void tc_03_LoginWithIncorrectEmailAndPass(){
      String email = "ghoulllgo" + generate4Digit() +"@gmaislasds.com";
        createAccountAndLogout("Rianne",email);
        signUp_Login_PageEvents.loginExpectingError(email, "INCORERCT@asda2");

    }

    String _email = "";
    @Test(priority = 4)
    public void tc_04_LogoutUser(){
   String email = "ghoulllgo" + generate4Digit() +"@gmaislasds.com";
        createAccountAndLogout("Rianne",email);
        _email = email;
       signUp_Login_PageEvents.loginSuccessfully(email, "Password123@asda2");
       
        homePageEvents.verifyUserIsLoggedIn();

        homePageEvents.logoutUser();

        signUp_Login_PageEvents.enter_login_info_visible();
    }

    @Test(priority = 5)
    public void tc_05_SignUpWithExistingEmail(){
        signUp_Login_PageEvents.signUpWithExistingEmail("Rianne", _email);
    }
    
    @Test(priority = 6)
    public void tc_06_ContactUsForm(){
        contactUsDetails = new Hashtable<>();
        contactUsDetails.put("name", "Rianne");
        contactUsDetails.put("email", "ghoulllgohasdauldas"+generate4Digit()+"@gmaisl.com");
        contactUsDetails.put("subject", "Test Subject");
        contactUsDetails.put("message", "Test Message");
        System.out.println(">>> TEST METHOD STARTED: " + Thread.currentThread().getStackTrace()[1].getMethodName());
        contactUsPageEvents.fillContactUsForm(contactUsDetails);
    }


    @Test(priority = 7)
    public void tc_07_TestCasesPage(){
        testCasePageEvents.navigateToTestCasesPage();
    }

    @Test(priority = 8 )
    public void tc_08_ProductPage(){
        productPageEvents.productListIsVisible(); 
    }
    @Test(priority = 9)
    public void tc_09_SearchProduct(){
        productPageEvents.searchForProduct("top");
    }
    
    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result){
        afterMethod(result, browser);
    }



}