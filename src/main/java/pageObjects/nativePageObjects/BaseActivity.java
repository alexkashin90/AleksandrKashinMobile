package pageObjects.nativePageObjects;

import io.appium.java_client.AppiumDriver;

public class BaseActivity {

    protected AppiumDriver appiumDriver;
    protected static final String appPackageName = "platkovsky.alexey.epamtestapp:id/";
    protected static final String findTextView = "//android.widget.TextView";

}
