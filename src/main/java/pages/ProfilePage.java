package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage {
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public WebElement getEmailInput () {
        return driver.findElement(By.id("email"));
    }
    public String getValueFromEmailInput () {
        return getEmailInput().getAttribute("value");
    }
    public String getTypeFromEmailInput () {
        return getEmailInput().getAttribute("type");
    }
    public String getAttributeDisabledFromInputEmail () {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return arguments[0].getAttribute('disabled');", getEmailInput()).toString();
    }
    public WebElement getNameInput () {
        return driver.findElement(By.id("name"));
    }
    public String getTypeFromNameInput () {
        return getNameInput().getAttribute("type");
    }
    public WebElement getCityInput () {
        return driver.findElement(By.id("city"));
    }
    public String getTypeFromCityInput () {
        return getCityInput().getAttribute("type");
    }
    public WebElement getCountryInput () {
        return driver.findElement(By.id("country"));
    }
    public String getTypeFromCountryInput () {
        return getCountryInput().getAttribute("type");
    }
    public WebElement getTwitterInput () {
        return driver.findElement(By.id("urlTwitter"));
    }
    public String getTypeFromTwitterInput () {
        return getTwitterInput().getAttribute("type");
    }
    public WebElement getGitHubInput () {
        return driver.findElement(By.id("urlGitHub"));
    }
    public String getTypeFromGitHubInput () {
        return getGitHubInput().getAttribute("type");
    }
    public WebElement getPhoneInput () {
        return driver.findElement(By.id("phone"));
    }
    public String getTypeFromPhoneInput () {
        return getPhoneInput().getAttribute("type");
    }
    public void waitUntilLoadDialogIsInvisible () {
        wait
                .withMessage("Load dialog is still visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("v-dialog v-dialog--persistent")));
    }
}
