package src;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.Global;
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
}
