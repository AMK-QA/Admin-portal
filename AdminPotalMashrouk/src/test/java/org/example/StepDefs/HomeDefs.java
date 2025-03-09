package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomeDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    CreateRider createRider;
    ListOfRider listOfRider;
    CreateDriver createDriver;
    ListOfDriver listOfDriver;
    ListOfTrips listOfTrips;
    BookTrip bookTrips;
    ScheduleTrips scheduleTrips;
    CreateVehicle createVehicle;
    ListOfVehicle listOfVehicle;
    DriversSettings driversSettings;
    RidersSettings ridersSettings;
    TripsSettings tripsSettings;
    SoftAssert softAssert = new SoftAssert();

    @Given("user logs in with valid credentials")
    public void userLogsInWithValidCredentials(){
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));

    }

    @When("user selects rider from the left menu")
    public void userSelectsRiderFromTheLeftMenu() {
        //open left side menu and select rider
        homePage.openRider();
    }

    @And("user selects create rider")
    public void userSelectsCreateRider() {
       createRider = homePage.selectCreateRider();
       softAssert.assertTrue(createRider.getTextInCreateRider().toLowerCase().contains("rider create"));
    }

    @Then("user can open the rider creation page")
    public void userCanOpenTheRiderCreationPage() {
        System.out.println("success");
        softAssert.assertAll();
    }

    @When("user selects driver from the left menu")
    public void userSelectsDriverFromTheLeftMenu() {
        homePage.openDriver();
    }

    @And("user selects create driver")
    public void userSelectsCreateDriver( ) {
        createDriver = homePage.selectCreateDriver();
    }

    @And("user selects list of driver")
    public void userSelectsListOfDriver() {
        listOfDriver = homePage.selectListOfDriver();
    }

    @When("user selects trips from the left menu")
    public void userSelectsTripsFromTheLeftMenu() {
        homePage.openTrips();
    }

    @And("user selects list of trip")
    public void userSelectsListOfTrip() {
       listOfTrips = homePage.selectListOfTrips();
    }

    @And("user selects list rider")
    public void userSelectsListRider() {
        // Select list of riders
        listOfRider = homePage.selectListOfRider();
    }

    @Then("user can open list of rider page")
    public void userCanOpenListOfRiderPage() {
        // Assert list of rider page open successfully
        softAssert.assertTrue(listOfRider.getTextInListOfRider().toLowerCase().contains("riders"));
        // To ensure all assertion is done
        softAssert.assertAll();
    }

    @And("user selects book trip")
    public void userSelectsBookTrip() {
        // When selecting book trips, create book trips object
        bookTrips = homePage.selectBookTrips();
    }

    @And("user selects schedule trip")
    public void userSelectsScheduleTrip() {
        // When selecting schedule trips, create schedule trips object
        scheduleTrips = homePage.selectScheduleTrips();
    }

    @Then("user can open the driver creation page")
    public void userCanOpenTheDriverCreationPage() {
        softAssert.assertTrue(createDriver.getTextInCreateDriver().toLowerCase().contains("create driver"));
    }

    @Then("user can open the list Of driver page")
    public void userCanOpenTheListOfDriverPage() {
        softAssert.assertTrue(listOfDriver.getTextInListOfDriver().toLowerCase().contains("drivers"));
        softAssert.assertAll();
    }

    @Then("user can open the book trip page")
    public void userCanOpenTheBookTripPage() {
        softAssert.assertTrue(bookTrips.getTextBookTrip().toLowerCase().contains("book trip"));
        softAssert.assertAll();
    }

    @Then("user can open the list of trips page")
    public void userCanOpenTheListOfTripsPage() {
        softAssert.assertTrue(listOfTrips.getText().toLowerCase().contains("trips"));
        softAssert.assertAll();
    }

    @Then("user can open the schedule trips page")
    public void userCanOpenTheScheduleTripsPage() {
        softAssert.assertTrue(scheduleTrips.getTextScheduleTrip().toLowerCase().contains("trip schedule"));
        softAssert.assertAll();
    }


    @When("user selects vehicle from the left menu")
    public void userSelectsVehicleFromTheLeftMenu() {
        // Open vehicle options
        homePage.openVehicle();
    }

    @And("user selects list of vehicle")
    public void userSelectsListOfVehicle() {
        // Create list of vehicle object
        listOfVehicle = homePage.selectListOfVehicle();
    }

    @Then("user can open the list of vehicle page")
    public void userCanOpenTheListOfVehiclePage() {
        // Assert list of vehicle successfully opened
        softAssert.assertTrue(listOfVehicle.getTextInListOfVehicleDriver().toLowerCase().contains("vehicles"));
        softAssert.assertAll();
    }

    @And("user selects create vehicle")
    public void userSelectsCreateVehicle() {
        // Create createVehicle page
        createVehicle = homePage.selectCreateVehicle();
    }

    @Then("user can open the create vehicle page")
    public void userCanOpenTheCreateVehiclePage() {
        // Assert create vehicle page opened successfully
        softAssert.assertTrue(createVehicle.getTextInCreateVehicle().toLowerCase().contains("create vehicle"));
        softAssert.assertAll();
    }

    @When("user selects configurations from the left menu")
    public void userSelectsConfigurationsFromTheLeftMenu() {
        // Open configurations
        homePage.openConfigurations();
    }

    @And("user selects drivers setting")
    public void userSelectsDriversSetting() {
        // Create drivers settings object
        driversSettings = homePage.selectDriversSettings();
    }

    @Then("user can open the drivers settings page")
    public void userCanOpenTheDriversSettingsPage() {
        // Assert drivers settings is successfully opened
        softAssert.assertTrue(driversSettings.getTextInDriversSettings().toLowerCase().contains("drivers settings"));
        softAssert.assertAll();
    }

    @And("user selects riders setting")
    public void userSelectsRidersSetting() {
        // Create riders settings object
        ridersSettings = homePage.selectRidersSettings();
    }

    @Then("user can open the riders settings page")
    public void userCanOpenTheRidersSettingsPage() {
        // Assert riders settings is opened successfully
        softAssert.assertTrue(ridersSettings.getTextInRidersSettings().toLowerCase().contains("riders settings"));
        softAssert.assertAll();
    }

    @And("user selects trips setting")
    public void userSelectsTripsSetting() {
        // Create trips settings object
        tripsSettings = homePage.selectTripsSettings();
    }

    @Then("user can open the trips settings page")
    public void userCanOpenTheTripsSettingsPage() {
        // Assert trips settings is opened successfully
        softAssert.assertTrue(tripsSettings.getTextInTripsSettings().toLowerCase().contains("trips settings"));
        softAssert.assertAll();
    }
}
