/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devops.dxc.devops;

import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author cristian
 */
@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumTest {

    @LocalServerPort
    private int port;
    private WebDriver driver;

    @BeforeAll
    public void setUp() {
        System.out.println("INICIANDO");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/seleniumdriver/chromedriver");
        driver = new ChromeDriver();
    }

    @AfterAll
    public void cerrar() {
        driver.quit();
    }

    private String getHost() {
        return "http://localhost:" + port;
    }

    private void formPage() {
        driver.get(getHost() + "/index.html");
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getTitle().contains("Devops"));
    }

    @Test
    public void cuandoSueldoEs1000000Ahorro10000000RetiroEs1000000() throws Exception {
        sendSolicitud(1000000.0, 10000000.0, 1000000.0, 0.0, 0.0);
    }

    @Test
    public void cuandoSueldoEs2000000Ahorro10000000RetiroEs8254690() throws Exception {
        sendSolicitud(2000000.0, 10000000.0, 8254690.0, 0.0, 0.0);
    }

    @Test
    public void cuandoSueldoEs2700000Ahorro10000000RetiroEs635914() throws Exception {
        sendSolicitud(2700000.0, 10000000.0, 635914.0, 0.0, 0.0);
    }

    @Test
    public void cuandoSueldoEs4700000Ahorro10000000RetiroEs19643() throws Exception {
        sendSolicitud(4700000.0, 10000000.0, 19643.0, 0.0, 0.0);
    }

    @Test
    public void cuandoSueldoEs5100000Ahorro20000000RetiroEs705948() throws Exception {
        sendSolicitud(5100000.0, 20000000.0, 705948.0, 0.0, 0.0);
    }

    @Test
    public void cuandoSueldoEs6100000Ahorro20000000RetiroEs508958() throws Exception {
        sendSolicitud(6100000.0, 20000000.0, 508958.0, 0.0, 0.0);
    }

    private void sendSolicitud(double sueldo, double saldo, double retiroEsperado, double saldoRestanteEsperado, double impuestoEsperado) {
        formPage();

        System.out.println("check saldo");
        WebElement inputSaldo = driver.findElement(By.id("saldo"));
        Assertions.assertEquals(true, inputSaldo.isDisplayed());

        System.out.println("check sueldo");
        WebElement inputSueldo = driver.findElement(By.id("sueldo"));
        Assertions.assertEquals(true, inputSueldo.isDisplayed());

        System.out.println("check boton");
        WebElement inputBoton = driver.findElement(By.id("enviar"));
        Assertions.assertEquals(true, inputBoton.isDisplayed());

        inputSaldo.click();
        inputSaldo.sendKeys(new BigDecimal(saldo).toPlainString());

        inputSueldo.click();
        inputSueldo.sendKeys(new BigDecimal(sueldo).toPlainString());

        inputBoton.click();

        try {
            Thread.sleep(200);
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
