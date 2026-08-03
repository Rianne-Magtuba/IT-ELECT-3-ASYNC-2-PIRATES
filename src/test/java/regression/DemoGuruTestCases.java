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

import com.google.common.base.Verify;

import base.BaseTest;
import pageEvents.CartPageEvents;
import pageEvents.CheckoutPageEvents;
import pageEvents.FooterPageEvents;
import pageEvents.HeaderPageEvents;
import pageEvents.HomePageEvents;
import pageEvents.LeftSideBarPageEvents;
import pageEvents.PaymentPageEvents;
import pageEvents.ProductDetailsPageEvents;
import pageEvents.ProductsPageEvents;
import pageEvents.contactUsPageEvents;
import pageEvents.signupPageEvents;
import pageEvents.signup_Login_PageEvents;
import pageEvents.testCasePageEvents;




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
        ProductsPageEvents productPageEvents = new ProductsPageEvents();
        HeaderPageEvents headerPageEvents = new HeaderPageEvents();
    FooterPageEvents footerPageEvents = new FooterPageEvents();
    ProductsPageEvents productsPageEvents = new ProductsPageEvents();
    ProductDetailsPageEvents productDetailsPageEvents = new ProductDetailsPageEvents();
    CartPageEvents cartPageEvents = new CartPageEvents();
    CheckoutPageEvents checkoutPageEvents = new CheckoutPageEvents();
    PaymentPageEvents paymentPageEvents = new PaymentPageEvents();
    LeftSideBarPageEvents leftSideBarPageEvents = new LeftSideBarPageEvents();
            
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
        headerPageEvents.verifyLoggedInAsUsername();
        homePageEvents.clickDeleteAccountButton(); 
      
        

    }


    @Test(priority = 2)
    public void tc_02_LoginSuccesfully(){
        String email = "ghoulllgohasdauldsa"+generate4Digit()+"dasas@gmaislasds.com";
      createAccountAndLogout("Rianne", email);

      homePageEvents.homepageIsDisplayed();
        signUp_Login_PageEvents.loginSuccessfully(email, "Password123@asda2");
   headerPageEvents.verifyLoggedInAsUsername();
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
        
        homePageEvents.homepageIsDisplayed();
       signUp_Login_PageEvents.loginSuccessfully(email, "Password123@asda2");
       
        headerPageEvents.verifyLoggedInAsUsername();

        homePageEvents.logoutUser();

        signUp_Login_PageEvents.enter_login_info_visible();
    }

    //test can't be run on its own as it needs the initialization of the _email variable from the previous test case. It is dependent on tc_04_LogoutUser to set the _email variable.
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
    
  @Test(priority = 10)
    public void tc10_VerifySubscriptionInHomePage(){
        homePageEvents.homepageIsDisplayed();
        footerPageEvents.scrollToFooter();
        footerPageEvents.verifySubscriptionTextVisible();
        footerPageEvents.subscribeWithEmail("subscriber" + generate4Digit() + "@mail.com");
        footerPageEvents.verifySubscriptionSuccessMessage();
    }

    @Test(priority = 11)
    public void tc11_VerifySubscriptionInCartPage(){
        homePageEvents.homepageIsDisplayed();
        headerPageEvents.clickCartButton();
        footerPageEvents.scrollToFooter();
        footerPageEvents.verifySubscriptionTextVisible();
        footerPageEvents.subscribeWithEmail("subscriber" + generate4Digit() + "@mail.com");
        footerPageEvents.verifySubscriptionSuccessMessage();
    }

    @Test(priority = 12)
    public void tc12_AddProductsInCart(){
        homePageEvents.homepageIsDisplayed();
        headerPageEvents.clickProductsButton();
        productsPageEvents.hoverAndAddFirstProductToCart();
        productsPageEvents.clickContinueShoppingButton();
        productsPageEvents.hoverAndAddSecondProductToCart();
        productsPageEvents.clickViewCartButton();
        cartPageEvents.verifyProductsInCart(2);
        cartPageEvents.verifyPricesQuantityAndTotal();
    }

    @Test(priority = 13)
    public void tc13_VerifyProductQuantityInCart(){
        homePageEvents.homepageIsDisplayed();
        productsPageEvents.clickViewProductForFirstProduct();
        productDetailsPageEvents.verifyProductDetailIsOpened();
        productDetailsPageEvents.setQuantity("4");
        productDetailsPageEvents.clickAddToCartButton();
        productsPageEvents.clickViewCartButton();
        cartPageEvents.verifyProductQuantityInCart("4");
    }

    @Test(priority = 14)
    public void tc14_PlaceOrderRegisterWhileCheckout(){
        homePageEvents.homepageIsDisplayed();
        headerPageEvents.clickProductsButton();
        productsPageEvents.hoverAndAddFirstProductToCart();
        productsPageEvents.clickContinueShoppingButton();
        headerPageEvents.clickCartButton();
        cartPageEvents.verifyCartPageIsDisplayed();
        cartPageEvents.clickProceedToCheckoutButton();
        cartPageEvents.clickRegisterLoginButton();

        signUp_Login_PageEvents.fillSignUpForm("Rianne14", "rianne14_" + generate4Digit() + "@mail.com");
        Dictionary<String, String> details = buildSignupDetails();
        signupPageEvents.fillUpSignUpForm(details);
       // signupPageEvents.validateUserRegister();
       // signupPageEvents.clickContinueButton();

        headerPageEvents.verifyLoggedInAsUsername();
        headerPageEvents.clickCartButton();
        cartPageEvents.clickProceedToCheckoutButton();
        checkoutPageEvents.verifyAddressDetailsAndReviewOrder();
        checkoutPageEvents.enterOrderComment("Please deliver in the morning.");
        checkoutPageEvents.clickPlaceOrderButton();
        paymentPageEvents.enterPaymentDetails("Rianne Magtuba", "4111111111111111", "123", "05", "2028");
        paymentPageEvents.clickPayButton();
        checkoutPageEvents.verifyOrderSuccessMessage();
        homePageEvents.clickDeleteAccountButton();
        homePageEvents.verifyUserIsDeleted();
    }

    @Test(priority = 15)
    public void tc15_PlaceOrderRegisterBeforeCheckout(){
        homePageEvents.homepageIsDisplayed();
        headerPageEvents.clickSignupLoginButton();

        signUp_Login_PageEvents.fillSignUpForm("Rianne15", "rianne15_" + generate4Digit() + "@mail.com");
        Dictionary<String, String> details = buildSignupDetails();
        signupPageEvents.fillUpSignUpForm(details);
       // signupPageEvents.validateUserRegister();
      //  signupPageEvents.clickContinueButton();
        headerPageEvents.verifyLoggedInAsUsername();

        headerPageEvents.clickProductsButton();
        productsPageEvents.hoverAndAddFirstProductToCart();
        productsPageEvents.clickContinueShoppingButton();
        headerPageEvents.clickCartButton();
        cartPageEvents.verifyCartPageIsDisplayed();
        cartPageEvents.clickProceedToCheckoutButton();
        checkoutPageEvents.verifyAddressDetailsAndReviewOrder();
        checkoutPageEvents.enterOrderComment("Please deliver in the morning.");
        checkoutPageEvents.clickPlaceOrderButton();
        paymentPageEvents.enterPaymentDetails("Rianne Magtuba", "4111111111111111", "123", "05", "2028");
        paymentPageEvents.clickPayButton();
        checkoutPageEvents.verifyOrderSuccessMessage();
        homePageEvents.clickDeleteAccountButton();
        homePageEvents.verifyUserIsDeleted();
    }

    @Test(priority = 16)
