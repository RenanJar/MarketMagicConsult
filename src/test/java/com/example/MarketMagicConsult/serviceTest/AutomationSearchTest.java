package com.example.MarketMagicConsult.serviceTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Properties;

public class AutomationSearchTest {

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "/snap/bin/chromium.chromedriver");
        navegar.get("https://www.google.com.br/");
    }
}
