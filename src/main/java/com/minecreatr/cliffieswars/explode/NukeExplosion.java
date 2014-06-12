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
        this.x=-radius;
        this.y=-radius;
        this.z=-radius;
    }




//    public void progress(){
//        int bpt = this.getBlocksPerTick();
//        int bc = 0;
//        out:
//        for (;x <= radius; x++) {
//            for (;y <= radius; y++) {
//                for (;z <= radius; z++){
//                    if (bc>=bpt){
//                        break out;
//                    }
//                    int absDistance = MathHelper.getDistance(x, y, z);
//                    Block block = worldObj.getBlock((int)(x+posX), (int)(y+posY), (int)(z+posZ));
//                    int ran = random.nextInt(10);
//                    int minRes = power-(absDistance*2)-ran;
//                    int tempX = (int)(x+posX);
//                    int tempY = (int)(y+posY);
//                    int tempZ = (int)(z+posZ);
//
//                    if (block.getExplosionResistance(entity) <= minRes){
//                        worldObj.setBlock((int) (x+posX), (int) (y+posY), (int) (z+posZ), Blocks.air);
//                    }
//                    bc++;
//                }
//                z=-radius;
//            }
//            y=-radius;
//        }
//        if (x>=radius&&y>=radius&&z>=radius){
//            this.hasExploded=true;
//        }
//        System.out.println("I'm Ticked!! >:(");
//    }

    public void progress()
    {
        int blocks = 0;
        int blocksPerTick = this.getBlocksPerTick();
        while(blocks<=blocksPerTick && !this.hasExploded)
        {
            if(x<=radius && y<=radius && z<=radius)
            {
                execute(x, y, z);
                blocks++;
                z++;
            }
            else if(z>radius)
            {
                z = -radius;
                y++;
            }
            else if(y>radius)
            {
                y = -radius;
                x++;
            }
            else if(x>radius)
            {
                this.hasExploded = true;
            }
            else
            {
                //DIVIDE BY CHEESE
            }

        }
    }

    private void execute(int x, int y, int z){
        int absDistance = MathHelper.getDistance(x, y, z);
        Block block = worldObj.getBlock((int)(x+posX), (int)(y+posY), (int)(z+posZ));
        int ran = random.nextInt(10);
        int minRes = power-(absDistance*2)-ran;
        if (block.getExplosionResistance(entity) <= minRes){
            worldObj.setBlock((int) (x+posX), (int) (y+posY), (int) (z+posZ), Blocks.air);
        }
    }
}
