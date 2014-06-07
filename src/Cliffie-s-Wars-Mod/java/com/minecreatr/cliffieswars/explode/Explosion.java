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
    protected boolean hasExploded =false;
    protected int x;
    protected int y;
    protected int z;

    public abstract void progress();

    public int getBlocksPerTick(){
        return 1400;
    }

    public boolean hasExploded(){
        return this.hasExploded;
    }
}
