package pageObjects.nativePageObjects;

import entities.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginActivity extends BaseActivity {

    @AndroidFindBy(id = appPackageName + "email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    private WebElement signInBtn;

    @AndroidFindBy(id = appPackageName + "register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    private WebElement registerNewUserBtn;

    @AndroidFindBy(id = appPackageName + "login_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    private WebElement emailInputField;

    @AndroidFindBy(id = appPackageName + "login_pwd")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    private WebElement passwordInputField;

    public LoginActivity(AppiumDriver appiumDriver) {
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public RegistrationActivity openRegistrationActivity() {
        appiumDriver.hideKeyboard();
        registerNewUserBtn.click();
        return new RegistrationActivity(appiumDriver);
    }

    public BudgetActivity loginUser(User user) {
        emailInputField.sendKeys(user.getEmail());
        passwordInputField.sendKeys(user.getPassword());
        signInBtn.click();
        return new BudgetActivity(appiumDriver);
    }
}
