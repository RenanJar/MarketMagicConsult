package com.example.MarketMagicConsult.serviceTest;

import com.example.MarketMagicConsult.DTO.MarketInputs;
import com.example.MarketMagicConsult.DTO.VerifiedObjectsDTO;
import com.example.MarketMagicConsult.service.AutomationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;


public class AutomationSearchTest {

    List<String> objectSeach = List.of("Tranquil Thicket","Rakdos Carnarium","Forgotten Cave","Haunted Fengraf","Barren Moor","Jungle Hollow","Mountain Valley"
            ,"Golgari Rot Farm"
            ,"Blighted Woodland"
            ,"Forge of Heroes"
            ,"Gruul Turf"
            ,"Khalni Garden"
            ,"Grim Backwoods"
            ,"Bojuka Bog"
            ,"Warped Landscape"
            ,"Myriad Landscape"
            ,"Jund Panorama"
            ,"Rocky Tar Pit"
            ,"Akoum Refuge"
            ,"Kazandu Refuge"
            ,"Temple of the False God"
            ,"Savage Lands"
            ,"Evolving Wilds"
            ,"Command Tower"
            ,"Terramorphic Expanse"
            ,"Sol Ring"
            ,"Scute Mob"
            ,"Sakura-Tribe Elder"
            ,"Loyal Apprentice"
            ,"Stitch Together"
            ,"Khalni Heart Expedition"
            ,"Borderland Explorer");

    AutomationService automationService = new AutomationService();

    @Test
    public void test(){
        MarketInputs marketInputs = new MarketInputs();
        marketInputs.setUrl("https://www.flowstore.com.br/");
        marketInputs.setImputFields("//input[@class='form-control inp_busca']");
        marketInputs.setPriceLabel("//div[@class='preco_com_desconto']");
        marketInputs.setLabelObjectsName("//*[@class='btn btn-light-green product--btn']");

        VerifiedObjectsDTO verifiedObjectsDTO = automationService.automationSearch(marketInputs,objectSeach);

        Assertions.assertEquals("Agony Warp",verifiedObjectsDTO.getObjectsFound().get(0).getName());
    }



}
