package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class NavigationBarTestCases extends DriverSetup{
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeClass
    public void login(){
        driver.manage().deleteAllCookies();
        driver.get(System.getProperty("production.loginPage"));
        loginPage = new LoginPage(driver);
        loginPage.loginWait(5);
        loginPage.login(loginData.get("validCredentials").getAsJsonObject());
    }
    @BeforeMethod
    public void navigatesToRecruitmentPage_clickAddButton(){
        dashboardPage = loginPage.navigateToDashboard();
    }

    @Test (testName = "Verify that when click on the Admin Page the browser navigates to the correct page")
    public void validateThatWhenEnterOnAdminNavigatesToCorrectPage(){
        AdminPage adminPage = dashboardPage.enterToAdminPage();
        Assert.assertEquals(adminPage.getPageTitle(),"Admin","navigates to wrong page");
    }

    @Test (testName = "Verify that when click on the PIM Page the browser navigates to the correct page")
    public void validateThatWhenEnterOnPIMNavigatesToCorrectPage(){
        PIMPage pimPage = dashboardPage.enterToPIMPage();
        Assert.assertEquals(pimPage.getPageTitle(),"PIM","navigates to wrong page");
    }

    @Test (testName = "Verify that when click on the Recruitment Page the browser navigates to the correct page")
    public void validateThatWhenEnterOnRecruitmentNavigatesToCorrectPage(){
        RecruitmentPage recruitmentPage = dashboardPage.enterToRecruitmentPage();
        Assert.assertEquals(recruitmentPage.getPageTitle(),"Recruitment","navigates to wrong page");
    }

    @Test (testName = "Verify that when click on the Dashboard Page the browser navigates to the correct page")
    public void validateThatWhenEnterOnDashboardNavigatesToCorrectPage(){
        dashboardPage.enterToDashboardPage();
        Assert.assertEquals(dashboardPage.getPageTitle(),"Dashboard","navigates to wrong page");
    }

    @Test (testName = "Verify that when click on the Leave Page the browser navigates to the correct page")
    public void validateThatWhenEnterOnLeaveNavigatesToCorrectPage(){
        LeavePage leavePage = dashboardPage.enterToLeavePage();
        Assert.assertEquals(leavePage.getPageTitle(),"Leave","navigates to wrong page");
    }

    @Test (testName = "Verify that when click on the MyInfo Page the browser navigates to the correct page")
    public void validateThatWhenEnterOnMyInfoNavigatesToCorrectPage(){
        MyInfoPage myInfoPage = dashboardPage.enterToMyInfoPage();
        Assert.assertEquals(myInfoPage.getPageTitle(),"MyInfo","navigates to wrong page");
    }

}
