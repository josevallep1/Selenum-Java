package com.testSimple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class GoogleSearchTest {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void miFirstTest (){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.clear();
        searchBox.sendKeys("Medellin");
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals("Medellin - Buscar con Google",driver.getTitle());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}