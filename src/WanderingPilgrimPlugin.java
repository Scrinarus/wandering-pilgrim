package src;

import com.fs.starfarer.api.BaseModPlugin;
import com.fs.starfarer.api.EveryFrameScript;
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
    @Override
    public void onGameLoad(boolean newGame)
    {
        Global.getSector().addTransientScript(new WanderingPilgrimPlugin.exampleEveryFrameScript());
    }

    public class exampleEveryFrameScript implements EveryFrameScript {

        @Override
        public boolean isDone()
        {
            return false;
        }

        @Override
        public boolean runWhilePaused()
        {
            return false;
        }

        @Override
        public void advance(float amount)
        {
            System.out.println("here's a message!");
        }
    }

}
