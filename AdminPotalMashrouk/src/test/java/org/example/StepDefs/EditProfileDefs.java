package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.EditPage;
import org.example.Pages.HomePage;
import org.example.Pages.ListOfRider;
import org.example.Pages.LoginPage;
import org.testng.Assert;

public class EditProfileDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    ListOfRider listOfRider;
    EditPage editPage;

    @Given("rider login with his credentials")
    public void riderLoginWithHisCredentials(){
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("rider select rider from left side menu")
    public void riderSelectRiderFromLeftSideMenu() {
        // Open rider options
        homePage.openRider();
    }

    @And("rider open list of rider")
    public void riderOpenListOfRider() {
        // Open list of riders page
        listOfRider = homePage.selectListOfRider();
    }

    @And("rider select his email number {int} and click on edit profile icon")
    public void riderSelectHisEmailNumberAndClickOnEditProfileIcon(int arg0) {
        // Open edit profile page
        editPage = listOfRider.clickOnEditIcon(arg0);
    }

    @And("user change his first name {string} and last name {string}")
    public void userChangeHisFirstNameAndLastName(String arg0, String arg1) {
        // Set new value of first name
        editPage.updateFirstName(arg0);
        // Set new value of last name
        editPage.updateLastName(arg1);
    }

    @Then("changes updated successfully")
    public void changesUpdatedSuccessfully() {
        System.out.println("success");
    }


    @And("update his email and phone number")
    public void updateHisEmailAndPhoneNumber() {
        // Update email
        editPage.updateEmail(Hooks.properties.getProperty("UserName"));
        // Update phone number
        editPage.updatePhoneNumber(Hooks.properties.getProperty("phoneNumber"));
    }

    @And("update gender {string}")
    public void updateGender(String arg0) {
        // Update gender
        editPage.updateGender(arg0);
    }

    @And("update rider status {string} and wheelchair accessibility {string}")
    public void updateRiderStatusAndWheelchairAccessibility(String arg0, String arg1) {
        // Update rider status
        editPage.updateRiderStatus(arg0);
        // Update wheelchair accessibility
        editPage.updateWheelchairAccessibility(arg1);
    }

    @And("update birthday to {string}")
    public void updateBirthdayTo(String arg0) {
        // Update rider birthday
        editPage.updateBirthday(arg0);
    }

    @And("confirmation updated information")
    public void confirmationUpdatedInformation() {
        // Confirm this updated
        editPage.clickOnUpdateButton();
    }
}
