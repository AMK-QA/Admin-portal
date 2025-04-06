package org.example.Pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class ListOfDriver {
    public ListOfDriver(){
        PageFactory.initElements(Hooks.driver,this);
    }

    /***************************************** Locators *************************************************/

    // text in list of driver page
    @FindBy(className = "clumber_title__JvOZd")
    public WebElement textInListOfDriver;
    // Get driver email
    @FindBy(css = "tr[class=\"ant-table-row ant-table-row-level-0\"] td:nth-child(4) div")
    public List<WebElement> driverEmail;
    // List include edit, delete & view
    @FindBy(className = "ant-space-item")
    public List<WebElement> rightIcons;
    // List of search, filter & create button
    @FindBy(css = "div[class=\"style_Search_Controls_Container__zJd28\"] button")
    public List<WebElement> buttonsList;
    // Search box locators
    @FindBy(id = "style_SearchInput__raqwh")
    public WebElement searchBox;
    // Filters date
    @FindBy(css = "input[size=\"12\"]")
    public List<WebElement> date;
    // Buttons at filter date cancel & apply, cancel with index 0 & apply with index 1
    @FindBy(css = "div[class=\"ant-modal-footer\"] button")
    public List<WebElement> filterButton;
    // List of driver name
    @FindBy(css = "div[style=\"display: flex; align-items: center; gap: 8px;\"] div")
            public List<WebElement> driverName;
    // List of all elements present in the driver
    @FindBy(css = "div[style=\"text-align: center;\"]")
            public List<WebElement> elementsInDriver;
    // Buttons at filter dates
    @FindBy(css = "div[class=\"ant-modal-footer\"] button")
            public List<WebElement> applyOrCancel;


    /**************************************** Methods ***************************************************/

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    public String getTextInListOfDriver(){
        return wait.until(ExpectedConditions.visibilityOf(textInListOfDriver)).getText();
    }
    public String returnCreatedDate(int number){
        // Equation to get created date
        int dateElement = number * 16;
        return elementsInDriver.get(dateElement).getText();
    }
    public String returnUpdatedDate(int number){
        // Equation to get updated date
        int dateElement = number * 16;
        return elementsInDriver.get(dateElement-1).getText();
    }
    public EditDriverPage clickOnEditIcon(int email) {
        // Condition to enable the Edit button based on the number of updated email
        rightIcons.get((email * 4) - 4).click();
        return new EditDriverPage();
    }

    public void clickOnViewIcon(int email){
        // Equation to select eye button
        rightIcons.get((email*4)-2).click();
    }
    public void clickOnViewButton(int email){
    //   Condition to select the View button,
        rightIcons.get((email*4)-1).click();
    }
    public List<WebElement> driverEmail(){
        // Return list of email in list of driver
        return driverEmail;
    }
    public List<WebElement> driverName(){
        // Return list of driver name
        return driverName;
    }
    public void openSearchBox() {
        // Open search box, first element in list button
        buttonsList.getFirst().click();
    }
    public void clickOnFiltersButton(String startDate, String endDate) {
        // Open filter view
        buttonsList.get(1).click();
        // Clear field
        date.get(1).clear();
        // Set start date
        date.get(1).sendKeys(startDate);
        // Press enter from keyboard
        date.get(1).sendKeys(Keys.ENTER);
        // Clear field
        date.get(2).clear();
        // Set end date
        date.get(2).sendKeys(endDate);
        // Press enter from keyboard
        date.get(2).sendKeys(Keys.ENTER);
        // Click on apply button
        applyOrCancel.get(1).click();
    }


    public CreateDriver clickOnCreateNewButton(){
        // Click on create new driver
        buttonsList.get(2).click();
        // Return create page to create new driver
        return new CreateDriver();
    }
    public void searchInListOfDrivers(String value){
        // Clear field before enter value
        searchBox.clear();
        // Enter searched value in search box
        searchBox.sendKeys(value);
        // Press enter from keyboard
        searchBox.sendKeys(Keys.ENTER);
    }
}
