package com.test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    public static WebDriver driver;

    @BeforeMethod
    public static void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @AfterMethod
    public static void tearDown() {
        // this method will run Before each @Test method we will have
        driver.quit();
        Reporter.log("======Browser Closed======");
    }

    public static void typeField(WebElement webElement, String text){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", webElement);
        webElement.clear();
        webElement.sendKeys(text);
    }
}
