package pageObjects;

public interface LeftSideBarElements {
    String WOMEN_CATEGORY_PANEL = "//a[normalize-space()='Women']";
    String MEN_CATEGORY_PANEL = "//a[normalize-space()='Men']";
    String KIDS_CATEGORY_PANEL = "//a[normalize-space()='Kids']";
    String WOMEN_DRESS_SUBCATEGORY = "//div[@id='Women']//a[contains(text(),'Dress')]";   
    String MEN_TSHIRTS_SUBCATEGORY = "//div[@id='Men']//a[contains(text(),'Tshirts')]";
    String CATEGORY_SECTION = "//div[@class='left-sidebar']//h2[text()='Category']";
    String CATEGORY_WOMEN_DRESS_PAGE = "//h2[@class='title text-center' and contains(., 'Dress')]\"";
    String CATEGORY_MEN_TSHIRTS_PAGE = "//span[normalize-space()='Men']";
    String BRAND_SECTION = "//div[@class='brands_products']//h2[text()='Brands']";
    String POLO_BRAND = "//a[@href='/brand_products/Polo']";
    String MADAME_BRAND = "//a[@href='/brand_products/Madame']";
    String POLO_PRODUCTS_PAGE = "//h2[@class='title text-center' and contains(., 'Polo')]";
    String MADAME_PRODUCTS_PAGE = "//h2[@class='title text-center' and contains(., 'Madame')]";
}