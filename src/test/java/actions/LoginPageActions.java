package actions;

import pages.LoginPage;

import static constants.Constants.LOGIN_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class provides actions that can be performed on the login page.
 * Author: Rob Thomson
 * Date: 06/06/2024
 */

public class LoginPageActions {

    public final LoginPage loginPage = new LoginPage();

    /**
     * Clicks the "Accept Cookies" button on the login page.
     * Ensures that the button is not null before attempting to click.
     */
    public void clickAcceptCookiesButton(){
        try {
            if (loginPage.acceptCookiesButton() == null) {
                throw new NullPointerException("Accept Cookies button is null.");
            }
            loginPage.acceptCookiesButton().click();
        } catch (Exception e) {
            System.err.println("Error clicking Accept Cookies button: " + e.getMessage());
        }
    }

    /**
     * Enters the provided email address into the email address field on the login page.
     * Ensures that the email address is not null or empty and that the field is not null before attempting to enter the email.
     *
     * @param emailAddress The email address to enter.
     */
    public void enterEmailAddress(String emailAddress) {
        try {
            if (emailAddress == null || emailAddress.isEmpty()) {
                throw new IllegalArgumentException("Email address cannot be null or empty.");
            }
            if (loginPage.emailAddressField() == null) {
                throw new NullPointerException("Email address field is null.");
            }
            loginPage.emailAddressField().clear();
            loginPage.emailAddressField().sendKeys(emailAddress);
        } catch (Exception e) {
            System.err.println("Error entering email address: " + e.getMessage());
        }
    }

    /**
     * Enters the provided password into the password field on the login page.
     * Ensures that the password is not null or empty and that the field is not null before attempting to enter the password.
     *
     * @param password The password to enter.
     */
    public void enterPassword(String password) {
        try {
            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be null or empty.");
            }
            if (loginPage.passwordField() == null) {
                throw new NullPointerException("Password field is null.");
            }
            loginPage.passwordField().clear();
            loginPage.passwordField().sendKeys(password);
        } catch (Exception e) {
            System.err.println("Error entering password: " + e.getMessage());
        }
    }

    /**
     * Clicks the "Login" button on the login page.
     * Ensures that the button is not null before attempting to click.
     */
    public void clickLoginButton() {
        try {
            if (loginPage.loginButton() == null) {
                throw new NullPointerException("Login button is null.");
            }
            loginPage.loginButton().click();
        } catch (Exception e) {
            System.err.println("Error clicking Login button: " + e.getMessage());
        }
    }

    public void checkLoginErrorIsDisplayed(){
        // Assert that the innerText matches the expected string with a custom message
        assertThat(LOGIN_ERROR_MESSAGE)
                .as("Check that the innerText of the element matches the expected text")
                .isEqualTo(loginPage.loginErrorMessage().getAttribute("innerText"));

    }
}