package regression;

import java.lang.reflect.Method;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.concurrent.TimeoutException;

import org.apache.hc.core5.util.Timeout;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pageEvents.HomePageEvents;
import pageEvents.signup_Login_PageEvents;
import pageEvents.signupPageEvents;


public class DemoGuruTestCases extends BaseTest{
    String browser;
    Dictionary<String, String> signupDetails;
    // registerPageEvents registerPage = new registerPageEvents();
    // loginPageEvents loginPage = new loginPageEvents();
    // flightPageEvents flightPage = new flightPageEvents();
       HomePageEvents homePageEvents = new HomePageEvents();
       signup_Login_PageEvents signUp_Login_PageEvents = new signup_Login_PageEvents();
       signupPageEvents signupPageEvents = new signupPageEvents();
      
            
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

    @Test(priority = 1)
    public void signup(){
       
        signUp_Login_PageEvents.signUp("Rianne","ghoulllgohul@gmaisl.com");
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
      
       homePageEvents.verifyUserIsLoggedIn();
       //delete temporarily
      // homePageEvents.clickDeleteAccountButton(); 
      
        

    }


    @Test(priority = 2)
    public void tc_02_Login(){
        signUp_Login_PageEvents.Login("ghoulllgohul@gmaisl.com", "Password123@asda2");
   homePageEvents.verifyUserIsLoggedIn();
     homePageEvents.clickDeleteAccountButton(); 
    }

    // @Test(priority = 3)
    // public void tc_03_Reservation(){
    //     flightPage.reserveFlight();
    
    // }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result){
        afterMethod(result, browser);
    }



}