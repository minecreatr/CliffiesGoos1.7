package com.minecreatr.cliffieswars;

import com.minecreatr.cliffieswars.CliffiesWars;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class WarTab
        extends CreativeTabs
{
    public WarTab(String label)
    {
        super(label);
    }

    public Item getTabIconItem()
    {
        return Item.getItemFromBlock(CliffiesWars.gWall);
    }
}
