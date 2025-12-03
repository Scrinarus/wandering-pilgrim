package src.campaign.econ;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.PlayerMarketTransaction;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.campaign.listeners.ColonyInteractionListener;

public class wp_DescriptionSetter implements ColonyInteractionListener {

    public wp_DescriptionSetter() {
        super();
    }

    @Override
    public void reportPlayerOpenedMarket(MarketAPI market) {
        if (market.getId().equals("wandering_pilgrim_station")){
            
            System.out.println("We are now at the Pilgrim!");
            
            SectorEntityToken wanderingPilgrimStation = Global.getSector().getEntityById("wandering_pilgrim_station");
            System.out.println("Current Location:");
            System.out.println(wanderingPilgrimStation.getContainingLocation().getId());
            
            if (wanderingPilgrimStation.getContainingLocation().getId().equals("zagan")){
                wanderingPilgrimStation.setCustomDescriptionId("wp_pilgrim_station_mazalot");
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("askonia")) {
                wanderingPilgrimStation.setCustomDescriptionId("wp_pilgrim_station_volturn");
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("canaan")) {
                wanderingPilgrimStation.setCustomDescriptionId("wp_pilgrim_station_gilead");
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("corvus")) {
                wanderingPilgrimStation.setCustomDescriptionId("wp_pilgrim_station_jangala");
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("yma")) {
                wanderingPilgrimStation.setCustomDescriptionId("wp_pilgrim_station_killa");
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("kumari_kandam")) {
                wanderingPilgrimStation.setCustomDescriptionId("wp_pilgrim_station_beholder");
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("eos_exodus")) {
                wanderingPilgrimStation.setCustomDescriptionId("wp_pilgrim_station_hesperus");
            } else {
                wanderingPilgrimStation.setCustomDescriptionId("wp_pilgrim_station_hyperspace");
            }

        }
    }

    @Override
    public void reportPlayerClosedMarket(MarketAPI market) {

    }

    @Override
    public void reportPlayerOpenedMarketAndCargoUpdated(MarketAPI market) {

    }

    @Override
    public void reportPlayerMarketTransaction(PlayerMarketTransaction transaction) {

    }
}
