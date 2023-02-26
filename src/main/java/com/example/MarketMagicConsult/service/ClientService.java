package com.example.MarketMagicConsult.service;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public String concatenateUrl (String url, String string){
        return url.concat(string);
    }
}
