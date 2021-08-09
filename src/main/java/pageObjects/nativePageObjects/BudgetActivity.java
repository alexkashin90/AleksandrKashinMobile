package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BudgetActivity extends BaseActivity {

    @AndroidFindBy(xpath = findTextView + "[@text='BudgetActivity']")
    private WebElement budgetActionBarTextView;
    @AndroidFindBy(id = appPackageName + "add_new_expense")
    private WebElement addNewExpenseBtn;

    public BudgetActivity(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public void waitUntilActivityIsLoaded() {
        new WebDriverWait(appiumDriver, 60)
            .until(ExpectedConditions.visibilityOf(addNewExpenseBtn));
    }

    public String getActivityName() {
        return budgetActionBarTextView.getText();
    }
}
