package data.hullmods;

import com.fs.starfarer.api.combat.BaseHullMod;
import com.fs.starfarer.api.combat.MutableShipStatsAPI;
import com.fs.starfarer.api.combat.ShipAPI.HullSize;
import com.fs.starfarer.api.impl.campaign.ids.Stats;

public class wp_GoliathHangar extends BaseHullMod {

        public static boolean AlLOW_CONVERTED_HANGAR = true;
        public static int CONVERTED_HANGAR_BONUS = 1;

        public void applyEffectsBeforeShipCreation(HullSize hullSize, MutableShipStatsAPI stats, String id) {
                stats.getDynamic().getMod(Stats.CONVERTED_HANGAR_MOD).modifyFlat(id, CONVERTED_HANGAR_BONUS);
                stats.getDynamic().getMod(Stats.FORCE_ALLOW_CONVERTED_HANGAR).modifyFlat(id, 1f);
                stats.getDynamic().getMod(Stats.CONVERTED_HANGAR_NO_CREW_INCREASE).modifyFlat(id, 1f);
                stats.getDynamic().getMod(Stats.CONVERTED_HANGAR_NO_REARM_INCREASE).modifyFlat(id, 1f);
                stats.getDynamic().getMod(Stats.CONVERTED_HANGAR_NO_DP_INCREASE).modifyFlat(id, 1f);
                stats.getDynamic().getMod(Stats.CONVERTED_HANGAR_NO_REFIT_PENALTY).modifyFlat(id, 1f);
        }

        public String getDescriptionParam(int index, HullSize hullSize) {
		if (index == 0) return "2";
		if (index == 1) return "4";
		return null;
	}

}