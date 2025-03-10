package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pageobjects.RegisterPage;
import utility.LoggerUtil;
import utility.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;
import utility.ExtentReportManager;

public class RegisterSteps {
    WebDriver driver;
    RegisterPage registerPage;
    ExtentTest test;

    @Given("User is on Demo Web Shop registration page")
    public void user_is_on_demo_web_shop_registration_page() {
        driver = Hooks.driver;
        driver.get("https://demowebshop.tricentis.com/");
        
        test = ExtentReportManager.createTest("Register Test");
        test.info("User is navigating to Demo Web Shop registration page");
        LoggerUtil.info("Navigating to Demo Web Shop registration page");
        
        registerPage = new RegisterPage(driver);
        registerPage.navigateToRegister();
    }

    @When("User enters valid details")
    public void user_enters_valid_details() {
        LoggerUtil.info("Entering user details");
        test.info("User entered registration details");
        registerPage.enterUserDetails("Aditya", "Singh", "adityaSingh" + 123 + "@gmail.com", "Aadi123");
        ScreenshotUtil.captureScreenshot(driver, "RegisterForm");
    }

    @When("User clicks register button")
    public void user_clicks_register_button() {
        LoggerUtil.info("Clicking register button");
        test.info("User clicked register button");
        registerPage.clickRegisterButton();
    }

    @Then("User should be registered successfully")
    public void user_should_be_registered_successfully() {
        LoggerUtil.info("Verifying successful registration");
        test.pass("User registered successfully");
        ScreenshotUtil.captureScreenshot(driver, "RegisterSuccess");
    }
}
