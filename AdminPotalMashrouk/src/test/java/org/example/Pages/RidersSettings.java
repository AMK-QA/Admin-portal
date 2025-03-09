package org.example.Pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RidersSettings {

    public RidersSettings(){
        PageFactory.initElements(Hooks.driver,this);
    }
    /***************************************** Locators *************************************************/

    @FindBy(className = "clumber_title__JvOZd")
    public WebElement textInRidersSettings;

    /**************************************** Methods ***************************************************/

    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));

    public String getTextInRidersSettings(){
        // Return text at riders settings page
        return wait.until(ExpectedConditions.visibilityOf(textInRidersSettings)).getText();
    }
}
