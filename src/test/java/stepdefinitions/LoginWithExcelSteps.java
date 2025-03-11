package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;
import utility.*;
import com.aventstack.extentreports.ExtentTest;
import java.io.IOException;

public class LoginWithExcelSteps {
    private WebDriver driver;
    private LoginPage loginPage;
    private ExtentTest test;

    @Given("User is on the login page")
       public void user_is_on_the_login_page() {
        driver = Loading.driver;
        driver.get("https://demowebshop.tricentis.com/login");
        
        test = ExtentReportManager.createTest("Login Test with Excel Data");
        test.info("User navigates to login page");
        LoggerUtil.info("Navigating to login page");
        AllureManager.addTextLog("Navigated to login page");
        
        loginPage = new LoginPage(driver);
    }

    @When("User enters credentials from {string} and sheet {string}")
      public void user_enters_credentials_from_excel(String fileName, String sheetName) throws IOException {
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testdata/" + fileName;
        String username = ExcelReader.getCellValue(filePath, sheetName, 1, 0);
        String password = ExcelReader.getCellValue(filePath, sheetName, 1, 1);
        
        LoggerUtil.info("Entering credentials from Excel file");
        test.info("User enters credentials from Excel file: " + fileName);
        AllureManager.addTextLog("Reading credentials from Excel file: " + fileName);
        
        enterCredentials(username, password);
        
        ScreenshotUtil.captureScreenshot(driver, "LoginCredentials");
        AllureManager.addScreenshotToAllureReport(driver, "Login Form with Credentials");
        loginPage.clickLogin();
    }

    @Step("Enter username {0} and password {1}")
    private void enterCredentials(String username, String password) {
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        AllureManager.addTextLog("Entered username: " + username);
    }

    @Then("User should be logged in successfully")
      public void user_should_be_logged_in_successfully() {
        LoggerUtil.info("Verifying successful login");
        test.info("Verifying user is logged in successfully");
        
        loginPage.verifyLoginSuccess();
        
        ScreenshotUtil.captureScreenshot(driver, "LoginSuccess");
        AllureManager.addScreenshotToAllureReport(driver, "Successful Login");
        test.pass("User logged in successfully");
        AllureManager.addTextLog("Login successful");
    }
}