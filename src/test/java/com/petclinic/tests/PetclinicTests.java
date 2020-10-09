package com.petclinic.tests;

import com.petclinic.pages.Prueba1;
import com.petclinic.pages.Prueba2;
import com.tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class PetclinicTests {
    private WebDriver driver;
    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {
        String host = "172.30.176.85";
        DesiredCapabilities dc = DesiredCapabilities.chrome();

        if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        }
        if (System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }
        String testName = ctx.getCurrentXmlTest().getName();
        String completeUrl = "http://" + host + ":4444/wd/hub";
        dc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
    }

    @Test
    public void registroPruebaTest() throws InterruptedException {
        Prueba1 registroPrueba = new Prueba1(driver);
        registroPrueba.goTo();
        registroPrueba.enterUserDetails("Alonzo", "Melendez", "av 7 junio 926", "Lima", "971237313");
        Thread.sleep(1000);
        registroPrueba.submit();
    }
    @Test
    public void registroPruebaTest2() throws InterruptedException {
        Prueba2 registroPrueba2 = new Prueba2(driver);
        registroPrueba2.goTo();
        registroPrueba2.enterUserDetails("Pablo", "Alvarado", "Av. Malachosky 386", "Lima", "998685963");
        Thread.sleep(1000);
        registroPrueba2.submit();
    }
    @Test
    public void registroPruebaTest3() throws InterruptedException {
        Prueba2 registroPrueba3 = new Prueba2(driver);
        registroPrueba3.goTo();
        registroPrueba3.enterUserDetails("Jaime", "Totto", "Jr. Claude Sahut 137", "Lima", "993670123");
        Thread.sleep(1000);
        registroPrueba3.submit();
    }
    @Test
    public void registroPruebaTest4() throws InterruptedException {
        Prueba2 registroPrueba4 = new Prueba2(driver);
        registroPrueba4.goTo();
        registroPrueba4.enterUserDetails("Carlos", "Patiño", "Jr. Batallon Callo Sur 186", "Lima", "999340721");
        Thread.sleep(1000);
        registroPrueba4.submit();
    }
    @AfterTest
    public void quitBrowser(){
        this.driver.quit();
    }

}
