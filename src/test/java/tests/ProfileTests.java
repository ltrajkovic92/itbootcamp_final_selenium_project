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

    @Test (priority = 3)
    public void editsProfile () {
        String email = "admin@admin.com";
        String password = "12345";
        String name = "Lazar Trajkovic";
        String phone = "+38161283223";
        String city = "Bucaramanga";
        String country = "Spain";
        String twitter = "https://twitter.com/profile/lazar1232";
        String github = "https://github.com/ltrajkovic92";

        navPage.clickOnLoginButton();
        loginPage.login(email,password);
        navPage.clickMyProfileButton();
        profilePage.waitUntilLoadDialogIsInvisible();

        profilePage.clearAndTypeName(name);
        profilePage.clearAndTypePhone(phone);
        profilePage.clearAndTypeCity(city);
        profilePage.clearAndTypeCountry(country);
        profilePage.clearAndTypeTwitter(twitter);
        profilePage.clearAndTypeGitHub(github);
        profilePage.clickOnSaveButton();

        messagePopUpPage.waitForSuccessfullyPopUpMessage();

        Assert.assertTrue(messagePopUpPage.getSuccessfullyPopUpMessageText().contains("Profile saved successfuly"),
                "Success pop-up message should contain 'Profile saved successfuly'");

        Assert.assertEquals(profilePage.getValueFromEmailInput(), email,
                "The email input value should be " + email);
        Assert.assertEquals(profilePage.getValueFromNameInput(), name,
                "The name input value should be " + name);
        Assert.assertEquals(profilePage.getValueFromPhoneInput(), phone,
                "The phone input value should be " + phone);
        Assert.assertEquals(profilePage.getValueFromCityInput(), city,
                "The city input value should be " + city);
        Assert.assertEquals(profilePage.getValueFromCountryInput(), country,
                "The country input value should be " + country);
        Assert.assertEquals(profilePage.getValueFromTwitterInput(), twitter,
                "The twitter input value should be " + twitter);
        Assert.assertEquals(profilePage.getValueFromGitHubInput(), github,
                "The github input value should be " + github);

        navPage.clickOnLogoutButton();
    }
}
