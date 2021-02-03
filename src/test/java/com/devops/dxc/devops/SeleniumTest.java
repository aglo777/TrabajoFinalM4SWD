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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
@TestMethodOrder(OrderAnnotation.class)
@Tag("functional")
public class SeleniumTest {

    @LocalServerPort
    private int port;
    private WebDriver driver;

    @BeforeAll
    public void setUp() throws Exception {

        if (org.apache.commons.lang.SystemUtils.IS_OS_MAC) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/seleniumdriver/chromedriver");
        } else if (org.apache.commons.lang.SystemUtils.IS_OS_WINDOWS) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/seleniumdriver/chromedriver_windows.exe");
        } else if (org.apache.commons.lang.SystemUtils.IS_OS_LINUX) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/seleniumdriver/chromedriver_linux");
        } else {
            throw new Exception("No soportado");
        }
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--no-sandbox");
        opt.addArguments("--headless");
        driver = new ChromeDriver(opt);

        formPage();
    }

    @AfterAll
    public void cerrar() {
        //driver.quit();
    }

    private String getHost() {
        return "http://localhost:" + port;
    }

    private void formPage() {
        driver.get(getHost() + "/index.html");
        sleep(1000);
        (new WebDriverWait(driver, 15)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getTitle().contains("DEVOPS"));

        sleep(3000);
    }

    @Test
    @Order(1)
    public void cuandoSueldoEs1000000Ahorro10000000RetiroEs1000000MetodoCalcula10() throws Exception {
        sendSolicitud(3400000.0, 10000000.0, 387604.0, 9612396.0, 612396.0);
    }

    @Test
    @Order(2)
    public void cuandoSueldoEs2000000Ahorro10000000RetiroEs8254690MetodoCalcula10() throws Exception {
        sendSolicitud(2000000.0, 10000000.0, 825469.0, 9174531.0, 174531.0);
    }

    @Test
    @Order(3)
    public void cuandoSueldoEs3400000Ahorro10000000RetiroEs387604MetodoCalcula10() throws Exception {
        sendSolicitud(3400000.0, 10000000.0, 387604.0, 9612396.0, 612396.0);
    }

    @Test
    @Order(4)
    public void cuandoSueldoEs4700000Ahorro10000000RetiroEs19643MetodoCalcula10() throws Exception {
        sendSolicitud(4700000.0, 10000000.0, 19643.0, 9980357.0, 980357.0);
    }

    @Test
    @Order(5)
    public void cuandoSueldoEs6100000Ahorro20000000RetiroEs508958MetodoCalcula10() throws Exception {
        sendSolicitud(6100000.0, 20000000.0, 508958.0, 19491042, 1491042.0);
    }

    @Test
    @Order(6)
    public void cuandoSueldoEs5100000Ahorro20000000RetiroEs705948MetodoCalcula10() throws Exception {
        sendSolicitud(5100000.0, 20000000.0, 705948.0, 19294052.0, 1294052.0);
    }

    @Test
    @Order(7)
    public void cuandoSueldoEs2700000Ahorro10000000RetiroEs635914MetodoCalcula10() throws Exception {
        sendSolicitud(2700000.0, 10000000.0, 635914.0, 9364086.0, 364086.0);
    }

    @Test
    @Order(8)
    public void testInputLetras() {
        testErrorInput("aa", "bb");
    }

    @Test
    @Order(9)
    public void testInputNegativos() {
        testErrorInput("-1", "-2");
    }

    private void testErrorInput(String strSaldo, String strSueldo) {
        formPage();
        WebElement inputSaldo = driver.findElement(By.id("saldo"));
        Assertions.assertEquals(true, inputSaldo.isDisplayed());

        // System.out.println("check sueldo");
        WebElement inputSueldo = driver.findElement(By.id("sueldo"));
        Assertions.assertEquals(true, inputSueldo.isDisplayed());

        //System.out.println("check boton");
        WebElement inputBoton = driver.findElement(By.id("calcular"));
        Assertions.assertEquals(true, inputBoton.isDisplayed());

        inputSaldo.click();
        inputSaldo.sendKeys(strSaldo);

        inputSueldo.click();
        inputSueldo.sendKeys(strSueldo);

        try {
            inputBoton.click();
        } catch (org.openqa.selenium.UnhandledAlertException e) {
            String textAlert = driver.switchTo().alert().getText();
            System.out.println("TextAlert: " + textAlert.trim());
            Assertions.assertEquals(true, textAlert.trim().contains("Hubo un problema"));
        }
    }

    private void sendSolicitud(double sueldo, double saldo, double retiroEsperado, double saldoRestanteEsperado, double impuestoEsperado) {

        //formPage();
        //System.out.println("check saldo");
        System.out.println("Check Saldo");
        WebElement inputSaldo = driver.findElement(By.id("saldo"));
        inputSaldo.clear();
        Assertions.assertEquals(true, inputSaldo.isDisplayed());

        System.out.println("Check sueldo");
        WebElement inputSueldo = driver.findElement(By.id("sueldo"));
        inputSueldo.clear();
        Assertions.assertEquals(true, inputSueldo.isDisplayed());

        System.out.println("Check boton");
        WebElement inputBoton = driver.findElement(By.id("calcular"));
        Assertions.assertEquals(true, inputBoton.isDisplayed());

        inputSaldo.click();
        inputSaldo.sendKeys(new BigDecimal(saldo).toPlainString());

        inputSueldo.click();
        inputSueldo.sendKeys(new BigDecimal(sueldo).toPlainString());

        System.out.println("Clic boton consulta");
        inputBoton.click();
        System.out.println("Esperando 2.5 segundos");
        sleep(2500);

        try {
            System.out.println("Esperando div con resultados");
            (new WebDriverWait(driver, 5)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("resultado")).isDisplayed());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SOURCE ERROR: " + driver.getPageSource());
        }
        System.out.println("Resultados encontrados:");
        String resultadoRetiro = driver.findElement(By.id("resp_dxc")).getText();
        String resultadoImpuesto = driver.findElement(By.id("resp_impuesto")).getText();
        String resultadoSaldo = driver.findElement(By.id("resp_saldo")).getText();

        System.out.println("Resultado Retiro: " + resultadoRetiro);
        System.out.println("Resultado Impuesto: " + resultadoImpuesto);
        System.out.println("Resultado Saldo: " + resultadoSaldo);
        Assertions.assertEquals(Double.parseDouble(resultadoRetiro), retiroEsperado);
        Assertions.assertEquals(Double.parseDouble(resultadoImpuesto), impuestoEsperado);
        Assertions.assertEquals(Double.parseDouble(resultadoSaldo), saldoRestanteEsperado);

        System.out.println("Clic en volver");
        driver.findElement(By.id("volver")).click();
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.findElement(By.id("formulario")).isDisplayed());
        System.out.println("Fin prueba");
    }

    private void sleep(int s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException ex) {
            Logger.getLogger(SeleniumTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
