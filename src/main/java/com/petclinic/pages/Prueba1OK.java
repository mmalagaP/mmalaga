package com.petclinic.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Prueba1OK {

    public WebDriver driver;
    public WebDriverWait wait;

    @FindBy(partialLinkText = "Owner Information")
    private WebElement ownerLink;

    @FindBy(linkText = "Consultores")
    private WebElement buscarLink;

    public Prueba1OK(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait (driver, 30);
        PageFactory.initElements(driver, this);
    }
    public void goToFlightDetailsPage() {
        this.wait.until(ExpectedConditions.visibilityOf(this.ownerLink));
        this.buscarLink.click();
    }
}
