package pageEvents;
import java.util.Dictionary;

import base.BaseTest;
import pageObjects.signUpPageElements;

public class signupPageEvents extends BaseTest{

    HomePageEvents homePageEvents = new HomePageEvents();

   public void fillUpSignUpForm(@SuppressWarnings("rawtypes") Dictionary registerDetails){
       
    accountInfoVisible();
    
    //Enter Account Information
        logInfo("Fill details: Title, Name, Email, Password, Date of birth");
       
           click(signUpPageElements.tittle_Mr);
   
        clear(signUpPageElements.PASSWORD);
        sendKeys(signUpPageElements.PASSWORD, registerDetails.get("password").toString());


        selectElementByVisibleText(signUpPageElements.DOB_DAY, registerDetails.get("day").toString());
        selectElementByVisibleText(signUpPageElements.DOB_MONTH, registerDetails.get("month").toString());
        selectElementByVisibleText(signUpPageElements.DOB_YEAR, registerDetails.get("year").toString());

 logInfo("Select checkbox 'Sign up for our newsletter!'");
        click(signUpPageElements.NEWSLETTER_CHECKBOX);
logInfo(" Select checkbox 'Receive special offers from our partners!'");
        click(signUpPageElements.SPECIAL_OFFERS_CHECKBOX);
        logInfo("Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number");
        clear(signUpPageElements.FIRST_NAME);
        sendKeys(signUpPageElements.FIRST_NAME, registerDetails.get("firstName").toString());

        clear(signUpPageElements.LAST_NAME);
        sendKeys(signUpPageElements.LAST_NAME, registerDetails.get("lastName").toString());

        clear(signUpPageElements.COMPANY);
        sendKeys(signUpPageElements.COMPANY, registerDetails.get("company").toString());

        clear(signUpPageElements.COMPANY_ADDRESS);
        sendKeys(signUpPageElements.COMPANY_ADDRESS, registerDetails.get("address1").toString());

        clear(signUpPageElements.COMPANY_ADDRESS2);
        sendKeys(signUpPageElements.COMPANY_ADDRESS2, registerDetails.get("address2").toString());

        selectElementByVisibleText(signUpPageElements.COUNTRY, registerDetails.get("country").toString());
        
        clear(signUpPageElements.STATE);
        sendKeys(signUpPageElements.STATE, registerDetails.get("state").toString());
        clear(signUpPageElements.CITY);
        sendKeys(signUpPageElements.CITY, registerDetails.get("city").toString());
        clear(signUpPageElements.ZIPCODE);
        sendKeys(signUpPageElements.ZIPCODE, registerDetails.get("zipcode").toString());
        clear(signUpPageElements.MOBILE_NUMBER);
        sendKeys(signUpPageElements.MOBILE_NUMBER, registerDetails.get("mobileNumber").toString());

        logInfo("Click Create Account button");
        click(signUpPageElements.CREATE_ACCOUNT_BUTTON);

        clickContinueButton();

       
    }

    public void accountInfoVisible(){
        logInfo("Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        assertElementIsDisplayed(signUpPageElements.ENTER_ACCOUNT_INFORMATION_TEXT);
    }
    

    public void validateUserRegister(){
        logInfo("Validate that 'ACCOUNT CREATED!' is visible");
        assertElementIsDisplayed(signUpPageElements.ACCOUNT_CREATED_TEXT);
    }
    public void clickContinueButton(){
        logInfo("Click Continue button");
        click(signUpPageElements.CONTINUE_BUTTON);
    }

  

}