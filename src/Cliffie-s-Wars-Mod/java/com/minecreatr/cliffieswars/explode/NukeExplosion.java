package com.minecreatr.cliffieswars.explode;

import com.minecreatr.cliffieswars.entity.NukeEntity;
import com.minecreatr.cliffieswars.util.MathHelper;
import net.minecraft.block.*;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;


/**
 * Created on 6/4/14
 */
public class NukeExplosion extends Explosion{


    private NukeEntity entity;

    public NukeExplosion(World worldObj, double x, double y, double z, int power, NukeEntity entity){
        this.worldObj = worldObj;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.power = power;
        this.entity = entity;
        this.random = new Random();
        this.radius = MathHelper.getRadiusFromPower(power);
    }

    public void progress(){
        int bpt = this.getBlocksPerTick();
        int bc = 0;
        int x;
        int y;
        int z;
        if (this.curX!=0||this.curY!=0||this.curZ!=0){
            x=curX;
            y=curY;
            z=curZ;
        }
        else {
            x=-radius;
            y=-radius;
            z=-radius;
        }
        out:
        for (;x <= radius; x++) {
            for (;y <= radius; y++) {
                for (;z <= radius; z++){
                    if (bc>=bpt){
                        saveData(x, y, z);
                        break out;
                    }
                    int absDistance = MathHelper.getDistance(x, y, z);
                    Block block = worldObj.getBlock(x, y, z);
                    int ran = random.nextInt(10);
                    int minRes = power-absDistance-ran;
                    if (block.getExplosionResistance(entity) <= minRes){
                        worldObj.setBlock((int) (x+posX), (int) (y+posY), (int) (z+posZ), Blocks.air);
                    }
                    bc++;
                }
            }
        }
        if (x<=radius&&y<=radius&&z<=radius){
            this.hasExploded=true;
        }
    }

    private void saveData(int x, int y, int z){
        this.curX=x;
        this.curY=y;
        this.curZ=z;
    }
}
