package testcases;

import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.LoginPage;


public class LoginTestCases extends DriverSetup{
    LoginPage loginPage;

    @BeforeClass
    public void initiatePage(){
        loginPage = new LoginPage(driver);
    }


    @BeforeMethod
    public void navigateToLoginPage(){
        //want to delete all cookies and navigates to homepage after every test
        driver.manage().deleteAllCookies();
        driver.get(System.getProperty("production.loginPage"));
    }


    @Test (testName = "verify that the user can't login without entering a username", priority = 1)
    public void loginWithoutUsername() {
        loginPage.loginWait(5);
        loginPage.login(loginData.get("without_username").getAsJsonObject());
        Assert.assertEquals(loginPage.getRequiredMessageFires(),"Required","required message not fires");
    }

    @Test (testName = "verify that the user can't login without entering a password" , priority = 2)
    public void loginWithoutPassword() {
        loginPage.loginWait(5);
        loginPage.login(loginData.get("without_password").getAsJsonObject());
        Assert.assertEquals(loginPage.getRequiredMessageFires(),"Required","required message not fires");
    }

    @Test (testName = "verify that the user can't login with wrong password", priority = 3)
    public void loginWithWrongPassword() {
        loginPage.loginWait(5);
        loginPage.login(loginData.get("withWrong_password").getAsJsonObject());
        Assert.assertEquals(loginPage.getErrorMessageFires(),"Invalid credentials","required message not fires");
    }

    @Test (testName = "verify that the user can't login with wrong username", priority = 4)
    public void loginWithWrongUsername() {
        loginPage.loginWait(5);
        loginPage.login(loginData.get("withWrong_username").getAsJsonObject());
        Assert.assertEquals(loginPage.getErrorMessageFires(),"Invalid credentials","required message not fires");
    }

    @Test (testName = "verify that the user can login with a valid credentials",priority = 5)
    public void validLogin() {
        loginPage.loginWait(5);
        loginPage.login(loginData.get("validCredentials").getAsJsonObject());
        Assert.assertEquals(driver.getCurrentUrl(),System.getProperty("production.dashboard"),"Don't navigates to dashboard ");
    }

}
