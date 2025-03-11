package com.test;

import com.pages.TextBoxPage;
import com.utils.DataRandom;
import org.junit.Assert;
import org.testng.annotations.Test;

public class TextBoxTest extends BaseTest {

    /**
     *
     */
    @Test
    public void TypeAllInfoAndSubmit(){
        TextBoxPage textBoxPage = new TextBoxPage();
        DataRandom dataRandom = new DataRandom();

        String name = dataRandom.getName();
        String email = dataRandom.getEmail();
        String currentAddress = dataRandom.getAddress();
        String permanentAddress = dataRandom.getAddress();

        textBoxPage.typeAllInfoAndSubmit(name, email, currentAddress, permanentAddress);
        Assert.assertTrue(textBoxPage.isOutputFrameDisplayed());
        Assert.assertTrue(textBoxPage.getInfoName().contains(name));
        Assert.assertTrue(textBoxPage.getInfoEmail().contains(email));
    }
}
