//package com.minecreatr.cliffieswars.power.inter;
//
//import com.minecreatr.cliffieswars.power.PowerNetworkRegistry;
//import net.minecraft.tileentity.TileEntity;
//
//import java.util.UUID;
//
///**
// * Created on 6/11/14
// */
//public class BasicPowerTileEntity extends TileEntity implements IPowerTile{
//
//    private int maxPower;
//    private int power;
//    private UUID powerNetworkId;
//
//    public BasicPowerTileEntity(int maxPower, int startingPower, UUID powerNetworkId){
//        this.maxPower=maxPower;
//        this.power=startingPower;
//        this.powerNetworkId=powerNetworkId;
//        getPowerNetwork().addBlock(xCoord, yCoord, zCoord);
//    }
//
//    public IPowerNetwork getPowerNetwork(){
//        return PowerNetworkRegistry.INSTANCE.getNetwork(powerNetworkId);
//    }
//}
