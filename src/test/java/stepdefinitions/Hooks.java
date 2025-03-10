package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.ExtentReportManager;
import utility.LoggerUtil;
import utility.ScreenshotUtil;

import java.io.File;

public class Hooks {
    public static WebDriver driver;
    
    @Before
    public void setup(Scenario scenario) {
        LoggerUtil.info("Starting scenario: " + scenario.getName());
        
        new File("screenshots").mkdirs();
        new File("reports").mkdirs();
        
        ExtentReportManager.setupReport();
      
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.captureScreenshot(driver, "Failed_" + scenario.getName());
        }
        
        LoggerUtil.info("Ending scenario: " + scenario.getName());
        ExtentReportManager.flushReport();
        
        if (driver != null) {
            driver.quit();
        }
    }
}
