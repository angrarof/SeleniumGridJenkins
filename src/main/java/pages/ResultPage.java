package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import settings.BasePage;

import java.util.List;

public class ResultPage extends BasePage {
    @FindBy(xpath = "//*[@data-component-type='s-search-result']")
    private List<WebElement> productResults;

    public int countResults(){
        int count=0;
        for(WebElement element:productResults){
            count+=1;
        }
        return count;
    }

    public void selectLastResult(){
        int lastElementNumber = countResults();
        WebElement lastElement = driver.findElement(By.xpath("//*[@data-cel-widget='search_result_"+lastElementNumber+"']"));
        clickOnElement(lastElement, true);
    }

    public ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
