package com.minecreatr.cliffieswars.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;

/**
 * Created on 6/9/14
 */
public class BunkerBusterEntity extends NukeEntity{

    public BunkerBusterEntity(World par1World, double par2, double par4, double par6, EntityLivingBase par8EntityLivingBase){
        super(par1World, par2, par4, par6, par8EntityLivingBase);
    }

    @Override
    protected void explode(){

    }
}
