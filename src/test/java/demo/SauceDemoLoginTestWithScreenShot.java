package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.*;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.io.IOException;

public class SauceDemoLoginTestWithScreenShot {

    private WebDriver driver;
    private ExtentReports extent;
    private ExtentTest test;

    @BeforeSuite
    public void startReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        spark.config().setReportName("Sauce Demo Automation Report");
        spark.config().setDocumentTitle("Selenium Test Report");

        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void completeOrderSuccessfully() throws IOException {
        test = extent.createTest("Complete SauceDemo Order");

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"),
                "Login failed. User was not redirected to inventory page.");

        // Add item to cart
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        WebElement cartBadge = driver.findElement(By.className("shopping_cart_badge"));
        Assert.assertEquals(cartBadge.getText(), "1",
                "Cart badge count is incorrect after adding item to cart.");

        // Open cart
        driver.findElement(By.className("shopping_cart_link")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"),
                "User was not redirected to cart page.");

        // Checkout
        driver.findElement(By.id("checkout")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one.html"),
                "User was not redirected to checkout step one.");

        // Fill customer information
        driver.findElement(By.id("first-name")).sendKeys("Ed");
        driver.findElement(By.id("last-name")).sendKeys("Dela Cruz");
        driver.findElement(By.id("postal-code")).sendKeys("4114");
        driver.findElement(By.id("continue")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"),
                "User was not redirected to checkout overview page.");

        // Finish order
        driver.findElement(By.id("finish")).click();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete.html"),
                "Order was not completed successfully.");

        WebElement successMessage = driver.findElement(By.className("complete-header"));
        Assert.assertEquals(successMessage.getText(), "Thank you for your order!",
                "Order completion message is incorrect.");

        // Take only one screenshot at the end
        String screenshotPath = takeScreenshot("completeOrderSuccessfully");

        // Attach screenshot to report
        test.pass("Order completed successfully")
            .addScreenCaptureFromPath(screenshotPath);
    }

    public String takeScreenshot(String fileName) throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        File folder = new File("test-output/screenshots");
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String screenshotFileName = fileName + "_" + System.currentTimeMillis() + ".png";
        File destination = new File(folder, screenshotFileName);
        FileHandler.copy(screenshot, destination);

        // IMPORTANT: return path relative to ExtentReport.html
        return "screenshots/" + screenshotFileName;
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void endReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}