package utility;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AllureManager {

    @Attachment(value = "Page Screenshot", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static void addScreenshotToAllureReport(WebDriver driver, String name) {
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    public static void addTextLog(String message) {
        Allure.addAttachment("Info", "text/plain", message);
    }

    public static void attachFileToAllureReport(String filePath, String name) {
        Path content = Paths.get(filePath);
        try {
            Allure.addAttachment(name, Files.newInputStream(content));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveTextLog(String message) {
        Allure.addAttachment("Text Attachment", "text/plain", message);
    }
}