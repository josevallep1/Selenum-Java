package com.pages;

import com.test.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TextBoxPage extends BaseTest {
    @FindBy(xpath = "//span[contains(text(),'Text Box')]")
    public WebElement textBoxOption;

    @FindBy(id = "userName")
    public WebElement nameText;

    @FindBy(id = "userEmail")
    public WebElement userEmailText;

    @FindBy(id = "currentAddress")
    public  WebElement currentAddressText;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressText;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "output")
    public WebElement outputFrame;

    @FindBy(id = "name")
    public WebElement lb_name;

    @FindBy(id = "email")
    public WebElement lb_mail;


    // constructor with PageFactory to initiate all the page objects
    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickTextBoxOption() {
        clickElement(textBoxOption);
    }

    public void typeAllInfoAndSubmit(String name, String mail, String currentAddress, String permanentAddress) {
        typeField(nameText,name);
        typeField(userEmailText,mail);
        typeField(currentAddressText,currentAddress);
        typeField(permanentAddressText,permanentAddress);
        clickElement(submitButton);
    }

    public boolean isOutputFrameDisplayed() {
       return outputFrame.isDisplayed();
    }

    public String getInfoName(){
        return lb_name.getText();
    }

    public String getInfoEmail(){
        return lb_mail.getText();
    }

    public void typeEmailAndSubmit(String mail) {
        typeField(userEmailText,mail);
        clickElement(submitButton);
    }
}
