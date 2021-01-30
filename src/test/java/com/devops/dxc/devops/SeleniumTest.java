/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devops.dxc.devops;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;

/**
 *
 * @author cristian
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class SeleniumTest {

    @LocalServerPort
    private int port;

    private String getHost() {
        return "http://localhost:" + port;
    }

    @Test
    public void testApp10Por100() throws Exception {

        Thread.sleep(5000);
        System.out.println("Probando");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/seleniumdriver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(getHost() + "/index.html");
        (new WebDriverWait(driver, 10)).until((ExpectedCondition<Boolean>) (WebDriver d) -> d.getTitle().contains("Devops"));

        driver.quit();
    }

}
