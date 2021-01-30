/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devops.dxc.devops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumTest {

    @LocalServerPort
    private int port;
    private WebDriver driver;

    protected void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/seleniumdriver/chromedriver");
        driver = new ChromeDriver();
    }

    private String getHost() {
        return "http://localhost:" + port;
    }

    private void formPage() {
        if (driver == null) {
            setUp();
        }
        driver.get(getHost() + "/index.html");
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getTitle().contains("Devops"));
    }

    @Test
    public void testApp10Por100() throws Exception {

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
        inputSaldo.sendKeys("11");

        inputSueldo.click();
        inputSueldo.sendKeys("22");

        inputBoton.click();

        Thread.sleep(3000);
        driver.quit();
    }

}
