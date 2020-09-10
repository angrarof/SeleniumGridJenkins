package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NavBar;
import pages.ResultPage;
import settings.BaseTest;

public class AmazonTest extends BaseTest {
    private NavBar navBar;
    private ResultPage resultPage;
    @BeforeClass
    public void before(){
        navBar = new NavBar(driver);
        resultPage = new ResultPage(driver);
    }

    @Test
    public void seachProduct(){
        navBar.enterTextOnSearch("inio asano");
        navBar.clickOnSearch();
        System.out.println("There are "+resultPage.countResults()+" results.");
        resultPage.selectLastResult();
        Assert.assertTrue(driver.findElement(By.id("dp-container")).isDisplayed());
    }
}
