package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import settings.BasePage;

import java.util.ArrayList;
import java.util.List;

public class AnimePage extends BasePage {
    @FindBy(css = "h1.Title")
    private WebElement animeTittle;

    @FindBy(css = ".ListAnimes.AX.Rows.A03.C02.D02 h3.Title")
    private List<WebElement> animeResults;

    public void validateAnimeTittle(String animeName){
        validateTextMathces(animeName, animeTittle.getText());
    }

    public List<WebElement> getAnimeResults(){
        List<WebElement> results = new ArrayList<>();
        for(WebElement element:animeResults){
            results.add(element);
        }
        return results;
    }

    public AnimePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }
}
