package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    protected static Properties runProperties = new Properties();
    protected static Properties testProperties = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader()
                .getResourceAsStream("run.properties")) {
            if (input == null) {
                throw new RuntimeException("run.properties not found in resources");
            }
            runProperties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load run.properties", e);
        }
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/custom-juice-shop.properties");
            testProperties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(" Failed to load custom-juice-shop.properties file.");
        }
    }



    public static String getBrowser() {
        // Runtime system property > Maven profile > default
        String browser = System.getProperty("browserName");   // from -DbrowserName=safari
        if (browser != null && !browser.isEmpty()) return browser;

        browser = runProperties.getProperty("browser");          // fallback to properties file
        return browser != null ? browser : "chrome";          // default to chrome
    }

    public static String getAppUrl() {
        String url = System.getProperty("app.url");
        if (url != null && !url.isEmpty()) return url;
        url = runProperties.getProperty("app.url");
        return url != null ? url : "http://localhost:3000";
    }
}
