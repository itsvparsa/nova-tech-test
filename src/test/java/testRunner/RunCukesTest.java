package testRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources/FeatureFiles"},
        plugin={"json:target/cucumber.json",
                "pretty:target/cucumber-html-report",
                "usage:target/cucumber-usage.json",
                "junit:target/cucumber-results.xml"},
        glue={"stepDefs"},
         tags = {"@automated"})

public class RunCukesTest {


}
