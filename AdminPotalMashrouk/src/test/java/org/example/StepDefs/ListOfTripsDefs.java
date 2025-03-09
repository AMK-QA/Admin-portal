package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.regex.Pattern;

public class ListOfTripsDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    ListOfTrips listOfTrips;
    BookTrip bookTrips;
    SoftAssert softAssert = new SoftAssert();

    @Given("user logs in with valid credentials to get list of trips")
    public void userLogsInWithValidCredentialsToGetListOfTrips(){
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("user selects rider from the left menu and list of trips to get trips")
    public void userSelectsRiderFromTheLeftMenuAndListOfTripsToGetTrips() {
        // Open trip menu
        homePage.openTrips();
        // Create list of trip page
        listOfTrips = homePage.selectListOfTrips();
    }

    @And("get list of rider email and driver email")
    public void getListOfRiderEmailAndDriverEmail() {
        // Format of email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        // Pattern to check format email
        Pattern pattern = Pattern.compile(emailRegex);
        for (int i =0; i<listOfTrips.riderEmail.size(); i++ ) {
            // Get all email in list of rider to check is it matches with valid format or not
            softAssert.assertTrue(pattern.matcher(listOfTrips.riderEmail().get(i).getText()).matches());
            System.out.println(listOfTrips.riderEmail().get(i).getText());
        }
        for (int i =0; i<listOfTrips.driverEmail().size(); i++ ) {
            // Get all email in list of rider to check is it matches with valid format or not
            softAssert.assertTrue(pattern.matcher(listOfTrips.driverEmail().get(i).getText()).matches());
            System.out.println(listOfTrips.driverEmail().get(i).getText());
        }
    }

    @Then("email of rider and driver should be in right format")
    public void emailOfRiderAndDriverShouldBeInRightFormat() {
        // To ensure all assertion is done
        softAssert.assertAll();
    }

    @And("Select trips delete email number {int} and click on delete button")
    public void selectTripsDeleteEmailNumberAndClickOnDeleteButton(int arg0) {
        // Delete email
        listOfTrips.clickOnDeleteIcon(arg0);
    }

    @And("Click on {string} to confirm deleting to delete trip")
    public void clickOnToConfirmDeletingToDeleteTrip(String arg0) {
        // Confirm delete
        listOfTrips.confirmDeleteRider(arg0);
    }

    @Then("trip should be deleted")
    public void tripShouldBeDeleted() {
        System.out.println("email is deleted");
    }

    @And("Select book trip")
    public void selectBookTrip() {
        // Select book trip
        bookTrips = listOfTrips.clickOnCreateNewButton();
    }

    @Then("trip should be booked")
    public void tripShouldBeBooked() {
        // Trip should be booked
        System.out.println("trip booked");
    }

    @And("Select view trip email number {int}")
    public void selectViewTripEmailNumber(int arg0) {
        // Click on eye icon
        listOfTrips.clickOnViewButton(arg0);
    }

    @Then("profile should be appear")
    public void profileShouldBeAppear() {
        System.out.println("trip appear");
    }

    @And("user select search box and enter value {string} at trips search box")
    public void userSelectSearchBoxAndEnterValueAtTripsSearchBox(String arg0) {
        // Open search box
        listOfTrips.openSearchBox();
        // Set value at search box
        listOfTrips.searchInListOfRiders(arg0);
    }

    @Then("The filtered trips list should be displayed")
    public void theFilteredTripsListShouldBeDisplayed() {
        System.out.println("Filtered");
    }

    @And("user filtered with start date {string} to end date {string} at list of trips")
    public void userFilteredWithStartDateToEndDateAtListOfTrips(String arg0, String arg1) {
        // Filtered by date
        listOfTrips.clickOnFiltersButton(arg0,arg1);
    }

    @And("user confirm filter by click on {string} button at list of trips")
    public void userConfirmFilterByClickOnButtonAtListOfTrips(String arg0) {
        // Apply changes
        listOfTrips.clickOnFilterButtons(arg0);
    }
}
