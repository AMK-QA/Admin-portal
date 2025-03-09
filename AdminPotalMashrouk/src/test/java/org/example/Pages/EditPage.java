package org.example.Pages;
import org.example.StepDefs.Hooks;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.Objects;

public class EditPage {
    public EditPage(){
        PageFactory.initElements(Hooks.driver,this);
    }
    /***************************************** Locators *************************************************/

    // Form editing
    @FindBy(className = "ant-input-lg")
    public List<WebElement> formEdit;
    // Drop down select
    @FindBy(className = "ant-select-selector")
    public List<WebElement> dropDownSelect;
    // Choices of drop down menu
    @FindBy(className = "ant-select-item-option-content")
    public List<WebElement> choices;
    // Birthday locator
    @FindBy(name = "birthday")
    public WebElement birthday;
    // Update button
    @FindBy(className = "style_submitBtn__JyZqk")
    public WebElement updateButton;

    /***************************************** methods *************************************************/

    public void updateFirstName(String firstName){
        // Clear field
        formEdit.getFirst().sendKeys(Keys.CONTROL,"a", Keys.DELETE);
        // Enter updated name
        formEdit.getFirst().sendKeys(firstName);
    }
    public void updateLastName(String lastName){
        // Clear field
        formEdit.get(1).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        // Enter updated name
        formEdit.get(1).sendKeys(lastName);
    }
    public void updateEmail(String email){
        // Clear field
        formEdit.get(2).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        // Enter updated email
        formEdit.get(2).sendKeys(email);
    }
    public void updatePhoneNumber(String phone){
        // Clear field
        formEdit.get(3).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        // Edit phone number
        formEdit.get(3).sendKeys(phone);
    }
    public void updateGender(String gender){
        // Open gender type menu
        dropDownSelect.getFirst().click();
        if (Objects.equals(gender,"male")){
            // Select male from drop down meu
            choices.getFirst().click();
        }
        else {
            // Select female from drop down menu
            choices.get(choices.size()-1).click();
        }
    }

    public void updateRiderStatus(String status){
        // Open status menu
        dropDownSelect.get(1).click();
        if (Objects.equals(status,"active")){
            // Select active from drop down menu
            choices.get(choices.size()-2).click();
        }
        else {
            // Select inactive from drop down menu
            choices.get(choices.size()-1).click();
        }
    }
    public void updateWheelchairAccessibility(String accessibility){
        // Open wheelchair accessibility
        dropDownSelect.get(2).click();
        if (Objects.equals(accessibility,"yes")){
            // Select yes from drop down menu
            choices.get(choices.size()-2).click();
        }
        else {
            // select no from drop down menu
            choices.get(choices.size()-1).click();
        }
    }
    public void updateBirthday(String birthday){
        // Clear field before enter new value
        this.birthday.clear();
        // Set updated value
        this.birthday.sendKeys(birthday);
        // Enter key from keyboard
        this.birthday.sendKeys(Keys.ENTER);
    }
    public void clickOnUpdateButton(){
        // Submit changes
        updateButton.click();
    }

}
