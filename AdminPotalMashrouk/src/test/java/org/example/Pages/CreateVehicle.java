package org.example.Pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class CreateVehicle {
    public CreateVehicle(){
        PageFactory.initElements(Hooks.driver,this);
    }
    /***************************************** Locators *************************************************/

    // Text in create vehicle
    @FindBy(className = "clumber_title__JvOZd")
    public WebElement textInCreateVehicle;
    // Inputs field
    @FindBy(className = "ant-input-outlined")
            public List<WebElement> inputs;
    // Status
    @FindBy(className = "ant-select-selection-wrap")
            public WebElement status;
    // Options of status
    @FindBy(className = "ant-select-item-option-content")
            public List<WebElement> options;
    //create button
    @FindBy(className = "style_submitBtn__dcyIJ")
            public WebElement confirmButton;

    /**************************************** Methods ***************************************************/

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    Actions actions = new Actions(Hooks.driver);

    public String getTextInCreateVehicle(){
        // Return text in create vehicle page
        return wait.until(ExpectedConditions.visibilityOf(textInCreateVehicle)).getText();
    }
    public void setBrand(String brand){
        // Set car brand
        inputs.get(1).sendKeys(brand);
    }
    public void setModel(String model){
        // Set model of car
        inputs.get(2).sendKeys(model);
    }
    public void setPlateNumber(String plateNumber){
        // Set  plate number
        inputs.get(3).sendKeys(plateNumber);
    }
    public void setLicenceType(String licenceType){
        // Set licence type
        inputs.get(4).sendKeys(licenceType);
    }
    public void setDriver(String driver){
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
