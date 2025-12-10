package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;

public class AdminUserPage {
    public WebDriver driver;

    public AdminUserPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
PageUtility page=new PageUtility();//object for page
    // Buttons and fields for Add User
    @FindBy(xpath = "//a[contains(@class,'btn') and contains(@class,'btn-rounded') and contains(@class,'btn-danger')]")
    WebElement addNewUserButton;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "user_type")  // Dropdown for user type when adding a new user
    WebElement userTypeDropdown;

    @FindBy(xpath = "//button[@type='submit' and @name='Create' and contains(@class, 'btn-danger')]")
    WebElement saveButton;

    // Search section
    @FindBy(xpath = "//a[contains(@class,'btn') and contains(@class,'btn-round') and contains(@class,'btn-primary')]")
    WebElement searchButton1;

    @FindBy(xpath = "//input[@name='un']")
    WebElement searchUsernameField;

    @FindBy(xpath = "//select[@name='ut']")  // Dropdown for user type in search
    WebElement searchUserTypeDropdown;

    @FindBy(xpath = "//button[@name='Search' and @type='submit']")
    WebElement searchButton2;

    @FindBy(xpath = "//a[contains(@class,'btn') and contains(@class,'btn-rounded') and contains(@class,'btn-warning')]")
    WebElement resetButton;

 

    public AdminUserPage clickOnAddNewUser() {
        addNewUserButton.click();
        return this;
    }

    public AdminUserPage  enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public AdminUserPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public AdminUserPage selectUserType(String type) {
    	page.selectDropDownWithText(userTypeDropdown, type);//page utility
    	return this;
    }

    public AdminUserPage clickOnSave() {
        saveButton.click();
        return this;
    }

    public AdminUserPage clickOnSearchButton() {
        searchButton1.click();
        return this;
    }

    public void searchUser(String username, String type) {
        searchUsernameField.sendKeys(username);
        page.selectDropDownWithText(searchUserTypeDropdown, type);//page utility
        searchButton2.click();
    }

    public AdminUserPage clickOnReset() {
        resetButton.click();
        return this;
    }
}
