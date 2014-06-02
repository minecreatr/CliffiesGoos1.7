
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RocketItem
        extends Item
{
    private String texture;

    public RocketItem(int id, String tex)
    {
        setUnlocalizedName(tex);
        setTextureName("CliffiesWarsMod:" + tex);
        this.texture = tex;
    }

    public CreativeTabs getCreativeTab()
    {
        return CliffiesWars.tab;
    }
}
