package com.testSimple;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseTestBk {

    static void escribirEnCampo(WebDriver driver, String id, String texto) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement webElement = driver.findElement(By.id(id));
        jse.executeScript("arguments[0].scrollIntoView(true);", webElement);
        webElement.clear();
        webElement.sendKeys(texto);
    }

    static void hacerClick (WebDriver driver, String id){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        WebElement webElement = driver.findElement(By.id(id));
        jse.executeScript("arguments[0].scrollIntoView(true);", webElement);
        webElement.click();
    }
}
