package com.test;

import com.pages.MainPage;
import com.pages.ToolTipsPage;
import org.junit.Assert;
import org.testng.annotations.Test;

public class ToolTipsTest extends BaseTest {

    /**
     *
     */
    @Test
    public void GetTooTipByButton () {
        ToolTipsPage toolTipsPage = new ToolTipsPage();
        MainPage mainPage = new MainPage();

        mainPage.clickOptionsButton("Widgets");
        toolTipsPage.clickToolTipsOption();

        Assert.assertEquals(toolTipsPage.getToolTipButton(), "Invalid email format");
    }
}
