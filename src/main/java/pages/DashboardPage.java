package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends SideNavigationPanel {
    WebDriver dashDriver;

    //Constructor
    public DashboardPage(WebDriver driver){
        super(driver);
        dashDriver = driver;
    }

    //Locators
    By dashboardPageTitleLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    By assignLeave = By.xpath("//button[@title = 'Assign Leave']");
    By applyLeave = By.xpath("//button[@title = 'Apply Leave']");
    By timeSheets = By.xpath("//button[@title = 'Timesheets']");
    By leaveList = By.xpath("//button[@title = 'Leave List']");
    By myLeave = By.xpath("//button[@title = 'My Leave']");
    By myTimesheet = By.xpath("//button[@title = 'My Timesheet']");
    By stopWatch = By.xpath("//i[@class='oxd-icon bi-stopwatch']");

    public void click_assignLeave(){
        dashDriver.findElement(assignLeave).click();

    }
    public void click_applyLeave(){
        dashDriver.findElement(applyLeave).click();
    }
    public void click_Timesheets(){
        dashDriver.findElement(timeSheets).click();
    }
    public void click_LeaveList(){
        dashDriver.findElement(leaveList).click();

    }
    public void click_MyLeave(){
        dashDriver.findElement(myLeave).click();

    }
    public void click_MyTimesheets(){
        dashDriver.findElement(myTimesheet).click();
    }
    public void click_Stopwatch(){
        dashDriver.findElement(stopWatch).click();
    }


    public LeavePage navigateToLeavePage(){
       return new LeavePage(dashDriver);
    }

    public String getPageTitle(){
        return dashDriver.findElement(dashboardPageLocator).getText();
    }

}
