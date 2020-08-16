package settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverSetup {
    private WebDriver driver;
    private final String nodeUrl="http://localhost:4444/wd/hub/";

    public DriverSetup(String browser, boolean headless) throws MalformedURLException {
        switch (browser.toLowerCase()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                WebDriverManager.chromedriver().setup();
                if(headless){
                    chromeOptions.addArguments("--headless");
                }
                driver = new RemoteWebDriver(new URL(nodeUrl),chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
                if(headless) {
                    firefoxOptions.addArguments("--headless");
                }
                WebDriverManager.firefoxdriver().setup();
                driver = new RemoteWebDriver(new URL(nodeUrl),firefoxOptions);
                break;
            default:
                System.out.println("Bad browser");
                break;
        }
        if (driver == null) {
            throw new AssertionError();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(WaitingTimeSetup.getWaitImplicit(),TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(WaitingTimeSetup.getWaitForPageLoad(), TimeUnit.SECONDS);
    }

    public WebDriver getDriver(){
        return driver;
    }
}
