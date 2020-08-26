package settings;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void suitSetup() throws Exception {
        driver = new DriverSetup("chrome",false).getDriver();
        driver.get("https://www.animeflv.net/");
        ScreenshotMethods.screenshotSetup();
    }

    @AfterTest
    public void tearDown(){
        ScreenshotMethods.screenshotTearDown();
        driver.close();
        driver.quit();
    }
}
