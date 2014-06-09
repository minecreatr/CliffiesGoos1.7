package com.minecreatr.cliffieswars.power;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created on 6/7/14
 */
public class PowerNetworkRegistry {

    private ArrayList<IPowerNetwork> networks = new ArrayList<IPowerNetwork>();

    public ArrayList<IPowerNetwork> getNetworks(){
        return this.networks;
    }

    public void addNetwork(IPowerNetwork network){
        this.networks.add(network);
    }

    public void removeNetwork(UUID id){
        Iterator<IPowerNetwork> i = networks.iterator();
        while (i.hasNext()){
            IPowerNetwork network = i.next();
            if (network.getNetworkId()==id){
                i.remove();
            }
        }
    }
}
