package org.example.Pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Hooks.driver,this);
    }

    /************************************* Locators ******************************************/

    // List include email & password
    @FindBy(css = "form[class=\"login_form__Zz6W2\"] div input")
    public List<WebElement> formLogin;
    // Sign in button locator
    @FindBy(className = "login_submitBtn__RaBW4")
    public WebElement submitSignInButton;

    /************************************* Methods *****************************************/

    public void setEmail(String email){
        //clear email field
        formLogin.getFirst().clear();
        //send email
        formLogin.getFirst().sendKeys(email);
    }

    public void setPassword(String password){
        //clear password field
        formLogin.get(1).clear();
        //send password
        formLogin.get(1).sendKeys(password);
    }

    public HomePage clickOnSubmitButton(){
        //click on login button
        submitSignInButton.click();
        //return home page to loaded locator at home page
        return new HomePage();
    }
    public HomePageDesign ClickOnSubmitToCheckDesign(){
        // Click on submit button
        submitSignInButton.click();
        // Return home page design
        return  new HomePageDesign();
    }
    //This method to login at step of any page need to test
    public HomePageDesign setCredentialsToCheckDesign(String email, String password)  {
        // Set email by calling email method
        setEmail(email);
        // Set password by calling set password method
        setPassword(password);
        // Return home page by calling click submit button method
        return ClickOnSubmitToCheckDesign();
    }

    //This method to login at step of any page need to test
    public HomePage setCredentials(String email, String password)  {
        // Set email by calling email method
        setEmail(email);
        // Set password by calling set password method
        setPassword(password);
        // Return home page by calling click submit button method
        return clickOnSubmitButton();
    }


}
