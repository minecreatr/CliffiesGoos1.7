package com.minecreatr.cliffieswars.explode;

import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.renderer.texture.ITickable;

import java.util.ArrayList;

/**
 * Created on 6/5/14
 */
public class NukeRegistry {

    public static NukeRegistry INSTANCE = new NukeRegistry();

    private ArrayList<Explosion> explosions;

    public NukeRegistry(){
        explosions = new ArrayList<Explosion>();
    }

    public void queExplosion(Explosion explosion){
        explosions.add(explosion);
    }

    public ArrayList<Explosion> getCurrentExplosions(){
        return this.explosions;
    }

    public boolean isCurrentlyExploding(){
        return (explosions.size()!=0);
    }

    public static ArrayList<Explosion> getExplosions(){
        return INSTANCE.getCurrentExplosions();
    }

    public static boolean isExploding(){
        return INSTANCE.isCurrentlyExploding();
    }

    public static void registerExplosion(Explosion explosion){
        INSTANCE.queExplosion(explosion);
    }
}
