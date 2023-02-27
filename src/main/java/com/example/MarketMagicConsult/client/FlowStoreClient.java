package com.example.MarketMagicConsult.client;

import com.example.MarketMagicConsult.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class FlowStoreClient {

    @Autowired
    ClientService clientService;
    String url= "https://www.flowstore.com.br/?view=ecom%2Fitens&id=82238&searchExactMatch=&busca=";

    public String getFlowStore(String nameItem) {

        RestTemplate restTemplate = new RestTemplate();
        String urlConsult = clientService.concatenateUrl(url, nameItem);
        System.out.println(urlConsult);

        return restTemplate.getForObject(urlConsult, String.class);
    }




}
