package com.minecreatr.cliffsgoos.src;


import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GenerateGoo implements IWorldGenerator
{
        @Override
        public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
        {
            if(!CliffiesTaints.blacklistedDims.contains(((WorldServer)world).provider.dimensionId))
            if(random.nextInt(5)==0)
            {
                Block[] gooIDs = {CliffiesTaints.rTaint1, CliffiesTaints.oTaint1, CliffiesTaints.yTaint1, CliffiesTaints.lTaint1, CliffiesTaints.gTaint1, CliffiesTaints.cTaint1, CliffiesTaints.bTaint1, CliffiesTaints.pTaint1};
                if(random.nextInt(10)==0)
                    world.setBlock(chunkX*16 + random.nextInt(16), 50+random.nextInt(50), chunkZ*16 + random.nextInt(16), gooIDs[random.nextInt(8)]);
            }
            else
            {
                Block[] gooIDs = {CliffiesTaints.rTaint, CliffiesTaints.oTaint, CliffiesTaints.yTaint, CliffiesTaints.lTaint, CliffiesTaints.gTaint, CliffiesTaints.cTaint, CliffiesTaints.bTaint, CliffiesTaints.pTaint};
                if(random.nextInt(10)==0)
                    world.setBlock(chunkX*16 + random.nextInt(16), 50+random.nextInt(50), chunkZ*16 + random.nextInt(16), gooIDs[random.nextInt(8)]);
            }
        }
}