package com.example.MarketMagicConsult.service;

import com.example.MarketMagicConsult.DTO.VerifiedObjectsDTO;
import com.example.MarketMagicConsult.client.FlowStoreClient;
import com.example.MarketMagicConsult.client.MarketPlaceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultService {

    @Autowired
    FlowStoreClient flowStoreClient;

    @Autowired
    VerifiedObjectsDTO verifiedObjectsDTO;

    public VerifiedObjectsDTO objectScanner(List<String> objectList,FlowStoreClient documentHtml,String validator){

        objectList.stream().forEach((item)->{

            String reponseHtml = documentHtml.getFlowStore(item);

            if(reponseHtml.contains(validator)){
                verifiedObjectsDTO.getObjectsFound().add(item);}
            else{
                verifiedObjectsDTO.getObjectsNotFound().add(item);
            }

        });

        return verifiedObjectsDTO;
    }

}
