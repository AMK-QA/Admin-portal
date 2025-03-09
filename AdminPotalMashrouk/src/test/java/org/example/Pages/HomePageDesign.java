package org.example.Pages;

import org.example.StepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class HomePageDesign {

    public HomePageDesign(){
        PageFactory.initElements(Hooks.driver,this);
    }

    /***************************************** Locators *************************************************/

    // Logo locator
    @FindBy(className = "sidebar_logo__V+rLO")
    public WebElement logo;
    // Three dash menu
    @FindBy(className = "header_iconContainer__uH094")
    public WebElement openThreeDashMenu;
    // Send keys in search box
    @FindBy(name = "searchQuery")
    public WebElement searchBox;
    // Right side at navigation bar
    @FindBy(css = "div[class=\"header_header_dropdowns__TK9RM\"] svg:nth-child(1)")
    public WebElement colorIcon;
    // Right side menu
    @FindBy(css = "div[class=\"header_header_dropdowns__TK9RM\"] img")
    public List<WebElement> rightSide;
    // List of colors, language, notification and profile photo
    @FindBy(className = "ant-dropdown-menu-title-content")
    public List<WebElement> navigationIcon;
    // Picture locator
    @FindBy(className = "clumber_bgOverlay__VbMjR")
    public WebElement picture;
    // Left side menu
    @FindBy(className = "ant-menu-title-content")
    public List<WebElement> dynamicMenu;
    // List of clicking left side menu
    @FindBy(className = "ant-menu-submenu-title")
    public List<WebElement> clickOnLeftSideMenu;
    // Logout button locators
    @FindBy(className = "header_logout_btn_sidebar__CVMq9")
    public WebElement logoutButton;
}
