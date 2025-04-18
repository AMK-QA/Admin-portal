package org.example.StepDefs;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.CreateRider;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class CreateRiderDefs {
    LoginPage loginPage = new LoginPage();
    HomePage homePage;
    CreateRider createRider;
    SoftAssert softAssert = new SoftAssert();
    Faker faker = new Faker();

    @Given("user logs in with valid credentials to create rider")
    public void userLogsInWithValidCredentialsToCreateRider() {
        //hard assert to assert website open successfully or not
        Assert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded, get username and password from configuration file
        homePage = loginPage.setCredentials(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }


    @When("user selects rider from the left menu to create rider")
    public void userSelectsRiderFromTheLeftMenuToCreateRider() {
        // Open from left side menu rider to select create
        homePage.openRider();
    }

    @And("user selects create rider to create rider")
    public void userSelectsCreateRiderToCreateRider() {
        // Create new create rider page
        createRider = homePage.selectCreateRider();
        // Assert create rider is opened successfully
        softAssert.assertTrue(createRider.getTextInCreateRider().toLowerCase().contains("rider create"), "Create page is not displayed");
    }
    @And("user enter his first name {string} and last name {string}")
    public void userEnterHisFirstNameAndLastName(String arg0, String arg1) {
        // Set first name
        createRider.setFirstName(arg0);
        // Set last name
        createRider.setLastName(arg1);
    }

    @And("user enter his email")
    public void userEnterHisEmail() {
        // set email with faker date
        createRider.setEmail(faker.internet().safeEmailAddress());
    }

    @And("user set his password and confirmation password")
    public void userSetHisPasswordAndConfirmationPassword() {
        // Set rider password, get password from configuration file
        createRider.setPassword(Hooks.properties.getProperty("password"));
        // confirm password, get password from configuration file
        createRider.setConfirmPassword(Hooks.properties.getProperty("password"));
    }

    @And("user set his phone number")
    public void userSetHisPhoneNumber() {
        // Set phone number, get phone number from configuration file and random number with faker date
        createRider.setPhoneNumber(Hooks.properties.getProperty("phoneNumber")+faker.number().numberBetween(1,9)+faker.number().numberBetween(1,9));
    }

    @And("user set gender {string} type and set his status {string}")
    public void userSetGenderTypeAndSetHisStatus(String arg0, String arg1) {
        // Select gender
        createRider.setGender(arg0);
        // Select status of rider
        createRider.setRiderStatus(arg1);
    }

    @And("user set wheelchair accessibility {string} and his birthday {string}")
    public void userSetWheelchairAccessibilityAndHisBirthday(String arg0, String arg1) {
        // Select wheelchair accessibility
        createRider.setWheelchair(arg0);
        // Set birthday
        createRider.setBirthdayField(arg1);
    }
    @And("click on create button")
    public void clickOnCreateButton() {
        // Click on create button
        createRider.clickOnCreateButton();
    }
    @And("user add nationality {string} and religion {string}")
    public void userAddNationalityAndReligion(String arg0, String arg1) {
        // Set nationality
        createRider.setNationality(arg0);
        // Set religion
        createRider.setReligion(arg1);
    }
    @Then("rider created successfully")
    public void riderCreatedSuccessfully() {
        // Ensure rider is created successfully
        softAssert.assertTrue(createRider.getSuccessMessage().toLowerCase().contains("created successfully"),"rider not created");
        // To ensure all assertions is done
        softAssert.assertAll();
    }



}
