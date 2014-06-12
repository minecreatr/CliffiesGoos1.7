package com.minecreatr.cliffieswars.power;

import com.minecreatr.cliffieswars.power.inter.IPowerNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created on 6/7/14
 */
public class PowerNetworkRegistry {

    public HashMap<UUID, IPowerNetwork> networks = new HashMap<UUID, IPowerNetwork>();
    public static PowerNetworkRegistry INSTANCE;

    private ArrayList<IPowerNetwork> getNetworksMap(){
        return (ArrayList<IPowerNetwork>)(this.networks.values());
    }

    public void addNetwork(UUID id, IPowerNetwork network){
        this.networks.put(id, network);
    }

    public void removeNetwork(UUID id){
        if (networks.get(id)!=null){
            networks.remove(id);
        }
    }

    public IPowerNetwork getNetwork(UUID key){
        return networks.get(key);
    }
}
