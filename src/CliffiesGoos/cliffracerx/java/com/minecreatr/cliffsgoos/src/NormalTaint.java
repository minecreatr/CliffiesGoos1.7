package com.minecreatr.cliffsgoos.src;


import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class NormalTaint extends Block
{
    /**
     * Private texture file.
     */
    private String tex;
    
    /**
     * A basic taint block.
     * Designed only to annoy the crap out of you, will change surrounding blocks into it if the block isn't bedrock or a anti-taint wall.
     * This is a Lv. 0 / annoyance taint.  If THIS scares you, wait until you see the others!
     * @param id
     * @param material
     * @param texture
     */
    public NormalTaint(int id, Material material, String texture)
    {
        super(material);
        this.tex = texture;
        this.setTickRandomly(true);
        setBlockTextureName("CliffiesTaints:" + texture);
    }
    
    /**
     * Block update.
     */
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote)
        {
            {
                for (int l = 0; l < 4; ++l)
                {
                    int i1 = par2 + par5Random.nextInt(3) - 1;
                    int j1 = par3 + par5Random.nextInt(5) - 3;
                    int k1 = par4 + par5Random.nextInt(3) - 1;

                    //Check and see if there are any non-air, non-taint-preventing and non-bedrock blocks nearby, and if so spread onto them.
                    if (par1World.getBlock(i1, j1, k1) != Blocks.air && par1World.getBlock(i1, j1, k1) != Blocks.bedrock && !(par1World.getBlock(i1, j1, k1) instanceof NormalBlock) && !(par1World.getBlock(i1, j1, k1) instanceof Tier2Taint))
                    {
                        //System.out.println("Cliffie's Taints: Taint taking over on x: "+i1+" y: "+j1+" z: "+k1);
                        par1World.setBlock(i1, j1, k1, this);
                    }
                }
            }
        }
    }
}
