package pageEvents;


import java.util.Dictionary;
import java.io.File;
import base.BaseTest;
import pageObjects.contactUsPageELements;

public class contactUsPageEvents extends BaseTest {

    HomePageEvents homePageEvents = new HomePageEvents();

public void fillContactUsForm(@SuppressWarnings("rawtypes") Dictionary contactUsDetails) {

    homePageEvents.homepageIsDisplayed();
    homePageEvents.clickContactUsButton();

    verifyContactFormIsDisplayed();
    logInfo("Fill Contact Us Form");
    clear(contactUsPageELements.NAME_INPUT);
    sendKeys(contactUsPageELements.NAME_INPUT, (String) contactUsDetails.get("name"));

    clear(contactUsPageELements.EMAIL_INPUT);
    sendKeys(contactUsPageELements.EMAIL_INPUT, (String) contactUsDetails.get("email"));

    clear(contactUsPageELements.SUBJECT_INPUT);
    sendKeys(contactUsPageELements.SUBJECT_INPUT, (String) contactUsDetails.get("subject"));

    clear(contactUsPageELements.MESSAGE_TEXTAREA);
    sendKeys(contactUsPageELements.MESSAGE_TEXTAREA, (String) contactUsDetails.get("message"));

   
String filename = "sample.jpg";
String filePath = new File("src/test-data/" + filename).getAbsolutePath();
// String filePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test-data" + File.separator + filename;
   
    System.out.println("Does Java see the file? " + new File(filePath).exists());
    sendKeys(contactUsPageELements.UPLOAD_FILE_BUTTON, filePath);
    

    logInfo("Click Submit button");
    click(contactUsPageELements.SUBMIT_BUTTON);
    acceptAlert();

verifySuccessMessageIsDisplayed();
    logInfo("Click Home button and verify that landed to home page successfully");
    click(contactUsPageELements.HOME_BUTTON);
    homePageEvents.homepageIsDisplayed();
 
}

public void verifyContactFormIsDisplayed() {
    logInfo("Verify 'GET IN TOUCH' is visible");
    assertElementIsDisplayed(contactUsPageELements.GET_IN_TOUCH_TEXT);
}

public void verifySuccessMessageIsDisplayed() {
    logInfo("Verify success message 'Success! Your details have been submitted successfully.' is visible");
    assertElementIsDisplayed(contactUsPageELements.SUCCESS_MESSAGE);

}
}