package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.example.Pages.ScheduleTrips;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ScheduleTripsDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    ScheduleTrips scheduleTrips;
    SoftAssert softAssert = new SoftAssert();

    @Given("user logs in with valid credentials to book schedule trip")
    public void userLogsOnWithValidCredentialsToBookScheduleTrip(){
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded, get username and password from configuration file
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("user selects trips from the left menu to book schedule trip")
    public void userSelectsTripsFromTheLeftMenuToBookScheduleTrip() {
        // Select trips
        homePage.openTrips();
    }

    @And("user selects schedule trips from the left menu to book schedule trip")
    public void userSelectsScheduleTripsFromTheLeftMenuToBookScheduleTrip() {
        // Select scheduled trip
        scheduleTrips = homePage.selectScheduleTrips();
        // Assert schedule trips is opened successfully
        softAssert.assertTrue(scheduleTrips.getTextScheduleTrip().toLowerCase().contains("schedule"));
    }

    @And("user set time hours {int} and minutes {int} at {string}")
    public void userSetTimeHoursAndMinutesAt(int arg0, int arg1, String arg2) {
        // Select day
        scheduleTrips.selectDay();
        // Set hours
        scheduleTrips.setHours(arg0);
        // Set minutes
        scheduleTrips.setMinutes(arg1);
        // Time is Am or PM
        scheduleTrips.setTime(arg2);
    }

    @Then("user book successfully")
    public void userBookSuccessfully() {
        // To confirm all asserts are done
        softAssert.assertAll();
    }

    @And("user set end time hours {int} and minutes {int} at {string}")
    public void userSetEndTimeHoursAndMinutesAt(int arg0, int arg1, String arg2) {
        // Select hours
        scheduleTrips.setHoursAtEndTime(arg0);
        // Select minutes
        scheduleTrips.setMinutesAtEndTime(arg1);
        // Select Am or Pm
        scheduleTrips.setTimeAtEndTime(arg2);
    }

    @And("user set first name {string} and set number of passenger {string}")
    public void userSetFirstNameAndSetNumberOfPassenger(String arg0, String arg1) {
        // Set first name
        scheduleTrips.setFirstName(arg0);
        // Set number of passenger
        scheduleTrips.selectPassenger(arg1);

    }

    @And("user select {string} at request pickup point and select drop off point from map")
    public void userSelectAtRequestPickupPointAndSelectDropOffPointFromMap(String arg0) {
        // Select pickup point
        scheduleTrips.selectPickUpPoint(arg0);
        // Select location from map
        scheduleTrips.selectPickUpPointFromMap();
    }

    @And("user confirm ride")
    public void userConfirmRide() {
        // Confirm ride
        scheduleTrips.confirmRide();
    }
}
