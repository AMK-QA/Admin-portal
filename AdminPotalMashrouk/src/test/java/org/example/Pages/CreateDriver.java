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
    // Set birthday field
    @FindBy(className = "ant-picker-input")
    public List<WebElement> date;
    // Create button locator
    @FindBy(className = "style_submitBtn__LVfF5")
    public WebElement createButton;
    // Pop up at left side
    @FindBy(className = "sidebar_floating_input__sRFBY")
            public WebElement leftPop;
    // Success message
    @FindBy(className = "Toastify__toast--close-on-click")
            public WebElement successMessage;



    /**************************************** Methods ***************************************************/

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    Actions actions = new Actions(Hooks.driver);

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
        // Set licence expiration date
        actions.click(date.get(1)).sendKeys(licenceExpirationDate).sendKeys(Keys.ENTER).perform();

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
        int size = dropDownMenu.size();
        // Click on gender field
        openThreeDropDownMenu.get(3).click();
        if(Objects.equals(gender, "female")){
            // Select female from list included gender
            dropDownMenu.getLast().click();
        }
        else if (Objects.equals(gender, "male")) {
            // Select male from list included gender
            dropDownMenu.get(size).click();
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
        // Get size of menu before clicking on nationality menu
        int size = dropDownMenu.size();
        wait.until(ExpectedConditions.invisibilityOf(leftPop));
        // Click on nationality
        openThreeDropDownMenu.get(1).click();
        /* Select nationality from drop down menu,
            get index from 4 to end of element at dynamic drop down menu
            because status and gender are opened first */
        dropDownMenu.get(size+4).click();
    }
    public void setBirthdayField(String birthday){
      // Set birthday field
        actions.click(date.getFirst()).sendKeys(birthday).sendKeys(Keys.ENTER).perform();
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
