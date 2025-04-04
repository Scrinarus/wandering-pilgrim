package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;

public class wp_HandwroughtArmor extends BaseHullMod {
	public static float HANDWROUGHT_REDUCTION = -5000f;
    
    public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
        stats.getArmorBonus().modifyFlat(id, (Float) HANDWROUGHT_REDUCTION);
    }

    public String getDescriptionParam(int index, HullSize hullSize) {
		if (index == 0) return "5000";
		return null;
	}
}