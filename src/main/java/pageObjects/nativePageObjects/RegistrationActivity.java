package pageObjects.nativePageObjects;

import entities.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationActivity extends BaseActivity {

    @AndroidFindBy(id = appPackageName + "registration_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='user@example.com']")
    private WebElement emailInputField;

    @AndroidFindBy(id = appPackageName + "registration_username")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@value='TimApple']")
    private WebElement usernameInputField;

    @AndroidFindBy(id = appPackageName + "registration_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Required']")
    private WebElement passwordInputField;

    @AndroidFindBy(id = appPackageName + "registration_confirm_password")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@value='Repeat please']")
    private WebElement confirmPasswordInputField;

    @AndroidFindBy(id = appPackageName + "register_new_account_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    private WebElement registerNewAccountBtn;

    public RegistrationActivity(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public RegistrationActivity registerUser(User user) {
        emailInputField.sendKeys(user.getEmail());
        usernameInputField.sendKeys(user.getUsername());
        passwordInputField.sendKeys(user.getPassword());
        confirmPasswordInputField.sendKeys(user.getPassword());
        registerNewAccountBtn.click();
        return this;
    }
}
