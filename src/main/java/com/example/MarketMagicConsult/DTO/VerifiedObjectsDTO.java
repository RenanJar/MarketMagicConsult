package com.example.MarketMagicConsult.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class VerifiedObjectsDTO {
    private List<String> objectsFound;
    private List<String> objectsNotFound;
}
