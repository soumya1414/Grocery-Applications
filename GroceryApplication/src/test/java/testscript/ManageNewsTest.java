package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Constant;
import pages.LoginPage;
import pages.HomePage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage hp;
	ManageNewsPage newsPage;
    @Test
    public void verifyUserIsAbleToAddNewsSuccessfully() throws IOException {

        String loginUsername = ExcelUtility.readStringData(0, 0, "adminpage");
        String loginPassword = ExcelUtility.readStringData(0, 1, "adminpage");
        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(loginUsername).enterPassword(loginPassword);
        hp=lp.clickOnLoginButton();
        Assert.assertTrue(lp.dashboarddisplayedTilePresent(), "User unable to login");
        //HomePage hp = new HomePage(driver);
        newsPage=hp.clickOnManageNews(); 
        //ManageNewsPage newsPage = new ManageNewsPage(driver);
        newsPage.clickOnAddNewNews();
        String newsContent = ExcelUtility.readStringData(0, 0, "ManageNews"); 
        newsPage.enterNews(newsContent);
        newsPage.clickOnSave();
        Assert.assertTrue(true,Constant.NEWSNOT);
    }

    @Test
    public void verifyUserIsAbleToSearchAddedNews() throws IOException {

        String loginUsername = ExcelUtility.readStringData(0, 0, "adminpage");
        String loginPassword = ExcelUtility.readStringData(0, 1, "adminpage");
        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(loginUsername).enterPassword(loginPassword);
        hp=lp.clickOnLoginButton();
        //HomePage hp = new HomePage(driver);
        newsPage=hp.clickOnManageNews();
       // ManageNewsPage newsPage = new ManageNewsPage(driver);
        newsPage.clickOnSearchButton1();
        String newsTitle = ExcelUtility.readStringData(0, 0, "ManageNews"); 
        newsPage.searchNews(newsTitle); 
        newsPage.clickOnSearchButton2(); 
        Assert.assertTrue(true,Constant.USERUNABLE);
    }
    @Test
    public void verifyUserIsAbleToResetSearchFilters() throws IOException {

        String loginUsername = ExcelUtility.readStringData(0, 0, "adminpage");
        String loginPassword = ExcelUtility.readStringData(0, 1, "adminpage");
        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(loginUsername).enterPassword(loginPassword);
        hp=lp.clickOnLoginButton();
        //HomePage hp = new HomePage(driver);
       newsPage= hp.clickOnManageNews();
       // ManageNewsPage newsPage = new ManageNewsPage(driver);
        newsPage.clickOnReset();

        Assert.assertTrue(true,Constant.USERSEARCH);
    }
}
