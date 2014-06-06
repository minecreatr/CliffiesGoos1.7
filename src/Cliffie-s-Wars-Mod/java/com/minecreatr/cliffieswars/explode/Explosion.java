package com.minecreatr.cliffieswars.explode;

import net.minecraft.world.World;

import java.util.Random;

/**
 * Created on 6/5/14
 */
public abstract class Explosion {
    protected World worldObj;
    protected double posX;
    protected double posY;
    protected double posZ;
    protected int power;
    protected int radius;
    protected Random random;
    public int curX = 0;
    public int curY = 0;
    public int curZ = 0;
    protected boolean hasExploded =false;

    public abstract void progress();

    public int getBlocksPerTick(){
        return 64;
    }

    public boolean hasExploded(){
        return this.hasExploded;
    }
}
