package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class JobPage {
    WebDriver jobDriver;

    public JobPage(WebDriver driver) {
        jobDriver = driver;
    }

    //locators
    By ClickOnAddButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By AddANewJob = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By AddADescription = By.xpath("//*[@placeholder='Type description here']");
    By uploadImage = By.xpath("//input[@type='file']");
    By AddNote = By.xpath("//*[@placeholder='Add note']");
    By ClickOnSave = By.xpath("//*[@type='submit']");
    By DeleteButton = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space'][1]");
    By ClickOnDelete = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']");


    //locators For payGrades
    By AddGrade = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By Submit = By.xpath("//*[@type='submit']");
    By AddCurrencies = By.xpath("//*[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By SelectCurrency = By.xpath("//*[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    By AEDCurrency = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[1]/div/div/div/div[2]/div/div[2]/div[2]");
    By MinSalary = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/div[2]/input");
    By MaxSalary = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/div/div[2]/input");
    By Save = By.xpath("(//button[@type='submit'])[2]");
    By addedGradeLocator = By.xpath("//div[contains(text(),'Grade22255')]");
    //Locator For Employment Status
    By EmploymentName = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By SaveEmployment = By.xpath("//*[@type='submit']");


    //Locator For Job Categories
    By AddANewCategory = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By SaveCategory = By.xpath("//*[@type='submit']");

    //Methods

    public void AddANewJobTitle(String job, String Description, String image, String note) {
        jobDriver.findElement(ClickOnAddButton).click();
        jobDriver.findElement(AddANewJob).sendKeys(job);
        jobDriver.findElement(AddADescription).sendKeys(Description);
        jobDriver.findElement(uploadImage).sendKeys(image);
        jobDriver.findElement(AddNote).sendKeys(note);
        jobDriver.findElement(ClickOnSave).click();
    }

    public void DeleteJob() {
        jobDriver.findElement(DeleteButton).click();
        jobDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        jobDriver.findElement(ClickOnDelete).click();
    }



    public void AddGrade(String grade) {
        jobDriver.findElement(ClickOnAddButton).click();
        jobDriver.findElement(AddGrade).sendKeys(grade);
        jobDriver.findElement(Submit).click();
    }

    public String getTheAddedGradeName(){
        return jobDriver.findElement(addedGradeLocator).getText();
    }

    public void AddCurrencies(String min, String max) {
        jobDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        jobDriver.findElement(AddCurrencies).click();
        jobDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        jobDriver.findElement(SelectCurrency).click();
        jobDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        jobDriver.findElement(AEDCurrency).click();
        jobDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        jobDriver.findElement(MinSalary).sendKeys(min);
        jobDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        jobDriver.findElement(MaxSalary).sendKeys(max);
        jobDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        jobDriver.findElement(Save).click();

    }

    // Method For Employment Status
    public void EmploymentPage(String nameStatus) {
        jobDriver.findElement(ClickOnAddButton).click();
        jobDriver.findElement(EmploymentName).sendKeys(nameStatus);
        jobDriver.findElement(SaveEmployment).click();
    }

    //Method For Categories Job
    public void CategoriesJob(String category) {
        jobDriver.findElement(ClickOnAddButton).click();
        jobDriver.findElement(AddANewCategory).sendKeys(category);
        jobDriver.findElement(SaveCategory).click();
    }


}
