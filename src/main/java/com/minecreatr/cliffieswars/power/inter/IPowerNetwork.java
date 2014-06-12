package com.minecreatr.cliffieswars.power.inter;

import com.minecreatr.cliffieswars.misc.BlockData;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created on 6/7/14
 */
public interface IPowerNetwork {


    public ArrayList<BlockData> blocks = new ArrayList<BlockData>();

    public boolean isInNetwork(int x, int y, int z);

    public int getCapacity();

    public int getTotalPower();

    public UUID getNetworkId();

    public NBTTagCompound writeToNBT(NBTTagCompound compound);
    public void addBlock(int x, int y, int z);
    public void removeBlock(int x, int y, int z);


}
