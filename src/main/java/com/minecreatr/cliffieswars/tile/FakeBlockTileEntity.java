package com.minecreatr.cliffieswars.tile;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Created on 6/3/14
 */
public class FakeBlockTileEntity extends NormalTileEntity{

    public int id;
    public FakeBlockTileEntity(){
        id=1;
    }


    @Override
    public void writeData(NBTTagCompound compound) {
        compound.setInteger("FakeId", this.id);
    };

    @Override
    public void readData(NBTTagCompound compound) {
        if (compound.hasKey("FakeId")){
            this.id = compound.getInteger("FakeId");
        }
    }

    public int getId(){
        return this.id;
    }

    public void setId(int id){
        this.id = id;
        this.markDirty();
    }
}
