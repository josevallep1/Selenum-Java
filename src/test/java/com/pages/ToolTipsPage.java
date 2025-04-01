package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.test.BaseTest.clickElement;
import static com.test.BaseTest.driver;

public class ToolTipsPage {
    @FindBy(xpath = "//span[contains(text(),'Tool Tips')]")
    public WebElement toolTipsOption;

    @FindBy (id = "toolTipButton")
    public WebElement toolTipButton;

    // constructor with PageFactory to initiate all the page objects
    public ToolTipsPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickToolTipsOption() {
        clickElement(toolTipsOption);
    }

    public String getToolTipButton() {
        new Actions(driver).moveToElement(toolTipButton).build().perform();
        return toolTipButton.getAttribute("title");
    }
}
