import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;

public class StepSound
        extends Block.SoundType
{
    public final String stepSoundName;
    public final float stepSoundVolume;
    public final float stepSoundPitch;

    public StepSound(String par1Str, float par2, float par3)
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
        return getBreakSound();
    }
}
