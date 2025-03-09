package org.example.StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.Pages.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import static org.example.StepDefs.Hooks.driver;

public class HomeDesignDefs {
    LoginPage loginPage = new LoginPage();
    HomePageDesign homePageDesign;
    SoftAssert softAssert = new SoftAssert();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    @Given("user logs in with valid credentials to check design")
    public void userLogsInWithValidCredentialsToCheckDesign() {
        //hard assert to assert website open successfully or not
        Assert.assertTrue(driver.getCurrentUrl().toLowerCase().contains("mashrouk"));
        //when user success to login home page uploaded
        homePageDesign = loginPage.setCredentialsToCheckDesign(Hooks.properties.getProperty("UserName"),Hooks.properties.getProperty("password"));
    }

    @When("navigation bar should displayed successfully")
    public void navigationBarShouldDisplayedSuccessfully(){
        // Wait until loading of home page
        wait.until(ExpectedConditions.visibilityOf(homePageDesign.picture));
        // Identify javascript executor to get background image because it identified inside ::before
        JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;
        String bgImage = (String) js.executeScript(
                "return window.getComputedStyle(document.querySelector('.clumber_bgOverlay__VbMjR'), '::before').getPropertyValue('background-image');"
        );
        // To Replace url word to get url without any extension
        bgImage = bgImage.replace("url(\"", "");
        // Assert picture put as expected or not
        softAssert.assertTrue(bgImage.contains("https://dev.moc.mashrouk.com/static/media/top_banner.1e4001e7fa28e8d831a0.svg"));
        // Assert picture is displayed or not
        softAssert.assertTrue(homePageDesign.picture.isDisplayed());
        // Get RGB color in navigation bar
        String rgbaValue = homePageDesign.picture.getCssValue("background-color");
        // Confirm color of navigation bar is appear with accepted color
        softAssert.assertEquals(rgbaValue.replace("rgba",""),"(0, 121, 107, 1)");
        // Change color as hex decimal
        String hexValue = Color.fromString(rgbaValue).asHex();
        // Assert color in hex
        softAssert.assertEquals(hexValue,"#00796b");
        // Confirm search box is appear
        softAssert.assertTrue(homePageDesign.searchBox.isDisplayed(),"Search box is not appear successfully");

    }
    @And("Icon at right side at navigation bar appear successfully")
    public void iconAtRightSideAtNavigationBarAppearSuccessfully() {
        // Confirm 3 dash icon is displayed
        softAssert.assertTrue(homePageDesign.openThreeDashMenu.isDisplayed(),"Left side menu is not appear");
        for (int i=0; i<homePageDesign.rightSide.size(); i++){
            // Assert that the notification, language, and profile icons are displayed successfully
            softAssert.assertTrue(homePageDesign.rightSide.get(i).isDisplayed(),"icon is not appear"+i);
        }
        // Assert color icon displayed successfully
        softAssert.assertTrue(homePageDesign.colorIcon.isDisplayed());
        // Confirmation drop down menu at navigation bar is opened successfully or not
        for (int iterator=0; iterator<=homePageDesign.rightSide.size();iterator++ ) {
            // Initialize the iterator in the while loop based on the dynamic menu size to ensure each iteration starts from the previous index
            int i=homePageDesign.navigationIcon.size();
            /*  Condition: The navigation bar does not contain a complete list of all  elements,
                    First condition: The list include language, profile, and notification icons,
                    Second condition: Specific for color icon
             */
            if (iterator < homePageDesign.rightSide.size()) {
                // First, open icons to allow the system to load the dropdown menu
                homePageDesign.rightSide.get(iterator).click();
            }   else {
                    homePageDesign.colorIcon.click();
            }
            // A small loop that iterates through all elements in the dropdown menus
            while ( i < homePageDesign.navigationIcon.size()) {
                // Wait until drop down menu appear
                wait.until(ExpectedConditions.visibilityOf(homePageDesign.navigationIcon.get(i)));
                // Assert that the options in the navigation bar icon appear successfully
                softAssert.assertTrue(homePageDesign.navigationIcon.get(i).isDisplayed());
                // Increment iterator
                i++;
            }
        }

    }

    @When("Logo appear as expected")
    public void logoAppearAsExpected() {
        // Confirm logo appear successfully ar not
        softAssert.assertTrue(homePageDesign.logo.isDisplayed());
        // Get color background in RGBA value
        String rgbValue = homePageDesign.logo.getCssValue("background");
        // Convert RGBA to hex decimal
        String hexValue = Color.fromString(rgbValue.replace("rgba","")).asHex();
        // Assert color in website appear as expected
        softAssert.assertEquals(hexValue,"#00796b");
    }
    @And("left side menu should is opened and displayed successfully")
    public void leftSideMenuShouldIsOpenedAndDisplayedSuccessfully() {
        // Array of expected element at left menu
        String[] expectedValueOfElement = {"dashboard","live map","riders","list","create",
                "drivers","list","create","trips","list","book",
                "schedule","vehicles","list","create","configurations",
                "drivers settings","riders settings","trips settings",
                "zones", "reports","service kpi dashboards","export center",
                "activity monitoring","user management","user management",
                "roles center","integrations"};
        // Start from index 0 so end iteration ar size of list -1
        for (int i=0; i<homePageDesign.clickOnLeftSideMenu.size(); i++){
            // Click on element to open elements inside this menu
            homePageDesign.clickOnLeftSideMenu.get(i).click();
        }
        // Start from index 0 so end iteration ar size of list -1
        for (int i=0; i<homePageDesign.dynamicMenu.size(); i++){
            // Confirm all element appear as expected
            softAssert.assertEquals(expectedValueOfElement[i],homePageDesign.dynamicMenu.get(i).getText().toLowerCase());
        }
    }

    @And("logout  button appear")
    public void logoutButtonAppear() {
        // Assert whether the logout button appears or not
        softAssert.assertTrue(homePageDesign.logoutButton.isDisplayed(),"Logout button not displayed");
    }

    @Then("all element should appear")
    public void allElementShouldAppear() {
        softAssert.assertAll();
    }



}
