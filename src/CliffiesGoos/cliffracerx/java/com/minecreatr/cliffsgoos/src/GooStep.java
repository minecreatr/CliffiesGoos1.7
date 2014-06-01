package com.minecreatr.cliffsgoos.src;


import net.minecraft.block.Block;

public class GooStep extends Block.SoundType
{
    public final String stepSoundName;
    public final float stepSoundVolume;
    public final float stepSoundPitch;

    public GooStep(String par1Str, float par2, float par3)
    {
        super(par1Str, par2, par3);
        this.stepSoundName = par1Str;
        this.stepSoundVolume = par2;
        this.stepSoundPitch = par3;
    }

    public float getVolume()
    {
        return this.stepSoundVolume;
    }

    public float getPitch()
    {
        return this.stepSoundPitch;
    }

    /**
     * Used when a block breaks, EXA: Player break, Shep eating grass, etc..
     */
    public String getBreakSound()
    {
        return this.stepSoundName;
    }

    public String getStepResourcePath()
    {
        return this.stepSoundName;
    }

    public String func_150496_b()
    {
        return this.getBreakSound();
    }
}
