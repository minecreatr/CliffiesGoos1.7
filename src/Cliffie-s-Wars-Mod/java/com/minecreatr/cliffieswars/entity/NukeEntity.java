package com.minecreatr.cliffieswars.entity;

import com.minecreatr.cliffieswars.explode.NukeExplosion;
import com.minecreatr.cliffieswars.explode.NukeRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;

/**
 * Created on 6/2/14
 */
public class NukeEntity extends EntityTNTPrimed{

    public NukeEntity(World par1World, double par2, double par4, double par6, EntityLivingBase par8EntityLivingBase){
        super(par1World, par2, par4, par6, par8EntityLivingBase);
        this.fuse = 5;
    }

    public NukeEntity(World world){
        super(world);
    }

    private void explode(){
        System.out.println("Beginning Nuking");
        NukeRegistry.registerExplosion(new NukeExplosion(worldObj, posX, posY, posZ, getPower() ,this));
    }

    public int getPower(){
        return 50;
    }

    @Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }

        if (this.fuse-- <= 0)
        {
            this.setDead();

            if (!this.worldObj.isRemote)
            {
                this.explode();
            }
        }
        else
        {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }
}
