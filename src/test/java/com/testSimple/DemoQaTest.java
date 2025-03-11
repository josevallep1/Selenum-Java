package com.testSimple;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoQaTest {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/text-box");
    }

    @Test
    public void InformacionCorrecta (){
        BaseTestBk.escribirEnCampo(driver, "userName", "Pepito Perez Ansuategui");
        BaseTestBk.escribirEnCampo(driver, "userEmail", "pepitoansuategui@yopmail.com");
        BaseTestBk.escribirEnCampo(driver, "currentAddress", "Calle Falsa 123");
        BaseTestBk.escribirEnCampo(driver, "permanentAddress", "Calle Permanente 123 Abc # 45 - 69");

        BaseTestBk.hacerClick(driver, "submit");

        WebElement output = driver.findElement(By.id("output"));
        Assert.assertTrue(output.isDisplayed());


        WebElement name = driver.findElement(By.id("name"));
        Assert.assertEquals(name.getText(), "Name:Pepito Perez Ansuategui");

        WebElement email = driver.findElement(By.id("email"));
        Assert.assertEquals(email.getText(), "Email:pepitoansuategui@yopmail.com");

        WebElement current = driver.findElement(By.id("currentAddress"));
        Assert.assertEquals(current.getAttribute("value"), "Calle Falsa 123");

        WebElement permanent = driver.findElement(By.id("permanentAddress"));
        Assert.assertEquals(permanent.getAttribute("value"), "Calle Permanente 123 Abc # 45 - 69");
    }

    @Test
    public void CorreoIncorrecto (){
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.clear();
        userEmail.sendKeys("pepitoansuateguiyopmail.com");

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");

        WebElement submit = driver.findElement(By.id("submit"));
        submit.click();

        WebElement userEmail2 = driver.findElement(By.id("userEmail"));
        Assert.assertEquals(userEmail2.getAttribute("class"), "mr-sm-2 field-error form-control");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
