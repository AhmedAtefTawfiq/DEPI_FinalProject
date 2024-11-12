package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage extends SideNavigationPanel {

    WebDriver leaveDriver;

    public LeavePage(WebDriver driver) {
        super(driver);
        leaveDriver = driver;
    }
    By leavePageTitleLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    By assignLeaveTitleLocator = By.xpath("//h6[text()='Assign Leave']");
    By leaveListTitleLocator = By.xpath("//h5[text()='Leave List']");
    By applyLeaveTitleLocator = By.xpath("//h6[text()='Apply Leave']");
    By myLeaveListTitleLocator =By.xpath("//h5[text()='My Leave List']");
    public String getAssignLeaveTitle(){
        return leaveDriver.findElement(assignLeaveTitleLocator).getText();
    }

    public String getLeaveListTitle(){
        return leaveDriver.findElement(leaveListTitleLocator).getText();
    }

    public String getApplyLeaveTitle(){
        return leaveDriver.findElement(applyLeaveTitleLocator).getText();
    }

    public String geMyLeaveListTitle(){
        return leaveDriver.findElement(myLeaveListTitleLocator).getText();
    }
    public String getPageTitle(){
        return leaveDriver.findElement(leavePageTitleLocator).getText();
    }
}
