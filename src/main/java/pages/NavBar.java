package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.BasePage;

public class NavBar extends BasePage {
    @FindBy(id = "twotabsearchtextbox")
    private WebElement txbSearch;

    @FindBy(css = ".nav-search-submit.nav-sprite input.nav-input")
    private WebElement btnSearch;

    public void enterTextOnSearch(String text){
        enterText(txbSearch, text);
    }

    public void clickOnSearch(){
        clickButton(btnSearch);
    }

    public NavBar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
