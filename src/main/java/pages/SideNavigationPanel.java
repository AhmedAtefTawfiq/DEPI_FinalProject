package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideNavigationPanel extends Logout{
    WebDriver sidePanelDriver;

    public SideNavigationPanel(WebDriver driver) {
        super(driver);
        sidePanelDriver = driver;
    }

    By searchLocator = By.xpath("//input[@placeholder='Search']");
    By adminPageLocator  = By.xpath("//span[text()='Admin']");
    By PIMPageLocator  = By.xpath("//span[text()='PIM']");
    By leavePageLocator  = By.xpath("//span[text()='Leave']");
    By recruitmentPageLocator  = By.xpath("//span[text()='Recruitment']");
    By dashboardPageLocator  = By.xpath("//span[text()='Dashboard']");
    By myInfoPageLocator  = By.xpath("//span[text()='My Info']");



    public void SearchItem (String itemWantSearchFor){
        sidePanelDriver.findElement(searchLocator).sendKeys(itemWantSearchFor);
    }

    public AdminPage enterToAdminPage (){
        sidePanelDriver.findElement(adminPageLocator).click();
        return new AdminPage(sidePanelDriver);
    }

    public PIMPage enterToPIMPage(){
        sidePanelDriver.findElement(PIMPageLocator).click();
        return new PIMPage(sidePanelDriver);
    }

    public RecruitmentPage enterToRecruitmentPage(){
        sidePanelDriver.findElement(recruitmentPageLocator).click();
        return new RecruitmentPage(sidePanelDriver);
    }

    public LeavePage enterToLeavePage(){
        sidePanelDriver.findElement(leavePageLocator).click();
        return new LeavePage(sidePanelDriver);
    }

    public DashboardPage enterToDashboardPage(){
        sidePanelDriver.findElement(dashboardPageLocator).click();
        return new DashboardPage(sidePanelDriver);
    }

    public MyInfoPage enterToMyInfoPage(){
        sidePanelDriver.findElement(myInfoPageLocator).click();
        return new MyInfoPage(sidePanelDriver);
    }

    public Logout clickOnProperties(){
        sidePanelDriver.findElement(propertiesLocator).click();
        return new Logout(sidePanelDriver);
    }



}
