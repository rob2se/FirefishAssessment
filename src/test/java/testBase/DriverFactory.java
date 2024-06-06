package testBase;

import org.openqa.selenium.WebDriver;

/**
 * DriverFactory class - This class implements the Singleton design pattern to manage
 * WebDriver instances across the application. It also uses the Factory design pattern
 * to create WebDriver instances.
 * Author: Rob Thomson
 * Date: 06/06/2024
 */
public class DriverFactory {

    // Singleton instance of DriverFactory
    private static final DriverFactory instance = new DriverFactory();

    // ThreadLocal to manage WebDriver instances in a multi-threaded environment
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Private constructor to prevent instantiation
    private DriverFactory() {
    }

    /**
     * Provides the global point of access to the Singleton instance of DriverFactory.
     *
     * @return The Singleton instance of DriverFactory.
     */
    public static DriverFactory getInstance() {
        return instance;
    }

    /**
     * Sets the WebDriver instance for the current thread.
     *
     * @param driverParam The WebDriver instance to be set.
     * @throws IllegalStateException if a WebDriver instance is already set.
     */
    public void setDriver(WebDriver driverParam) {
        // Guard clause to check if a driver is already set
        if (driver.get() != null) {
            throw new IllegalStateException("Driver is already set. Cannot set a new driver.");
        }
        driver.set(driverParam);
    }

    /**
     * Gets the WebDriver instance for the current thread.
     *
     * @return The WebDriver instance.
     * @throws IllegalStateException if the WebDriver instance is not set.
     */
    public WebDriver getDriver() {
        // Guard clause to check if a driver is set before getting it
        if (driver.get() == null) {
            throw new IllegalStateException("Driver is not set. Call setDriver() before getting the driver.");
        }
        return driver.get();
    }

    /**
     * Closes and quits the WebDriver instance for the current thread and removes it from ThreadLocal.
     *
     * @throws IllegalStateException if the WebDriver instance is not set.
     */
    public void closeDriver() {
        // Guard clause to check if a driver is set before closing/quitting
        if (driver.get() == null) {
            throw new IllegalStateException("Driver is not set. Call setDriver() before closing/quitting the driver.");
        }
        driver.get().close();
        driver.get().quit();
        driver.remove();
    }
}