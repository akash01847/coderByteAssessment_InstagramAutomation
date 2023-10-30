package utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    public Properties properties;
    public static Scenario sc;

    public String loadProperties(String property) throws IOException {
        properties = new Properties();
        FileInputStream dataFile = new FileInputStream("src/main/java/resources/data.properties");
        properties.load(dataFile);
        return properties.getProperty(property);
    }

    public void navigate() throws IOException {
        driver.manage().window().maximize();
        driver.get(loadProperties("url"));
    }

    public WebDriver initializeDriver() throws IOException {
        if (driver == null) {
        String browser = loadProperties("webBrowser");
        Log.info(browser);
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "/home/knoldus/coderByteAssessment_instagram/instagramAutomation/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sendbox");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--clear-data");
            driver = new ChromeDriver(options);
            Log.info("You have initialized a Chrome driver");
            navigate();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
            Log.info("You have initialized a Firefox driver");
            navigate();
        } else if (browser.equalsIgnoreCase("Chrome headless")) {
            System.setProperty("webdriver.chrome.driver", "/home/knoldus/coderByteAssessment_instagram/instagramAutomation/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("start-maximized");
            options.addArguments("--window-size=1920x1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--clear-data");
            options.addArguments("--remote-allow-origins=*");
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("profile.default_content_setting_values.notifications", 2);
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            driver = new ChromeDriver(options);
            Log.info("You have initialized Chrome in headless mode");
            navigate();
        } else if (browser.equalsIgnoreCase("Firefox headless")) {
            System.setProperty("webdriver.gecko.driver", "src/main/java/resources/drivers/geckodriver");
            FirefoxOptions options = new FirefoxOptions();
            options.setLogLevel(FirefoxDriverLogLevel.TRACE);
//            options.setHeadless(true);
            driver = new FirefoxDriver(options);
            driver.manage().window().maximize();
            Log.info("You have initialized Firefox in headless mode");
            navigate();
        } else {
            Log.error("There is some error in Browser name");
        }
        }
        return driver;
    }

}
