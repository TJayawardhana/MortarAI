package org.firehouse.Base;

import com.google.common.collect.ImmutableList;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.firehouse.util.TestUtil;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public enum BrowserType {
        CHROME,
        FIREFOX,
        IE,
        EDGE,
        SAFARI,
        CHROME_HEADLESS,
        FIREFOX_HEADLESS
    }

    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);
    private static final String DEFAULT_BROWSER = "chrome";

    public static WebDriver driver;
    public static Properties prop;

    public TestBase() {
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/org/firehouse/Configurations/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.iedriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    public static void initialization(String browser) {
        BrowserType browserType = getBrowserTypeOrDefault(browser);

        driver = createWebDriver(browserType);
        if (driver == null) {
            logger.error("Unsupported browser: " + browserType);
            System.exit(-1);
        }

        // Maximise the Browser
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICITLY_WAIT));

        try {
            driver.get(prop.getProperty("BASE_URL"));
        } catch (TimeoutException e) {
            logger.error("Timeout occurred while loading the page. Closing the browser.");
            closeBrowser();
        }
    }

    private static BrowserType getBrowserTypeOrDefault(String browser) {
        if (browser == null || browser.isEmpty()) {
            return BrowserType.valueOf(DEFAULT_BROWSER.toUpperCase());
        } else {
            try {
                return BrowserType.valueOf(browser.toUpperCase());
            } catch (IllegalArgumentException e) {
                logger.error("Invalid browser type provided: " + browser);
                return BrowserType.valueOf(DEFAULT_BROWSER.toUpperCase());
            }
        }
    }

    private static WebDriver createWebDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("remote-allow-origins=*");
                chromeOptions.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
                chromeOptions.addArguments("test-type");
                chromeOptions.addArguments("start-maximized");
                chromeOptions.setExperimentalOption("excludeSwitches", ImmutableList.of("disable-popup-blocking"));
                return new ChromeDriver(chromeOptions);
            case FIREFOX:
                return new FirefoxDriver();
            case IE:
                InternetExplorerOptions ieOptions = new InternetExplorerOptions();
                ieOptions.setCapability(InternetExplorerDriver.IE_USE_PER_PROCESS_PROXY, false);
                return new InternetExplorerDriver(ieOptions);
            case EDGE:
                return new EdgeDriver();
            case SAFARI:
                return new SafariDriver();
            case CHROME_HEADLESS:
                ChromeOptions headlessOptions = new ChromeOptions();
                headlessOptions.addArguments("headless");
                return new ChromeDriver(headlessOptions);
            case FIREFOX_HEADLESS:
                FirefoxOptions headlessFirefoxOptions = new FirefoxOptions();
                headlessFirefoxOptions.addArguments("--headless");
                return new FirefoxDriver(headlessFirefoxOptions);
            default:
                logger.error("Unsupported browser type: " + browserType);
                return null;
        }
    }

    @AfterTest
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

