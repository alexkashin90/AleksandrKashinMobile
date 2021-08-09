package utils;

import com.github.javafaker.Faker;
import entities.User;
import java.util.ResourceBundle;

public class NativeTestPropertiesManager {

    public static final String EXPECTED_CHECKBOX_TEXT;
    public static final String BUDGET_ACTIVITY;
    public static final User RANDOM_USER;

    static {
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        int index = email.indexOf('@');
        String username = email.substring(0,index);
        ResourceBundle rb = ResourceBundle.getBundle("nativeTest");
        BUDGET_ACTIVITY = rb.getString("budgetActivity");
        EXPECTED_CHECKBOX_TEXT = rb.getString("expectedCheckBoxText");
        RANDOM_USER = new User(email,
            username,
            faker.internet().password(8, 12));
    }
}
