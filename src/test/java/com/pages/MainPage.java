package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.test.BaseTest.clickElement;
import static com.test.BaseTest.driver;

public class MainPage {
    @FindBy(xpath = "//h5[contains(text(),'Elements')]")
    public WebElement elementsButton;

    @FindBy(xpath = "//h5[contains(text(),'Widgets')]")
    public WebElement widgetsButton;

    // constructor with PageFactory to initiate all the page objects
    public MainPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOptionsButton(String option) {
        switch (option) {
            case "Elements":
                clickElement(elementsButton);
                break;
            case "Widgets":
                clickElement(widgetsButton);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + option);
        }
    }
}
