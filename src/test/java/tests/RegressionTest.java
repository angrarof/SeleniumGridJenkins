package tests;

import org.testng.annotations.Test;
import pages.HomePage;
import settings.BaseTest;

public class RegressionTest extends BaseTest {
    HomePage homePage = new HomePage(driver);

    @Test
    public void searchForProduct() throws InterruptedException {
        homePage.enterTextOnSearchBox("This is the first test of xml file");
        homePage.clickOnSearchButton();
        Thread.sleep(5000);
    }
}
