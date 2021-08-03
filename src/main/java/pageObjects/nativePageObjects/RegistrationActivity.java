package pageObjects.nativePageObjects;

import entities.User;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class RegistrationActivity extends BaseActivity {

    @AndroidFindBy(id = appPackageName + "register_button")
    private WebElement registerBtn;
    @AndroidFindBy(id = appPackageName + "registration_email")
    private WebElement emailInputField;
    @AndroidFindBy(id = appPackageName + "registration_username")
    private WebElement usernameInputField;
    @AndroidFindBy(id = appPackageName + "registration_password")
    private WebElement passwordInputField;
    @AndroidFindBy(id = appPackageName + "registration_confirm_password")
    private WebElement confirmPasswordInputField;
    @AndroidFindBy(className = "android.widget.CheckedTextView")
    private WebElement agreementCheckbox;
    @AndroidFindBy(id = appPackageName + "register_new_account_button")
    private WebElement registerNewAccountBtn;

    public RegistrationActivity(AppiumDriver appiumDriver) {
        PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
    }

    public RegistrationActivity registerUser(User user, AppiumDriver appiumDriver) {
        emailInputField.sendKeys(user.getEmail());
        usernameInputField.sendKeys(user.getUsername());
        passwordInputField.sendKeys(user.getPassword());
        confirmPasswordInputField.sendKeys(user.getPassword());
        appiumDriver.hideKeyboard();
        registerNewAccountBtn.click();
        return this;
    }

    public RegistrationActivity clickOnCheckBox() {
        agreementCheckbox.click();
        return this;
    }

    public String getCheckBoxStatus() {
        return agreementCheckbox.getAttribute("Checked");
    }

    public String getCheckBoxText() {
        return agreementCheckbox.getText();
    }
}
