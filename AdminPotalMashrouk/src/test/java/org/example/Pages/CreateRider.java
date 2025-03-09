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

public class CreateRider {

    public CreateRider(){
        PageFactory.initElements(Hooks.driver,this);
    }

    /***************************************** Locators *************************************************/
    //Text in create rider page
    @FindBy(className = "clumber_title__JvOZd")
            public WebElement textRider;
    // Form create rider
    @FindBy(className = "ant-input-lg")
            public List<WebElement> formCreation;
    // Open three drop down menu, include gender, rider state, wheelchair
    @FindBy(className = "ant-select-lg")
            public List <WebElement> openThreeDropDownMenu;
    // To select options from drop down menu that include gender, rider state, wheelchair
    @FindBy(className = "ant-select-item-option-content")
            public List<WebElement> dropDownMenu;
    // Set birthday field
    @FindBy(name = "birthday")
            public WebElement birthdayField;
    // Create button locator
    @FindBy(className = "style_submitBtn__JyZqk")
            public WebElement createButton;

    /***************************************** Methods *************************************************/

    WebDriverWait wait =  new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    public String getTextInCreateRider(){
        // Return text to assert create rider page open
        return  wait.until(ExpectedConditions.visibilityOf(textRider)).getText();
    }

    public void setFirstName(String firstName){
        // Clear field before insert value
        formCreation.getFirst().clear();
        // Send value of first name
        formCreation.getFirst().sendKeys(firstName);
    }
    public void setLastName(String lastName){
        // Clear field before insert value
        formCreation.get(1).clear();
        // Send value of last name
        formCreation.get(1).sendKeys(lastName);
    }
    public void setEmail(String email){
        // Clear field before insert value
        formCreation.get(2).clear();
        // Send value of email
        formCreation.get(2).sendKeys(email);
    }
    public void setPhoneNumber(String phoneNumber){
        // Clear field before insert value
        formCreation.get(3).clear();
        // Send value of phone number
        formCreation.get(3).sendKeys(phoneNumber);
    }
    public void setPassword(String password){
        // Clear field before insert value
        formCreation.get(4).clear();
        // Send value of password
        formCreation.get(4).sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword){
        // Clear field before insert value
        formCreation.get(5).clear();
        // Send value of confirm password
        formCreation.get(5).sendKeys(confirmPassword);
    }
    public void setGender(String gender){
        // Click on gender field
        openThreeDropDownMenu.getFirst().click();
        if(Objects.equals(gender, "female")){
            // Select female from list included gender
            dropDownMenu.get(1).click();
        }
        else if (Objects.equals(gender, "male")) {
            // Select male from list included gender
            dropDownMenu.getFirst().click();
        }
    }
    public void setRiderStatus(String riderStatus) {
        // Click on rider status field
        openThreeDropDownMenu.get(1).click();
        if (Objects.equals(riderStatus, "active")) {
            // Set active rider status
            dropDownMenu.get(2).click();
        } else if (Objects.equals(riderStatus, "inactive")) {
            // Set inactive rider status
            dropDownMenu.get(3).click();
        }
    }
    public void setWheelchair(String wheelchair) {
        // Click on wheelchair accessibility
        openThreeDropDownMenu.get(2).click();
        if (Objects.equals(wheelchair, "yes")) {
            // Set active rider status
            dropDownMenu.get(4).click();
        } else if (Objects.equals(wheelchair, "no")) {
            // Set inactive rider status
            dropDownMenu.get(5).click();
        }
    }
    public void setBirthdayField(String birthday){
        // Clear field to enter right value
        birthdayField.clear();
        // Set birthday field
        birthdayField.sendKeys(birthday);
        // Action to press enter button
        birthdayField.sendKeys(Keys.ENTER);

    }
    public void clickOnCreateButton(){
        // Click on create button
        createButton.click();
    }


}
