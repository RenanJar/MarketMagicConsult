package com.example.MarketMagicConsult.serviceTest;

import com.example.MarketMagicConsult.DTO.MarketInputs;
import com.example.MarketMagicConsult.DTO.VerifiedObjectsDTO;
import com.example.MarketMagicConsult.service.AutomationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;


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
    }



}
