package com.example.MarketMagicConsult.serviceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonServiceTest {

    String stringValue ="R$ 1,00 R$ 0,94 R$ 0,80";

    @Test
    public void StringToBigDecimalValue(){
        Pattern pattern = Pattern.compile("R\\$ (\\d+),(\\d+)");
        Matcher matcher = pattern.matcher(stringValue);
        List<BigDecimal> valuesFound = new ArrayList<>();

        while (matcher.find()){
            BigDecimal reais = new BigDecimal(matcher.group(1));
            BigDecimal centavos = new BigDecimal(matcher.group(2)).divide(BigDecimal.valueOf(100));
            BigDecimal value = reais.add(centavos);

            valuesFound.add(value.setScale(2));
        }

        BigDecimal minValue = Collections.min(valuesFound);
        Assertions.assertEquals(new BigDecimal("0.80"),minValue);
        Assertions.assertEquals(3,valuesFound.size());
    }
}
