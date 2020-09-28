package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.NavBar;
import pages.ResultPage;
import settings.BaseTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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

        List<Double> resultPrices = resultPage.getResultPrices();
        Collections.sort(resultPrices);
        System.out.println(resultPrices);

        HashMap<String, String> details = resultPage.getProductDetails();
        System.out.println(details);

        resultPage.selectLastResult();
        Assert.assertTrue(driver.findElement(By.id("dp-container")).isDisplayed());
        System.out.println(driver.getTitle());
    }
}
