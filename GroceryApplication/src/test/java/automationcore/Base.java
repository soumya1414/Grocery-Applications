package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ScreenshotUtility;

public class Base {

    Properties pro;
    FileInputStream fis;
    public WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters("browsers")
    public void intializeBrowse(String browsers) throws IOException {

        // Load config file
        pro = new Properties();
        fis = new FileInputStream(Constant.CONFIGFILE);
        pro.load(fis);

        if(browsers.equalsIgnoreCase("chrome")) {
            driver=new ChromeDriver();
          }
          else if(browsers.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
          }
          else if(browsers.equalsIgnoreCase("edge")){
            WebDriverManager.edgedriver();
            driver=new EdgeDriver();
          }
        
        driver.get(pro.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
      }
     
    @AfterMethod(alwaysRun = true)
    public void driverQuit(ITestResult iTestResult) throws IOException {

        if (iTestResult.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtility screenShot = new ScreenshotUtility();
            screenShot.getScreenshot(driver, iTestResult.getName());
        }

       // if (driver != null) {
            //driver.quit();
        }
    }
//} 