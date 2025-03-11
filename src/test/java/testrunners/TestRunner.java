package testrunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import java.io.File;

@CucumberOptions(
    features = "src/test/java/features",
    glue = "stepdefinitions",
    plugin = {
        "pretty", 
        "html:reports/cucumber.html",
        "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        "json:target/cucumber-reports/cucumber.json"
    }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @BeforeClass
    public static void setup() {
        // Create allure-results directory if it doesn't exist
        new File("target/allure-results").mkdirs();
    }
}