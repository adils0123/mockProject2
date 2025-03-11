package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.AllureManager;
import utility.ExtentReportManager;
import utility.LoggerUtil;
import utility.ScreenshotUtil;

import java.io.File;

public class Loading {
    public static WebDriver driver;
    
    @Before
    public void setup(Scenario scenario) {
        LoggerUtil.info("Starting scenario: " + scenario.getName());
              
        ExtentReportManager.setupReport();
      
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        
        AllureManager.addTextLog("Starting scenario: " + scenario.getName());
    }
    
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            LoggerUtil.error("Scenario failed: " + scenario.getName());
            ScreenshotUtil.captureScreenshot(driver, "Failed_" + scenario.getName());
            AllureManager.addScreenshotToAllureReport(driver, "Failure Screenshot");
            AllureManager.addTextLog("Scenario failed: " + scenario.getName());
        } else {
            ScreenshotUtil.captureScreenshot(driver, "Passed_" + scenario.getName());
            AllureManager.addScreenshotToAllureReport(driver, "Success Screenshot");
            AllureManager.addTextLog("Scenario passed: " + scenario.getName());
        }
        
        LoggerUtil.info("Ending scenario: " + scenario.getName());
        ExtentReportManager.flushReport();
       
            driver.quit();
      }
}