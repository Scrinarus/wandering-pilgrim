package src.world;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.SectorAPI;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.StarSystemAPI;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.impl.campaign.ids.Conditions;
import com.fs.starfarer.api.impl.campaign.ids.Industries;
import com.fs.starfarer.api.impl.campaign.ids.Submarkets;

import java.util.ArrayList;
import java.util.Arrays;

public class WanderingPilgrimGen {
    public static void generate(SectorAPI sector) {
        //distance setting
        final float pilgrimDistMazalot = 350f;
        //target Mazalot in Zagan and put Pilgrim in Orbit
		StarSystemAPI system = Global.getSector().getStarSystem("Zagan");
        SectorEntityToken wanderingPilgrimStation = system.addCustomEntity("wandering_pilgrim_station", "Wandering Pilgrim", "wp_pilgrim", "luddic_church");
        wanderingPilgrimStation.setCircularOrbitPointingDown(system.getEntityById("mazalot"), 0.6f, pilgrimDistMazalot, 40f);
        wanderingPilgrimStation.setCustomDescriptionId("wp_pilgrim_station_hyperspace");

        //generate appropriate market
        MarketAPI wanderingPilgrimMarket = addMarketplace.addMarketplace("luddic_church",wanderingPilgrimStation,
                null,
                "Wandering Pilgrim",
                4,
                new ArrayList(Arrays.asList(
                        Conditions.POPULATION_4,
                        Conditions.LUDDIC_MAJORITY,
                        Conditions.OUTPOST)),
                new ArrayList(Arrays.asList(
                        Industries.POPULATION,
                        Industries.SPACEPORT,
                        Industries.COMMERCE,
                        "wp_support_fleet",
                        "wp_home_guard"
                        )),
                new ArrayList(Arrays.asList(
                        Submarkets.SUBMARKET_OPEN,
                        Submarkets.SUBMARKET_BLACK,
                        Submarkets.SUBMARKET_STORAGE)),
                0.3f
                );

    }
}
