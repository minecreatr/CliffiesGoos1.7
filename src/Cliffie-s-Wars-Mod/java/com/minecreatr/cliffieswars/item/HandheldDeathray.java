package com.minecreatr.cliffieswars.item;

import com.minecreatr.cliffieswars.CliffiesWars;
import com.minecreatr.cliffieswars.entity.LaserEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class HandheldDeathray
        extends Item
{
    private String tex;
    private String col;
    private IIcon[] icons;

    public HandheldDeathray(int id, String tex, String color)
    {
        setUnlocalizedName(tex);
        setTextureName("CliffiesWarsMod:" + tex);
        this.tex = tex;
        isDamageable();
        setMaxDamage(2);
        this.col = color;
    }

    public CreativeTabs getCreativeTab()
    {
        return CliffiesWars.tab;
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        LaserEntity laser = new LaserEntity(par2World, par3EntityPlayer, 1.5F, this.col);
        laser.setColor(this.col);


        par2World.playSoundAtEntity(par3EntityPlayer, "cliffieswarsmod:laser", 0.5F, 2.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        laser.color = this.col;
        if (!par2World.isRemote)
        {
            laser.color = this.col;
            par2World.spawnEntityInWorld(laser);
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
}
