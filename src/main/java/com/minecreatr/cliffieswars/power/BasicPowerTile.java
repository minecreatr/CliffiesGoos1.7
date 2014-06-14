package com.minecreatr.cliffieswars.power;

import com.minecreatr.cliffieswars.power.IPowerGenerator;
import com.minecreatr.cliffieswars.power.IPowerProvider;
import com.minecreatr.cliffieswars.power.IPowerReceiver;
import com.minecreatr.cliffieswars.power.IPowerTile;
import com.minecreatr.cliffieswars.tile.NormalTileEntity;

/**
 * Created on 6/14/14
 */
public class BasicPowerTile extends NormalTileEntity implements IPowerTile,IPowerReceiver,IPowerGenerator{

    //can the block recieve power from the specified side
    public boolean canReceivePower(int side){
        return true;
    }

    //is it actually a reciever
    public boolean isReceiver(){
        return false;
    }

    //is it actually a generator
    public boolean isGenerator(){
        return false;
    }

    //power requested per tick
    public int requestPower(){
        return 0;
    }

    public boolean canProvidePower(int side){
        return true;
    }

    public int generatePower(){
        return 0;
    }
}
