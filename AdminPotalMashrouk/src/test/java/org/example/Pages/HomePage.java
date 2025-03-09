package org.example.Pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class HomePage {

    public HomePage(){
        PageFactory.initElements(Hooks.driver,this);
    }


    /***************************************** Locators *************************************************/

    // Test at home page
    @FindBy(className = "clumber_title__JvOZd")
    public WebElement textAtHomePage;
    // The menu size increases depending on number of elements that are opened
    @FindBy(css = "ul[class=\"ant-menu ant-menu-root ant-menu-inline ant-menu-light sidebar_sideBar_menu__rrdNc css-dev-only-do-not-override-u5mh6\"] li")
    public List<WebElement> listLeftMenu;

    /**************************************** Methods ***************************************************/

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    public String getTextAtHomePage(){
       return wait.until(ExpectedConditions.visibilityOf(textAtHomePage)).getText();
    }

    public void openRider() {
        // Open rider drop down menu
        listLeftMenu.get(2).click();
    }

    public ListOfRider selectListOfRider() {
        // When open rider list of rider at dynamic menu take index 3
        listLeftMenu.get(3).click();
        // Return creation of list of rider page
        return new ListOfRider();
    }
    public CreateRider selectCreateRider() {
        // When open rider, create rider at dynamic menu take index 4
        listLeftMenu.get(4).click();
        return new CreateRider();
    }
    public void openDriver() {
        // Open driver drop down menu
        listLeftMenu.get(3).click();
    }

    public ListOfDriver selectListOfDriver(){
        // When open driver list of driver at dynamic menu take index 4
        listLeftMenu.get(4).click();
        return new ListOfDriver();
    }
    public CreateDriver selectCreateDriver(){
        // When open driver, create driver at dynamic menu take index 5
        listLeftMenu.get(5).click();
        return new CreateDriver();
    }

    public void openTrips() {
        // Open trips drop down menu
        listLeftMenu.get(4).click();
    }

    public ListOfTrips selectListOfTrips(){
        // When open trips list of trip at dynamic menu take index 5
        listLeftMenu.get(5).click();
        return new ListOfTrips();
    }
    public BookTrip selectBookTrips(){
        // When open trips, book trip at dynamic menu take index 6
        listLeftMenu.get(6).click();
        return new BookTrip();
    }
    public ScheduleTrips selectScheduleTrips(){
        // When open trips, schedule trip at dynamic menu take index 7
        listLeftMenu.get(7).click();
        return new ScheduleTrips();
    }
    public void openVehicle() {
        // Open vehicle drop down menu
        listLeftMenu.get(5).click();
    }
    public ListOfVehicle selectListOfVehicle(){
        // When open vehicle, list of vehicle at dynamic menu take index 6
        listLeftMenu.get(6).click();
        return new ListOfVehicle();
    }
    public CreateVehicle selectCreateVehicle(){
        // When open vehicle, create vehicle at dynamic menu take index 7
        listLeftMenu.get(7).click();
        return new CreateVehicle();
    }
    public void openConfigurations() {
        // Open configurations drop down menu
        listLeftMenu.get(6).click();
    }
    public DriversSettings selectDriversSettings(){
        // When open configurations, drivers settings at dynamic menu take index 7
        listLeftMenu.get(7).click();
        return new DriversSettings();
    }
    public RidersSettings selectRidersSettings(){
        // When open configurations, riders settings at dynamic menu take index 8
        listLeftMenu.get(8).click();
        return new RidersSettings();
    }
    public TripsSettings selectTripsSettings(){
        // When open configurations, trips settings at dynamic menu take index 9
        listLeftMenu.get(9).click();
        return new TripsSettings();
    }

}
