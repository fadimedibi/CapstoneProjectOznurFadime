package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features ="src/test/resources/features",
        glue = "stepDefinitions",
        dryRun =false,
        tags = "@requestInfo",
        plugin = {//"pretty",// prints Gherkin steps in console
                "html:target/default-cucumber-reports",
                "json:target/cucumber.json",
                "rerun:target/rerun.txt"
        }
)
public class CucumberRunner {
}
