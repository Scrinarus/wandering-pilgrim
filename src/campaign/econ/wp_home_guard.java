package src.campaign.econ;

import com.fs.starfarer.api.impl.campaign.econ.impl.OrbitalStation;

public class wp_home_guard extends OrbitalStation {
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
