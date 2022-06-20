package scripts;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Waiter;

public class CarvanaTest extends Base{

    @Test(priority = 1, description = "Validate Carvana home page title and url")
    public void testHomePage(){
        driver.get("https://www.carvana.com/");
        Assert.assertEquals(driver.getTitle(), "Carvana | Buy & Finance Used Cars Online | At Home Delivery");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/");
    }

    @Test(priority = 2, description = "Validate Carvana logo")
    public void testLogo(){
        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaHomePage.carvanaLogo.isDisplayed());
    }

    @Test(priority = 3, description = "Validate the main navigation section items")
    public void testMainNavigation(){
        driver.get("https://www.carvana.com/");
        Assert.assertTrue(carvanaHomePage.howItWorksButton.isDisplayed());
        Assert.assertTrue(carvanaHomePage.aboutCarvanaButton.isDisplayed());
        Assert.assertTrue(carvanaHomePage.supportAndContactButton.isDisplayed());
        Assert.assertEquals(carvanaHomePage.howItWorksButton.getText(), "HOW IT WORKS");
        Assert.assertEquals(carvanaHomePage.aboutCarvanaButton.getText(), "ABOUT CARVANA");
        Assert.assertEquals(carvanaHomePage.supportAndContactButton.getText(), "SUPPORT & CONTACT");
    }

    @Test(priority = 4, description = "Validate the sign in error message")
    public void testSignInError(){
        driver.get("https://www.carvana.com/");
        actions.click(carvanaHomePage.signInButton).perform();
        Assert.assertTrue(carvanaHomePage.signInModalMessage.isDisplayed());
        Assert.assertEquals(carvanaHomePage.signInModalMessage.getText(), "HEY THERE, WELCOME BACK.");
        actions.sendKeys(carvanaHomePage.usernameInputBox, "johndoe@gmail.com")
                .sendKeys(carvanaHomePage.passwordInputBox, "abcd1234")
                .click(carvanaHomePage.modalSignInButton).perform();
        Assert.assertTrue(carvanaHomePage.signInErrorMessage.isDisplayed());
        Assert.assertEquals(carvanaHomePage.signInErrorMessage.getText(),
                "Email address and/or password combination is incorrect\nPlease try again or reset your password.");
    }

    @Test(priority = 5, description = "Validate the search filter options and search button")
    public void testSearchFilters(){
        driver.get("https://www.carvana.com/");
        actions.click(carvanaHomePage.searchCarsButton).perform();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        String[] expectedFilters = {"PAYMENT & PRICE", "MAKE & MODEL", "BODY TYPE", "YEAR & MILEAGE", "FEATURES", "MORE FILTERS"};
        for (int i = 0; i < carvanaSearchPage.searchFilters.size(); i++) {
            Assert.assertTrue(carvanaSearchPage.searchFilters.get(i).isDisplayed());
            Assert.assertEquals(carvanaSearchPage.searchFilters.get(i).getText(), expectedFilters[i]);
        }
    }

    @Test(priority = 6, description = "Validate the search result tiles")
    public void testSearchResultTiles(){
        driver.get("https://www.carvana.com/");
        actions.click(carvanaHomePage.searchCarsButton).perform();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.carvana.com/cars");
        actions.sendKeys(carvanaSearchPage.searchInputBox, "mercedes-benz").perform();
        actions.click(carvanaSearchPage.searchGoButton).perform();
        Waiter.waitUntilURLContains(driver, 10, "mercedes-benz");
        Assert.assertTrue(driver.getCurrentUrl().contains("mercedes-benz"));

        for (WebElement carImage : carvanaSearchPage.carImages) {
            Assert.assertTrue(carImage.isDisplayed());
            Assert.assertNotNull(carImage);
        }
        for (WebElement favoriteButton : carvanaSearchPage.favoriteButtons) {
            Assert.assertTrue(favoriteButton.isDisplayed());
            Assert.assertNotNull(favoriteButton);
        }
        for (WebElement inventoryType : carvanaSearchPage.inventoryTypes) {
            Assert.assertTrue(inventoryType.isDisplayed());
            Assert.assertNotNull(inventoryType);
        }
        for (WebElement yearMakeModel : carvanaSearchPage.yearMakeModels) {
            Assert.assertTrue(yearMakeModel.isDisplayed());
            Assert.assertNotNull(yearMakeModel);
        }
        for (WebElement trimAndMileage : carvanaSearchPage.trimAndMileages) {
            Assert.assertTrue(trimAndMileage.isDisplayed());
            Assert.assertNotNull(trimAndMileage);
        }
        for (WebElement price : carvanaSearchPage.prices) {
            Assert.assertTrue(price.isDisplayed());
            Assert.assertTrue(Integer.parseInt(price.getText().replaceAll("\\D", "")) > 0);
        }
        for (WebElement monthlyPayment : carvanaSearchPage.monthlyPayments) {
            Assert.assertTrue(monthlyPayment.isDisplayed());
            Assert.assertNotNull(monthlyPayment);
        }
        for (WebElement downPayment : carvanaSearchPage.downPayments) {
            Assert.assertTrue(downPayment.isDisplayed());
            Assert.assertNotNull(downPayment);
        }
        for (WebElement deliveryChip : carvanaSearchPage.deliveryChips) {
            Assert.assertTrue(deliveryChip.isDisplayed());
            Assert.assertNotNull(deliveryChip);
        }
    }
}
