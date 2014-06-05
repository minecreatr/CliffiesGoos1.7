package com.minecreatr.cliffieswars;

import com.minecreatr.cliffieswars.client.render.RenderNuke;
import com.minecreatr.cliffieswars.entity.LaserEntity;
import com.minecreatr.cliffieswars.entity.NukeEntity;
import com.minecreatr.cliffieswars.entity.RPGEntity;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy
        extends CommonProxy
{
    public static void registerRenderers()
    {
        RenderingRegistry.registerEntityRenderingHandler(LaserEntity.class, new RenderLaser());
        RenderingRegistry.registerEntityRenderingHandler(RPGEntity.class, new RenderRPG());
        RenderingRegistry.registerEntityRenderingHandler(NukeEntity.class, new RenderNuke());
    }

    @SideOnly(Side.CLIENT)
    public static int addArmour(String armour)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armour);
    }
}
