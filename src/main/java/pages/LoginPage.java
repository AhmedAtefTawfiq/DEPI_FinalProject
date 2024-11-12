package pages;

import com.google.gson.JsonObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.Duration;


public class LoginPage {
   public WebDriver loginDriver;

    //constructor
    public LoginPage(WebDriver driver) {
        loginDriver = driver;
    }

    //locators
    private final By usernameLocator = By.name("username");
    private final By passwordLocator = By.name("password");
    private final By loginButtonLocator = By.tagName("button");
    private final By errorMessageLocator = By.xpath("//div[@class='oxd-alert-content oxd-alert-content--error']//p");
    private final By requiredMessage = By.xpath("//span[text()='Required']");

    //methods

    public void enterUsername(String usernameValue) {
        loginDriver.findElement(usernameLocator).sendKeys(usernameValue);
    }

    public void enterPassword(String passwordValue) {
        loginDriver.findElement(passwordLocator).sendKeys(passwordValue);
    }

    public void clickLoginButton() {
        loginDriver.findElement(loginButtonLocator).click();
    }

    public void login(JsonObject jsonObject) {
        enterUsername(jsonObject.getAsJsonObject().get("username").getAsString());
        enterPassword(jsonObject.getAsJsonObject().get("password").getAsString());
        clickLoginButton();
    }

    public String getErrorMessageFires() {
        return loginDriver.findElement(errorMessageLocator).getText();
    }

    public String getRequiredMessageFires(){
        return loginDriver.findElement(requiredMessage).getText();
    }

    public void loginWait(int time) {
        loginDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }

    public DashboardPage navigateToDashboard(){
        return new DashboardPage(loginDriver);
    }

}
