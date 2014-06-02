
import com.minecreatr.cliffsgoos.src.NormalBlock;
import net.minecraft.block.material.Material;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class FakeTurf
        extends NormalBlock
{
    private String tex;

    public FakeTurf(int id, Material material, String texture)
    {
        super(id, material, texture);
        this.tex = texture;
        setBlockTextureName("CliffiesWarsMod:" + texture);
    }

    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }
}
