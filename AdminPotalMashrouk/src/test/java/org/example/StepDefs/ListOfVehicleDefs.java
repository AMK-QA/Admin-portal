package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ListOfVehicleDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    ListOfVehicle listOfVehicle;
    CreateVehicle createVehicle;
    SoftAssert softAssert = new SoftAssert();
    @Given("user logs in with valid credentials to get list of vehicle")
    public void userLogsInWithValidCredentialsToGetListOfVehicle(){
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("user selects vehicle from the left menu and list of vehicle")
    public void userSelectsVehicleFromTheLeftMenuAndListOfVehicle() {
        // Open rider menu
        homePage.openVehicle();
        // Create list of vehicle page
        listOfVehicle = homePage.selectListOfVehicle();
    }

    @And("Select vehicle delete with number {int} and click on delete button")
    public void selectVehicleDeleteWithNumberAndClickOnDeleteButton(int arg0) {
        // Select which icons need to click, and number of email
        listOfVehicle.clickOnDeleteIcon(arg0);
    }

    @And("Click on {string} to confirm deleting vehicle")
    public void clickOnToConfirmDeletingVehicle(String arg0) {
        // Select yes to confirm rider
        listOfVehicle.confirmDeleteVehicle(arg0);
    }

    @Then("vehicle should be deleted")
    public void vehicleShouldBeDeleted() {
        System.out.println("Deleted");
        softAssert.assertAll();
    }


    @And("Select create vehicle")
    public void selectCreateVehicle() {
        // Create vehicle page
        createVehicle = listOfVehicle.clickOnCreateNewButton();
        // Assert create page is successfully opened
        softAssert.assertTrue(createVehicle.getTextInCreateVehicle().toLowerCase().contains("vehicle"));
    }
    @Then("create page should be opened")
    public void createPageShouldBeOpened() {
        softAssert.assertAll();
    }

    @And("user select search box and enter value {string} in search box at vehicle search box")
    public void userSelectSearchBoxAndEnterValueInSearchBoxAtVehicleSearchBox(String arg0) {
        // Open search box to enter value
        listOfVehicle.openSearchBox();
        // Filter rider list
        listOfVehicle.searchInListOfVehicle(arg0);
    }

    @Then("The filtered vehicle list should be displayed")
    public void theFilteredVehicleListShouldBeDisplayed() {
        System.out.println("vehicle displayed");
    }

    @And("user filtered with start date {string} to end date {string}  at vehicle filter")
    public void userFilteredWithStartDateToEndDateAtVehicleFilter(String arg0, String arg1) {
        // Select start date and end date
        listOfVehicle.clickOnFiltersButton(arg0,arg1);
    }

    @And("user confirm filter by click on {string} button at vehicle filter")
    public void userConfirmFilterByClickOnButtonAtVehicleFilter(String arg0) {
        // Confirm date filter
        listOfVehicle.clickOnFilterButtons(arg0);
    }

    @Then("The filtered riders list should be displayed at vehicle filter")
    public void theFilteredRidersListShouldBeDisplayedAtVehicleFilter() {
        System.out.println("Filtered");
    }


}
