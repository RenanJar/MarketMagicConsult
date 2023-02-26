package com.example.MarketMagicConsult.serviceTest;

import com.example.MarketMagicConsult.service.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientServiceTest {

    ClientService clientService = new ClientService();

    @Test
    public void mustConcatenateUrl (){
        String url = "https://www.google.com.br/";
        String concatenate = "Teste";

        String urlconcatenated = clientService.concatenateUrl(url,concatenate);

        Assertions.assertEquals("https://www.google.com.br/Teste",urlconcatenated);
    }
}
