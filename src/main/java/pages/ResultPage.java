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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ResultPage extends BasePage {
    @FindBy(xpath = "//*[@data-component-type='s-search-result']")
    private List<WebElement> productResults;

    @FindBy(css = ".a-price .a-offscreen")
    private List<WebElement> resultPrices;

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

    public List<Double> getResultPrices(){
        List<Double> newPrices = new ArrayList<>();
        for(WebElement price:resultPrices){
            newPrices.add(Double.parseDouble(getInvisibleText(price).replace("$","").replace(",","")));
        }
        return newPrices;
    }

    public HashMap getProductDetails(){
        HashMap<String,String> productDetails = new HashMap<>();
        for(int i=1;i<=resultPrices.size();i++){
            String tittle = driver.findElement(By.xpath("//*[@data-cel-widget='search_result_"+i+"']//h2")).getText();
            String price = "No price";
            try {
                price = getInvisibleText(driver.findElement(By.xpath("//*[@data-cel-widget='search_result_"+i+"']//*[@class='a-offscreen']")));
            }catch (Exception e){
                System.out.println("Product '"+tittle+"' does not display any price.");
            }
            productDetails.put(tittle,price);
        }
        return productDetails;
    }

    public ResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
