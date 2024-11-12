package testcases;

import helpers.DataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LeavePage;
import pages.LoginPage;

public class DashboardTestCases extends DriverSetup {


    DashboardPage dashboard;
    LeavePage leavePage;

    @BeforeClass
    public void login() {
        driver.manage().deleteAllCookies();
        driver.get(System.getProperty("production.loginPage"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWait(5);
        loginPage.login(loginData.get("validCredentials").getAsJsonObject());//login
        loginPage.loginWait(5);
        Assert.assertEquals(driver.getCurrentUrl(),System.getProperty("production.dashboard"),"Don't navigates to dashboard ");
        dashboard = loginPage.navigateToDashboard(); //initiate the dashboard page
        loginPage.loginWait(5);
        leavePage = dashboard.navigateToLeavePage(); // navigates to leave page
    }



    @BeforeMethod
    public void navigateToLoginPage(){
        //navigates to dashboard page after every test
        driver.get(System.getProperty("production.dashboard"));
    }

    @Test(testName = "Verify the 'Assign Leave' icon is clickable", priority = 1)
    public void assignLeave() {
        dashboard.click_assignLeave();
        Assert.assertEquals(leavePage.getAssignLeaveTitle(), "Assign Leave", "The icon is working properly");
    }

    @Test(testName = "Verify the 'Leave List' icon is clickable", priority = 2)
    public void leaveList() {
        dashboard.click_LeaveList();
        Assert.assertEquals(leavePage.getLeaveListTitle(), "Leave List", "The icon is working properly");
    }

    @Test(testName = "Verify the 'Time Sheet' icon is clickable", priority = 3)
    public void timeSheet() {
        dashboard.click_Timesheets();
         WebElement textElement = driver.findElement(By.xpath("(//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'])[2]"));
        Assert.assertEquals(textElement.getText(), "Timesheets Pending Action", "The icon is working properly");
    }

    @Test(testName = "Verify the 'Apply Leave' icon is clickable", priority = 4)
    public void applyLeave() {
        dashboard.click_applyLeave();
        Assert.assertEquals(leavePage.getApplyLeaveTitle(), "Apply Leave", "The icon is working properly");
    }

    @Test(testName = "Verify the 'My Leave' icon is clickable", priority = 5)
    public void myLeave() {
        dashboard.click_MyLeave();
        Assert.assertEquals(leavePage.geMyLeaveListTitle(), "My Leave List", "The icon is working properly");
    }

    @Test(testName = "Verify the 'My Timesheet' icon is clickable", priority = 6)
    public void myTimeSheet() {
        dashboard.click_MyTimesheets();
        WebElement textElement = driver.findElement(By.xpath("(//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title'])"));
        Assert.assertEquals(textElement.getText(), "My Timesheet", "The icon is working properly");
    }

    @Test(testName = "Verify the 'Stopwatch' icon is clickable", priority = 7)
    public void stopWatch() {
        dashboard.click_Stopwatch();
        WebElement textElement = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']"));
        Assert.assertEquals(textElement.getText(), "Punch In", "The icon is working properly");
    }


}




