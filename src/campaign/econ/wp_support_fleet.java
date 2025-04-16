package src.campaign.econ;

import com.fs.starfarer.api.impl.campaign.econ.impl.BaseIndustry;
import com.fs.starfarer.api.impl.campaign.ids.Commodities;

public class wp_support_fleet extends BaseIndustry {
    public void apply() {
        demand(Commodities.ORGANICS, 3);
        demand(Commodities.HEAVY_MACHINERY, 3);
        demand(Commodities.SUPPLIES, 3);
        demand(Commodities.FUEL, 3);

        supply(Commodities.FOOD, 4);
        supply(Commodities.ORE, 3);
        supply(Commodities.RARE_ORE, 2);
        supply(Commodities.DOMESTIC_GOODS, 3);
    }
    @Override
    public boolean isAvailableToBuild() {
        return false;
    }
    @Override
    public boolean showWhenUnavailable() {
        return false;
    }
    @Override
    public boolean canImprove() {
        return false;
    }
}
