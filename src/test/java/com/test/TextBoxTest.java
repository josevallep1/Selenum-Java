package com.test;

import com.pages.MainPage;
import com.pages.TextBoxPage;
import com.utils.DataRandom;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    /**
     *
     */
    @Test
    public void TypeAllInfoAndSubmit(){
        TextBoxPage textBoxPage = new TextBoxPage();
        MainPage mainPage = new MainPage();
        DataRandom dataRandom = new DataRandom();

        mainPage.clickOptionsButton("Elements");
        textBoxPage.clickTextBoxOption();

        String name = dataRandom.getName();
        String email = dataRandom.getEmail();
        String currentAddress = dataRandom.getAddress();
        String permanentAddress = dataRandom.getAddress();

        textBoxPage.typeAllInfoAndSubmit(name, email, currentAddress, permanentAddress);
        Assert.assertTrue(textBoxPage.isOutputFrameDisplayed());
        Assert.assertTrue(textBoxPage.getInfoName().contains(name));
        Assert.assertTrue(textBoxPage.getInfoEmail().contains(email));
    }


    /**
     *
     */
    @Test
    public void TypeIncorrectMailAndSubmit () throws InterruptedException {
        TextBoxPage textBoxPage = new TextBoxPage();
        MainPage mainPage = new MainPage();

        mainPage.clickOptionsButton("Elements");
        textBoxPage.clickTextBoxOption();

        String email = "test.com";

        textBoxPage.typeEmailAndSubmit(email);
        WebElement userEmail2 = driver.findElement(By.id("userEmail"));
        Assert.assertEquals(userEmail2.getAttribute("class"), "mr-sm-2 field-error form-control");
        new Actions(driver).moveToElement(userEmail2).build().perform();
        //Assert.assertEquals(userEmail2.getAttribute("title"), "Invalid email format");
    }
}
