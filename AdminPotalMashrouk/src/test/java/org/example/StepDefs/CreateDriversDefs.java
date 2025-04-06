package org.example.StepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.CreateDriver;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CreateDriversDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    CreateDriver createDriver;
    SoftAssert softAssert = new SoftAssert();
    Faker faker = new Faker();

    @Given("user logs in with valid credentials to create driver")
    public void userLogsInWithValidCredentialsToCreateDriver() {
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded, get username and password from configuration file
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("user selects driver from the left menu to create driver")
    public void userSelectsDriverFromTheLeftMenuToCreateDriver() {
        // To open driver at left side
        homePage.openDriver();
    }

    @And("user selects create driver to create driver")
    public void userSelectsCreateDriverToCreateDriver() {
        // Create createDriver object
        createDriver = homePage.selectCreateDriver();
    }

    @And("user enter his first name {string} and last name {string} at driver form")
    public void userEnterHisFirstNameAndLastNameAtDriverForm(String arg0, String arg1) {
        // Set first name field
        createDriver.setFirstName(arg0);
        // Set last name field
        createDriver.setLastName(arg1);
    }

    @And("user enter his Id at driver form")
    public void userEnterHisIdAtDriverForm() {
        // set id
        createDriver.setId(Hooks.properties.getProperty("id"));
    }

    @And("user set his password and confirmation password at driver form")
    public void userSetHisPasswordAndConfirmationPasswordAtDriverForm() {
        // Set rider password, get password from configuration file
        createDriver.setPassword(Hooks.properties.getProperty("password"));
        // confirm password, get password from configuration file
        createDriver.setConfirmPassword(Hooks.properties.getProperty("password"));
    }

    @And("user set his phone number at driver form")
    public void userSetHisPhoneNumberAtDriverForm() {
        // Set phone number, get phone number from configuration file
        createDriver.setPhoneNumber(Hooks.properties.getProperty("phoneNumber")+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9));
    }

    @And("user enter his email at driver form")
    public void userEnterHisEmailAtDriverForm() {
        // Get email from configuration file
        createDriver.setEmail(faker.internet().safeEmailAddress());
    }


    @And("user enter his driver licence {string} and expiration date {string}")
    public void userEnterHisDriverLicenceAndExpirationDate(String arg0, String arg1) {
        // Set driver licence details
        createDriver.setDriverLicence(arg0,arg1);
    }

    @And("user set gender {string} type and set his status {string} at driver form")
    public void userSetGenderTypeAndSetHisStatusAtDriverForm(String arg0, String arg1) {
        // Select status of rider
        createDriver.setDriverStatus(arg1);
        // Select gender
        createDriver.setGender(arg0);
    }

    @And("user set nationality and his birthday {string} at driver form")
    public void userSetNationalityAndHisBirthdayAtDriverForm(String arg0) {
        // Select nationality accessibility
        createDriver.setNationality();
        // Set birthday
        createDriver.setBirthdayField(arg0);
    }


    @And("click on create button at driver form")
    public void clickOnCreateButtonAtDriverForm() {
        // Click on create button
        createDriver.clickOnCreateButton();
    }
    @And("user select religion {string}")
    public void userSelectReligion(String arg0) {
        // Select Religion
        createDriver.setReligion(arg0);
    }

    @Then("driver created successfully")
    public void driverCreatedSuccessfully() {
        softAssert.assertTrue(createDriver.getSuccessMessage().toLowerCase().contains("created successfully"));
        // To ensure all assertions is done
        softAssert.assertAll();
    }


}
