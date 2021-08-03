package pageObjects.nativePageObjects;

import entities.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginActivity extends BaseActivity {

    @AndroidFindBy(id = appPackageName + "email_sign_in_button")
    private WebElement signInBtn;
    @AndroidFindBy(id = appPackageName + "register_button")
    private WebElement registerNewUserBtn;
    @AndroidFindBy(id = appPackageName + "login_email")
    private WebElement emailInputField;
    @AndroidFindBy(id = appPackageName + "login_pwd")
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
        appiumDriver.hideKeyboard();
        signInBtn.click();
        return new BudgetActivity(appiumDriver);
    }
}
