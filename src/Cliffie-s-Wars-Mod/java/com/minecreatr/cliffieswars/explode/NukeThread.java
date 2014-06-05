package com.minecreatr.cliffieswars.explode;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.io.InputStream;

/**
 * Created on 6/4/14
 */
public class NukeThread extends Thread{

    private World worldObj;
    private double posX;
    private double posY;
    private double posZ;
    private int radius;

    public NukeThread(World worldObj, double x, double y, double z, int radius){
        this.worldObj = worldObj;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.radius = radius;
    }

    public void run(){
        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++){
                    Block block = worldObj.getBlock(x, y, z);
                    if (block != Blocks.bedrock){
                        worldObj.setBlock((int) (x+posX), (int) (y+posY), (int) (z+posZ), Blocks.air);
                    }
                }
            }
        }
    }
}
