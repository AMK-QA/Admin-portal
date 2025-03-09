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

public class ListOfTrips {
    public ListOfTrips(){
        PageFactory.initElements(Hooks.driver,this);
    }

    /***************************************** Locators **************************************************/
    // Text at list of trips page
    @FindBy(className = "clumber_title__JvOZd")
    public WebElement textInTrips;

    // Get rider email
    @FindBy(css = "tr[class=\"ant-table-row ant-table-row-level-0\"] td:nth-child(2) div")
    public List<WebElement> riderEmail;
    // Get driver email
    @FindBy(css = "tr[class=\"ant-table-row ant-table-row-level-0\"] td:nth-child(3) div")
    public List<WebElement> driverEmail;
    // List include edit, delete & view
    @FindBy(className = "ant-space-item")
    public List<WebElement> rightIcons;
    // Pop appear to confirm delete
    @FindBy(className = "ant-popconfirm-title")
    public WebElement popUp;
    // Yes or No at alert to confirm deleting
    @FindBy(css = "div[class=\"ant-popconfirm-buttons\"] button")
    public List<WebElement> yesOrNo;
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

    /***************************************** Methods ***************************************************/

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    public String getText(){
        // Get text at list of trips page
        return wait.until(ExpectedConditions.visibilityOf(textInTrips)).getText();
    }
    public void clickOnDeleteIcon(int email){
        // Equation to select Delete button
        rightIcons.get((email*4)-3).click();
    }
    public void clickOnViewButton(int email){
        // Condition to select the View button
        rightIcons.get((email*4)-2).click();
    }

    public List<WebElement> riderEmail(){
        // Return list of email in list of rider
        return riderEmail;
    }
    public List<WebElement> driverEmail(){
        // Return list of email in list of driver
        return driverEmail;
    }

    public void confirmDeleteRider(String confirm){
        // Wait until alert appear to confirm deleting
        wait.until(ExpectedConditions.visibilityOf(popUp));
        if (Objects.equals(confirm,"yes")){
            // To confirm process press yes, second element in list
            yesOrNo.get(1).click();
        }else {
            // To ignore process press no, the first element in list
            yesOrNo.getFirst().click();
        }
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
        date.get(1).sendKeys(Keys.ENTER);
        // Clear field
        date.get(2).clear();
        // Set end date
        date.get(2).sendKeys(endDate);
        date.get(2).sendKeys(Keys.ENTER);
    }

    public void clickOnFilterButtons(String status){
        if (Objects.equals(status,"apply")){
            // Click on apply filter
            filterButton.get(1).click();
        }
        else {
            // cancel filter button
            filterButton.getFirst().click();
        }
    }
    public BookTrip clickOnCreateNewButton(){
        // Click on create new rider
        buttonsList.get(2).click();
        // Return create page to create new rider
        return new BookTrip();
    }
    public void searchInListOfRiders(String value){
        // Clear field before enter value
        searchBox.clear();
        // Enter searched value in search box
        searchBox.sendKeys(value);
        // Press enter from keyboard
        searchBox.sendKeys(Keys.ENTER);
    }
}
