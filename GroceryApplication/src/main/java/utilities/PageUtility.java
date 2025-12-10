package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
    public void selectDragDropWithValue(WebElement element, String value) {
        Select object = new Select(element);
        object.selectByValue(value);
    }

    public void selectDropDownWithText(WebElement element, String text) {
        Select object = new Select(element);
        object.selectByVisibleText(text);
    }

    public void selectDropDownWithIndex(WebElement element, int index) {
        Select object = new Select(element);
        object.selectByIndex(index);
    }

    public String getElementText(WebElement element) {
        return element.getText();
    }
    
    public boolean isElementDisplayed(WebElement element) {
        return element.isDisplayed();
    }
}


//create object objectname.methid name then call
//call 5 
//in automation course we cancraete one and one methid amd perofm actions apply 