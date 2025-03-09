package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.EditVehicle;
import org.example.Pages.HomePage;
import org.example.Pages.ListOfVehicle;
import org.example.Pages.LoginPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class EditVehicleDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    ListOfVehicle listOfVehicle;
    EditVehicle editVehicle;
    SoftAssert softAssert = new SoftAssert();
    @Given("user logs in with valid credentials to edit vehicle")
    public void userLogsInWithValidCredentialsToEditVehicle(){
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded, get username and password from configuration file
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("user selects vehicle from the left menu to edit vehicle")
    public void userSelectsVehicleFromTheLeftMenuToEditVehicle() {
        // Open vehicle
        homePage.openVehicle();
    }

    @And("user selects list of vehicle and click on edit vehicle with number {int}")
    public void userSelectsListOfVehicleAndClickOnEditVehicleWithNumber(int arg0) {
        // Select Create vehicle
        listOfVehicle = homePage.selectListOfVehicle();
        // Assert create vehicle page is opened successfully
        softAssert.assertTrue(listOfVehicle.getTextInListOfVehicleDriver().toLowerCase().contains("vehicles"));
        // Open edit vehicle page
        editVehicle = listOfVehicle.clickOnEditIcon(arg0);
        // Assert edit vehicle is opened
        softAssert.assertTrue(editVehicle.getTextInCreateVehicle().toLowerCase().contains("update"));
    }

    @And("user edit brand name {string} and model {string}")
    public void userEditBrandNameAndModel(String arg0, String arg1) {
        // Update brand
        editVehicle.setBrand(arg0);
        // Update model
        editVehicle.setModel(arg1);
    }

    @And("user edit plate number {string} and licence type {string}")
    public void userEditPlateNumberAndLicenceType(String arg0, String arg1) {
        // Update plate number
        editVehicle.setPlateNumber(arg0);
        // Update licence type
        editVehicle.setLicenceType(arg1);
    }

    @And("user edit driver {string} with status {string}")
    public void userEditDriverWithStatus(String arg0, String arg1) {
        // Update driver
        editVehicle.setDriver(arg0);
        // Update status
        editVehicle.setStatus(arg1);
    }

    @And("user confirm editing")
    public void userConfirmEditing() {
        // Confirm editing
        editVehicle.clickOnCreateButton();
    }

    @Then("vehicle is edited successfully")
    public void vehicleIsEditedSuccessfully() {
        // Ensure all assertions are done
        softAssert.assertAll();
    }
}
