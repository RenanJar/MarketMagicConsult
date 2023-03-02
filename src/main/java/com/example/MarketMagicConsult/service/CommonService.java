package com.example.MarketMagicConsult.service;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class CommonService {

    public BigDecimal StringToBigDecimalValue(String stringValue){
        Pattern pattern = Pattern.compile("R\\$ (\\d+),(\\d+)");
        Matcher matcher = pattern.matcher(stringValue);
        List<BigDecimal> valuesFound = new ArrayList<>();

        while (matcher.find()){
            BigDecimal reais = new BigDecimal(matcher.group(1));
            BigDecimal centavos = new BigDecimal(matcher.group(2)).divide(BigDecimal.valueOf(100));
            BigDecimal value = reais.add(centavos);

            valuesFound.add(value.setScale(2));
        }
        return Collections.min(valuesFound);
    }
}
