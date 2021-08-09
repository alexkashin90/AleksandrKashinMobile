package pageObjects.webPageObjects;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.BaseTest;

public class GoogleMainPage {
    private AppiumDriver appiumDriver;

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchField;

    @FindBy(xpath = "//li[@class='sbct']")
    private List<WebElement> suggestions;

    @FindBy(xpath = "//div[@aria-level='3']")
    List<WebElement> searchResults;

    public GoogleMainPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public GoogleMainPage openPage(String pageUrl) {
        appiumDriver.navigate().to(pageUrl);
        // Make sure that page was loaded completely
        new WebDriverWait(appiumDriver, 10).until(
            wd -> ((JavascriptExecutor) wd)
                .executeScript("return document.readyState")
                .equals("complete")
        );
        return this;
    }

    public GoogleMainPage performSearch(String searchString) {
        searchField.sendKeys(searchString);
        suggestions.get(0).click();
        // Make sure that page was loaded completely
        new WebDriverWait(appiumDriver, 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        new WebDriverWait(appiumDriver, 10).until(webDriver -> searchResults.size()>0);
        return this;
    }

    public List<WebElement> getSearchResults() {
       return searchResults;
    }
}
