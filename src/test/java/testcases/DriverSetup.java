package testcases;

import com.google.gson.JsonObject;
import helpers.DataReader;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.Logout;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

public class DriverSetup {
    protected static WebDriver driver;

    JsonObject loginData;
    Logout logout;


    @BeforeSuite (alwaysRun = true)
    public void openBrowser() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(System.getProperty("production.loginPage"));
        }
    }

    @BeforeSuite (alwaysRun = true)
    public void loadPropertyFiles(){
        Properties properties = System.getProperties();
        try {
            properties.load(Files.newInputStream(new File("src/main/resources/ConfigFiles/Urls.Properties").toPath()));
            properties.load(Files.newInputStream(new File("src/main/resources/ConfigFiles/Pathes.Properties").toPath()));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
            // throw new RuntimeException(e);
        }
    }

    @BeforeClass(alwaysRun = true)
    public void loadData(){
        loginData = DataReader.getInstance().readDataJsonObject(System.getProperty("testData.login"));

    }

    @AfterMethod(alwaysRun = true)
    public void setTestStatus(ITestResult result) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()){
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src , new File("src/test/resources/Screnshots"+ result.getName()+ ".png"));
        }
    }




    @AfterTest
    public void logoutTest(){
        logout = new Logout(driver);
        logout.logoutWait(5);
        logout.clickOnLogout();
    }



    @AfterSuite (alwaysRun = true)
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
