package scenarios;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import pageObjects.webPageObjects.GoogleMainPage;
import setup.BaseTest;
import utils.WebTestPropertiesManager;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Make sure that we have relevant search result via google search")
    public void googleSearchTest() throws InterruptedException {
        PageObject pageObject = (PageObject) getPageObject();
        GoogleMainPage googleMainPage = (GoogleMainPage) pageObject.getSomePageObject();
        googleMainPage.openPage(WebTestPropertiesManager.GOOGLE_PAGE);
        googleMainPage.performSearch(WebTestPropertiesManager.QUERY);
        List<WebElement> results = googleMainPage.getSearchResults();
        Assert.assertTrue(results.size() > 0);
        Assert.assertTrue(results.get(1)
                                 .getText()
                                 .toLowerCase()
                                 .contains(WebTestPropertiesManager.QUERY.toLowerCase()));
        System.out.println("Test of Google Search is done");
    }
}
