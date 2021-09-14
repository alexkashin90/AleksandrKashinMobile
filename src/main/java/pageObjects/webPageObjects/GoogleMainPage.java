package pageObjects.webPageObjects;

import static data.Constants.MAX_WAIT_TIME;

import io.appium.java_client.AppiumDriver;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleMainPage {
    private AppiumDriver appiumDriver;

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchField;

    @FindBy(xpath = "//li[@class='sbct']")
    private List<WebElement> suggestions;

    @FindBy(xpath = "//div[@id='rso']/div")
    List<WebElement> searchResults;

    @FindBy(xpath = "//a[@role='button']/h3/div")
    WebElement otherResultsButton;

    public GoogleMainPage(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver, this);
    }

    public GoogleMainPage openPage(String pageUrl) {
        appiumDriver.navigate().to(pageUrl);
        // Make sure that page was loaded completely
        new WebDriverWait(appiumDriver, MAX_WAIT_TIME)
            .until(ExpectedConditions.visibilityOf(searchField));
        return this;
    }

    public GoogleMainPage performSearch(String searchString) {
        searchField.sendKeys(searchString);
        suggestions.get(0).click();
        // Make sure that page was loaded completely
        new WebDriverWait(appiumDriver, MAX_WAIT_TIME)
            .until(ExpectedConditions.visibilityOf(otherResultsButton));
        return this;
    }

    public List<WebElement> getSearchResults() {
       return searchResults;
    }
}
