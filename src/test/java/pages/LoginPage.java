package pages;

import enums.Locators;
import helpers.GetElements;
import org.openqa.selenium.WebElement;

/**
 * Page object model for the LoginPage.
 * This class provides methods to retrieve the web elements on the login page.
 * Author: Rob Thomson
 * Date: 06/06/2024
 */
public class LoginPage {

    private final GetElements element;

    /**
     * Constructor for the LoginPage class.
     * Initializes the GetElements helper.
     */
    public LoginPage() {
        this.element = new GetElements();
    }

    /**
     * Retrieves the "Accept Cookies" button element.
     *
     * @return The web element for the "Accept Cookies" button.
     */
    public WebElement acceptCookiesButton() {
        return element.getElement(Locators.Xpath, "//a[text()='Accept All']");
    }

    /**
     * Retrieves the email address field element.
     *
     * @return The web element for the email address field.
     */
    public WebElement emailAddressField() {
        return element.getElement(Locators.Xpath, "//input[@placeholder='email address']");
    }

    /**
     * Retrieves the password field element.
     *
     * @return The web element for the password field.
     */
    public WebElement passwordField() {
        return element.getElement(Locators.Xpath, "//input[@placeholder='password']");
    }

    /**
     * Retrieves the login button element.
     *
     * @return The web element for the login button.
     */
    public WebElement loginButton() {
        return element.getElement(Locators.Xpath, "//input[@type='submit']");
    }

    public WebElement loginErrorMessage(){
        return element.getElement(Locators.Xpath, "//div[@role='alert']");
    }
}
