package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

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


    @And("Select driver delete email number {int} and click on delete button")
    public void selectDriverDeleteEmailNumberAndClickOnDeleteButton(int arg0) {
        // Select which icons need to click, and number of email
        listOfDriver.clickOnDeleteIcon(arg0);
    }

    @And("Click on {string} to confirm deleting at list of driver")
    public void clickOnToConfirmDeletingAtListOfDriver(String arg0) {
        // Select yes to confirm driver
        listOfDriver.confirmDeleteRider(arg0);
    }

    @Then("driver should be deleted")
    public void driverShouldBeDeleted() {
        System.out.println("delete");
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
    }

    @Then("The filtered drivers list should be displayed")
    public void theFilteredDriversListShouldBeDisplayed() {
        System.out.println("filtered");
    }

    @And("user filtered with start date {string} to end date {string} at list of driver page")
    public void userFilteredWithStartDateToEndDateAtListOfDriverPage(String arg0, String arg1) {
        // Select start date and end date
        listOfDriver.clickOnFiltersButton(arg0,arg1);
    }

    @And("user confirm filter by click on {string} button at list of driver page")
    public void userConfirmFilterByClickOnButtonAtListOfDriverPage(String arg0) {
        // Confirm date filter
        listOfDriver.clickOnFilterButtons(arg0);
    }
}
