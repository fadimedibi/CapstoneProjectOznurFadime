package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/rerun.txt",
        glue = "stepDefinitions",
        plugin = {
                "html:target/rerun-default-cucumber-reports",
                "json:target/rerun-cucumber.json"
        }
)


public class FailedRunner {

}
