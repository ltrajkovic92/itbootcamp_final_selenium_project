package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest {

    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheLoginPage () {
        navPage.clickOnLanguagesButton();
        navPage.clickOnEnLanguageButton();
        navPage.clickOnLoginButton();

        Assert.assertTrue(pageUrl.isLoginPage(),
                "Should be redirected to the Login page.");
    }

    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes () {
        navPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.getEmailInputType(), "email",
                "The attribute type for email field should be 'email'.");

        Assert.assertEquals(loginPage.getPasswordInputType(), "password",
                "The attribute type for email field should be 'password'.");
    }

    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserDoesNotExist () {
        String email = "non-existing-user@gmal.com";
        String password = "password123";

        navPage.clickOnLoginButton();
        loginPage.login(email,password);
        messagePopUpPage.waitForErrorPopUpToBeVisible();

        Assert.assertEquals(messagePopUpPage.getErrorMessageText(), "User does not exists",
                "Error message should be 'User does not exists'.");

        Assert.assertTrue(pageUrl.isLoginPage(),
                "Should be redirected to the Login page.");
    }
}
