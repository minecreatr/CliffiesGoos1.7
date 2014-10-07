package com.minecreatr.cliffsgoos.src;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class AirlockType extends NormalBlock
{
    private String tex;
    
    public AirlockType(int id, Material material, String texture)
    {
        super(id, material, texture);
        this.tex = texture;
        setBlockTextureName("CliffiesTaints:" + texture);
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World,
            int par2, int par3, int par4)
    {
        return null;
    }
    
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass()
    {
        return 1;
    }
    
    public boolean renderAsNormalBlock()
    {
        return false;
    }
}