public void tc16_PlaceOrderLoginBeforeCheckout(){

    //added extra account creation as accounts gets deleted at the end as per the test case
    String email = "rianne16_" + generate4Digit() + "@mail.com";
    String password = "Password123@asda2";

    createAccountAndLogout("Rianne16", email);

    homePageEvents.homepageIsDisplayed();
    headerPageEvents.clickSignupLoginButton();
    
    signUp_Login_PageEvents.loginSuccessfully(email, password);
    headerPageEvents.verifyLoggedInAsUsername();

    headerPageEvents.clickProductsButton();
    productsPageEvents.hoverAndAddFirstProductToCart();
    productsPageEvents.clickContinueShoppingButton();
    headerPageEvents.clickCartButton();
    cartPageEvents.verifyCartPageIsDisplayed();
    cartPageEvents.clickProceedToCheckoutButton();
    checkoutPageEvents.verifyAddressDetailsAndReviewOrder();
    checkoutPageEvents.enterOrderComment("Please deliver in the morning.");
    checkoutPageEvents.clickPlaceOrderButton();
    paymentPageEvents.enterPaymentDetails("Rianne Magtuba", "4111111111111111", "123", "05", "2028");
    paymentPageEvents.clickPayButton();
    checkoutPageEvents.verifyOrderSuccessMessage();
    homePageEvents.clickDeleteAccountButton();
    homePageEvents.verifyUserIsDeleted();
}

    @Test(priority = 17)
    public void tc17_RemoveProductsFromCart(){
        homePageEvents.homepageIsDisplayed();
        headerPageEvents.clickProductsButton();
        productsPageEvents.hoverAndAddFirstProductToCart();
        productsPageEvents.clickContinueShoppingButton();
        headerPageEvents.clickCartButton();
        cartPageEvents.verifyCartPageIsDisplayed();
        cartPageEvents.removeFirstProductFromCart();
        cartPageEvents.verifyProductRemovedFromCart();
    }

    @Test(priority = 18)
    public void tc18_ViewCategoryProducts(){
        homePageEvents.homepageIsDisplayed();
        leftSideBarPageEvents.verifyCategorySectionIsDisplayed();
        leftSideBarPageEvents.clickWomenCategory();
        leftSideBarPageEvents.clickWomenDressSubcategory();
        leftSideBarPageEvents.verifyWomenDressCategoryPage();
        leftSideBarPageEvents.clickMenCategory();
        leftSideBarPageEvents.clickMenTshirtsSubcategory();
        leftSideBarPageEvents.verifyMenTshirtsCategoryPage();
    }

    @Test(priority = 19)
    public void tc19_ViewAndCartBrandProducts(){
        homePageEvents.homepageIsDisplayed();
        headerPageEvents.clickProductsButton();
        leftSideBarPageEvents.verifyBrandSectionIsDisplayed();
        leftSideBarPageEvents.clickPoloBrand();
        leftSideBarPageEvents.verifyPoloBrandProductsPage();
        leftSideBarPageEvents.clickMadameBrand();
        leftSideBarPageEvents.verifyMadameBrandProductsPage();
    }

    @Test(priority = 20)
    public void tc20_SearchProductsAndVerifyCartAfterLogin(){
        String email = "poneldimaguila@gmail.com";
        productPageEvents.searchForProduct("top");
        productsPageEvents.hoverAndAddFirstProductToCart();
        productsPageEvents.clickContinueShoppingButton();
        productsPageEvents.hoverAndAddSecondProductToCart();
        productsPageEvents.clickContinueShoppingButton();
        headerPageEvents.clickCartButton();
        cartPageEvents.verifyProductsInCart(2);
        headerPageEvents.clickSignupLoginButton();
        signUp_Login_PageEvents.loginSuccessfully(email, "123456");
        headerPageEvents.clickCartButton();
        cartPageEvents.verifyProductsInCart(2);   
    }

    @Test(priority = 21)
    public void tc21_AddReviewOnProduct(){
        productPageEvents.productListIsVisible(); 
        productDetailsPageEvents.verifyWriteReviewLabelIsVisible();
        productDetailsPageEvents.fillUpWriteReview("Niel", "niel" + generate4Digit() + "@mail.com", "This is a test review.");
    }

    @Test(priority = 22)
    public void tc22_AddToCartFromRecommendedItems(){
        homePageEvents.homepageIsDisplayed();
        homePageEvents.verifyRecommendedItemsSectionIsDisplayed();
        homePageEvents.clickAddToCartRecommendedItemButton();
        headerPageEvents.clickCartButton();
        cartPageEvents.verifyProductsInCart(1);
    }

    @Test(priority = 23)
    public void tc23_VerifyAddressDetailsInCheckoutPage(){
        homePageEvents.homepageIsDisplayed();
        createAccount("Niel", "nielniel"+generate4Digit()+"@gmaisl.com" );
        headerPageEvents.verifyLoggedInAsUsername();
        homePageEvents.homepageIsDisplayed();
        headerPageEvents.clickProductsButton();
        productsPageEvents.hoverAndAddFirstProductToCart();
        productsPageEvents.clickContinueShoppingButton();
        headerPageEvents.clickCartButton();
        cartPageEvents.clickProceedToCheckoutButton();
        checkoutPageEvents.verifyDeliveryAddress(signupDetails);
        checkoutPageEvents.verifyBillingAddress(signupDetails);
        homePageEvents.clickDeleteAccountButton();
        homePageEvents.verifyUserIsDeleted();
    }

    @Test(priority = 24)
    public void tc24_DownloadInvoiceAfterPurchaseOrder(){
        homePageEvents.homepageIsDisplayed();
        headerPageEvents.clickProductsButton();
        productsPageEvents.hoverAndAddFirstProductToCart();
        productsPageEvents.clickContinueShoppingButton();
        headerPageEvents.clickCartButton();
        cartPageEvents.verifyCartPageIsDisplayed();
        cartPageEvents.clickProceedToCheckoutButton();
        cartPageEvents.clickRegisterLoginButton();

        signUp_Login_PageEvents.fillSignUpForm("Rianne14", "rianne14_" + generate4Digit() + "@mail.com");
        Dictionary<String, String> details = buildSignupDetails();
        signupPageEvents.fillUpSignUpForm(details);

        headerPageEvents.verifyLoggedInAsUsername();
        headerPageEvents.clickCartButton();
        cartPageEvents.clickProceedToCheckoutButton();
        checkoutPageEvents.verifyAddressDetailsAndReviewOrder();
        checkoutPageEvents.enterOrderComment("Please deliver in the morning.");
        checkoutPageEvents.clickPlaceOrderButton();
        paymentPageEvents.enterPaymentDetails("Rianne Magtuba", "4111111111111111", "123", "05", "2028");
        paymentPageEvents.clickPayButton();
        checkoutPageEvents.verifyOrderSuccessMessage();
        checkoutPageEvents.clickDownloadInvoiceButton();
        //checkoutPageEvents.verifyInvoiceDownloaded();
        checkoutPageEvents.clickContinueButton();
        homePageEvents.clickDeleteAccountButton();
        homePageEvents.verifyUserIsDeleted();
    }

    @Test(priority = 25)
    public void tc25_VerifyScrollUpUsingArrowButtonAndScrollDownFunctionality(){
        homePageEvents.homepageIsDisplayed();
        footerPageEvents.scrollToFooter();
        footerPageEvents.verifySubscriptionTextVisible();
        homePageEvents.clickArrowUpButton();
        homePageEvents.verifyTopOfTheScreenTextIsVisible();
    }

    @Test(priority = 26)
    public void tc26_VerifyScrollUpWithoutArrowButtonAndScrollDownFunctionality(){
        homePageEvents.homepageIsDisplayed();
        footerPageEvents.scrollToFooter();
        footerPageEvents.verifySubscriptionTextVisible();
        headerPageEvents.scrollToHeader();
        homePageEvents.verifyTopOfTheScreenTextIsVisible();
    }

    private Dictionary<String, String> buildSignupDetails(){
        Dictionary<String, String> details = new Hashtable<>();
        details.put("password", "Password123@asda2");
        details.put("day", "1");
        details.put("month", "January");
        details.put("year", "1990");
        details.put("firstName", "Rianne");
        details.put("lastName", "Magtuba");
        details.put("company", "Test Company");
        details.put("address1", "123 Test Way");
        details.put("address2", "456 Test Street");
        details.put("country", "India");
        details.put("state", "Test State");
        details.put("city", "Test City");
        details.put("zipcode", "1234");
        details.put("mobileNumber", "09123456789");
        return details;
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result){
        afterMethod(result, browser);
    }



}