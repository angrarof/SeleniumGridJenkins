package tests;

import components.NavigationVar;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AnimePage;
import settings.BaseTest;
import settings.ScreenshotMethods;

public class AnimeTest extends BaseTest {
    private NavigationVar navigationVar;
    private AnimePage animePage;

    @BeforeClass(alwaysRun = true)
    public void beforeClass(){
        navigationVar = new NavigationVar(this.driver);
        animePage = new AnimePage(this.driver);
    }

    @Test(groups = "regression")
    public void searchForAnime() throws Exception {
        navigationVar.enterTextOnSearch("naruto shippuden");
        ScreenshotMethods.takeScreenshot(this.driver);
        navigationVar.clickOnSearch();
    }

    @Test(groups = "smoke")
    public void validateAnimeSearched() throws Exception {
        String animeToSearch = "One Piece";
        navigationVar.enterTextOnSearch(animeToSearch);
        ScreenshotMethods.takeScreenshot(driver);
        if(navigationVar.validateAnimeIsOnResults(animeToSearch)){
           animePage.validateAnimeTittle(animeToSearch);
           ScreenshotMethods.takeScreenshot(driver);
        }else{
            navigationVar.clickOnMasResultados();
            for(WebElement anime:animePage.getAnimeResults()){
                if(animeToSearch.equalsIgnoreCase(anime.getText())){
                    anime.click();
                    animePage.validateAnimeTittle(animeToSearch);
                    ScreenshotMethods.takeScreenshot(driver);
                    break;
                }
            }
        }
    }


}
