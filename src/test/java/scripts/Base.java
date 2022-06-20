package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.CarvanaHomePage;
import pages.CarvanaSearchPage;
import utilities.Driver;

public class Base {

    WebDriver driver;
    Actions actions;
    CarvanaHomePage carvanaHomePage;
    CarvanaSearchPage carvanaSearchPage;


    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        actions = new Actions(driver);
        carvanaHomePage = new CarvanaHomePage(driver);
        carvanaSearchPage = new CarvanaSearchPage(driver);
    }

    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }
}
