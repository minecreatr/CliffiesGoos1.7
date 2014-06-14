package com.minecreatr.cliffieswars.power;

import com.minecreatr.cliffieswars.power.IPowerProvider;
import com.minecreatr.cliffieswars.power.IPowerTile;
import com.minecreatr.cliffieswars.power.BasicPowerTile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created on 6/14/14
 */
public class BasicPowerBlock extends Block implements IPowerProvider{

    public BasicPowerBlock(Material material){
        super(material);
    }


    public IPowerTile getPowerTile(World world, int x, int y, int z){
        if (world.getTileEntity(x, y, z) instanceof IPowerTile){
            return (IPowerTile) world.getTileEntity(x, y, z);
        }
        else {
            return null;
        }
    }

    public boolean hasTileEntity(int meta){
        return true;
    }

    public TileEntity createTileEntity(World world, int meta){
        return new BasicPowerTile();
    }


}
