package src.campaign.econ;

import com.fs.starfarer.api.campaign.PlayerMarketTransaction;
import com.fs.starfarer.api.campaign.econ.MarketAPI;
import com.fs.starfarer.api.campaign.listeners.ColonyInteractionListener;

public class wp_DescriptionSetter implements ColonyInteractionListener {

    public wp_DescriptionSetter() {
        super();
    }

    @Override
    public void reportPlayerOpenedMarket(MarketAPI market) {
        if (market.getFactionId().equals("luddic_church")){
            System.out.println(market.getName());
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
