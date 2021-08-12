package utils;

import java.util.ResourceBundle;

public class WebTestPropertiesManager {

    public static final String GOOGLE_PAGE;
    public static final String QUERY;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("webTest");
        GOOGLE_PAGE = rb.getString("googleURL");
        QUERY = rb.getString("query");
    }
}
