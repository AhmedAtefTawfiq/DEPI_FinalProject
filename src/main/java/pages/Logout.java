package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class Logout {

    WebDriver logoutDriver;

    public Logout(WebDriver driver) {
        logoutDriver = driver;
    }

    protected By propertiesLocator = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    protected By dropdownLocator = By.className("oxd-dropdown-menu");
    protected By logoutLocator = By.xpath("//a[text()='Logout']");

    //methods

    public void logoutWait(int time) {
        logoutDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public LoginPage clickOnLogout(){
        logoutDriver.findElement(propertiesLocator).click();
        logoutDriver.findElement(logoutLocator).click();
        return new LoginPage(logoutDriver);
    }
}
