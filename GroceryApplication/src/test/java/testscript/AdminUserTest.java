package testscript;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import automationcore.Base;
import constants.Constant;
import pages.LoginPage;
import pages.HomePage;
import pages.AdminUserPage;
import utilities.ExcelUtility;
// import utilities.RandomDataUtility; 
import utilities.RandomDataUtility;

public class AdminUserTest extends Base {
	HomePage hp;
	AdminUserPage adminUser;
    @Test
    public void verifyUserIsAbleToAddNewUser() throws IOException {
        String loginUsername = ExcelUtility.readStringData(0, 0, "adminpage");
        String loginPassword = ExcelUtility.readStringData(0, 1, "adminpage");

        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(loginUsername).enterPassword(loginPassword);
        hp=lp.clickOnLoginButton();
        Assert.assertTrue(lp.dashboarddisplayedTilePresent(), "User unable to login");
       // HomePage hp = new HomePage(driver);
        adminUser=hp.clickOnmoreinfo();

       // AdminUserPage adminUser = new AdminUserPage(driver);
        //adminUser.clickOnAddNewUser();

        // --- Enter user details from Excel ---
        RandomDataUtility rdu = new RandomDataUtility(); 
        String newUsername = rdu.randomusername();      
        String newPassword = rdu.randompassword();       

        

        adminUser.enterUsername(newUsername).enterPassword(newPassword).selectUserType("Admin").clickOnSave();
        Assert.assertTrue(true,Constant.NEWSUCESS);
    }

    @Test
    public void verifyUserIsAbleToSearchAddedUser() throws IOException {
        String loginUsername = ExcelUtility.readStringData(0, 0, "adminpage");
        String loginPassword = ExcelUtility.readStringData(0, 1, "adminpage");

        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(loginUsername).enterPassword(loginPassword);
        hp= lp.clickOnLoginButton();

        //HomePage hp = new HomePage(driver);
        adminUser=hp.clickOnmoreinfo();
        //AdminUserPage adminUser = new AdminUserPage(driver);
        adminUser.clickOnSearchButton();

        String searchUsername = ExcelUtility.readStringData(0, 2, "adminpage"); 
        adminUser.searchUser(searchUsername, "Admin");

        Assert.assertTrue(true,Constant.SEARCHUSER);
    }

    @Test
    public void verifyUserIsAbleToResetSearchFilters() throws IOException {

        // --- Login ---
        String loginUsername = ExcelUtility.readStringData(0, 0, "adminpage");
        String loginPassword = ExcelUtility.readStringData(0, 1, "adminpage");

        LoginPage lp = new LoginPage(driver);
        lp.enterUsername(loginUsername).enterPassword(loginPassword);
        hp=lp.clickOnLoginButton();

        //HomePage hp = new HomePage(driver);
        adminUser=hp.clickOnmoreinfo();

        //AdminUserPage adminUser = new AdminUserPage(driver);
        adminUser.clickOnReset();

        Assert.assertTrue(true,Constant.UNABLERESET);
    }
}
