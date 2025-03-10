package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/features",
    glue = "stepdefinitions",
    plugin = {"pretty", "html:reports/cucumber.html"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
