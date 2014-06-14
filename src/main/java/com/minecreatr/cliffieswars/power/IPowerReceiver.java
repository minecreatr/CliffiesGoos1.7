package com.minecreatr.cliffieswars.power;

/**
 * Created on 6/14/14
 */
public interface IPowerReceiver {

    public int requestPower();

    public boolean canReceivePower(int side);

    public boolean isReceiver();
}
