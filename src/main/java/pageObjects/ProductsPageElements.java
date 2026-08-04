package pageObjects;

public interface ProductsPageElements {



    String SEARCH_BOX = "//input[@id='search_product']"; 
    String PRODUCT_CARDS = "cssSelector:.features_items .single-products";
    String View_PRODUCT_BUTTON = "//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]";
    String PRODUCT_NAME = "//h2[normalize-space()='Blue Top']";
    String PRODUCT_CATEGORY = "//p[normalize-space()='Category: Women > Tops']";
    String PRODUCT_PRICE = "//span[normalize-space()='Rs. 500']";
    String PRODUCT_AVAILABILITY = "//div[@class='product-details']//p[2]";
    String PRODUCT_CONDITION = "//body//section//p[3]";
    String PRODUCT_BRAND = "//body//section//p[4]";
    String SEARCH_BUTTON = "//i[@class='fa fa-search']";
    String SEARCHED_PRODUCTS_HEADER = "//h2[@class='title text-center']";

    String VIEW_PRODUCT_BUTTON = "(//a[contains(text(),'View Product')])[1]";
    String FIRST_PRODUCT_ADD_TO_CART_BUTTON = "(//a[contains(text(),'Add to cart')])[2]";
    String CONTINUE_SHOPPING_BUTTON = "//button[normalize-space()='Continue Shopping']";
    String SECOND_PRODUCT_ADD_TO_CART_BUTTON = "(//a[contains(text(),'Add to cart')])[4]";
    String VIEW_CART_BUTTON = "//p[@class='text-center']//a";
    String FIRST_PRODUCT_ADD_TO_CART = "(//div[@class='product-image-wrapper'])[1]//div[@class='product-overlay']//a[contains(@class, 'add-to-cart')]";
    
    String SECOND_PRODUCT_ADD_TO_CART = "(//div[@class='product-image-wrapper'])[2]//div[@class='product-overlay']//a[contains(@class, 'add-to-cart')]";
    
}