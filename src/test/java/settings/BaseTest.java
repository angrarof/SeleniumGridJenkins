package settings;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void suitSetup() throws MalformedURLException {
        driver = new DriverSetup("chrome",false).getDriver();
        driver.get("https://www.amazon.com.mx/");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
