package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AdminPage extends SideNavigationPanel{

    WebDriver adminDriver;
    public AdminPage(WebDriver driver)
    {
        super(driver);
        adminDriver = driver;
    }

    //Locators
    By adminTitleLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");
    By AddButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By UserRole = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    By AsAdmin = By.xpath("//span[contains(text(),'Admin')]");
    By AsEss = By.xpath("//span[contains(text(),'ESS')]");
    By SearchEmployeeName = By.xpath("//*[@placeholder='Type for hints...']");
    By EmployeeName = By.xpath("//span[contains(text(),'Jobin Mathew Sam')][1]");
    By SelectStatus = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    By Status = By.xpath("//span[contains(text(),'Enabled')]");
    By UserName = By.xpath("//input[@autocomplete='off']");
    By Password = By.xpath("(//input[@type='password'])[1]");
    By ConfirmPassword = By.xpath("(//input[@type='password'])[2]");
    By Save = By.xpath("//button[@type='submit']");
    By ClickOnOrganization = By.xpath("//span[contains(text(),'Organization ')]");
    By GeneralInformation = By.xpath("//*[contains(text(),'General Information')]");
    By ConfigurationLocator = By.xpath("//span[contains(text(),'Configuration ')]");
    By LocalizationPageLocator = By.xpath("//*[contains(text(),'Localization')]");
    By qualificationButtonLocator= By.xpath("//span[contains(text(),'Qualifications ')]");
    By LanguagePageLocator = By.xpath("//*[contains(text(),'Languages')]");
    By NationalitiesPageLocator = By.xpath("//*[contains(text(),'Nationalities')]");
    By jobMenuLocator = By.xpath("//span[contains(text(),'Job')]");
    By jobTitlesPageLocator = By.xpath("//*[contains(text(),'Job Titles')]");
    By payGradesPageLocator = By.xpath("//a[contains(text(),'Pay Grades')]");
    By employmentStatusPageLocator = By.xpath("//a[contains(text(),'Employment Status')]");
    By jobCategoriesPageLocator = By.xpath("//a[contains(text(),'Job Categories')]");

    //Method of searching
    By userManagement = By.xpath("//*[contains(text(),'User Management ')]");
    By user = By.xpath("//a[contains(text(),'User')]");
    By AddUserName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By SelectUserRole = By.xpath("(//div[@class='oxd-select-text-input'])[1]");
    By Select = By.xpath("//span[contains(text(),'Admin')]");
    By ClickOnEmployeeField = By.xpath("//input[@placeholder='Type for hints...']");
    By WriteEmployeeName = By.xpath("//span[contains(text(),'Jobin Mathew Sam')][1]");
    By selectStatusField = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    By EnableStatus = By.xpath("//span[contains(text(),'Enabled')]");
    By ClickOnSearch = By.xpath("//*[@type='submit']");
    By ClickOnEdit = By.xpath("//i[@class='oxd-icon bi-pencil-fill']");
    By StatusSelect = By.xpath("//div[contains(text(),'Enabled')]");
    By EditStatus = By.xpath("//span[contains(text(),'Disabled')]");
    By Submit = By.xpath("//button[@type='submit']");
    By DeleteButton = By.xpath("//i[@class='oxd-icon bi-trash']");
    By Delete = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");


    public void AddANewUser() {
        adminDriver.findElement(AddButton).click();
    }

    public void SelectUserRole() {
        adminDriver.findElement(UserRole).click();
        adminDriver.findElement(AsAdmin).click();
    }

    public void SelectUserRoleESS() {
        adminDriver.findElement(UserRole).click();
        adminDriver.findElement(AsEss).click();
    }

    public void SearchForEmployee(String SearchEmployee) {
        adminDriver.findElement(SearchEmployeeName).sendKeys(SearchEmployee);
        adminDriver.findElement(EmployeeName).click();
    }

    public void Status() {
        adminDriver.findElement(SelectStatus).click();
        adminDriver.findElement(Status).click();
    }

    public void UserName(String username) {
        adminDriver.findElement(UserName).sendKeys(username);
    }

    public void Password(String pass) {
        adminDriver.findElement(Password).sendKeys(pass);
    }

    public void ConfirmPassword(String confirmPassword) {
        adminDriver.findElement(ConfirmPassword).sendKeys(confirmPassword);
    }

    public void Save() {
        adminDriver.findElement(Save).click();

    }

    public void Wait(int time) {
        adminDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public void UserManagement() {
        adminDriver.findElement(userManagement).click();
        adminDriver.findElement(user).click();
    }

    public void AddUserName(String user) {
        adminDriver.findElement(AddUserName).sendKeys(user);
    }

    public void SelectUser() {
        adminDriver.findElement(SelectUserRole).click();
        adminDriver.findElement(Select).click();
    }

    public void EmployeeField(String Employee) {
        adminDriver.findElement(ClickOnEmployeeField).sendKeys(Employee);
        adminDriver.findElement(WriteEmployeeName).click();
    }

    public void SelectStatus() {
        adminDriver.findElement(selectStatusField).click();
        adminDriver.findElement(EnableStatus).click();


    }

    public void ClickSearch() {
        adminDriver.findElement(ClickOnSearch).click();

    }

    public void setClickOnEdit() {
        adminDriver.findElement(ClickOnEdit).click();
    }

    public void EditeUser() {
        adminDriver.findElement(StatusSelect).click();
        adminDriver.findElement(EditStatus).click();
        adminDriver.findElement(Submit).click();
    }

    public String getPageTitle(){
        return adminDriver.findElement(adminTitleLocator).getText();
    }

    public GeneralPage OpenTheGeneralInformation() {
        adminDriver.findElement(ClickOnOrganization).click();
        adminDriver.findElement(GeneralInformation).click();
        return new GeneralPage(adminDriver);
    }

    public LocalizationPage OpenTheLocalizationPage() {
        adminDriver.findElement(ConfigurationLocator).click();
        adminDriver.findElement(LocalizationPageLocator).click();
        return new LocalizationPage(adminDriver);
    }

    public LanguagePage OpenTheLanguagePage() {
        adminDriver.findElement(qualificationButtonLocator).click();
        adminDriver.findElement(LanguagePageLocator).click();
        return new LanguagePage(adminDriver);
    }

    public NationalitiesPage OpenTheNationalitiesPage() {
        adminDriver.findElement(NationalitiesPageLocator).click();
        return new NationalitiesPage(adminDriver);
    }

    public JobPage OpenJobTitlesPage() {
        adminDriver.findElement(jobMenuLocator).click();
        adminDriver.findElement(jobTitlesPageLocator).click();
        return new JobPage(adminDriver);
    }

    public JobPage OpenPayGradesPage() {
        adminDriver.findElement(jobMenuLocator).click();
        adminDriver.findElement(payGradesPageLocator).click();
        return new JobPage(adminDriver);
    }

    public JobPage OpenEmploymentStatusPage() {
        adminDriver.findElement(jobMenuLocator).click();
        adminDriver.findElement(employmentStatusPageLocator).click();
        return new JobPage(adminDriver);
    }

    public JobPage openJobCategories() {
        adminDriver.findElement(jobMenuLocator).click();
        adminDriver.findElement(jobCategoriesPageLocator).click();
        return new JobPage(adminDriver);
    }


    public void returnBackToPayGradePage() {
        adminDriver.findElement(jobMenuLocator).click();
        adminDriver.findElement(payGradesPageLocator).click();
    }

}
