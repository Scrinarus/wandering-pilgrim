package src.campaign.econ;

import com.fs.starfarer.api.Global;
import com.fs.starfarer.api.campaign.BaseCampaignEventListener;
import com.fs.starfarer.api.campaign.SectorEntityToken;
import com.fs.starfarer.api.campaign.StarSystemAPI;

public class wp_PilgrimMovement extends BaseCampaignEventListener {
    public wp_PilgrimMovement(boolean permaRegister) {
        super(permaRegister);
    }

    @Override
    public void reportEconomyMonthEnd() {
        //distance setting
        final float pilgrimDistMazalot = 350f;
        final float pilgrimDistVolturn = 350f;
        final float pilgrimDistGilead = 350f;
        final float pilgrimDistJangala = 350f;
        final float pilgrimDistKilla = 350f;
        final float pilgrimDistBeholder = 350f;
        final float pilgrimDistHesperus = 350f;
        boolean movedPilgrim = false;
        if (Global.getSector().getClock().getDay() == 1 && !movedPilgrim) {
            System.out.println("Pilgrim movement in progress!");

            //all potential systems with the Pilgrim in them
            StarSystemAPI zagan = Global.getSector().getStarSystem("Zagan");
            StarSystemAPI askonia = Global.getSector().getStarSystem("Askonia");
            StarSystemAPI canaan = Global.getSector().getStarSystem("Canaan");
            StarSystemAPI corvus = Global.getSector().getStarSystem("Corvus");
            StarSystemAPI yma = Global.getSector().getStarSystem("Yma");
            StarSystemAPI kumari = Global.getSector().getStarSystem("Kumari_Kandam");
            StarSystemAPI exodus = Global.getSector().getStarSystem("Eos_Exodus");
            //find the pilgrim
            SectorEntityToken wanderingPilgrimStation = Global.getSector().getEntityById("wandering_pilgrim_station");

            //move the Pilgrim
            if (wanderingPilgrimStation.getContainingLocation().getId().equals("zagan")) {
                zagan.removeEntity(wanderingPilgrimStation);
                askonia.addEntity(wanderingPilgrimStation);
                wanderingPilgrimStation.setCircularOrbitPointingDown(Global.getSector().getEntityById("volturn"), 0.6f, pilgrimDistVolturn, 40f);
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("askonia")) {
                askonia.removeEntity(wanderingPilgrimStation);
                canaan.addEntity(wanderingPilgrimStation);
                wanderingPilgrimStation.setCircularOrbitPointingDown(Global.getSector().getEntityById("gilead"), 0.6f, pilgrimDistGilead, 40f);
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("canaan")) {
                canaan.removeEntity(wanderingPilgrimStation);
                corvus.addEntity(wanderingPilgrimStation);
                wanderingPilgrimStation.setCircularOrbitPointingDown(Global.getSector().getEntityById("jangala"), 0.6f, pilgrimDistJangala, 40f);
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("corvus")) {
                corvus.removeEntity(wanderingPilgrimStation);
                yma.addEntity(wanderingPilgrimStation);
                wanderingPilgrimStation.setCircularOrbitPointingDown(Global.getSector().getEntityById("killa"), 0.6f, pilgrimDistKilla, 40f);
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("yma")) {
                yma.removeEntity(wanderingPilgrimStation);
                kumari.addEntity(wanderingPilgrimStation);
                wanderingPilgrimStation.setCircularOrbitPointingDown(Global.getSector().getEntityById("beholder_station"), 0.6f, pilgrimDistBeholder, 40f);
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("kumari_kandam")) {
                kumari.removeEntity(wanderingPilgrimStation);
                exodus.addEntity(wanderingPilgrimStation);
                wanderingPilgrimStation.setCircularOrbitPointingDown(Global.getSector().getEntityById("hesperus"), 0.6f, pilgrimDistHesperus, 40f);
            } else if (wanderingPilgrimStation.getContainingLocation().getId().equals("eos_exodus")) {
                exodus.removeEntity(wanderingPilgrimStation);
                zagan.addEntity(wanderingPilgrimStation);
                wanderingPilgrimStation.setCircularOrbitPointingDown(Global.getSector().getEntityById("mazalot"), 0.6f, pilgrimDistMazalot, 40f);
            }
            movedPilgrim = true;
            System.out.println("Pilgrim new location:");
            System.out.println(wanderingPilgrimStation.getContainingLocation().getId());
        }

        if (Global.getSector().getClock().getDay() == 15){
            System.out.println("Pilgrim status reset!");
            movedPilgrim = false;
        }
    }
}
