package pageEvents;

import base.BaseTest;
import pageObjects.TestCasePageElements;

public class testCasePageEvents extends BaseTest {

    HomePageEvents homePageEvents = new HomePageEvents();
    public void navigateToTestCasesPage() {

        homePageEvents.homepageIsDisplayed();
        homePageEvents.navigateToTestCasesPage();
        verifyTestCasesPageIsDisplayed();

     
    }
    public void verifyTestCasesPageIsDisplayed() {
        logInfo("Verify that 'TEST CASES' page is visible");
        assertElementIsDisplayed(TestCasePageElements.TEST_CASES_HDR);
    }
    
}
