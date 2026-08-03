package pageEvents;

import base.BaseTest;
import pageObjects.LeftSideBarElements;

public class LeftSideBarPageEvents extends BaseTest {

    public void clickWomenCategory() {
        logger.info("Click 'Women' category");
        click(LeftSideBarElements.WOMEN_CATEGORY_PANEL);
    }

    public void clickMenCategory() {
        logger.info("Click 'Men' category");
        click(LeftSideBarElements.MEN_CATEGORY_PANEL);
    }

    public void clickWomenDressSubcategory() {
        logger.info("Click 'Women Dress' subcategory");
        click(LeftSideBarElements.WOMEN_DRESS_SUBCATEGORY); 
    }

    public void clickMenTshirtsSubcategory() {
        logger.info("Click 'Men Tshirts' subcategory");
        click(LeftSideBarElements.MEN_TSHIRTS_SUBCATEGORY); 
    }

    public void verifyCategorySectionIsDisplayed() {
        logger.info("Verify Category section is displayed");
        assertElementIsDisplayed(LeftSideBarElements.CATEGORY_SECTION);
    }

    public void verifyWomenDressCategoryPage() {
        logger.info("Verify women dress category page");
        assertElementIsDisplayed(LeftSideBarElements.CATEGORY_WOMEN_DRESS_PAGE);
    }

    public void verifyMenTshirtsCategoryPage() {
        logger.info("Verify men tshirts category page");
        assertElementIsDisplayed(LeftSideBarElements.CATEGORY_MEN_TSHIRTS_PAGE);
    }

    public void clickPoloBrand() {
        logger.info("Click 'Polo' brand");
        click(LeftSideBarElements.POLO_BRAND);
    }

    public void clickMadameBrand() {
        logger.info("Click 'Madame' brand");
        click(LeftSideBarElements.MADAME_BRAND);
    }

    public void verifyBrandSectionIsDisplayed() {
        logger.info("Verify Brand section is displayed");
        assertElementIsDisplayed(LeftSideBarElements.BRAND_SECTION);
    }

    public void verifyPoloBrandProductsPage() {
        logger.info("Verify Polo brand products page");
        assertElementIsDisplayed(LeftSideBarElements.POLO_PRODUCTS_PAGE);
    }

    public void verifyMadameBrandProductsPage() {
        logger.info("Verify Madame brand products page");
        assertElementIsDisplayed(LeftSideBarElements.MADAME_PRODUCTS_PAGE);
    }
}
