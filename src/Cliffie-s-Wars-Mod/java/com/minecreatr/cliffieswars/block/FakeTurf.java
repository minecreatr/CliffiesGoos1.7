package com.minecreatr.cliffieswars.block;

import com.minecreatr.cliffieswars.CliffiesWars;
import com.minecreatr.cliffsgoos.src.NormalBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import com.minecreatr.cliffieswars.tile.FakeBlockTileEntity;
import net.minecraftforge.client.MinecraftForgeClient;

public class FakeTurf
        extends NormalBlock
{
    private String tex;

    public FakeTurf(int id, Material material, String texture)
    {
        super(id, material, texture);
        this.tex = texture;
        setBlockTextureName("CliffiesWarsMod:" + texture);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9){
        if (player.getCurrentEquippedItem()==null){
            return false;
        }
        if (player.getCurrentEquippedItem().getItem()==null){
            return false;
        }
        if (player.getCurrentEquippedItem().getItem() instanceof ItemBlock && player.getCurrentEquippedItem().getItem() != Item.getItemFromBlock(CliffiesWars.fakeTurf)){
            ItemBlock item = (ItemBlock) player.getCurrentEquippedItem().getItem();
            if (world.getTileEntity(x, y, z) instanceof FakeBlockTileEntity){
                FakeBlockTileEntity entity = (FakeBlockTileEntity) world.getTileEntity(x, y, z);
                entity.setId(Item.getIdFromItem(item));
                world.setBlockMetadataWithNotify(x, y, z, item.getDamage(player.getCurrentEquippedItem()), 1);
                player.addChatMessage(new ChatComponentText(""+item.getDamage(player.getCurrentEquippedItem())));
                world.markBlockForUpdate(x, y, z);
                player.addChatMessage(new ChatComponentText("It is: "+Item.getIdFromItem(item)));
                return true;
            }
        }
        return false;
    }

    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side){
        if (world.getTileEntity(x, y, z) instanceof FakeBlockTileEntity){
            FakeBlockTileEntity entity = (FakeBlockTileEntity) world.getTileEntity(x, y, z);
            Block fakeBlock = Block.getBlockById(entity.getId());
            return fakeBlock.getIcon(side, world.getBlockMetadata(x, y, z));
        }
        else {
            return this.getIcon(side, world.getBlockMetadata(x, y, z));
        }
    }

    @Override
    public boolean hasTileEntity(int meta){
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int meta){
        return new FakeBlockTileEntity();
    }
}
