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


    public static String get(String key) {
        // Check system property first
        String sysValue = System.getProperty(key);
        if (sysValue != null) return sysValue;

        // fallback to run.properties
        return properties.getProperty(key);
    }
}
