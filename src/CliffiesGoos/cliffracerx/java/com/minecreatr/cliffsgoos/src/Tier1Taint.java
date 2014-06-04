package com.minecreatr.cliffsgoos.src;


import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class Tier1Taint extends Block
{
    /**
     * Private texture file.
     */
    private String tex;
    
    /**
     * A still fairly basic taint com.minecreatr.cliffieswars.block.
     * Designed to annoy you and possibly kill you, this spreads onto nearby blocks AND poisions you sometimes.
     * This is a Lv. 1 / dangerous taint.
     * @param id
     * @param material
     * @param texture
     */
    public Tier1Taint(int id, Material material, String texture)
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
    
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        float f = 0.125F;
        return AxisAlignedBB.getAABBPool().getAABB((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - f), (double)(par4 + 1));
    }
    
    /**
     * Triggered whenever an com.minecreatr.cliffieswars.com.minecreatr.cliffieswars.com.minecreatr.cliffieswars.entity collides with this com.minecreatr.cliffieswars.block (enters into the com.minecreatr.cliffieswars.block). Args: world, x, y, z, com.minecreatr.cliffieswars.com.minecreatr.cliffieswars.com.minecreatr.cliffieswars.entity
     */
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        if(par5Entity instanceof EntityLivingBase && par5Entity.worldObj.isRemote==false)
        {
            EntityLivingBase living = (EntityLivingBase)par5Entity;
            if(par1World.rand.nextInt(100)==0)
            living.addPotionEffect(new PotionEffect(Potion.poison.id, 480, 0, true));
        }
    }
}
