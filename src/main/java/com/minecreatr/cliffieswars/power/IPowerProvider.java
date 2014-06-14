package com.minecreatr.cliffieswars.power;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created on 6/14/14
 */
public interface IPowerProvider {

    public IPowerTile getPowerTile(World world, int x, int y, int z);
}
