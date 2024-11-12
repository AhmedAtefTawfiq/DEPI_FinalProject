package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class RecruitmentPage extends SideNavigationPanel{
    WebDriver recDriver;

    //Constructor
    public RecruitmentPage(WebDriver driver){
        super(driver);
        recDriver = driver;
    }

    //Locators
    private final By recruitmentPageTitleLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    private final By fName = By.name("firstName");
    private final By midName = By.name("middleName");
    private final By lastName = By.name("lastName");
    private final By vacancy = By.xpath("//i[@class = 'oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    private final By email = By.xpath("(//input[@placeholder='Type here'])[1]");
    private final By contactNumber = By.xpath("(//input[@placeholder='Type here'])[2]");
    private final By saveButton = By.xpath("//button[@type = 'submit']");
    private final By resume = By.xpath("//input[@type='file']");
    private final By addButtonLocator = By.xpath("//i[@class = 'oxd-icon bi-plus oxd-button-icon']");

    //Methods
    public void enterFirstName(String fname){
        recDriver.findElement(fName).sendKeys(fname);
    }

    public void enterMidName(String midname){
        recDriver.findElement(midName).sendKeys(midname);
    }

    public void enterLastName(String lname){
        recDriver.findElement(lastName).sendKeys(lname);
    }

    public void addVacancy(){
        recDriver.findElement(vacancy).click();
        recDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        recDriver.findElement(By.xpath("//span[contains(text(),'Junior Account Assistant')]")).click();
    }

    public void uploadResume(String yourResume){
        recDriver.findElement(resume).sendKeys(yourResume);
    }

    public void enterYourMail(String mail) {
        recDriver.findElement(email).sendKeys(mail);
    }

    public void enterNumber(String numb){
        recDriver.findElement(contactNumber).sendKeys(numb);
    }

    public void clickSave(){
        recDriver.findElement(saveButton).click();
    }

    public void clickOnAddButton(){
        recDriver.findElement(addButtonLocator).click();
    }

    public String getPageTitle(){
        return recDriver.findElement(recruitmentPageTitleLocator).getText();
    }
}
