package org.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class ClickChecks {

    public void runOne() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(ClickChecks.class))
                .build();
        Launcher launcher = LauncherFactory.create();
        launcher.execute(request);
    }

    public WebDriver driver;

    Path resourceDirectory = Paths.get("src","main","resources");
    String absolutePathToResources = resourceDirectory.toFile().getAbsolutePath();

    public String htmlfilepath = "file:///" + absolutePathToResources + "/index.html";

    @BeforeAll
    public static void setDriver() {
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setup() {
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void quit() {
        driver.quit();
    }

    @Test
    public void firstTest() {
        String buttonId = "button_a";
        buttonClicks(buttonId);
    }

    @Test
    public void secondTest() {
        String buttonId = "button_b";
        buttonClicks(buttonId);
    }

    @Test
    public void thirdTest() {
        String buttonId = "button_c";
        buttonClicks(buttonId);
    }

    @Test
    public void fourthTest() {
        String buttonId = "button_d";
        buttonClicks(buttonId);
    }

    public void buttonClicks(String buttonId) {
        driver.get(htmlfilepath);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));

        String title = driver.getTitle();
        assertTrue(title.contains("Page title"));

        WebElement button = driver.findElement(By.id(buttonId));
        WebElement countelement = driver.findElement(By.className("sometext"));

        String counttext = countelement.getText();
        assertTrue(counttext.contains("0"));
        System.out.println(buttonId + ": Initial check passed.");

        button.click();
        System.out.println(buttonId + ": First click executed.");

        counttext = countelement.getText();
        assertTrue(counttext.contains("1"));
        System.out.println(buttonId + ": Check after first click passed.");

        button.click();
        System.out.println(buttonId + ": Second click executed.");

        counttext = countelement.getText();
        assertTrue(counttext.contains("2"));
        System.out.println(buttonId + ": Final check passed.");
    }
}