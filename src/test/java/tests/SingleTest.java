package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import settings.BaseTest;

public class SingleTest extends BaseTest {

    private HomePage homePage;
    @BeforeClass
    public void setUp(){
        homePage = new HomePage(this.driver);
    }

    @Test(priority = 2)
    public void testTwo(){
        System.out.println("Starting test 2");
        homePage.enterTextOnSearchBox("Another text");
        homePage.clickOnSearchButton();
    }

    @Test(priority = 1)
    public void enterText(){
        System.out.println("Starting test 1");
        homePage.enterTextOnSearchBox("Xiaomi redmi note 9s");
        homePage.clickOnSearchButton();
    }
}
