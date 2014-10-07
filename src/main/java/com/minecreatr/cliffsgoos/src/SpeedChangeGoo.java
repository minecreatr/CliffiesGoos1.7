package com.minecreatr.cliffsgoos.src;


import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class SpeedChangeGoo extends Block
{
    /**
     * Private texture file.
     */
    private String tex;
    
    /**
     * May be made of goos, but won't kill you or spread!
     * For making crazy racetracks (imagine gelocity from portal 2).
     * This is a Lv. -1 / harmless and used for other things goo.
     * @param id
     * @param material
     * @param texture
     */
    public SpeedChangeGoo(int id, Material material, String texture, float boost)
    {
        super(material);
        this.tex = texture;
        this.slipperiness = boost;
        this.setTickRandomly(true);
        setBlockTextureName("CliffiesTaints:" + texture);
    }
}
