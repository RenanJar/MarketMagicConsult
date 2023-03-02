package com.example.MarketMagicConsult.DTO;

import lombok.*;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardDTO {
    private String name;
    private BigDecimal price;

}
