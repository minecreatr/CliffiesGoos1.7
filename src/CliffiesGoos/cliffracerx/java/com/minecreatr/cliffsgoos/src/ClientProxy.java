package com.minecreatr.cliffsgoos.src;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy
{
    //@Override
    public static void registerRenderers()
    {
        
    }

    @SideOnly(Side.CLIENT)
    public static int addArmour(String armour)
    {
         return RenderingRegistry.addNewArmourRendererPrefix(armour);
    }
}
