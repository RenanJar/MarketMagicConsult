package com.example.MarketMagicConsult.service;

import com.example.MarketMagicConsult.DTO.VerifiedObjectsDTO;
import com.example.MarketMagicConsult.client.FlowStoreClient;
import com.example.MarketMagicConsult.client.MarketPlaceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ConsultService {

    @Autowired
    FlowStoreClient flowStoreClient;

    @Autowired
    VerifiedObjectsDTO verifiedObjectsDTO;

    public VerifiedObjectsDTO objectScanner(List<String> objectList,FlowStoreClient documentHtml,String validator){

        List<String> objectsFound = new ArrayList<>();
        List<String> objectsNotFound = new ArrayList<>();

        objectList.stream().forEach((item)->{

            String responseHtml = documentHtml.getFlowStore(item);
            System.out.println(responseHtml);
            if(responseHtml.contains(validator)){
                objectsFound.add(item);}
            else{
                objectsNotFound.add(item);
            }

        });

        verifiedObjectsDTO.setObjectsFound(objectsFound);
        verifiedObjectsDTO.setObjectsNotFound(objectsNotFound);

        return verifiedObjectsDTO;
    }

}
