package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

abstract public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, WaitingTimeSetup.getWaitForWebElement());
    }

    public void waitElementToAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void enterText(WebElement element, String text){
        waitElementToAppear(element);
        element.sendKeys(text.toLowerCase());
    }

    public void clickElement(WebElement element){
        waitElementToBeClickable(element);
        element.click();
    }

    public void validateTextMathces(String expected, String result){
        Assert.assertEquals(expected.toLowerCase().trim(),result.toLowerCase().trim());
    }
}
