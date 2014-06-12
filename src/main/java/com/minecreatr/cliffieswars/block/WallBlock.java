package com.minecreatr.cliffieswars.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class WallBlock
        extends Block
{
    private String tex;

    public WallBlock(int id, Material material, String texture)
    {
        super(material);
        this.tex = texture;
        setBlockTextureName("CliffiesWarsMod:" + texture);
    }
}
