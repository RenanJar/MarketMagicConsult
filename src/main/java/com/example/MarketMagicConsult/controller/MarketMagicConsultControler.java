package com.example.MarketMagicConsult.controller;

import com.example.MarketMagicConsult.DTO.VerifiedObjectsDTO;
import com.example.MarketMagicConsult.client.FlowStoreClient;
import com.example.MarketMagicConsult.service.ConsultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consultmarket")
public class MarketMagicConsultControler {

    @Autowired
    private ConsultService consultService;

    @Autowired
    private FlowStoreClient flowStoreClient;

    @Autowired
    private VerifiedObjectsDTO verifiedObjectsDTO;

    @PostMapping("/flowstoreconsult")
    public ResponseEntity<VerifiedObjectsDTO> consultListObjectsFlowStore(@RequestBody List<String> listObjects){

        return ResponseEntity.ok(verifiedObjectsDTO);
}

}
