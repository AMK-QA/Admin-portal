package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.HomePage;
import org.example.Pages.LoginPage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LoginDefs {

    SoftAssert softAssert = new SoftAssert();
    LoginPage loginPage =new LoginPage();
    HomePage homePage;

    @Given("Open website")
    public void openWebsite(){
        //Hard assert to assert website open with valid url
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("mashrouk"));
    }

    @When("Enter Registered Email")
    public void enterRegisteredEmail() {
        //Enter registered email
        loginPage.setEmail(Hooks.properties.getProperty("UserName"));
    }

    @And("Enter password")
    public void enterPassword() {
        //Enter valid password
        loginPage.setPassword(Hooks.properties.getProperty("password"));
        //Return home page to assert home page open or not
        homePage = loginPage.clickOnSubmitButton();
    }

    @Then("user can login successfully")
    public void userCanLoginSuccessfully() {
        softAssert.assertTrue(homePage.getTextAtHomePage().toLowerCase().contains("dashboard"));
        softAssert.assertAll();
    }
}
