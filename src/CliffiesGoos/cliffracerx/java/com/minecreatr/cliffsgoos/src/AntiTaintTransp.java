package com.minecreatr.cliffsgoos.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class AntiTaintTransp extends NormalBlock
{
    private String tex;
    
    public AntiTaintTransp(int id, Material material, String texture)
    {
        super(id, material, texture);
        this.tex = texture;
        setBlockTextureName("CliffiesTaints:" + texture);
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public int getRenderBlockPass()
    {
        return 1;
    }
}
