package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaHomePage {
    public CarvanaHomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".fSZhVx svg")
    public WebElement carvanaLogo;

    @FindBy(className = "gXAmVW")
    public WebElement howItWorksButton;

    @FindBy(className = "bQSPiS")
    public WebElement aboutCarvanaButton;

    @FindBy(className = "iXAdzc")
    public WebElement supportAndContactButton;

    @FindBy(css = ".dnjyaj>a")
    public WebElement signInButton;

    @FindBy(className = "kVBfpP")
    public WebElement signInModalMessage;

    @FindBy(id = "usernameField")
    public WebElement usernameInputBox;

    @FindBy(id = "passwordField")
    public WebElement passwordInputBox;

    @FindBy(className = "nqLpU")
    public WebElement modalSignInButton;

    @FindBy(className = "dhUWhc")
    public WebElement signInErrorMessage;

    @FindBy(css = ".dewPuX>a:nth-child(1)")
    public WebElement searchCarsButton;
}
