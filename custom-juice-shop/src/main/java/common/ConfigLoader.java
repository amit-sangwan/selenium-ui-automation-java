package common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader()
                .getResourceAsStream("run.properties")) {
            if (input == null) {
                throw new RuntimeException("run.properties not found in resources");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load run.properties", e);
        }
    }


    public static String getBrowser() {
        // Runtime system property > Maven profile > default
        String browser = System.getProperty("browserName");   // from -DbrowserName=safari
        if (browser != null && !browser.isEmpty()) return browser;

        browser = properties.getProperty("browser");          // fallback to properties file
        return browser != null ? browser : "chrome";          // default to chrome
    }

    public static String getAppUrl() {
        String url = System.getProperty("app.url");
        if (url != null && !url.isEmpty()) return url;
        url = properties.getProperty("app.url");
        return url != null ? url : "http://localhost:3000";
    }
}
