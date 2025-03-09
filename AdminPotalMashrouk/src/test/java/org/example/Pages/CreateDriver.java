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

public class CreateDriver {
    public CreateDriver(){
        PageFactory.initElements(Hooks.driver,this);
    }
    /***************************************** Locators *************************************************/

    @FindBy(className = "clumber_title__JvOZd")
    public WebElement textInCreateDriver;
    // Form create driver
    @FindBy(className = "ant-input-lg")
    public List<WebElement> formCreation;
    // Open three drop down menu, include gender, driver state, nationality
    @FindBy(className = "ant-select-single")
    public List <WebElement> openThreeDropDownMenu;
    // To select options from drop down menu that include gender, driver state, nationality
    @FindBy(className = "ant-select-item-option-content")
    public List<WebElement> dropDownMenu;
    // Expiration date of licence
    @FindBy(name = "licenseExpirationDate")
    public WebElement expirationDate;
    // Set birthday field
    @FindBy(name = "birthday")
    public WebElement birthdayField;
    // Create button locator
    @FindBy(className = "driver_submitBtn__hqE0R")
    public WebElement createButton;
    // Upload photo locator
    @FindBy(css = "input[accept=\"image/jpeg,.jpeg,.jpg,image/png,.png\"]")
            public WebElement uploadPhoto;


    /**************************************** Methods ***************************************************/

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    public String getTextInCreateDriver(){
        return wait.until(ExpectedConditions.visibilityOf(textInCreateDriver)).getText();
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
    public void setId(String id){
        // Clear field before insert value
        formCreation.get(2).clear();
        // Send value of id
        formCreation.get(2).sendKeys(id);
    }
    public void setPhoneNumber(String phoneNumber){
        // Clear field before insert value
        formCreation.get(3).clear();
        // Send value of phone number
        formCreation.get(3).sendKeys(phoneNumber);
    }
    public void setEmail(String email){
        // Clear field before insert value
        formCreation.get(4).clear();
        // Send value of email
        formCreation.get(4).sendKeys(email);
    }
    public void setDriverLicence(String driverLicence, String licenceExpirationDate){
        // Clear field before insert value
        formCreation.get(5).clear();
        // Send value of driver licence
        formCreation.get(5).sendKeys(driverLicence);
        // Clear expiration date
        expirationDate.clear();
        // Set licence expiration date
        expirationDate.sendKeys(licenceExpirationDate);
        // Press enter from keyboard
        expirationDate.sendKeys(Keys.ENTER);

    }
    public void setPassword(String password){
        // Clear field before insert value
        formCreation.get(6).clear();
        // Send value of password
        formCreation.get(6).sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword){
        // Clear field before insert value
        formCreation.get(7).clear();
        // Send value of confirm password
        formCreation.get(7).sendKeys(confirmPassword);
    }
    public void setGender(String gender){
        // Click on gender field
        openThreeDropDownMenu.get(2).click();
        if(Objects.equals(gender, "female")){
            // Select female from list included gender, get index 3 at dynamic drop down menu because status is opened first
            dropDownMenu.get(3).click();
        }
        else if (Objects.equals(gender, "male")) {
            // Select male from list included gender, get index 2
            dropDownMenu.get(2).click();
        }
    }
    public void setDriverStatus(String riderStatus) {
        // Click on driver status field
        openThreeDropDownMenu.getFirst().click();
        if (Objects.equals(riderStatus, "active")) {
            // Set active driver status
            dropDownMenu.getFirst().click();
        } else if (Objects.equals(riderStatus, "inactive")) {
            // Set inactive driver status
            dropDownMenu.get(1).click();
        }
    }
    public void setNationality() {
        // Click on nationality
        openThreeDropDownMenu.get(1).click();
        /* Select nationality from drop down menu,
            get index from 4 to end of element at dynamic drop down menu
            because status and gender are opened first */
        dropDownMenu.get(6).click();
    }
    public void setBirthdayField(String birthday){
        // Clear field to enter right value
        birthdayField.clear();
        // Set birthday field
        birthdayField.sendKeys(birthday);
        // Action to press enter button
        birthdayField.sendKeys(Keys.ENTER);
    }
    public void uploadPhoto(){
        uploadPhoto.sendKeys("C:\\Users\\Alaa\\Contacts\\Projects\\AdminPotalMashrouk\\src\\test\\java\\org\\example\\TestData\\lOGO.png");
    }
    public void clickOnCreateButton(){
        // Click on create button
        createButton.click();
    }
}
