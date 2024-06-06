package testBase;

import enums.Browsers;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import constants.Constants;

import java.net.MalformedURLException;

import static constants.Constants.BASE_URL;

/**
 * TestBase class - This class manages the setup and teardown of the WebDriver instance
 * for each test scenario. It uses Cucumber's @Before and @After annotations to initialize
 * and close the WebDriver instance respectively.
 * Author: Rob Thomson
 * Date: 06/06/2024
 */
public class TestBase {

    private final BrowserFactory bf = new BrowserFactory();

    /**
     * This method is executed before each test scenario. It initializes the WebDriver
     * instance and navigates to the base URL.
     *
     * @param scenario The Cucumber Scenario object.
     * @throws MalformedURLException If the URL is malformed.
     * @throws InterruptedException  If the thread is interrupted.
     */
    @Before
    public void launchApplication(Scenario scenario) throws MalformedURLException, InterruptedException {
        String browserParameter = getParameter();
        DriverFactory.getInstance().setDriver(bf.createBrowserInstance(Browsers.valueOf(browserParameter)));
        WebDriver driver = DriverFactory.getInstance().getDriver();
        driver.navigate().to(BASE_URL);
    }

    /**
     * Retrieves the browser type from the command line parameter -Dbrowser.
     *
     * @return The browser type as a capitalized string.
     * @throws RuntimeException If the browser parameter is empty or not provided.
     */
    private String getParameter() {
        String value = System.getProperty("browser");
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("Browser parameter is not set. Use -Dbrowser=<browser> to set the browser.");
        }
        String valueCapitalised = value.substring(0, 1).toUpperCase() + value.substring(1).toLowerCase();
        return valueCapitalised;
    }

    /**
     * This method is executed after each test scenario. It closes and quits the WebDriver instance.
     */
    @After
    public void tearDown() {
        try {
            DriverFactory.getInstance().closeDriver();
        } catch (IllegalStateException e) {
            System.err.println("Error during teardown: " + e.getMessage());
        }
    }
}