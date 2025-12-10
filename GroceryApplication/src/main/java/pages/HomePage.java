package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public WebDriver driver;
    public HomePage(WebDriver driver) {//design technique PageFactory
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@data-toggle='dropdown']")
    WebElement adminDropdown;
    @FindBy(xpath = "//a[contains(@href, '/admin/logout') and @class='dropdown-item']")
    WebElement logoutButton;
    @FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")
    WebElement moreinfo;
    @FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")
    WebElement moreinfo2;
    @FindBy(xpath="//b[text()='7rmart supermarket']") WebElement pagetitle;
    
    public HomePage clickOnAdminDropdown() {
        adminDropdown.click();
        return this;//in home page
    }

    public LoginPage clickOnLogoutButton() {
        logoutButton.click();
        return new LoginPage(driver);//since it goes to next page 
    }
    public AdminUserPage clickOnmoreinfo() {
    	moreinfo.click();
    	return new AdminUserPage(driver);
    }
    public ManageNewsPage clickOnManageNews() {
    	moreinfo2.click();
    	return new ManageNewsPage(driver);
    }
    public boolean pageTitleIsDisplayed() {//for assertion donot add chaining one 
		return pagetitle.isDisplayed();
	}
}


