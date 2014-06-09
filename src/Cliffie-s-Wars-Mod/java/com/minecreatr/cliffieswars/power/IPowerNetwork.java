package com.minecreatr.cliffieswars.power;

import sun.org.mozilla.javascript.internal.ast.Block;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created on 6/7/14
 */
public interface IPowerNetwork {

    public ArrayList<IPowerBlock> blocks = new ArrayList<IPowerBlock>();

    public boolean isInNetwork(IPowerBlock block);

    public int getCapacity();

    public int getTotalPower();

    public UUID getNetworkId();
}
