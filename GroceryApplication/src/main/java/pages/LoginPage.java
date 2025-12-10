package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    WaitUtility wait=new WaitUtility();
    @FindBy(name = "username") 
    WebElement user;

    @FindBy(name = "password") 
    WebElement password;

    @FindBy(className = "btn-dark")
    WebElement login;
    @FindBy(xpath="//p[text()='Dashboard']") 
    WebElement dashboard;
    @FindBy(xpath="//b[text()='7rmart supermarket']") 
    WebElement title;
    public LoginPage enterUsername(String userValue) {
        user.sendKeys(userValue);
        return this;
    }

    public LoginPage enterPassword(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    public HomePage clickOnLoginButton() {
    	wait.waitUntilElementToBeClickable(driver,login);
        login.click();
        return new HomePage(driver);
    }
    public boolean dashboarddisplayedTilePresent() {
        return dashboard.isDisplayed();
    }
    public String titleGet() {
    	return title.getText();
    }
}



