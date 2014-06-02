
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Random;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class HandheldRocketLauncher
        extends Item
{
    private String tex;
    private String col;
    private IIcon[] icons;

    public HandheldRocketLauncher(int id, String tex, String color)
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
        RPGEntity laser = new RPGEntity(par2World, par3EntityPlayer, 1.5F, this.col);
        laser.setColor(this.col);
        if ((par3EntityPlayer.capabilities.isCreativeMode) || (par3EntityPlayer.inventory.hasItem(Item.getItemById(CliffiesWars.rocketID + 256))))
        {
            par2World.playSoundAtEntity(par3EntityPlayer, "cliffieswarsmod:woosh", 0.5F, 2.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            laser.color = this.col;
            if (!par3EntityPlayer.capabilities.isCreativeMode) {
                par3EntityPlayer.inventory.consumeInventoryItem(CliffiesWars.rocket);
            }
            if (!par2World.isRemote)
            {
                laser.color = this.col;
                par2World.spawnEntityInWorld(laser);
            }
        }
        return par1ItemStack;
    }

    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
}
