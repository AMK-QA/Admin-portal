package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class ListOfDriversDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    ListOfDriver listOfDriver;
    CreateDriver createDriver;
    SoftAssert softAssert = new SoftAssert();

    @Given("user logs in with valid credentials to get list of driver")
    public void userLogsInWithValidCredentialsToGetListOfDriver(){
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("user selects driver from the left menu and list of driver to get driver")
    public void userSelectsDriverFromTheLeftMenuAndListOfDriverToGetDriver() {
        // Open rider menu
        homePage.openDriver();
        // Create list of rider page
        listOfDriver = homePage.selectListOfDriver();
    }

    @And("get list of driver email")
    public void getListOfDriverEmail() {
        // Format of email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        // Pattern to check format email
        Pattern pattern = Pattern.compile(emailRegex);
        for (int i =0; i<listOfDriver.driverEmail().size(); i++ ) {
            // Get all email in list of rider to check is it matches with valid format or not
            softAssert.assertTrue(pattern.matcher(listOfDriver.driverEmail().get(i).getText()).matches());
            System.out.println(listOfDriver.driverEmail().get(i).getText());
        }
    }

    @Then("email should be in right format at list of driver")
    public void emailShouldBeInRightFormatAtListOfDriver() {
        // To ensure all assertion is done
        softAssert.assertAll();
    }


    @And("Select create driver")
    public void selectCreateDriver() {
        // Create rider page
        createDriver = listOfDriver.clickOnCreateNewButton();
        // Assert create page is successfully opened
        softAssert.assertTrue(createDriver.getTextInCreateDriver().toLowerCase().contains("create rider"));
    }

    @Then("driver profile should be opened")
    public void driverProfileShouldBeOpened() {
        System.out.println("opened");
    }

    @And("Select view driver email number {int}")
    public void selectViewDriverEmailNumber(int arg0) {
        // Click on view icon at list of driver page
        listOfDriver.clickOnViewButton(arg0);
    }

    @Then("driver should be his profile")
    public void driverShouldBeHisProfile() {
        System.out.println("profile");
    }

    @And("user select search box and enter value {string} in search box at list of driver")
    public void userSelectSearchBoxAndEnterValueInSearchBoxAtListOfDriver(String arg0) {
        // Open search box to enter value
        listOfDriver.openSearchBox();
        // Filter rider list
        listOfDriver.searchInListOfDrivers(arg0);
        for (int i=0; i<listOfDriver.driverName().size(); i++){
            // Assert all result include filtered name only
            softAssert.assertTrue(listOfDriver.driverName().get(i).getText().contains(arg0));
        }
    }

    @Then("The filtered drivers list should be displayed")
    public void theFilteredDriversListShouldBeDisplayed() {
        // Ensure all assertions are done
        softAssert.assertAll();
    }

    @And("user filtered with start date {string} to end date {string} to driver number {int} at list of driver page")
    public void userFilteredWithStartDateToEndDateAtListOfDriverPage(String arg0, String arg1, int arg2) {
        // Select start date and end date
        listOfDriver.clickOnFiltersButton(arg0,arg1);
        // Define the date format of filter date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        // Define the date format of created and updated
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Get created date from UI
        String createdDateText = listOfDriver.returnCreatedDate(arg2);
        // Substring from 1 to 10 to neglect time
        String createdDateOnly = createdDateText.substring(0, 10);
        LocalDate createdDate = LocalDate.parse(createdDateOnly, formatter2);
        // Get update date from UI
        String updatedDateText = listOfDriver.returnUpdatedDate(arg2);
        // Substring from 1 to 10 to neglect time
        String updatedDateOnly = updatedDateText.substring(0, 10);
        LocalDate updatedDate = LocalDate.parse(updatedDateOnly, formatter2);
        // Define filtered start and end dates (You can fetch these dynamically if needed)
        LocalDate startDate = LocalDate.parse(arg0, formatter);
        LocalDate endDate = LocalDate.parse(arg1, formatter);
        // Check if createdDate is between startDate and endDate
        Assert.assertTrue(
                (createdDate.isEqual(startDate) || createdDate.isAfter(startDate)) &&
                        (createdDate.isEqual(endDate) || createdDate.isBefore(endDate)),
                "Created date is not within the filtered range"
        );
        // Check if UpdatedDate is between startDate and endDate
        Assert.assertTrue(
                (updatedDate.isEqual(startDate) || updatedDate.isAfter(startDate)) &&
                        (updatedDate.isEqual(endDate) || updatedDate.isBefore(endDate)),
                "Updated date is not within the filtered range!"
        );
    }


}
