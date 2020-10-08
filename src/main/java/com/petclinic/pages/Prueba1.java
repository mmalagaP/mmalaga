package com.petclinic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Clock;

public class Prueba1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameTxt;

    @FindBy(name = "lastName")
    private WebElement lastNameTxt;

    @FindBy(name = "address")
    private WebElement addressTxt;

    @FindBy(name = "city")
    private WebElement cityTxt;

    @FindBy(name = "telephone")
    private WebElement telephoneTxt;

    @FindBy(name = "add-owner")
    private WebElement submitBtn;

    public Prueba1(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }
    public void goTo(){
        this.driver.get("http://192.168.1.55:8083/petclinic/owners/new");
        this.wait.until(ExpectedConditions.visibilityOf(this.lastNameTxt));
    }
    public void enterUserDetails(String firstName, String lastName, String address, String city, String telephone){
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
        this.addressTxt.sendKeys(address);
        this.cityTxt.sendKeys(city);
        this.telephoneTxt.sendKeys(telephone);
    }
    public void submit(){

        this.submitBtn.click();
    }
}
