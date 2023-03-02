package com.example.MarketMagicConsult.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class MarketInputs {
    String url;
    String imputFields;
    String labelObjectsName;
    String priceLabel;

}
