package com.minecreatr.cliffieswars.power;

import com.minecreatr.cliffieswars.power.inter.IPowerBlock;
import com.minecreatr.cliffieswars.power.inter.IPowerTile;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created on 6/11/14
 */
public class BasicPowerBlock extends Block implements IPowerBlock{

    public BasicPowerBlock(Material material){
        super(material);
    }


    public TileEntity createTileEntity(){
        return new TileEntity();
    }

    public boolean hasTileEntity(int meta){
        return true;
    }

    public IPowerTile getPowerTile(World worldObj, int x, int y, int z){
        return (IPowerTile)worldObj.getTileEntity(x, y, z);
    }

}
