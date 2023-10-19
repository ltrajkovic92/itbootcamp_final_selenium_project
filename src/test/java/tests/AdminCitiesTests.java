package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest {

    @Test(priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities () {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();
        loginPage.login(email,password);
        navPage.clickOnAdminButton();
        navPage.clickOnAdminCitiesButton();

        Assert.assertTrue(pageUrl.isAdminCitiesPage(),
                "Should be redirected to the Admin/Cities page.");
    }

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypesForCreateOrEditNewCity () {
        navPage.clickOnAdminButton();
        navPage.clickOnAdminCitiesButton();

        citiesPage.clickOnNewItemButton();
        citiesPage.waitForCreateOrEditDialog();

        Assert.assertEquals(citiesPage.getNameInputType(), "text",
                "The attribute type for name field should be 'text'.");
    }

    @Test (priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void createNewCity () {
        String cityName = "Lazar Trajkovic's city";

        navPage.clickOnAdminButton();
        navPage.clickOnAdminCitiesButton();
        citiesPage.clickOnNewItemButton();
        citiesPage.waitForCreateOrEditDialog();

        citiesPage.clearAndTypeName(cityName);
        citiesPage.clickOnSaveButton();

        messagePopUpPage.waitForSuccessfullyPopUpMessage();
        Assert.assertTrue(messagePopUpPage.getSuccessfullyPopUpMessageText()
                .contains("Saved successfully"),
                "Success pop-up message should contain 'Saved successfully'");
    }

    @Test (priority = 4, retryAnalyzer = RetryAnalyzer.class)
    public void editCity () {
        String oldCityName = "Lazar Trajkovic's city";
        String newCityName = "Lazar Trajkovic's city Edited";

        navPage.clickOnAdminButton();
        navPage.clickOnAdminCitiesButton();

        citiesPage.clearAndTypeInSearch(oldCityName);
        citiesPage.waitForNumberOfTableRows(1);
        citiesPage.clickOnEditButtonFromTableRow(1);

        citiesPage.clearAndTypeName(newCityName);
        citiesPage.clickOnSaveButton();

        messagePopUpPage.waitForSuccessfullyPopUpMessage();
        Assert.assertTrue(messagePopUpPage.getSuccessfullyPopUpMessageText()
                        .contains("Saved successfully"),
                "Success pop-up message should contain 'Saved successfully'");
    }

    @Test (priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void searchCity () {
        String newCityName = "Lazar Trajkovic's city Edited";

        navPage.clickOnAdminButton();
        navPage.clickOnAdminCitiesButton();

        citiesPage.clearAndTypeInSearch(newCityName);
        citiesPage.waitForNumberOfTableRows(1);

        Assert.assertEquals(citiesPage.getTextFromTheField(1,2), newCityName,
                "City name in the field should be " + newCityName);
    }

    @Test (priority = 6, retryAnalyzer = RetryAnalyzer.class)
    public void deleteCity () {
        String newCityName = "Lazar Trajkovic's city Edited";

        navPage.clickOnAdminButton();
        navPage.clickOnAdminCitiesButton();

        citiesPage.clearAndTypeInSearch(newCityName);
        citiesPage.waitForNumberOfTableRows(1);

        Assert.assertEquals(citiesPage.getTextFromTheField(1,2), newCityName,
                "City name in the field should be " + newCityName);

        citiesPage.clickOnDeleteButtonFromTableRow(1);
        citiesPage.waitForDeleteDialog();
        citiesPage.clickOnDeleteButtonFromDialog();

        messagePopUpPage.waitForSuccessfullyPopUpMessage();
        Assert.assertTrue(messagePopUpPage.getSuccessfullyPopUpMessageText()
                        .contains("Deleted successfully"),
                "Success pop-up message should contain 'Deleted successfully'");
    }
}
