package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By computersLink = By.linkText("Computers");

    public void clickOnComputers() {
        driver.findElement(computersLink).click();
    }
}
