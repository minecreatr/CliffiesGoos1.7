package com.minecreatr.cliffieswars;

import com.minecreatr.cliffieswars.explode.Explosion;
import com.minecreatr.cliffieswars.explode.NukeRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraftforge.event.CommandEvent;

import java.util.Iterator;

/**
 * Created on 6/5/14
 */
public class EventHooks {


    @SubscribeEvent
    public void onTick(TickEvent.ServerTickEvent event){
        if (NukeRegistry.isExploding()){
            Iterator<Explosion> i = NukeRegistry.getExplosions().iterator();
            while(i.hasNext()){
                Explosion explosion = i.next();
                if (explosion.hasExploded()){
                    System.out.println("Ending Nuking");
                    i.remove();
                    return;
                }
                explosion.progress();
            }
        }
    }
}
