package steps;

import actions.LoginPageActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testBase.DriverFactory;

import static constants.Constants.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * LoginSteps class - This class contains the step definitions for the login feature.
 * It uses Cucumber's annotation to define the steps and interact with the login page actions.
 * Author: Rob Thomson
 * Date: 06/06/2024
 */
public class LoginSteps {

    // Instance of LoginPageActions to perform actions on the login page
    LoginPageActions loginActions = new LoginPageActions();

    /**
     * Step definition for navigating to the login page.
     * It asserts that the current URL contains the base URL.
     */
    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        assertThat(DriverFactory.getInstance().getDriver().getCurrentUrl())
                .as("The current URL should contain the base URL")
                .contains(BASE_URL);
    }

    /**
     * Step definition for accepting the cookie policy.
     * It calls the action to click the accept cookies button.
     */
    @When("I accept the cookie policy")
    public void iAcceptTheCookiePolicy() {
        loginActions.clickAcceptCookiesButton();
    }

    /**
     * Step definition for entering an email address.
     * It calls the action to enter the provided email address.
     *
     * @param emailAddress The email address to be entered.
     */
    @And("I enter an email address {string}")
    public void iEnterAnEmailAddress(String emailAddress) {
        loginActions.enterEmailAddress(emailAddress);
    }

    /**
     * Step definition for entering a password.
     * It calls the action to enter the provided password.
     *
     * @param password The password to be entered.
     */
    @And("I enter a password {string}")
    public void iEnterAPassword(String password) {
        loginActions.enterPassword(password);
    }

    /**
     * Step definition for clicking the login button.
     * It calls the action to click the login button.
     */
    @And("I click on the login button")
    public void iClickOnTheLoginButton() {
        loginActions.clickLoginButton();
    }

    /**
     * Step definition for verifying successful login.
     * It asserts that the current URL contains 'Dashboard' indicating successful login.
     */
    @Then("I am successfully logged in")
    public void iAmSuccessfullyLoggedIn() {
        assertThat(DriverFactory.getInstance().getDriver().getCurrentUrl())
                .as("Check if the current URL contains 'Dashboard'")
                .contains("Dashboard");
    }
}
