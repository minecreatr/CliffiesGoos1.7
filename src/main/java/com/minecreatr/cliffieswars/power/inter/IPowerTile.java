package com.minecreatr.cliffieswars.power.inter;

/**
 * Created on 6/7/14
 */
public interface IPowerTile {

    public IPowerNetwork getPowerNetwork();

    public int getMaxPower();

    public int getPower();
}
