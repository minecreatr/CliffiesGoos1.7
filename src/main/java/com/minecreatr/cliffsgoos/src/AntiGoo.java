package com.minecreatr.cliffsgoos.src;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created on 6/1/14
 */
public class AntiGoo extends Block {

    private String tex;

    public AntiGoo(Material material, String texture){
        super(material);
        this.tex = texture;
        setBlockTextureName("CliffiesTaints:" + texture);
        this.setTickRandomly(true);
    }

    @Override
    public int tickRate(World world){
        return 1;
    }

    @Override
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random){
        if (!par1World.isRemote){
            int i1 = par2 + par5Random.nextInt(3) - 1;
            int j1 = par3 + par5Random.nextInt(3) - 1;
            int k1 = par4 + par5Random.nextInt(3) - 1;
            if (par1World.getBlock(i1, j1, k1) instanceof Tier1Taint || par1World.getBlock(i1, j1, k1) instanceof Tier2Taint || par1World.getBlock(i1, j1, k1) instanceof Tier3Taint){
                par1World.setBlock(i1, j1, k1, this);
            }
            if(par5Random.nextInt(5)==0)
                par1World.setBlock(par2, par3, par4, Blocks.air);
        }
    }
}
