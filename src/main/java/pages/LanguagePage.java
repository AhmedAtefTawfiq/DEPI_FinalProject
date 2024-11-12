package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguagePage {
    public WebDriver languageDriver;

    public  LanguagePage(WebDriver driver){
        languageDriver = driver;
    }
    //Locators

    By AddButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    By Language = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By Save = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']");

        //Methode
        public void Qualification (String language)
        {
            languageDriver.findElement(AddButton).click();
            languageDriver.findElement(Language).sendKeys(language);
            languageDriver.findElement(Save).click();
        }


}
