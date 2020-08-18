package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.BasePage;

import java.util.ArrayList;
import java.util.List;

public class NavigationVar extends BasePage {
    @FindBy(id = "search-anime")
    WebElement textBoxSearch;

    @FindBy(css = ".Search button")
    WebElement btnSearch;

    @FindBy(css = ".ListResult")
    WebElement searchResultBox;

    @FindBy(css = ".ListResult li>a")
    List<WebElement> searchResults;

    @FindBy(css = ".MasResultados")
    private WebElement btnMasResultados;

    public boolean validateAnimeIsOnResults(String animetoSearch){
        boolean flag = false;
        waitElementToAppear(searchResultBox);
        for(WebElement anime:searchResults){
            if(animetoSearch.equalsIgnoreCase(anime.getText())){
                anime.click();
                flag = true;
            }
        }
        return flag;
    }

    public List<WebElement> getSearchResults(){
        List<WebElement> results = new ArrayList<>();
        waitElementToAppear(searchResultBox);
        for(WebElement oneResult:searchResults){
            results.add(oneResult);
        }
        return results;
    }

    public void enterTextOnSearch(String text){
        enterText(textBoxSearch, text);
    }

    public void clickOnSearch(){
        clickElement(btnSearch);
    }

    public void clickOnMasResultados(){
        clickElement(btnMasResultados);
    }

    public void clickAnimeOnResults(String anime){

    }

    public NavigationVar(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }
}
