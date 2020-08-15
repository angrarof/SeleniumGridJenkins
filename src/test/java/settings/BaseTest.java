package settings;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    @org.testng.annotations.Parameters(value = {"browser"})
    public void suitSetup(String browser) throws MalformedURLException {
        driver = new DriverSetup("chrome",false).getDriver();
        System.out.println(browser);
        driver.get("https://www.amazon.com.mx/");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
