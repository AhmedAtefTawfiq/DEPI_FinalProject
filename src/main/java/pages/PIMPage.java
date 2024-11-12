package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.file.Paths;
import java.time.Duration;

public class PIMPage extends SideNavigationPanel{
    WebDriver PIMDriver;

    public PIMPage(WebDriver driver) {
        super(driver);
        PIMDriver = driver;
    }

    private final By PIMTitleLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    private final By addEmployeeButtonLocator = By.xpath("//a[contains(text(),'Add Employee')]");
    private final By addEmployeeFirstNameLocator = By.xpath("//input[contains(@class,'firstname')]");
    private final By addEmployeeMiddleNameLocator = By.xpath("//input[contains(@class,'middlename')]");
    private final By addEmployeeLastNameLocator = By.xpath("//input[contains(@class,'lastname')]");
    private final By addEmployeeEmployeeID = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    private final By addEmployeeSaveButton = By.xpath("//button[contains(@type,'submit')]");
    private final By EmployeeListButtonLocator = By.xpath("//a[contains(text(),'Employee List')]");
    private final By EmployeeListRecordEmployeeIDLocator = By.xpath("(//div[contains(@class,'oxd-padding-cell')])[12]");
    private final By EmployeeListEmployeePictureLocator = By.xpath("(//img)[4]");
    private final By EmployeeListEmployeePictureUploadButton = By.xpath("(//button)[4]");
    private final By EmployeeListEmployeeIDField = By.xpath("(//input[contains(@class,'input oxd-input--active')])[2]");
    private final By EmployeeListEmployeeNameField = By.xpath("(//input[contains(@placeholder,'Type')])[1]");
    private final By EmployeeListSupervisorNameField = By.xpath("(//input[contains(@placeholder,'Type')])[2]");
    private final By EmployeeListSearchButton = By.xpath("(//button[contains(@type,'submit')])");
    private final By EmployeeListResetButton = By.xpath("(//button[contains(@class,'ghost')])");
    private final By EmployeeListRecordFoundText = By.xpath("(//span[contains(@class,'oxd-text oxd-text--span')])[13]");

    public String getPageTitle(){
        PIMDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return PIMDriver.findElement(PIMTitleLocator).getText();
    }

    public WebElement EmployeeListRecordEmployeeName()
    {
        WebDriverWait wait = new WebDriverWait(PIMDriver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addEmployeeFirstNameLocator));
        return PIMDriver.findElement(addEmployeeFirstNameLocator);
    }

    public WebElement EmployeeListRecordFoundTextElement()
    {
        return PIMDriver.findElement(EmployeeListRecordFoundText);
    }

    public void addNewEmployee(String firstname , String middlename ,String lastname , String id ) {

        PIMDriver.findElement(addEmployeeFirstNameLocator).sendKeys(firstname);
        PIMDriver.findElement(addEmployeeMiddleNameLocator).sendKeys(middlename);
        PIMDriver.findElement(addEmployeeLastNameLocator).sendKeys(lastname);
        PIMDriver.findElement(addEmployeeEmployeeID).sendKeys(id);
        PIMDriver.findElement(addEmployeeSaveButton).click();

    }

    public void addEmployeePicture() {

        PIMDriver.findElement(EmployeeListRecordEmployeeIDLocator).click();
        PIMDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PIMDriver.findElement(EmployeeListEmployeePictureLocator).click();
        PIMDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        String imagePath = Paths.get("./trial.jpg").toAbsolutePath().toString();
        PIMDriver.findElement(EmployeeListEmployeePictureUploadButton).sendKeys(imagePath);
        PIMDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        PIMDriver.findElement(addEmployeeSaveButton).click();
    }

    public void filterByEmployeeID(String ID) {

        PIMDriver.findElement(EmployeeListEmployeeIDField).sendKeys(ID);
        PIMDriver.findElement(EmployeeListSearchButton).click();

    }

    public void filterByEmployeeName(String name) {

        PIMDriver.findElement(EmployeeListEmployeeNameField).sendKeys(name);
        PIMDriver.findElement(EmployeeListSearchButton).click();

    }

    public void filterBySupervisorName(String name) {

        PIMDriver.findElement(EmployeeListSupervisorNameField).sendKeys(name);
        PIMDriver.findElement(EmployeeListSearchButton).click();

    }


    public void navigateToAddEmployeePage()
    {
        PIMDriver.findElement(addEmployeeButtonLocator).click();
    }

    public void navigateToEmployeeListPage()
    {
        PIMDriver.findElement(EmployeeListButtonLocator).click();
    }

    public void PIMWait(int time) {
        PIMDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }


}
