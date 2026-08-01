
package pageObjects;

public interface signUpPageElements {
    
    String ENTER_ACCOUNT_INFORMATION_TEXT = "//input[@id='email']";
    String tittle_Mr = "//input[@id='id_gender1']";
    String tittle_Mrs = "//input[@id='id_gender2']";
  

    String PASSWORD = "//input[@id='password']";


    //Date Of Birth
    String DOB_DAY = "//select[@id='days']";
    String DOB_MONTH = "//select[@id='months']";
    String DOB_YEAR = "//select[@id='years']";

    String NEWSLETTER_CHECKBOX = "//input[@id='newsletter']";
    String SPECIAL_OFFERS_CHECKBOX = "//input[@id='optin']";

    //Address Information

    String FIRST_NAME = "//input[@id='first_name']";
    String LAST_NAME = "//input[@id='last_name']";
    String COMPANY = "//input[@id='company']";
    String  COMPANY_ADDRESS = "//input[@id='address1']";
    String COMPANY_ADDRESS2 = "//input[@id='address2']";
    String COUNTRY = "//select[@id='country']";
    String STATE = "//input[@id='state']";
    String CITY = "//input[@id='city']";
    String ZIPCODE = "//input[@id='zipcode']";
    String MOBILE_NUMBER = "//input[@id='mobile_number']";
    String CREATE_ACCOUNT_BUTTON = "//button[normalize-space()='Create Account']";

    //Navigation
    String ACCOUNT_CREATED_TEXT = "//b[normalize-space()='Account Created!']"; 
    String CONTINUE_BUTTON = "//a[@class='btn btn-primary']";
}