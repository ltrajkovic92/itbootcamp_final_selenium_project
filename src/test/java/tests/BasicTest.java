package tests;

import helper.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import pages.NavPage;
import pages.PageUrl;

import java.io.IOException;
import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected NavPage navPage;
    protected PageUrl pageUrl;
    protected LoginPage loginPage;

    @BeforeClass
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navPage = new NavPage(driver,wait);
        pageUrl = new PageUrl(driver,wait);
        loginPage = new LoginPage(driver,wait);
    }

    @BeforeMethod
    public void beforeMethode () {
        driver.navigate().to(baseUrl);
    }

    @AfterMethod
    public void afterMethod (ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Helper.takeScreenshotWithDateAndTime(driver, testResult.getName());
        }
    }

    @AfterClass
    public void afterClass () {
        driver.quit();
    }
}
