package src.campaign.econ;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.BaseCampaignEventListener;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.StarSystemAPI;

public class wp_PilgrimMovement extends BaseCampaignEventListener {
    //original movement code written by Scrinarus
    //much cleaner code refactor performed by Mezzelo

    public wp_PilgrimMovement(boolean permaRegister) {
        super(permaRegister);
    }

    private class PilgrimLocationInfo {
        private String systemName;
        private String orbitTarget;
        private float orbitDist;
        private float orbitDays;
        public PilgrimLocationInfo(String systemName, String orbitTarget, float orbitDist, float orbitDays) {
            this.systemName = systemName;
            this.orbitTarget = orbitTarget;
            this.orbitDist = orbitDist;
            this.orbitDays = orbitDays;
        }
    }
    final PilgrimLocationInfo[] systemRoute = {
            new PilgrimLocationInfo("zagan", "mazalot", 350f, 35f),
            new PilgrimLocationInfo("askonia", "volturn", 200f, 20f),
            new PilgrimLocationInfo("canaan", "gilead", 350f, 35f),
            new PilgrimLocationInfo("corvus", "jangala", 350f, 35f),
            new PilgrimLocationInfo("yma", "killa", 150f, 15f),
            new PilgrimLocationInfo("kumari kandam", "beholder_station", 100f, 10f),
            new PilgrimLocationInfo("eos exodus", "hesperus", 350f, 35f),
    };

    //handle how long the Pilgrim idles for, and changes it to move only once every interval via flags
    final float interval = 2f;
    boolean isMoved = false;

    @Override
    public void reportEconomyMonthEnd() {
        if (Global.getSector().getClock().getMonth() % interval == 0 && !isMoved) {
            SectorEntityToken wanderingPilgrimStation = Global.getSector().getEntityById("wandering_pilgrim_station");
            if (wanderingPilgrimStation == null)
                return;

            int containing = -1;
            int destination = -1;
            for (int i = 0; i < systemRoute.length && containing < 0; i++) {
                if (wanderingPilgrimStation.getContainingLocation().getId().equals(systemRoute[i].systemName)) {
                    containing = i;
                    for (int g = 1; g < systemRoute.length; g++) {
                        int searchIndex = (i + g) % systemRoute.length;
                        // logic would go in this conditional to ensure the target location is valid (i.e. no hostilities)
                        if (true) {
                            destination = searchIndex;
                            break;
                        }
                    }
                }
            }

            if (containing > -1 && destination > -1) {
                Global.getSector().getStarSystem(systemRoute[containing].systemName).removeEntity(wanderingPilgrimStation);
                Global.getSector().getStarSystem(systemRoute[destination].systemName).addEntity(wanderingPilgrimStation);
                wanderingPilgrimStation.setCircularOrbitPointingDown(
                        Global.getSector().getEntityById(systemRoute[destination].orbitTarget),
                        0.6f,
                        systemRoute[destination].orbitDist,
                        systemRoute[destination].orbitDays
                );
            }
            isMoved = true;
        }
        if (Global.getSector().getClock().getMonth() % interval == 1) {
            isMoved = false;
        }
    }
}
