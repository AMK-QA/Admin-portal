package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class EditProfileDriverDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    ListOfDriver listOfDriver;
    EditDriverPage editDriverPage;
    SoftAssert softAssert = new SoftAssert();

    @Given("driver login with his credentials")
    public void driverLoginWithHisCredentials(){
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("driver select driver from left side menu")
    public void driverSelectDriverFromLeftSideMenu() {
        // Open rider options
        homePage.openDriver();
    }

    @And("driver open list of driver")
    public void driverOpenListOfDriver() {
        // Open list of riders page
        listOfDriver = homePage.selectListOfDriver();
    }

    @And("driver select his email number {int} and click on edit profile icon")
    public void driverSelectHisEmailNumberAndClickOnEditProfileIcon(int arg0) {
        // Open edit profile page
        editDriverPage = listOfDriver.clickOnEditIcon(arg0);
        // Assert edit profile is opened successfully
        softAssert.assertTrue(editDriverPage.getTextInEditDriver().toLowerCase().contains("update driver"));
    }

    @And("user change his first name {string} and last name {string} at edit driver page")
    public void userChangeHisFirstNameAndLastNameAtEditDriverPage(String arg0, String arg1) {
        // Set new value of first name
        editDriverPage.setFirstName(arg0);
        // Set new value of last name
        editDriverPage.setLastName(arg1);
    }

    @And("update his email and phone number at edit driver page")
    public void updateHisEmailAndPhoneNumberAtEditDriverPage() {
        // Update email
        editDriverPage.setEmail(Hooks.properties.getProperty("UserName"));
        // Update phone number
        editDriverPage.setPhoneNumber(Hooks.properties.getProperty("phoneNumber"));
    }

    @And("update gender {string} at edit driver page")
    public void updateGenderAtEditDriverPage(String arg0) {
        // Update gender
        editDriverPage.setGender(arg0);
    }

    @And("update rider status {string} and select nationality")
    public void updateRiderStatusAndSelectNationality(String arg0) {
        // Update rider status
        editDriverPage.updateDriverStatus(arg0);
        // Update nationality
        editDriverPage.setNationality();
    }

    @And("update birthday to {string} at edit driver page")
    public void updateBirthdayToAtEditDriverPage(String arg0) {
        // Update rider birthday
        editDriverPage.setBirthdayField(arg0);
    }

    @And("confirmation updated information at edit driver page")
    public void confirmationUpdatedInformationAtEditDriverPage() {
        // Confirm this updated
        editDriverPage.clickOnUpdateButton();
    }

    @Then("changes updated successfully at edit driver page")
    public void changesUpdatedSuccessfullyAtEditDriverPage() {
        System.out.println("success");
        softAssert.assertAll();
    }


    @And("upload profile photo")
    public void uploadProfilePhoto() {
        // Upload profile photo
        editDriverPage.uploadPhoto();
    }

    @And("set id number and licence details {string} and expiration date {string}")
    public void setIdNumberAndLicenceDetailsAndExpirationDate(String arg0, String arg1) {
        // Set id number
        editDriverPage.setId(Hooks.properties.getProperty("id"));
        // Set licence details
        editDriverPage.setDriverLicence(arg0,arg1);
    }
}
