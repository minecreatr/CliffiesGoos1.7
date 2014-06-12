package com.minecreatr.cliffieswars.item;

import com.minecreatr.cliffieswars.CliffiesWars;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BatteryItem
        extends Item
{
    private String texture;
    private IIcon[] icons;

    public BatteryItem(int id, String tex)
    {
        setUnlocalizedName(tex);
        setTextureName("CliffiesWarsMod:" + tex);
        this.texture = tex;
        isDamageable();
        setMaxDamage(2);
    }

    public CreativeTabs getCreativeTab()
    {
        return CliffiesWars.tab;
    }

    public IIcon getIconFromDamage(int par1)
    {
        if ((par1 >= 0) || (par1 >= -500)) {
            return this.icons[0];
        }
        if ((par1 >= -1000) && (par1 < -500)) {
            return this.icons[1];
        }
        if ((par1 >= -1500) && (par1 < -1000)) {
            return this.icons[2];
        }
        if ((par1 >= -2000) && (par1 < -1500)) {
            return this.icons[3];
        }
        if ((par1 >= -2500) && (par1 < -2000)) {
            return this.icons[4];
        }
        return this.icons[5];
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.icons = new IIcon[6];
        this.icons[0] = par1IconRegister.registerIcon("CliffiesWarsMod:bat1");
        this.icons[1] = par1IconRegister.registerIcon("CliffiesWarsMod:bat2");
        this.icons[2] = par1IconRegister.registerIcon("CliffiesWarsMod:bat3");
        this.icons[3] = par1IconRegister.registerIcon("CliffiesWarsMod:bat4");
        this.icons[4] = par1IconRegister.registerIcon("CliffiesWarsMod:bat5");
        this.icons[5] = par1IconRegister.registerIcon("CliffiesWarsMod:emptyBattery");
    }
}
