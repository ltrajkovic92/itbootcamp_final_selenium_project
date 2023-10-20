package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class ProfileTests extends BasicTest {

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheProfilePage () {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        loginPage.login(email,password);
        navPage.clickMyProfileButton();

        Assert.assertTrue(pageUrl.isProfilePage(),
                "Should be redirected to the Profile page.");

        profilePage.waitUntilLoadDialogIsInvisible();

        Assert.assertEquals(profilePage.getValueFromEmailInput(), email,
                "The email input value should be " + email);

        navPage.clickOnLogoutButton();
    }

    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes () {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        loginPage.login(email,password);
        navPage.clickMyProfileButton();
        profilePage.waitUntilLoadDialogIsInvisible();

        Assert.assertEquals(profilePage.getTypeFromEmailInput(), "email",
                "The email input type should be 'email'");
        Assert.assertEquals(profilePage.getAttributeDisabledFromInputEmail(), "disabled",
                "The email input should be 'disabled'");
        Assert.assertEquals(profilePage.getTypeFromNameInput(), "text",
                "The name input type should be 'text'");
        Assert.assertEquals(profilePage.getTypeFromCityInput(), "text",
                "The city input type should be 'text'");
        Assert.assertEquals(profilePage.getTypeFromCountryInput(), "text",
                "The country input type should be 'text'");
        Assert.assertEquals(profilePage.getTypeFromTwitterInput(), "url",
                "The twitter input type should be 'url'");
        Assert.assertEquals(profilePage.getTypeFromGitHubInput(), "url",
                "The github input type should be 'url'");
        Assert.assertEquals(profilePage.getTypeFromPhoneInput(), "tel",
                "The phone input type should be 'url'");

        navPage.clickOnLogoutButton();
    }
}
