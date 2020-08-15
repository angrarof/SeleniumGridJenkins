package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePage;
import settings.BaseTest;

public class RegressionTest extends BaseTest {
    private HomePage homePage;

    @BeforeClass
    public void setUp(){
       homePage = new HomePage(this.driver);
    }


    @Test
    public void searchForProduct() {
        System.out.println("Starting test");
        homePage.enterTextOnSearchBox("This is the first test of xml file");
        homePage.clickOnSearchButton();
        System.out.println("Finishing test");
    }
}
