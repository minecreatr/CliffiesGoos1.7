package com.minecreatr.cliffieswars.power;

/**
 * Created on 6/14/14
 */
public interface IPowerGenerator {

    public int generatePower();

    public boolean canProvidePower(int side);

    public boolean isGenerator();
}
