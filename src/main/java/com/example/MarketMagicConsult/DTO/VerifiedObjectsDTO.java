package com.example.MarketMagicConsult.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VerifiedObjectsDTO {
    private List<String> objectsFound;
    private List<String> objectsNotFound;
}
