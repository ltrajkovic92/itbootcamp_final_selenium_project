package pages;

import org.openqa.selenium.*;
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
    public String getValueFromNameInput () {
        return getNameInput().getAttribute("value");
    }
    public void clearAndTypeName (String name) {
        getNameInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),name);
    }
    public WebElement getCityInput () {
        return driver.findElement(By.id("city"));
    }
    public String getTypeFromCityInput () {
        return getCityInput().getAttribute("type");
    }
    public String getValueFromCityInput () {
        return getCityInput().getAttribute("value");
    }
    public void clearAndTypeCity (String city) {
        getCityInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),city);
        getCityInput().sendKeys(Keys.ENTER);
    }
    public WebElement getCountryInput () {
        return driver.findElement(By.id("country"));
    }
    public String getTypeFromCountryInput () {
        return getCountryInput().getAttribute("type");
    }
    public String getValueFromCountryInput () {
        return getCountryInput().getAttribute("value");
    }
    public void clearAndTypeCountry (String country) {
        getCountryInput().click();
        getCountryInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),country);
    }
    public WebElement getTwitterInput () {
        return driver.findElement(By.id("urlTwitter"));
    }
    public String getTypeFromTwitterInput () {
        return getTwitterInput().getAttribute("type");
    }
    public String getValueFromTwitterInput () {
        return getTwitterInput().getAttribute("value");
    }
    public void clearAndTypeTwitter (String twitter) {
        getTwitterInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),twitter);
    }
    public WebElement getGitHubInput () {
        return driver.findElement(By.id("urlGitHub"));
    }
    public String getTypeFromGitHubInput () {
        return getGitHubInput().getAttribute("type");
    }
    public String getValueFromGitHubInput () {
        return getGitHubInput().getAttribute("value");
    }
    public void clearAndTypeGitHub (String github) {
        getGitHubInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),github);
    }
    public WebElement getPhoneInput () {
        return driver.findElement(By.id("phone"));
    }
    public String getTypeFromPhoneInput () {
        return getPhoneInput().getAttribute("type");
    }
    public String getValueFromPhoneInput () {
        return getPhoneInput().getAttribute("value");
    }
    public void clearAndTypePhone (String phone) {
        getPhoneInput().sendKeys(Keys.chord(Keys.CONTROL, "a"),phone);
    }
    public WebElement getSaveButton () {
        return driver.findElement(By.className("btnSave"));
    }
    public void clickOnSaveButton () {
        getSaveButton().click();
    }
    public void waitUntilLoadDialogIsInvisible () {
        wait
                .withMessage("Load dialog is still visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("v-dialog v-dialog--persistent")));
    }
}
