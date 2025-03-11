package stepdefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobjects.RegisterPage;
import utility.LoggerUtil;
import utility.ScreenshotUtil;
import com.aventstack.extentreports.ExtentTest;
import utility.ExtentReportManager;

import java.time.Duration;

public class RegisterSteps {
    WebDriver driver;
    RegisterPage registerPage;
    ExtentTest test;
    private By registrationConfirmMessage = By.xpath("//div[@class='result']");

    @Given("User is on Demo Web Shop registration page")
    public void user_is_on_demo_web_shop_registration_page() {
        driver = Loading.driver;
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
        
        // Generate random email to avoid duplicate registration issues
        String randomEmail = "adityaSingh" + System.currentTimeMillis() + "@gmail.com";
        registerPage.enterUserDetails("Aditya", "Singh", randomEmail, "Aadi123");
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
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(registrationConfirmMessage));
       
        String confirmationText = driver.findElement(registrationConfirmMessage).getText();
        Assert.assertTrue(confirmationText.contains("Your registration completed"), 
                "Registration failed: " + confirmationText);
        
        test.pass("User registered successfully");
        ScreenshotUtil.captureScreenshot(driver, "RegisterSuccess");
    }
}