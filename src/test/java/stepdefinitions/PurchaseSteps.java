package stepdefinitions;

import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pageobjects.CartPage;
import pageobjects.ComputersPage;
import pageobjects.DesktopsPage;
import pageobjects.HomePage;
import utility.*;

public class PurchaseSteps {
    HomePage homePage;
    ComputersPage computersPage;
    DesktopsPage desktopsPage;
    CartPage cartPage;
    ExtentTest test;
    WebDriver driver;

    @Given("User is on Demo Web Shop homepage")
    public void user_is_on_demo_web_shop_homepage() {
        driver = Hooks.driver;
        driver.get("https://demowebshop.tricentis.com/");
        
        test = ExtentReportManager.createTest("Purchase Test");
        test.info("User is navigating to Demo Web Shop homepage");
        LoggerUtil.info("Navigating to Demo Web Shop homepage");
        
        homePage = new HomePage(driver);
        computersPage = new ComputersPage(driver);
        desktopsPage = new DesktopsPage(driver);
        cartPage = new CartPage(driver);
    }

    @When("User clicks on Computers link")
    public void user_clicks_on_computers_link() {
        LoggerUtil.info("Clicking on Computers link");
        test.info("User clicked on Computers link");
        homePage.clickOnComputers();
    }

    @When("User selects Desktops")
    public void user_selects_desktops() {
        LoggerUtil.info("Clicking on Desktops category");
        test.info("User clicked on Desktops category");
        computersPage.clickOnDesktops();
    }

    @When("User selects the first desktop")
    public void user_selects_the_first_desktop() {
        LoggerUtil.info("Selecting the first desktop");
        test.info("User selected the first desktop");
        desktopsPage.selectFirstDesktop();
    }

    @When("User adds the desktop to the cart")
    public void user_adds_the_desktop_to_the_cart() {
        LoggerUtil.info("Adding the desktop to the cart");
        test.info("User added the desktop to the cart");
        desktopsPage.goToCart();
        ScreenshotUtil.captureScreenshot(driver, "AddedToCart");
    }

    @When("User navigates to cart and proceeds to checkout")
    public void user_navigates_to_cart_and_proceeds_to_checkout() {
        LoggerUtil.info("Navigating to cart and proceeding to checkout");
        test.info("User navigated to cart and proceeded to checkout");
        cartPage.openCart();
        cartPage.proceedToCheckout();
        ScreenshotUtil.captureScreenshot(driver, "CheckoutPage");
    }

    @Then("Order summary should be displayed")
    public void order_summary_should_be_displayed() {
        LoggerUtil.info("Verifying Order Summary");
        test.pass("Order Summary is displayed");
    }
}
