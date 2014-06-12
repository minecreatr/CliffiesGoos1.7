//package com.minecreatr.cliffieswars.util;
//
//import com.minecreatr.cliffieswars.power.inter.IPowerBlock;
//import com.minecreatr.cliffieswars.power.inter.IPowerNetwork;
//import net.minecraft.nbt.NBTTagCompound;
//
//import java.util.UUID;
//
///**
// * Created on 6/10/14
// */
//public class NBTHelper {
//
//    public static IPowerNetwork loadNetworkFromNBT(NBTTagCompound compound){
//        return new IPowerNetwork() {
//            @Override
//            public boolean isInNetwork(IPowerBlock block) {
//                return false;
//            }
//
//            @Override
//            public int getCapacity() {
//                return 0;
//            }
//
//            @Override
//            public int getTotalPower() {
//                return 0;
//            }
//
//            @Override
//            public UUID getNetworkId() {
//                return null;
//            }
//
//            @Override
//            public NBTTagCompound writeToNBT(NBTTagCompound compound) {
//                return null;
//            }
//        };
//    };
//}
