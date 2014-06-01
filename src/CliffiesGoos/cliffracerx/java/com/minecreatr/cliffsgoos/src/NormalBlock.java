package com.minecreatr.cliffsgoos.src;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class NormalBlock extends Block
{
    private String tex;
    
    public NormalBlock(int id, Material material, String texture)
    {
        super(material);
        this.tex = texture;
        setBlockTextureName("CliffiesTaints:" + texture);
    }
}
