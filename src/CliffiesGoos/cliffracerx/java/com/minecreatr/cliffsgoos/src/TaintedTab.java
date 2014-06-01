package com.minecreatr.cliffsgoos.src;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TaintedTab extends CreativeTabs
{
    // Main constructor, nothing to see here.
    public TaintedTab(String label)
    {
        super(label);
    }
    
    // This sets the item/block seen as the creative tab's icon. :D
    // We set it to our custom block.
    @Override
    public Item getTabIconItem()
    {
        return Item.getItemFromBlock(CliffiesTaints.rTaint);
    }
}
