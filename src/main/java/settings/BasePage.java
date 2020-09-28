package settings;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, WaitingTimeSetup.getWaitForWebElement());
        js = (JavascriptExecutor) this.driver;
    }

    public void waitElementToAppear(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void enterText(WebElement element, String text){
        waitElementToAppear(element);
        element.sendKeys(text);
    }

    public void clickButton(WebElement button){
        waitElementToBeClickable(button);
        String typeOfElement = button.getAttribute("type");
        if(typeOfElement.equalsIgnoreCase("input")){
            button.submit();
        }else{
            button.click();
        }
    }

    public void clickOnElement(WebElement element, boolean scroll){
        if(scroll){
            js.executeScript("arguments[0].scrollIntoView();",element);
        }
        waitElementToBeClickable(element);
        element.click();
    }

    public String getInvisibleText(WebElement element){
        String text = element.getAttribute("textContent");
        return text;
    }
}
