import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * RunTest class - This class is used to run the Cucumber tests.
 * It specifies the location of the feature files, tags to include/exclude, and the plugins for reporting.
 * Author: Rob Thomson
 * Date: 06/06/2024
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/featureFiles/"},
        tags = "not @ignore",
        plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber/cucumber.json"}
)
public class RunTest {
    // This class is intentionally left empty. It serves as an entry point for the Cucumber tests.
}
