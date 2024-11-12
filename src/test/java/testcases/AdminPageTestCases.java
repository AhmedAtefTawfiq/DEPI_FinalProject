package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.nio.file.Paths;

public class AdminPageTestCases extends DriverSetup{
    DashboardPage dashboardPage;
    AdminPage adminPage;
    GeneralPage generalPage;
    LocalizationPage localizationPage;
    LanguagePage languagePage;
    NationalitiesPage nationalitiesPage;
    JobPage jobPage;
    //String testImage = "C:\\Atef\\Projects\\OrangeHrm\\src\\qc.png";
    String testImage = Paths.get("./qc.png").toAbsolutePath().toString();

@BeforeClass
public void login() {
    driver.manage().deleteAllCookies();
    driver.get(System.getProperty("production.loginPage"));
    LoginPage loginPage = new LoginPage(driver);
    loginPage.loginWait(5);
    loginPage.login(loginData.get("validCredentials").getAsJsonObject());
    dashboardPage = loginPage.navigateToDashboard();
    adminPage = dashboardPage.enterToAdminPage();
}

   @BeforeMethod
   public void navigatesToAdminPage(){
       dashboardPage.enterToAdminPage();
   }

    @Test(testName = "Add A New Admin User ", priority = 1)
    public void AddANewUSerAsAdmin() {
        adminPage = new AdminPage(driver);
        adminPage.AddANewUser();
        adminPage.SelectUserRole();
        adminPage.SearchForEmployee("Jobin");
        adminPage.Wait(5);
        adminPage.Status();
        adminPage.Wait(5);
        adminPage.UserName("Maged Ragheb");
        adminPage.Password("0123456789Ma#");
        adminPage.ConfirmPassword("0123456789Ma#");
        adminPage.Save();
    }

    @Test(testName = "Add A New Ess User ", priority = 2)
    public void AddANewUSerAsEss() {
        adminPage.AddANewUser();
        adminPage.SelectUserRoleESS();
        adminPage.SearchForEmployee("Jobin");
        adminPage.Wait(5);
        adminPage.Status();
        adminPage.Wait(5);
        adminPage.UserName("Maged");
        adminPage.Password("0123456789Ma#");
        adminPage.ConfirmPassword("0123456789Ma#");
        adminPage.Save();
        adminPage.Wait(5);
        WebElement Success = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-text--toast-title oxd-toast-content-text']"));
        Assert.assertEquals(Success.getText(), "Success", "Saved");
    }

    @Test(testName = "Searching for a user ", priority = 3)
    public void SearchingForUser() {
        adminPage.UserManagement();
        adminPage.AddUserName("Maged Ragheb");
        adminPage.SelectUser();
        adminPage.EmployeeField("Jobin ");
        adminPage.SelectStatus();
        adminPage.ClickSearch();

    }

    @Test(testName = "Edit User", priority = 4)
    public void EditUser() {
        adminPage.setClickOnEdit();
        adminPage.EditeUser();
    }

    @Test(testName = "Searching ", priority = 5)
    public void Searching() {
        adminPage.UserManagement();
        adminPage.AddUserName("Maged");
        adminPage.ClickSearch();

    }
    @Test(testName = "Edit the GeneralInformation", priority = 6)
    public void Organization() {
        generalPage = adminPage.OpenTheGeneralInformation();
        generalPage.ClickOnEditeSwitch();
        generalPage.EditOrgName("Orange");
        generalPage.RegistrationNumber("50200");
        generalPage.TaxId("63336");
        generalPage.phoneNumber("+201581869");
        generalPage.fax("96581");
        generalPage.Email("maa@mam.com");
        generalPage.Address1("Giza");
        generalPage.Address2("6october");
        generalPage.City("cairo");
        generalPage.ZIP("11922");
        generalPage.State("NM");
        generalPage.Country();
        generalPage.Save();

    }
    @Test(testName = "Verify that the user can add a new Localization",priority = 7)
    public void addNewLocalization(){
        localizationPage = adminPage.OpenTheLocalizationPage();
        localizationPage.Localization();
    }

    @Test(testName = "Add a new language",priority = 8)
    public void addLanguage(){
        languagePage = adminPage.OpenTheLanguagePage();
        languagePage.Qualification("German");

    }

    @Test(testName = "Add a Nationality", priority = 9 )
    public void addNationality() {
        nationalitiesPage = adminPage.OpenTheNationalitiesPage();
        nationalitiesPage.addNationality("Egyptian");

    }

    //Job tests
    @Test(testName = "Verify that the user can add a new job", priority = 10)
    public void addNewJob() {
        jobPage = adminPage.OpenJobTitlesPage();
        jobPage.AddANewJobTitle("QC",
                "Quality control engineers are in charge of ensuring all products in their company meet the set quality standards",
                testImage,
                "Testing");

    }
    @Test(testName = "Verify that the user can Delete a job",priority = 11)
    public void DeleteJob(){
        jobPage.DeleteJob();

    }

    @Test(testName = "Add a new pay grade", priority = 12)
    public void addNewGrade() {
        jobPage = adminPage.OpenPayGradesPage();
        jobPage.AddGrade("Grade22255");
        jobPage.AddCurrencies("10000","1000000");
        adminPage.returnBackToPayGradePage();
        Assert.assertEquals(jobPage.getTheAddedGradeName(),"Grade22255","Done");
    }

    @Test(testName = "Add a Employment Status", priority =13)
    public void addEmploymentStatus() {
        jobPage = adminPage.OpenEmploymentStatusPage();
        jobPage.EmploymentPage("Full Time");
    }

    @Test(testName = "Add a new job categories ", priority = 14)
    public void addNewJobCategories() {
        jobPage = adminPage.openJobCategories();
        jobPage.CategoriesJob("Developer");
    }
}

