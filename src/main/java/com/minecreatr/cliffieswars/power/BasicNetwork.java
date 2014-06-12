//package com.minecreatr.cliffieswars.power;
//
//import com.minecreatr.cliffieswars.misc.BlockData;
//import com.minecreatr.cliffieswars.power.inter.IPowerBlock;
//import com.minecreatr.cliffieswars.power.inter.IPowerNetwork;
//import net.minecraft.block.Block;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.nbt.NBTTagList;
//import net.minecraft.world.World;
//
//import java.util.Iterator;
//import java.util.UUID;
//
///**
// * Created on 6/10/14
// */
//public class BasicNetwork implements IPowerNetwork {
//
//    protected UUID id;
//    private World worldObj;
//
//    public BasicNetwork(UUID id, World world){
//        this.id=id;
//        this.worldObj=world;
//    }
//
//    public boolean isInNetwork(int x, int y, int z){
//        for (int i=0;i<blocks.size();i++){
//            BlockData temp = blocks.get(i);
//            if (temp.posX==x&&temp.posY==y&&temp.posZ==z){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public int getCapacity(){
//        int cap = 0;
//        for (int i=0;i<blocks.size();i++){
//            BlockData data = blocks.get(i);
//            Block tempBlock = worldObj.getBlock(data.posX, data.posY, data.posZ);
//            if (tempBlock instanceof IPowerBlock){
//                cap=cap+((IPowerBlock)tempBlock).getMaxPower();
//            }
//        }
//        return cap;
//    }
//
//    public int getTotalPower(){
//        int power = 0;
//        for (int i=0;i<blocks.size();i++){
//            BlockData data = blocks.get(i);
//            Block tempBlock = worldObj.getBlock(data.posX, data.posY, data.posZ);
//            if (tempBlock instanceof IPowerBlock){
//                power=power+((IPowerBlock)tempBlock).getPower();
//            }
//        }
//        return power;
//    }
//
//    public UUID getNetworkId(){
//        return this.id;
//    }
//
//    public NBTTagCompound writeToNBT(NBTTagCompound compound){
//        NBTTagList locs = new NBTTagList();
//        for (int i=0;i<blocks.size();i++){
//            NBTTagCompound curcom = new NBTTagCompound();
//            curcom.setInteger("x", blocks.get(i).posX);
//            curcom.setInteger("y", blocks.get(i).posY);
//            curcom.setInteger("z", blocks.get(i).posZ);
//            locs.appendTag(curcom);
//        }
//        compound.setTag("Blocks", locs);
//        return compound;
//    }
//
//    public void addBlock(int x, int y, int z){
//        BlockData data = new BlockData(x, y, z);
//        blocks.add(data);
//    }
//
//    public void removeBlock(int x, int y, int z){
//        Iterator<BlockData> it = blocks.iterator();
//        while(it.hasNext()){
//            BlockData temp = it.next();
//            if (temp.posX==x&&temp.posY==y&&temp.posZ==z){
//                it.remove();
//            }
//        }
//    }
//}
