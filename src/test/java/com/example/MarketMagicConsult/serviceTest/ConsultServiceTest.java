package com.example.MarketMagicConsult.serviceTest;

import com.example.MarketMagicConsult.DTO.VerifiedObjectsDTO;
import com.example.MarketMagicConsult.client.FlowStoreClient;
import com.example.MarketMagicConsult.service.ConsultService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ConsultServiceTest {
    @Autowired
    FlowStoreClient flowStoreClient;
    @Test
    public void mustReturnVerifiedObjects(){
        //cenario
        ConsultService consultService = Mockito.mock(ConsultService.class);
        List<String> listTest= new ArrayList<>();
        listTest.add("FANTASMA DE RAMIREZ DEPIETRO");
        listTest.add("Tasha, Unholy Archmage");
        VerifiedObjectsDTO verifiedObject = new VerifiedObjectsDTO(new ArrayList<String>(),new ArrayList<String>());
        verifiedObject.getObjectsFound().add("FANTASMA DE RAMIREZ DEPIETRO");
        verifiedObject.getObjectsNotFound().add("Tasha, Unholy Archmage");

        Mockito.when(consultService.objectScanner(listTest,flowStoreClient,"bt_comprar"))
                .thenReturn(verifiedObject);

        VerifiedObjectsDTO verifiedObjectsDTO = consultService.objectScanner(listTest,flowStoreClient,"bt_comprar");

        Assertions.assertTrue(verifiedObjectsDTO.getObjectsNotFound().contains("Tasha, Unholy Archmage"));
        Assertions.assertTrue(verifiedObjectsDTO.getObjectsFound().contains("FANTASMA DE RAMIREZ DEPIETRO"));
    }


}
