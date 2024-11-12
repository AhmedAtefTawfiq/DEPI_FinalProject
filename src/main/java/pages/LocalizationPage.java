package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class LocalizationPage {
    public WebDriver LocalDriver;

    public LocalizationPage(WebDriver driver) {
        LocalDriver = driver;
    }

    //Locators

    By SelectLanguage = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    By language = By.xpath("//div[starts-with(text(),'German')]");
    By language2 = By.xpath("//div[starts-with(text(),'English')]");
    By SelectDate = By.xpath("//div[starts-with(text(),'yy')]");
    By dataFormat = By.xpath("//div[starts-with(text(),'dd')]");
    By Save = By.xpath("//button[@type='submit']");


    //Methods
    public void Localization() {
        LocalDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LocalDriver.findElement(SelectLanguage).click();
        LocalDriver.findElement(language2).click();
//        LocalDriver.findElement(SelectDate).click();
//        LocalDriver.findElement(dataFormat).click();
//        LocalDriver.findElement(Save).click();
//        LocalDriver.findElement(SelectLanguage).click();
//        LocalDriver.findElement(language2).click();
        LocalDriver.findElement(Save).click();

    }


}
