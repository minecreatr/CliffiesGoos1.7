package com.minecreatr.cliffieswars.power.inter;

import net.minecraft.world.World;

/**
 * Created on 6/7/14
 */
public interface IPowerBlock {

    public IPowerTile getPowerTile(World worldObj, int x, int y, int z);
}
