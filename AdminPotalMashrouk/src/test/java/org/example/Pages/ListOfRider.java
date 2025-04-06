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

public class ListOfRider {
    public ListOfRider(){
        PageFactory.initElements(Hooks.driver,this);
    }
    /***************************************** Locators *************************************************/

    // Text in list of rider page
    @FindBy(className = "clumber_title__JvOZd")
    public WebElement textInListOfRider;

    // Get rider email
    @FindBy(css = "tr[class=\"ant-table-row ant-table-row-level-0\"] td:nth-child(3) div")
            public List<WebElement> riderEmail;
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


    /***************************************** Methods *************************************************/

    WebDriverWait wait =  new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    public String getTextInListOfRider(){
        // Return text to assert list of rider page open
        return  wait.until(ExpectedConditions.visibilityOf(textInListOfRider)).getText();
    }
    public EditPage clickOnEditIcon(int email) {
        // Condition to enable the Edit button based on the number of updated email
        rightIcons.get((email * 4) - 4).click();
        return new EditPage();
    }

    public void clickOnViewButton(int email){
    /*   Condition to select the View button,
            button 3 is hidden and the remaining three buttons do not contain a random number */
        rightIcons.get((email*4)-1).click();
    }

    public List<WebElement> riderEmail(){
        // Return list of email in list of rider
        return riderEmail;
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
    public CreateRider clickOnCreateNewButton(){
        // Click on create new rider
        buttonsList.get(2).click();
        // Return create page to create new rider
        return new CreateRider();
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
