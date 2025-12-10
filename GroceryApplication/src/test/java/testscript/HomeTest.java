package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.LoginPage;
import pages.HomePage;
import utilities.ExcelUtility;

public class HomeTest extends Base {
	HomePage hp;

    @Test(description="user is able to logout successfully")
    public void verifyUserisAbletoLogoutSuccessfully() throws IOException {
        String userValue = ExcelUtility.readStringData(0, 0, "loginpage");
        String passwordValue = ExcelUtility.readStringData(0, 1, "loginpage");

        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(userValue).enterPassword(passwordValue);
        hp=lp.clickOnLoginButton();
        hp.clickOnAdminDropdown();
        lp=hp.clickOnLogoutButton();
        Boolean pagetitledisplayed = hp.pageTitleIsDisplayed();
        Assert.assertTrue(pagetitledisplayed, Constant.VALIDSUCESSFULLY);

    }
}

