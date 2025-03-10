package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ComputersPage {
    WebDriver driver;

    public ComputersPage(WebDriver driver) {
        this.driver = driver;
    }

    private By desktopsLink = By.linkText("Desktops");

    public void clickOnDesktops() {
        driver.findElement(desktopsLink).click();
    }
}
