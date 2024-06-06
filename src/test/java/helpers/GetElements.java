package helpers;

import enums.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testBase.DriverFactory;
import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

/**
 * GetElements class - custom locator class that waits for element visibility and clickability of the element.
 * This class provides methods to retrieve web elements based on different locator strategies.
 * Author: Rob Thomson
 * Date: 06/06/2024
 */
public class GetElements {

    private final WebDriver driver;

    /**
     * Constructor for the GetElements class.
     * Initializes the WebDriver instance.
     */
    public GetElements() {
        this.driver = DriverFactory.getInstance().getDriver();
    }

    /**
     * Retrieves a web element based on the provided locator and value.
     * This method waits for the element to be visible and clickable before returning it.
     *
     * @param locator The type of locator (e.g., ID, XPath, etc.).
     * @param value The value of the locator.
     * @return The web element located by the specified locator and value, or null if the element is not found.
     */
    public WebElement getElement(Locators locator, String value) {
        validateInput(locator, value);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            By byElement = getByElement(locator, value);

            wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
            wait.until(ExpectedConditions.elementToBeClickable(byElement));

            return driver.findElement(byElement);
        } catch (TimeoutException e) {
            assertThat(false)
                    .withFailMessage("Error: Element with locator %s and value %s was not found within the timeout period.", locator, value)
                    .isTrue();
        } catch (NoSuchElementException e) {
            assertThat(false)
                    .withFailMessage("Error: Element with locator %s and value %s was not found.", locator, value)
                    .isTrue();
        } catch (WebDriverException e) {
            assertThat(false)
                    .withFailMessage("WebDriver error: %s", e.getMessage())
                    .isTrue();
        }

        return null;
    }

    /**
     * Validates the input parameters for the getElement method.
     * Ensures that the locator and value are not null or empty.
     *
     * @param locator The locator strategy to use.
     * @param value   The value of the locator.
     */
    private void validateInput(Locators locator, String value) {
        assertThat(locator).withFailMessage("Locator cannot be null.").isNotNull();
        assertThat(value).withFailMessage("Value cannot be null or empty.").isNotNull().isNotEmpty();
    }

    /**
     * Gets the By object based on the specified locator and value.
     * Converts the Locators enum to the corresponding By object.
     *
     * @param locator The locator strategy to use.
     * @param value   The value of the locator.
     * @return The By object representing the locator.
     */
    private By getByElement(Locators locator, String value) {
        switch (locator) {
            case ClassName:
                return By.className(value);
            case CssSelector:
                return By.cssSelector(value);
            case Id:
                return By.id(value);
            case LinkText:
                return By.linkText(value);
            case Name:
                return By.name(value);
            case PartialLink:
                return By.partialLinkText(value);
            case TagName:
                return By.tagName(value);
            case Xpath:
                return By.xpath(value);
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locator);
        }
    }
}