package com.minecreatr.cliffieswars;

import com.minecreatr.cliffieswars.explode.Explosion;
import com.minecreatr.cliffieswars.explode.NukeRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

/**
 * Created on 6/5/14
 */
public class EventHooks {


    @SubscribeEvent
    public void onTick(TickEvent event){
        if (NukeRegistry.isExploding()){
            for (int i=0;i<NukeRegistry.getExplosions().size();i++){
                Explosion explosion = NukeRegistry.getExplosions().get(i);
                if (explosion.hasExploded()){
                    NukeRegistry.getExplosions().remove(i);
                    System.out.println("Ending Nuking");

                    return;
                }
                explosion.progress();
            }
        }
    }
}
