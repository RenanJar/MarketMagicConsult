package com.example.MarketMagicConsult.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultmarket")
public class MarketMagicConsultControler {

    @GetMapping("/ok")
    public ResponseEntity<String> consult(){
        return ResponseEntity.ok("OKKOKOKOKOKOKOK");
    }

    /*
    @Autowired
    private ConsultService consultService;

    @Autowired
    private FlowStoreClient flowStoreClient;

    @Autowired
    private VerifiedObjectsDTO verifiedObjectsDTO;



  @PostMapping("/flowStoreConsult")
    public ResponseEntity<VerifiedObjectsDTO> consultListObjectsFlowStore(@RequestBody List<String> listObjects){
        verifiedObjectsDTO = consultService.objectScanner(listObjects,flowStoreClient,"bt_comprar");
        System.out.print(verifiedObjectsDTO.getObjectsFound().toString());
        return ResponseEntity.ok(verifiedObjectsDTO);
    }*/

}
