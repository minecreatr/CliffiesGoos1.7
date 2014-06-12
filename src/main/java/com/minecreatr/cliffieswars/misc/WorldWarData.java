//package com.minecreatr.cliffieswars.misc;
//
//import com.minecreatr.cliffieswars.power.inter.IPowerNetwork;
//import com.minecreatr.cliffieswars.power.PowerNetworkRegistry;
//import com.minecreatr.cliffieswars.util.NBTHelper;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.nbt.NBTTagList;
//import net.minecraft.world.WorldSavedData;
//
//import java.util.*;
//
///**
// * Created on 6/10/14
// */
//public class WorldWarData extends WorldSavedData{
//
//    private HashMap<UUID, IPowerNetwork> networks = PowerNetworkRegistry.INSTANCE.networks;
//
//    public WorldWarData(String tagName) {
//        super(tagName);
//    }
//
//    @Override
//    public void readFromNBT(NBTTagCompound compound) {
//        if (compound.hasKey("PowerNetworks")){
//            NBTTagList list = compound.getTagList("PowerNetworks", 10);
//            for (int i=0;i<list.tagCount();i++){
//                NBTTagCompound curcomp = list.getCompoundTagAt(i);
//                networks.put(UUID.fromString(curcomp.getString("id")), NBTHelper.loadNetworkFromNBT(curcomp));
//            }
//        }
//    }
//
//    @Override
//    public void writeToNBT(NBTTagCompound compound) {
//        NBTTagList list = new NBTTagList();
//        Iterator it = networks.entrySet().iterator();
//        while(it.hasNext()){
//            NBTTagCompound curcomp = new NBTTagCompound();
//            Map.Entry pairs = (Map.Entry)it.next();
//            ((IPowerNetwork)pairs.getValue()).writeToNBT(curcomp);
//            curcomp.setString("id", (String)pairs.getKey());
//            list.appendTag(curcomp);
//        }
//        compound.setTag("PowerNetworks", list);
//    }
//
//}
