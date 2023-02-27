package com.example.MarketMagicConsult;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MarketMagicConsultApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketMagicConsultApplication.class, args);

	}

}
