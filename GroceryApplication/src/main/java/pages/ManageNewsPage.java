package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
    public WebDriver driver;

    public ManageNewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger' and @href='https://groceryapp.uniqassosiates.com/admin/news/add']")
    WebElement addNewNewsButton;

    @FindBy(xpath = "//textarea[@id='news' and @name='news']")
    WebElement newsTextArea;

    
    @FindBy(xpath = "//button[@type='submit' and @name='create' and contains(@class,'btn-danger')]")
    WebElement saveButton;

   
    @FindBy(xpath = "//a[@class='btn btn-rounded btn-primary' and contains(@onclick,'click_button(2)')]")
    WebElement searchButton1;

   
    @FindBy(xpath = "//input[@class='form-control' and @name='un' and @placeholder='Title']")
    WebElement searchTitleField;

    @FindBy(xpath = "//button[@class='btn btn-danger btn-fix' and @type='submit' and @name='Search']")
    WebElement searchButton2;

   
    @FindBy(xpath = "//a[@class='btn btn-rounded btn-warning' and contains(@href,'/admin/list-news')]")
    WebElement resetButton;

    public ManageNewsPage clickOnAddNewNews() {
        addNewNewsButton.click();
        return this;
    }

    public ManageNewsPage enterNews(String newsText) {
        newsTextArea.clear();
        newsTextArea.sendKeys(newsText);
        return this;
    }

    public ManageNewsPage clickOnSave() {
        saveButton.click();
        return this;
    }

    public ManageNewsPage clickOnSearchButton1() {
        searchButton1.click();
        return this;
    }

    public void searchNews(String newsTitle) {
        searchTitleField.clear();
        searchTitleField.sendKeys(newsTitle);
        searchButton2.click();
    }
    
    public ManageNewsPage clickOnSearchButton2() {
        searchButton2.click();
        return this;
    }

    public ManageNewsPage clickOnReset() {
        resetButton.click();
        return this;
    }
}


	