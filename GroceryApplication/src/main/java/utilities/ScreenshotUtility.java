package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class ScreenshotUtility {//a method is craeted we pass webdriver and string failed tetscase
	public void getScreenshot(WebDriver driver, String failedTestCase) throws IOException {//test case to store the failes test case resukt

		TakesScreenshot scrShot = (TakesScreenshot) driver;//its a TakesScreenshot this is called as casting bracket interface name outside driver is called casting
		java.io.File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//we store the screenshot in an file tempoaryily

		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//we get date and time with second amd we store it 

		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot");// create file in directory//craete screenshot folder //user directory to get the path we do it and create an folder output screenshot
		if (!f1.exists()) {

		f1.mkdirs();
		}
		String destination = System.getProperty("user.dir") + "//outputScreenShot//" + failedTestCase + timeStamp
		+ ".png";
		// String destination = f1.getPath() + "//" + failedTestCase + timeStamp +
		// ".png";//we give time to undestand it 

		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination);
		}

}

//interface:Take screenshot interface is used in it 
