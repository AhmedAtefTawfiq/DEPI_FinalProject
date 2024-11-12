package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NationalitiesPage {
    public WebDriver NationalDriver;

    public NationalitiesPage(WebDriver driver) {
        this.NationalDriver = driver;
    }

    //Locators
    By AddButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By Nationality = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By SaveButton = By.xpath("//button[@type='submit']");

    //Methode
    public void addNationality(String nationality) {
        NationalDriver.findElement(AddButton).click();
        NationalDriver.findElement(Nationality).sendKeys(nationality);
        NationalDriver.findElement(SaveButton).click();

    }
}
