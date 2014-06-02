
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
    }

    @SideOnly(Side.CLIENT)
    public static int addArmour(String armour)
    {
        return RenderingRegistry.addNewArmourRendererPrefix(armour);
    }
}
