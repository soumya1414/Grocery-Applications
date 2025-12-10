package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

    HomePage home;

    @Test(priority = 1, description = "User is able to login with valid credentials", groups = {"smoke"})
    public void validUserLoginWithValidCredentials() throws IOException {
        String username = ExcelUtility.readStringData(0, 0, "loginpage");
        String password = ExcelUtility.readStringData(0, 1, "loginpage");

        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(username).enterPassword(password);

        home=lp.clickOnLoginButton();
        boolean isDashboardDisplayed = lp.dashboarddisplayedTilePresent();

        Assert.assertTrue(isDashboardDisplayed, Constant.VALIDCREDNETIAL);
    }

    @Test(priority = 2, description = "Invalid username and valid password", retryAnalyzer = retry.Retry.class)
    public void invalidUserNameAndValidPassword() throws IOException {
        String username = ExcelUtility.readStringData(1, 0, "loginpage");
        String password = ExcelUtility.readStringData(1, 1, "loginpage");

        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(username)
          .enterPassword(password).clickOnLoginButton();

        String expectedTitle = "7rmart supermarket";
        String actualTitle = lp.titleGet();

        Assert.assertEquals(actualTitle, expectedTitle, Constant.INVALIDCREDNETIAL1);
    }

    @Test(priority = 3, description = "Valid username and invalid password")
    public void validUserNameAndInvalidPassword() throws IOException {
        String username = ExcelUtility.readStringData(2, 0, "loginpage");
        String password = ExcelUtility.readStringData(2, 1, "loginpage");

        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(username)
          .enterPassword(password).clickOnLoginButton();

        String expectedTitle = "7rmart supermarket";
        String actualTitle = lp.titleGet();

        Assert.assertEquals(actualTitle, expectedTitle, Constant.INVALIDCREDNETIAL2);
    }

    @Test(priority = 4, description = "Invalid username and invalid password", groups = {"smoke"}, dataProvider = "loginProvider")
    public void invalidUserNameAndInvalidPassword(String username, String password) throws IOException {

        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(username)
          .enterPassword(password).clickOnLoginButton();

        String expectedTitle = "7rmart supermarket";
        String actualTitle = lp.titleGet();

        Assert.assertEquals(actualTitle, expectedTitle, Constant.INVALIDCREDNETIAL);
    }

    @DataProvider(name = "loginProvider")
    public Object[][] getDataFromDataProvider() {
        return new Object[][] {
            {"admin", "admin22"},
            {"admin123", "123"}
        };
    }
}
