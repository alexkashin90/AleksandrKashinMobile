package utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class CloudTestPropertiesManager {

    public static String API_KEY;
    public static final String PROJECT_NAME;
    public static final String APPIUM_HUB;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("cloudTest");

        PROJECT_NAME = rb.getString("projectName");
        APPIUM_HUB = rb.getString("appiumHub");

        try {
            API_KEY = URLEncoder.encode(rb.getString("apiKey"), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
