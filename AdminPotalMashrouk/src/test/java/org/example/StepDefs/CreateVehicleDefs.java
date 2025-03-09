package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.CreateVehicle;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CreateVehicleDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    CreateVehicle createVehicle;
    SoftAssert softAssert = new SoftAssert();
    @Given("user logs in with valid credentials to create vehicle")
    public void userLogsInWithValidCredentialToCreateVehicle(){
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded, get username and password from configuration file
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("user selects vehicle from the left menu to create vehicle")
    public void userSelectsVehicleFromTheLeftMenuToCreateVehicle() {
        // Open vehicle
        homePage.openVehicle();
    }
    @And("user selects create vehicle at create vehicle")
    public void userSelectsCreateVehicleAtCreateVehicle() {
        // Select Create vehicle
        createVehicle = homePage.selectCreateVehicle();
        // Assert create vehicle page is opened successfully
        softAssert.assertTrue(createVehicle.getTextInCreateVehicle().toLowerCase().contains("vehicle"));
    }

    @And("user set brand name {string} and model {string}")
    public void userSetBrandNameAndModel(String arg0, String arg1) {
        // Set brand
        createVehicle.setBrand(arg0);
        // Set model
        createVehicle.setModel(arg1);
    }

    @And("user set plate number {string} and licence type {string}")
    public void userSetPlateNumberAndLicenceType(String arg0, String arg1) {
        // Set plate number
        createVehicle.setPlateNumber(arg0);
        // Set licence type
        createVehicle.setLicenceType(arg1);
    }

    @And("user set driver {string} with status {string}")
    public void userSetDriverWithStatus(String arg0, String arg1) {
        // Set driver
        createVehicle.setDriver(arg0);
        // Select status
        createVehicle.setStatus(arg1);
    }

    @And("user confirm creation")
    public void userConfirmCreation() {
        // Confirm creation
        createVehicle.clickOnCreateButton();
    }

    @Then("vehicle is created successfully")
    public void vehicleIsCreatedSuccessfully() {
        // Confirm all assertion is done
        softAssert.assertAll();
    }
}
