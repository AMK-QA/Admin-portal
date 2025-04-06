package org.example.Pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(className = "ant-select-selection-item")
            public List <WebElement> openThreeDropDownMenu;
    // To select options from drop down menu that include gender, rider state, wheelchair
    @FindBy(className = "ant-select-item-option-content")
            public List<WebElement> dropDownMenu;
    // Set birthday field
    @FindBy(className = "ant-picker-input")
            public WebElement birthdayField;
    // Create button locator
    @FindBy(className = "style_submitBtn__JyZqk")
            public WebElement createButton;
    // Success message
    @FindBy(className = "Toastify__toast-body")
    public WebElement successMessage;

    /***************************************** Methods *************************************************/

    WebDriverWait wait =  new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    Actions actions = new Actions(Hooks.driver);

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
        openThreeDropDownMenu.get(3).click();
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
        openThreeDropDownMenu.get(4).click();
        if (Objects.equals(wheelchair, "yes")) {
            // Set active rider status
            dropDownMenu.get(4).click();
        } else if (Objects.equals(wheelchair, "no")) {
            // Set inactive rider status
            dropDownMenu.get(5).click();
        }
    }
    public void setNationality(String nationality){
        // Open drop down menu
        openThreeDropDownMenu.get(1).click();
        // Set nationality
        actions.click(openThreeDropDownMenu.get(1)).sendKeys(nationality).sendKeys(Keys.ENTER).perform();

    }
    public void setBirthdayField(String birthday){
        // Set birthday
        actions.click(birthdayField).sendKeys(birthday).sendKeys(Keys.ENTER).perform();
    }
    public void setReligion(String religion){
        // Get size of drop down options before clicking
        int size = dropDownMenu.size();
        // Click on menu
        openThreeDropDownMenu.get(2).click();
        if (Objects.equals(religion,"islam")){
            // Click on islam option
            dropDownMenu.get(size).click();
        } else if (Objects.equals(religion,"christianity")) {
            // Click on Christianity
            dropDownMenu.get(size+1).click();
        } else if (Objects.equals(religion.toLowerCase(),"judaism")) {
            // Click on Judaism
            dropDownMenu.get(size+2).click();
        } else if (Objects.equals(religion,"hinduism")) {
            // Click on Hinduism
            dropDownMenu.get(size+3).click();
        } else if (Objects.equals(religion,"buddhism")) {
            // Click on Buddhism
            dropDownMenu.get(size+4).click();
        } else if (Objects.equals(religion,"sikhism")) {
            // Click on Sikhism
            dropDownMenu.get(size+5).click();
        } else {
            // Click on other
            dropDownMenu.getLast().click();
        }

    }
    public void clickOnCreateButton(){
        // Click on create button
        createButton.click();
    }
    public String getSuccessMessage(){
        // Return success message
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
    }


}
