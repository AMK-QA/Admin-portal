package org.example.Pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
public class BookTrip {

    public BookTrip(){
        PageFactory.initElements(Hooks.driver,this);
    }

    /***************************************** Locators *************************************************/
    // Text in schedule trips
    @FindBy(className = "clumber_title__JvOZd")
    public WebElement textInBookTrip;
    // First name
    @FindBy(className = "ant-input-lg")
    public WebElement firstName;
    // Select number of passenger
    @FindBy(id = "passengersCount")
    public WebElement passenger;
    // Select pick up point
    @FindBy(id = "requestPickup")
    public WebElement pickUp;
    // Pick up on map buttons
    @FindBy(className = "trips_PickupOnMapButton__3FMeh")
    public List<WebElement> pickUpOnMap;
    // Map locator
    @FindBy(css = "div[style=\"z-index: 3; position: absolute; height: 100%; width: 100%; padding: 0px; border-width: 0px; margin: 0px; left: 0px; top: 0px; touch-action: pan-x pan-y;\"]")
    public WebElement map;
    // Buttons confirm or cancel
    @FindBy(css = "div[class=\"trips_LocationSelectionButtons__oiLDD\"] button")
    public List<WebElement> buttonsConfirmOrCancel;
    // Get ride proposal or clear details button
    @FindBy(css = "div[class=\"trips_ButtonsContainer__88OkU\"] button")
    public List<WebElement> confirmRideOrCancel;

    /**************************************** Methods ***************************************************/

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    Actions actions = new Actions(Hooks.driver);
    JavascriptExecutor js = (JavascriptExecutor) Hooks.driver;

    public void setFirstName(String firstName){
        // Clear field before enter value
        this.firstName.clear();
        // Set first name value
        this.firstName.sendKeys(firstName);
    }
    public void selectPassenger(String passengerNumber){
        // Create select option
        Select passengerNumberSelect = new Select(passenger);
        // Set options bt visible text
        passengerNumberSelect.selectByVisibleText(passengerNumber);
    }
    public void selectPickUpPoint(String pickUp)
    {
        // Create select
        Select points =  new Select(this.pickUp);
        // Set by visible text
        points.selectByVisibleText(pickUp);
    }
    public void selectPickUpPointFromMap(){
        // Click on pickup on map
        pickUpOnMap.get(1).click();
        // Set location on map
        actions.moveToElement(map,70,70).click().perform();
        // Confirm location
        buttonsConfirmOrCancel.getFirst().click();
    }
    public String getTextBookTrip(){
        // Get text in schedule trips
        return wait.until(ExpectedConditions.visibilityOf(textInBookTrip)).getText();
    }
    public void confirmRide(){
        // Confirm ride
        confirmRideOrCancel.getFirst().click();
    }
    public void clearDetails(){
        // Delete ride
        confirmRideOrCancel.get(1).click();
    }
}
