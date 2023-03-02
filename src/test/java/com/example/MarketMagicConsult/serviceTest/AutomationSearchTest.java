package com.example.MarketMagicConsult.serviceTest;

import com.example.MarketMagicConsult.DTO.CardDTO;
import com.example.MarketMagicConsult.DTO.MarketInputs;
import com.example.MarketMagicConsult.DTO.VerifiedObjectsDTO;
import com.example.MarketMagicConsult.service.AutomationService;
import com.example.MarketMagicConsult.service.CommonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AutomationSearchTest {

    AutomationService automationService = new AutomationService();
    List<String> objectSeach = List.of("Agony Warp","Arcane Denial","Arcane Signet","Arcum's Astrolabe");

    @Test
    public void test(){
        MarketInputs marketInputs = new MarketInputs();
        marketInputs.setUrl("https://www.flowstore.com.br/");
        marketInputs.setImputFields("//input[@class='form-control inp_busca']");
        marketInputs.setPriceLabel("//div[@class='preco_com_desconto']");
        marketInputs.setLabelObjectsName("//div[@class='nomes_cards']");

        VerifiedObjectsDTO verifiedObjectsDTO = automationService.automationSearch(marketInputs,objectSeach);

        Assertions.assertEquals("Agony Warp",verifiedObjectsDTO.getObjectsFound().get(0).getName());

        /*

        System.setProperty("webdriver.chrome.driver", "/snap/bin/chromium.chromedriver");
        WebDriver webDriver = new ChromeDriver(
                (ChromeDriverService)(new ChromeDriverService.Builder() {
                    @Override
                    protected File findDefaultExecutable() {
                        if (new File("/snap/bin/chromium.chromedriver").exists()) {
                            return new File("/snap/bin/chromium.chromedriver") {
                                @Override
                                public String getCanonicalPath() throws IOException {
                                    return this.getAbsolutePath();
                                }
                            };
                        } else {
                            return super.findDefaultExecutable();
                        }
                    }
                }).build());

        List<CardDTO> objectFound= new ArrayList<>();
        List<String> objectNotFound= new ArrayList<>();

        webDriver.get("https://www.flowstore.com.br/");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        for (String item : objectSeach) {
            try {
                WebElement inputSeach = webDriver.findElement(By.xpath("//input[@class='form-control inp_busca']"));
                inputSeach.click();
                webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                String textInbox =inputSeach.getText();
                if(textInbox != ""){
                    inputSeach.sendKeys(item, Keys.ENTER);
                }else{
                    inputSeach.clear();
                    inputSeach.sendKeys(item, Keys.ENTER);
                }
                List<WebElement> objectName = webDriver.findElements(By.xpath("//div[@class='nomes_cards']"));
                if (objectName.isEmpty()) {
                    objectNotFound.add(item);
                } else {
                    WebElement objectValue = webDriver.findElement(By.xpath("//div[@class='preco_com_desconto']"));

                    CardDTO cardDTO = new CardDTO();
                    cardDTO.setName(item);
                    cardDTO.setPrice(commonService.StringToBigDecimalValue(objectValue.getText()));

                    objectFound.add(cardDTO);
                }
                objectName.clear();
            } catch (NoSuchElementException e) {

                System.out.println("O elemento não foi encontrado: " + e.getMessage());
            }

        }


        webDriver.close();

         */
    }



}
