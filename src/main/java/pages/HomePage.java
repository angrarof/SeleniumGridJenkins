package pages;

import org.jsoup.Connection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.BasePage;

public class HomePage extends BasePage {
    @FindBy(id = "twotabsearchtextbox")
    private WebElement txbSearch;

    @FindBy(xpath = "//input[@value='Ir']")
    private WebElement btnSearch;

    public void enterTextOnSearchBox(String text){
        writeText(txbSearch,text);
    }

    public void clickOnSearchButton(){
        clickElement(btnSearch);
    }

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
