package src;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
import src.campaign.econ.wp_DescriptionSetter;
import src.campaign.econ.wp_PilgrimMovement;
import src.world.WanderingPilgrimGen;

public class WanderingPilgrimPlugin extends BaseModPlugin{
    private static void initWanderingPilgrim() {
        new WanderingPilgrimGen().generate(Global.getSector());
    }

    @Override
    public void onNewGame() {
        //Global.getLogger(this.getClass()).info("Hooray My mod plugin in a jar is loaded!");
        initWanderingPilgrim();
    }
    @Override
    public void onGameLoad(boolean newGame)
    {
        if (!Global.getSector().getListenerManager().hasListenerOfClass(wp_DescriptionSetter.class))
            Global.getSector().getListenerManager().addListener(new wp_DescriptionSetter());
        if (!Global.getSector().getListenerManager().hasListenerOfClass(wp_PilgrimMovement.class))
            Global.getSector().getListenerManager().addListener(new wp_PilgrimMovement(true));
    }

}
