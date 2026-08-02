package pageObjects;

public interface contactUsPageELements {
    
    String GET_IN_TOUCH_TEXT = "//h2[normalize-space()='Get In Touch']";
    String NAME_INPUT = "//input[@placeholder='Name']";
    String EMAIL_INPUT = "//input[@placeholder='Email']";
    String SUBJECT_INPUT = "//input[@placeholder='Subject']";
    String MESSAGE_TEXTAREA = "//textarea[@id='message']";
    String UPLOAD_FILE_BUTTON = "//input[@name='upload_file']";

    String SUBMIT_BUTTON = "//input[@name='submit']";
    String SUCCESS_MESSAGE = "//div[@class='status alert alert-success']";
    String HOME_BUTTON = "//a[@class='btn btn-success']";

}
