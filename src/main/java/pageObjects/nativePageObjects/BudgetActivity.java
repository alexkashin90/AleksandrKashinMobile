package pageObjects.nativePageObjects;

import static data.Constants.MAX_WAIT_TIME;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BudgetActivity extends BaseActivity {

    @AndroidFindBy(xpath = findTextView + "[@text='BudgetActivity']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@label='Budget']")
    private WebElement budgetActionBarText;

    @AndroidFindBy(id = appPackageName + "add_new_expense")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Add']")
    private WebElement addNewExpenseBtn;

    public BudgetActivity(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void waitUntilActivityIsLoaded() {
        new WebDriverWait(appiumDriver, MAX_WAIT_TIME)
            .until(ExpectedConditions.visibilityOf(addNewExpenseBtn));
    }

    public String getActivityName() {
        return budgetActionBarText.getText();
    }
}
