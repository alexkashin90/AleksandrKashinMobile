package pageObjects.webPageObjects;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage {
    private AppiumDriver appiumDriver;

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchField;

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
        searchField.sendKeys(Keys.ENTER);
        // Make sure that page was loaded completely
        new WebDriverWait(appiumDriver, 10).until(
            wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );
        return this;
    }

    public List<WebElement> getSearchResults() {
       return searchResults;
    }
}
