package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyInfoPage {

    WebDriver myInfoDriver;

    public MyInfoPage(WebDriver driver) {
        myInfoDriver = driver;
    }
    By myInfoPageTitleLocator = By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']");

    public String getPageTitle(){
        return myInfoDriver.findElement(myInfoPageTitleLocator).getText();
    }
}
