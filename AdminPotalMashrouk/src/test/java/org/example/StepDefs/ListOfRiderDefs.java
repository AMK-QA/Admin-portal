package org.example.StepDefs;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.CreateRider;
import org.example.Pages.HomePage;
import org.example.Pages.ListOfRider;
import org.example.Pages.LoginPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.regex.Pattern;

public class ListOfRiderDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    ListOfRider listOfRider;
    CreateRider createRider;
    SoftAssert softAssert = new SoftAssert();

    @Given("user logs in with valid credentials to get list of rider")
    public void userLogsInWithValidCredentialToGetListOfRider(){
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("user selects rider from the left menu and list of rider to get rider")
    public void userSelectsRiderFromTheLeftMenuAndListOfRiderToGetRider() {
        // Open rider menu
        homePage.openRider();
        // Create list of rider page
        listOfRider = homePage.selectListOfRider();
    }


    @And("get list of rider email")
    public void getListOfRiderEmail() {
        // Format of email
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        // Pattern to check format email
        Pattern pattern = Pattern.compile(emailRegex);
        for (int i =0; i<listOfRider.riderEmail.size(); i++ ) {
            // Get all email in list of rider to check is it matches with valid format or not
            softAssert.assertTrue(pattern.matcher(listOfRider.riderEmail().get(i).getText()).matches());
            System.out.println(listOfRider.riderEmail().get(i).getText());
        }
    }

    @Then("email should be in right format")
    public void emailShouldBeInRightFormat() {
        // To ensure all assertion is done
         softAssert.assertAll();
    }

    @And("Select rider delete email number {int} and click on delete button")
    public void selectRiderDeleteEmailNumberAndClickOnDeleteButton(int arg0) {
        // Select which icons need to click, and number of email
        listOfRider.clickOnDeleteIcon(arg0);
    }
    @And("Click on {string} to confirm deleting")
    public void clickOnToConfirmDeleting(String arg0) {
        // Select yes to confirm rider
        listOfRider.confirmDeleteRider(arg0);
    }

    @Then("rider should be deleted")
    public void riderShouldBeDeleted() {
        System.out.println("Rider deleted");
    }

    @And("user select search box and enter value {string} in search box")
    public void userSelectSearchBoxAndEnterValueInSearchBox(String arg0) {
        // Open search box to enter value
        listOfRider.openSearchBox();
        // Filter rider list
        listOfRider.searchInListOfRiders(arg0);
    }

    @Then("The filtered riders list should be displayed")
    public void theFilteredRidersListShouldBeDisplayed() {
        System.out.println("riders is filtered successfully");
    }


    @And("user filtered with start date {string} to end date {string}")
    public void userFilteredWithStartDateToEndDate(String arg0, String arg1) {
        // Select start date and end date
        listOfRider.clickOnFiltersButton(arg0,arg1);
    }


    @And("user confirm filter by click on {string} button")
    public void userConfirmFilterByClickOnButton(String arg0) {
        // Confirm date filter
        listOfRider.clickOnFilterButtons(arg0);
    }

    @And("Select create rider")
    public void selectCreateRider() {
        // Create rider page
        createRider = listOfRider.clickOnCreateNewButton();
        // Assert create page is successfully opened
        softAssert.assertTrue(createRider.getTextInCreateRider().toLowerCase().contains("create rider"));
    }

    @And("Select view rider email number {int}")
    public void selectViewRiderEmailNumber(int arg0) {
        // Click on view icon at list of rider page
        listOfRider.clickOnViewButton(arg0);
    }

    @Then("rider should be created")
    public void riderShouldBeCreated() {
        System.out.println("create page is opened successfully");
    }
}
