package testcases;

import helpers.DataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardPage;
import pages.LoginPage;
import pages.RecruitmentPage;

import java.nio.file.Paths;
import java.time.Duration;

public class RecruitmentTestCases extends DriverSetup{


    RecruitmentPage recruitmentPage;
    DashboardPage dashboard;
    //String testPDFFile = "Test_1.5MB.pdf";
    String testPDFFile = Paths.get("Test_1.5MB.pdf").toAbsolutePath().toString();

    @BeforeClass
    public void login() {
        driver.manage().deleteAllCookies();
        driver.get(System.getProperty("production.loginPage"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWait(5);
        loginPage.login(loginData.get("validCredentials").getAsJsonObject());
        dashboard = loginPage.navigateToDashboard();
        recruitmentPage = dashboard.enterToRecruitmentPage();
    }

    @BeforeMethod
    public void navigatesToRecruitmentPage_clickAddButton(){
        recruitmentPage.enterToRecruitmentPage();
        recruitmentPage.clickOnAddButton();
    }


    @Test(testName = "Validate add a candidate by a valid data", priority = 1)
    public void validData(){
        recruitmentPage = new RecruitmentPage(driver);
        recruitmentPage.enterFirstName("pepe");
        recruitmentPage.enterMidName("julian");
        recruitmentPage.enterLastName("onzima");
        recruitmentPage.addVacancy();
        recruitmentPage.enterYourMail("pepeonzima@gmail.com");
        recruitmentPage.enterNumber("010236952852");
        recruitmentPage.clickSave();
        WebElement textElement = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/h6[1]"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(textElement));
        Assert.assertEquals(textElement.getText(), "Candidate Profile", "Application Initiated Successfully");
    }

    @Test(testName = "Validate Leaving First name Empty", priority = 2)
    public void noFirstname(){
        recruitmentPage.enterFirstName("");
        recruitmentPage.enterMidName("julian");
        recruitmentPage.enterLastName("onzima");
        recruitmentPage.addVacancy();
        recruitmentPage.enterYourMail("pepeonzima@gmail.com");
        recruitmentPage.enterNumber("010236952852");
        recruitmentPage.clickSave();
        WebElement textElement = driver.findElement(By.xpath("//span[@class = 'oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        Assert.assertEquals(textElement.getText(), "Required", "First Name is Required");
    }

    @Test(testName = "Validate Leaving Last name Empty", priority = 3)
    public void noLastname() {
        recruitmentPage.enterFirstName("pepe");
        recruitmentPage.enterMidName("julian");
        recruitmentPage.enterLastName("");
        recruitmentPage.addVacancy();
        recruitmentPage.enterYourMail("pepeonzima@gmail.com");
        recruitmentPage.enterNumber("010236952852");
        recruitmentPage.clickSave();
        WebElement textElement = driver.findElement(By.xpath("//span[@class = 'oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        Assert.assertEquals(textElement.getText(), "Required", "Last name is Required");

    }

    @Test(testName = "Validate Leaving Email Empty", priority = 4)
    public void noEmail() {
        recruitmentPage.enterFirstName("pepe");
        recruitmentPage.enterMidName("julian");
        recruitmentPage.enterLastName("onzima");
        recruitmentPage.addVacancy();
        recruitmentPage.enterYourMail("");
        recruitmentPage.enterNumber("010236952852");
        recruitmentPage.clickSave();
        WebElement textElement = driver.findElement(By.xpath("//span[@class = 'oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        Assert.assertEquals(textElement.getText(), "Required", "Email is Required");
    }

    @Test(testName = "Validate upload a PDF file larger than 1 MB", priority = 5)
    public void largeFile() {
        driver.findElement(By.linkText("Recruitment")).click();
        driver.findElement(By.xpath("//i[@class = 'oxd-icon bi-plus oxd-button-icon']")).click();
        recruitmentPage.enterFirstName("pepe");
        recruitmentPage.enterMidName("julian");
        recruitmentPage.enterLastName("onzima");
        recruitmentPage.addVacancy();
        recruitmentPage.uploadResume(testPDFFile);
        recruitmentPage.enterYourMail("pepeonzima@gmail.com");
        recruitmentPage.enterNumber("010236952852");
        recruitmentPage.clickSave();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement textElement = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        Assert.assertEquals(textElement.getText(), "Attachment Size Exceeded", "Attachment is big");
    }

    @Test(testName = "Verify providing very long first name More than 50 characters", priority = 6)
    public void largeFirstname(){
        recruitmentPage.enterFirstName("Tarekibrahimmohamedhassanmostafa");
        recruitmentPage.enterMidName("julian");
        recruitmentPage.enterLastName("onzima");
        recruitmentPage.addVacancy();
        recruitmentPage.enterYourMail("pepeonzima@gmail.com");
        recruitmentPage.enterNumber("010236952852");
        recruitmentPage.clickSave();
        WebElement textElement = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        Assert.assertEquals(textElement.getText(), "Should not exceed 30 characters", "First Name is too big");
    }

    @Test(testName = "Verify providing a long mobile number More than 30 digits", priority = 7)
    public void largeContactNumber(){
        recruitmentPage.enterFirstName("pepe");
        recruitmentPage.enterMidName("julian");
        recruitmentPage.enterLastName("onzima");
        recruitmentPage.addVacancy();
        recruitmentPage.enterYourMail("pepeonzima@gmail.com");
        recruitmentPage.enterNumber("01023695285296325528415555558555");
        recruitmentPage.clickSave();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement textElement = driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
        Assert.assertEquals(textElement.getText(), "Should not exceed 25 characters", "Contact number is too big");
    }


}




