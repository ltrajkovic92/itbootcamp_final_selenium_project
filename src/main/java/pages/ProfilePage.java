package pages;

import org.openqa.selenium.By;
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
    public void waitUntilLoadDialogIsInvisible () {
        wait
                .withMessage("Load dialog is still visible.")
                .until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("v-dialog v-dialog--persistent")));
    }
}
