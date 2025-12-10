package utilities;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
    public static int EXPLICITWAIT = 5; //constant wait time

    public void waitUntilElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilAlertIsPresent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitUntilElementIsVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilURLContains(WebDriver driver, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.urlContains(text));
    }

    public void waitUntilElementIsSelected(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }
}


