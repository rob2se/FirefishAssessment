package testBase;

import enums.Browsers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * BrowserFactory class - This class is responsible for creating instances of WebDriver
 * for different browsers. It supports Chrome, Firefox, and Internet Explorer.
 * Author: Rob Thomson
 * Date: 06/06/2024
 */
public class BrowserFactory {

    /**
     * Creates an instance of WebDriver based on the specified browser type.
     *
     * @param browser The type of browser for which the WebDriver instance is to be created.
     * @return A WebDriver instance for the specified browser.
     * @throws MalformedURLException If an error occurs while setting up BrowserStack capabilities.
     */
    public WebDriver createBrowserInstance(Browsers browser) throws MalformedURLException {
        if (browser == null) {
            throw new IllegalArgumentException("Browser type cannot be null.");
        }
        switch (browser) {
            case Chrome:
                return createChromeDriver();
            case Firefox:
                return createFirefoxDriver();
            case IE:
                return createInternetExplorerDriver();
            default:
                throw new IllegalArgumentException("Unsupported browser type: " + browser);
        }
    }

    /**
     * Creates a WebDriver instance for Chrome browser.
     *
     * @return A WebDriver instance for Chrome.
     */
    private WebDriver createChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        configureChromeOptions(options);
        WebDriver driver = new ChromeDriver(options);
        maximizeWindow(driver);
        return driver;
    }

    /**
     * Configures options for Chrome browser.
     *
     * @param options The ChromeOptions instance to configure.
     */
    private void configureChromeOptions(ChromeOptions options) {
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        //options.addArguments("--headless");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
    }

    /**
     * Maximizes the browser window.
     *
     * @param driver The WebDriver instance whose window is to be maximized.
     */
    private void maximizeWindow(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("Driver cannot be null.");
        }
        driver.manage().window().maximize();
    }

    /**
     * Creates a WebDriver instance for Firefox browser.
     *
     * @return A WebDriver instance for Firefox.
     */
    private WebDriver createFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        configureFirefoxOptions(options);
        WebDriver driver = new FirefoxDriver(options);
        maximizeWindow(driver);
        return driver;
    }

    /**
     * Configures options for Firefox browser.
     *
     * @param options The FirefoxOptions instance to configure.
     */
    private void configureFirefoxOptions(FirefoxOptions options) {
        options.addArguments("-private");
    }

    /**
     * Creates a WebDriver instance for Internet Explorer browser.
     *
     * @return A WebDriver instance for Internet Explorer.
     */
    private WebDriver createInternetExplorerDriver() {
        WebDriverManager.iedriver().setup();
        InternetExplorerOptions options = new InternetExplorerOptions();
        configureIEOptions(options);
        WebDriver driver = new InternetExplorerDriver(options);
        maximizeWindow(driver);
        return driver;
    }

    /**
     * Configures options for Internet Explorer browser.
     *
     * @param options The InternetExplorerOptions instance to configure.
     */
    private void configureIEOptions(InternetExplorerOptions options) {
        options.addCommandSwitches("-private");
    }

    /**
     * Configures capabilities for BrowserStack.
     *
     * @return A DesiredCapabilities instance configured for BrowserStack.
     * @throws MalformedURLException If an error occurs while setting up BrowserStack capabilities.
     */
    private DesiredCapabilities configureBrowserStackCapabilities() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1920x1080");
        caps.setCapability("browser", "chrome"); // Use "chrome" instead of "Chrome"
        caps.setCapability("browser_version", "latest");
        caps.setCapability("os", "Windows");
        caps.setCapability("name", "BStack-[Java] Sample Test");
        caps.setCapability("build", "BStack Build Number 1");
        return caps;
    }
}