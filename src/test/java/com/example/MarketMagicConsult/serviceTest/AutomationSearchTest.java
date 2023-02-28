package com.example.MarketMagicConsult.serviceTest;

import com.example.MarketMagicConsult.DTO.VerifiedObjectsDTO;
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

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AutomationSearchTest {

    List<String> objectSeach = List.of("Agony Warp","Arcane Denial","Arcane Signet","Arcum's Astrolabe","Ash Barrens","Barren Moor","Bojuka Bog","Brainstorm","Brine Shaman","Clairvoyance","Coffin Purge","Command Tower",
            "Compulsive Research","Consider","Counterspell","Death Rattle","Deep Analysis","Deep Freeze","Dimir Aqueduct","Dimir Infiltrator","Dimir Signet","Dispel",
            "Dispersal Shield","Dizzy Spell","Doom Blade","Drift of Phantasms","Everflowing Chalice","Evolving Wilds","Exclude",
            "Executioner's Capsule","Faerie Macabre","Fellwar Stone","Forbidden Alchemy","Gempalm Polluter","Ghost of Ramirez DePietro","Gitaxian Probe","Go for the Throat","Honored Heirloom","Ice Tunnel","Innocent Blood","Into the Roil","Kasmina's Transmutation",
            "Keep Watch","Logic Knot","Lonely Sandbar","Merchant Scroll","Mind Stone","Muddle the Mixture","Mystic Sanctuary","Mystical Teachings","Nightscape Familiar","Opal Palace","Oubliette",
            "Path of Ancestry","Peek","Perplex","Pieces of the Puzzle","Ponder","Preordain","Relic of Progenitus","Serum Visions","Shred Memory","Star Compass","Strategic Planning","Syphon Mind","Tasigur's Cruelty","Terramorphic Expanse",
            "Think Twice","Thought Vessel","Tormod, the Desecrator","Treasure Cruise","Trinket Mage","Vault of Whispers","Vendetta","Victim of Night");

    @Test
    public void test(){
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

        /*List<String> objectSearch = new ArrayList<>();
        objectSearch.add("TORMOD, O PROFANADOR");
        objectSearch.add("Tasha, Unholy Archmage");
        objectSearch.add("GHOST OF RAMIREZ DEPIETRO");*/

        List<String> objectFound= new ArrayList<>();
        List<String> objectNotFound= new ArrayList<>();


        webDriver.get("https://www.flowstore.com.br/");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        for (String item : objectSeach) {
            try {
                WebElement inputSeach = webDriver.findElement(By.xpath("//input[@class='form-control inp_busca']"));
                inputSeach.click();
                webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                String textinbox =inputSeach.getText();
                if(textinbox != ""){
                    inputSeach.sendKeys(item, Keys.ENTER);
                }else{
                    inputSeach.clear();
                    inputSeach.sendKeys(item, Keys.ENTER);
                }
                List<WebElement> objectName = webDriver.findElements(By.xpath("//div[@class='nomes_cards']"));
                if (objectName.isEmpty()) {
                    objectNotFound.add(item);
                } else {
                    objectFound.add(item);
                }
                objectName.clear();
            } catch (NoSuchElementException e) {

                System.out.println("O elemento não foi encontrado: " + e.getMessage());
            }

        }


        webDriver.close();
        System.out.println(objectFound.toString());
        System.out.println(objectNotFound.toString());
    }



}
