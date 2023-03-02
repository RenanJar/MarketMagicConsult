package com.example.MarketMagicConsult.controller;

import com.example.MarketMagicConsult.DTO.MarketInputs;
import com.example.MarketMagicConsult.DTO.VerifiedObjectsDTO;
import com.example.MarketMagicConsult.service.AutomationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultmarket")
public class MarketMagicConsultControler {
    @Autowired
    private VerifiedObjectsDTO verifiedObjectsDTO;

    @Autowired
    private AutomationService automationService;

    @Autowired
    private MarketInputs marketInputs;

    @PostMapping("/flowstoreconsult")
    public ResponseEntity<VerifiedObjectsDTO> consultListObjectsFlowStore(@RequestBody List<String> listObjects){
        marketInputs.setUrl("https://www.flowstore.com.br/");
        marketInputs.setImputFields("//input[@class='form-control inp_busca']");
        marketInputs.setPriceLabel("//div[@class='preco_com_desconto']");
        marketInputs.setLabelObjectsName("//div[@class='nomes_cards']");

        return ResponseEntity.ok(automationService.automationSearch(marketInputs,listObjects));
}

}
