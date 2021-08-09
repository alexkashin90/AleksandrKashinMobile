package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.PageObject;
import pageObjects.nativePageObjects.BudgetActivity;
import pageObjects.nativePageObjects.LoginActivity;
import pageObjects.nativePageObjects.RegistrationActivity;
import setup.BaseTest;
import utils.NativeTestPropertiesManager;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"},
          description = "Make sure that after registering a new user and logging in"
              + " we are on a BudgetActivity page")
    public void newAccountRegistrationTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        PageObject pageObject = (PageObject) getPageObject();
        LoginActivity loginActivity = (LoginActivity) pageObject.getSomePageObject();
        RegistrationActivity registrationActivity = loginActivity.openRegistrationActivity();
        registrationActivity.registerUser(NativeTestPropertiesManager.RANDOM_USER);
        BudgetActivity budgetActivity = loginActivity.loginUser(NativeTestPropertiesManager.RANDOM_USER);
        budgetActivity.waitUntilActivityIsLoaded();
        Assert.assertTrue(budgetActivity.getActivityName().contains(NativeTestPropertiesManager.BUDGET_ACTIVITY)
            , "Expected text is not equal to actual");
        System.out.println("Test of registration a new user in an app is done");
    }
}
