package pageObjects;

public interface productPageElements {
    

    String SEARCH_BOX = "//input[@id='search_product']"; 
    String PRODUCT_CARDS = "cssSelector:.features_items .single-products";
    String View_PRODUCT_BUTTON = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]";
    String PRODUCT_NAME = "//h2[normalize-space()='Blue Top']";
    String PRODUCT_CATEGORY = "//p[normalize-space()='Category: Women > Tops']";
    String PRODUCT_PRICE = "//span[normalize-space()='Rs. 500']";
    String PRODUCT_AVAILABILITY = "//div[@class='product-details']//p[2]";
    String PRODUCT_CONDITION = "//body//section//p[3]";
    String PRODUCT_BRAND = "//span[@class='google-anno-t']";
    String SEARCH_BUTTON = "//i[@class='fa fa-search']";
    String SEARCHED_PRODUCTS_HEADER = "//h2[@class='title text-center']";
}
