package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.BookTrip;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BookTripDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    BookTrip bookTrip;
    SoftAssert softAssert = new SoftAssert();
    @Given("user logs in with valid credentials to book trip")
    public void userLogsInWithValidCredentialsToBookTrip(){
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded, get username and password from configuration file
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("user selects trips from the left menu to book trip")
    public void userSelectsTripsFromTheLeftMenuToBookTrip() {
        // Select trips
        homePage.openTrips();
    }

    @And("user selects schedule trips from the left menu to book trip")
    public void userSelectsScheduleTripsFromTheLeftMenuToBookTrip() {
        // Select scheduled trip
        bookTrip = homePage.selectBookTrips();
        // Assert schedule trips is opened successfully
        softAssert.assertTrue(bookTrip.getTextBookTrip().toLowerCase().contains("book trip"));

    }

    @And("user set first name {string} and set number of passenger {string} to book trip")
    public void userSetFirstNameAndSetNumberOfPassengerToBookTrip(String arg0, String arg1) {
        // Set first name
        bookTrip.setFirstName(arg0);
        // Set number of passenger
        bookTrip.selectPassenger(arg1);

    }

    @And("user select {string} at request pickup point and select drop off point from map to book trip")
    public void userSelectAtRequestPickupPointAndSelectDropOffPointFromMapToBookTrip(String arg0) {
        // Select pickup point
        bookTrip.selectPickUpPoint(arg0);
        // Select location from map
        bookTrip.selectPickUpPointFromMap();
    }

    @And("user confirm ride at book ride")
    public void userConfirmRideAtBookRide() {
        // Confirm ride
        bookTrip.confirmRide();
    }

    @Then("user book successfully to book trip")
    public void userBookSuccessfullyToBookTrip() {
        // Confirm all assertions
        softAssert.assertAll();
    }
}
