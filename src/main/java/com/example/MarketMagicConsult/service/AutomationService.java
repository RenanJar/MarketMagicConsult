package com.example.MarketMagicConsult.service;

import com.example.MarketMagicConsult.DTO.CardDTO;
import com.example.MarketMagicConsult.DTO.MarketInputs;
import com.example.MarketMagicConsult.DTO.VerifiedObjectsDTO;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

@Service
public class AutomationService {
    @Autowired
    private MarketInputs marketInputs;
    @Autowired
    private Logger logger;

    private CommonService commonService = new CommonService();

    public VerifiedObjectsDTO automationSearch(MarketInputs marketInputs,List<String> listObjects){

        List<CardDTO> objectsFound = new ArrayList<>();
        List<String> objectsNotFound = new ArrayList<>();

        System.setProperty("webdriver.chrome.driver", "/snap/bin/chromium.chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--remote-allow-origins=*");

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
                }).build(),options);

        webDriver.get(marketInputs.getUrl());
        webDriver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        for (String item : listObjects) {
            try {
                WebElement inputSeach = webDriver.findElement(By.xpath(marketInputs.getImputFields()));
                inputSeach.click();
                webDriver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                String textInbox = inputSeach.getText();
                if(textInbox != ""){
                    inputSeach.sendKeys(item, Keys.ENTER);
                }else{
                    inputSeach.clear();
                    inputSeach.sendKeys(item, Keys.ENTER);
                }
                List<WebElement> objectName = webDriver.findElements(By.xpath(marketInputs.getLabelObjectsName()));
                if (objectName.isEmpty()) {
                    objectsNotFound.add(item);
                    logger.info(item+" NotFound");

                } else {
                    WebElement objectValue = webDriver.findElement(By.xpath(marketInputs.getPriceLabel()));
                    CardDTO cardDTO = new CardDTO();
                    cardDTO.setName(item);
                    cardDTO.setPrice(commonService.StringToBigDecimalValue(objectValue.getText()));
                    objectsFound.add(cardDTO);
                    logger.info(item+" Found");
                }
                objectName.clear();
            } catch (NoSuchElementException e) {
                System.out.println("O elemento não foi encontrado: " + e.getMessage());
            }
        }

        webDriver.close();

        return new VerifiedObjectsDTO(objectsFound,objectsNotFound);
    }

}
