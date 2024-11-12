package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GeneralPage {
    public WebDriver GeneralDriver;

    public GeneralPage(WebDriver driver) {
        this.GeneralDriver = driver;

    }


    By ClickOnEditSwitch = By.xpath("//*[@class='oxd-switch-input oxd-switch-input--active --label-left']");

    By OrgName = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/input");
    By RegNumber = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    By Tax = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    By Phone = By.xpath("//*[@modelmodifiers='[object Object]']");
    By Fax = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input");
    By Email = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[3]/div/div[2]/input");
    By Address = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[1]/div/div[2]/input");
    By Address2 = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/div/div[2]/input");
    By City = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[3]/div/div[2]/input");
    By State = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[1]/div/div[2]/input");
   By Zip = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[2]/div/div[2]/input");
    By SelectCountry = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[3]/div/div[2]/div/div/div[2]/i");
    By Country = By.xpath("//*[contains(text(),'Egypt')]");
    By Note = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[6]/div/div/div[2]");
    By SaveButton = By.xpath("//*[@type='submit']");



    //Methods


    public void ClickOnEditeSwitch() {
        GeneralDriver.findElement(ClickOnEditSwitch).click();
    }

    public void EditOrgName(String orgname) {
        GeneralDriver.findElement(OrgName).click();
        GeneralDriver.findElement(OrgName).sendKeys(Keys.CONTROL + "a");
        GeneralDriver.findElement(OrgName).sendKeys(Keys.BACK_SPACE);
        GeneralDriver.findElement(OrgName).sendKeys(orgname);
    }

    public void RegistrationNumber(String num) {
        GeneralDriver.findElement(RegNumber).click();
        GeneralDriver.findElement(RegNumber).sendKeys(Keys.CONTROL + "a");
        GeneralDriver.findElement(RegNumber).sendKeys(Keys.BACK_SPACE);
        GeneralDriver.findElement(RegNumber).sendKeys(num);
    }

    public void TaxId(String tax) {
        GeneralDriver.findElement(Tax).click();
        GeneralDriver.findElement(Tax).sendKeys(Keys.CONTROL + "a");
        GeneralDriver.findElement(Tax).sendKeys(Keys.BACK_SPACE);
        GeneralDriver.findElement(Tax).sendKeys(tax);
    }

    public void phoneNumber(String phoneNumber) {
        GeneralDriver.findElement(Phone).click();
        GeneralDriver.findElement(Phone).sendKeys(Keys.CONTROL + "a");
        GeneralDriver.findElement(Phone).sendKeys(Keys.BACK_SPACE);
        GeneralDriver.findElement(Phone).sendKeys(phoneNumber);
    }

    public void fax(String fax) {
        GeneralDriver.findElement(Fax).click();
        GeneralDriver.findElement(Fax).sendKeys(Keys.CONTROL + "a");
        GeneralDriver.findElement(Fax).sendKeys(Keys.BACK_SPACE);
        GeneralDriver.findElement(Fax).sendKeys(fax);
    }

    public void Email(String mail) {
        GeneralDriver.findElement(Email).click();
        GeneralDriver.findElement(Email).sendKeys(Keys.CONTROL + "a");
        GeneralDriver.findElement(Email).sendKeys(Keys.BACK_SPACE);
        GeneralDriver.findElement(Email).sendKeys(mail);
    }

    public void Address1(String address1) {
        GeneralDriver.findElement(Address).click();
        GeneralDriver.findElement(Address).sendKeys(Keys.CONTROL + "a");
        GeneralDriver.findElement(Address).sendKeys(Keys.BACK_SPACE);
        GeneralDriver.findElement(Address).sendKeys(address1);
    }

    public void Address2(String address) {
        GeneralDriver.findElement(Address2).click();
        GeneralDriver.findElement(Address2).sendKeys(Keys.CONTROL + "a");
        GeneralDriver.findElement(Address2).sendKeys(Keys.BACK_SPACE);
        GeneralDriver.findElement(Address2).sendKeys(address);
    }

    public void City(String city) {
        GeneralDriver.findElement(City).click();
        GeneralDriver.findElement(City).sendKeys(Keys.CONTROL + "a");
        GeneralDriver.findElement(City).sendKeys(Keys.BACK_SPACE);
        GeneralDriver.findElement(City).sendKeys(city);
    }

    public void ZIP(String zip) {
        GeneralDriver.findElement(Zip).click();
        GeneralDriver.findElement(Zip).sendKeys(Keys.CONTROL + "a");
        GeneralDriver.findElement(Zip).sendKeys(Keys.BACK_SPACE);
        GeneralDriver.findElement(Zip).sendKeys(zip);
    }

    public void State(String state) {
        GeneralDriver.findElement(State).click();
        GeneralDriver.findElement(State).sendKeys(Keys.CONTROL + "a");
        GeneralDriver.findElement(State).sendKeys(Keys.BACK_SPACE);
        GeneralDriver.findElement(State).sendKeys(state);
    }

    public void Country() {
        GeneralDriver.findElement(SelectCountry).click();
        GeneralDriver.findElement(Country).click();

    }


    public void Save() {
        GeneralDriver.findElement(SaveButton).click();
    }
}

