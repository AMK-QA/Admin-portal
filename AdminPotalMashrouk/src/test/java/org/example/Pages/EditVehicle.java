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

public class EditVehicle {
    public EditVehicle(){
        PageFactory.initElements(Hooks.driver,this);
    }

    /***************************************** Locators *************************************************/

    // Text in edit vehicle
    @FindBy(className = "clumber_title__JvOZd")
    public WebElement textInEditVehicle;
    // Inputs field
    @FindBy(className = "ant-input-outlined")
    public List<WebElement> inputs;
    // Status
    @FindBy(className = "ant-select-selection-wrap")
    public WebElement status;
    // Options of status
    @FindBy(className = "ant-select-item-option-content")
    public List<WebElement> options;
    // Confirm button
    @FindBy(className = "style_submitBtn__dcyIJ")
    public WebElement confirmButton;

    /**************************************** Methods ***************************************************/

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    public String getTextInCreateVehicle(){
        // Return text in create vehicle page
        return wait.until(ExpectedConditions.visibilityOf(textInEditVehicle)).getText();
    }
    public void setBrand(String brand){
        // Force delete field
        inputs.get(1).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        // Set car brand
        inputs.get(1).sendKeys(brand);
    }
    public void setModel(String model){
        // Force delete field
        inputs.get(2).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        // Set model of car
        inputs.get(2).sendKeys(model);
    }
    public void setPlateNumber(String plateNumber){
        // Force delete field
        inputs.get(3).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        // Set  plate number
        inputs.get(3).sendKeys(plateNumber);
    }
    public void setLicenceType(String licenceType){
        // Force delete field
        inputs.get(4).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        // Set licence type
        inputs.get(4).sendKeys(licenceType);
    }
    public void setDriver(String driver){
        // Force delete field
        inputs.get(5).sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        // Set driver
        inputs.get(5).sendKeys(driver);
    }
    public void setStatus(String status){
        // Open status menu
        this.status.click();
        if (Objects.equals(status,"verified")){
            // Select verified options
            options.getFirst().click();
        } else if (Objects.equals(status,"pending")) {
            // select pending status
            options.get(1).click();
        }else {
            // Select rejected
            options.get(2).click();
        }
    }
    public void clickOnCreateButton(){
        confirmButton.click();
    }
}
