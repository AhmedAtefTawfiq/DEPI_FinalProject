package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PIMPage;


public class PIMTestCases extends DriverSetup{
    PIMPage pimpage;
    DashboardPage dashboardPage;

    @BeforeClass
    public void loginAndNavigateToPIM() {
        driver.manage().deleteAllCookies();
        driver.get(System.getProperty("production.loginPage"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWait(5);
        loginPage.login(loginData.get("validCredentials").getAsJsonObject());//login
        loginPage.loginWait(5);
        dashboardPage = loginPage.navigateToDashboard();
        pimpage = dashboardPage.enterToPIMPage();



    }
    @BeforeMethod
    public void navigatesToPIM_Page(){
        dashboardPage.enterToPIMPage();
    }

    @Test (testName = "verify that the added Employee is saved successfully",priority = 4)
    public void validEmployeeAddition() {
        pimpage.navigateToAddEmployeePage();
        pimpage.PIMWait(3);
        pimpage.addNewEmployee("ahmedxx","ahmeds","genina","1112");
        pimpage.PIMWait(5);
    }

    @Test (testName = "test adding employee picture",priority = 3)
    public void employeePictureAddition() {
        pimpage.navigateToEmployeeListPage();
        pimpage.PIMWait(5);
        pimpage.addEmployeePicture();
    }


    @Test (testName = "check filtering process by ID",priority = 1)
    public void checkFilterProcessByID() {
        pimpage.navigateToEmployeeListPage();
        pimpage.PIMWait(3);
        pimpage.filterByEmployeeID("0422");
        pimpage.PIMWait(3);
        WebElement Element = pimpage.EmployeeListRecordFoundTextElement() ;
        String regex = "\\(1\\) Record Found";
        Assert.assertTrue(Element.getText().matches(regex));
    }

    @Test (testName = "check filtering process by Employee Name",priority = 2)
    public void checkFilterProcessByEmployeeName() {
        pimpage.navigateToEmployeeListPage();
        pimpage.PIMWait(3000);
        pimpage.filterByEmployeeName("Charlotte");
        pimpage.PIMWait(3000);
        WebElement Element = pimpage.EmployeeListRecordFoundTextElement() ;
        String regex = ".*Records Found";
        Assert.assertTrue(Element.getText().matches(regex));    }


}
