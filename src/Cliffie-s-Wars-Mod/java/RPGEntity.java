
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.List;
import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.util.Vec3Pool;
import net.minecraft.world.World;

public class RPGEntity
        extends Entity
        implements IProjectile
{
    protected int xTile = -1;
    protected int yTile = -1;
    protected int zTile = -1;
    protected Block inTile;
    protected int inData;
    protected boolean inGround;
    public int canBePickedUp;
    public int arrowShake;
    public Entity shootingEntity;
    protected int ticksInGround;
    protected int ticksInAir;
    public double damage = 2.0D;
    protected int knockbackStrength;
    public String color = "r";

    public RPGEntity(World par1World)
    {
        super(par1World);
        this.renderDistanceWeight = 10.0D;
        setSize(0.5F, 0.5F);
    }

    public RPGEntity(World par1World, double par2, double par4, double par6)
    {
        super(par1World);
        this.renderDistanceWeight = 10.0D;
        setSize(0.5F, 0.5F);
        setPosition(par2, par4, par6);
        this.yOffset = 0.0F;
    }

    public RPGEntity(World par1World, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase, float par4, float par5)
    {
        super(par1World);
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = par2EntityLivingBase;
        if ((par2EntityLivingBase instanceof EntityPlayer)) {
            this.canBePickedUp = 1;
        }
        this.posY = (par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight() - 0.1000000014901161D);
        double d0 = par3EntityLivingBase.posX - par2EntityLivingBase.posX;
        double d1 = par3EntityLivingBase.boundingBox.minY + par3EntityLivingBase.height / 3.0F - this.posY;
        double d2 = par3EntityLivingBase.posZ - par2EntityLivingBase.posZ;
        double d3 = MathHelper.sqrt_double(d0 * d0 + d2 * d2);
        if (d3 >= 1.0E-007D)
        {
            float f2 = (float)(Math.atan2(d2, d0) * 180.0D / 3.141592653589793D) - 90.0F;
            float f3 = (float)-(Math.atan2(d1, d3) * 180.0D / 3.141592653589793D);
            double d4 = d0 / d3;
            double d5 = d2 / d3;
            setLocationAndAngles(par2EntityLivingBase.posX + d4, this.posY, par2EntityLivingBase.posZ + d5, f2, f3);
            this.yOffset = 0.0F;
            float f4 = (float)d3 * 0.2F;
            setThrowableHeading(d0, d1 + f4, d2, par4, par5);
        }
    }

    public RPGEntity(World par1World, EntityLivingBase par2EntityLivingBase, float par3, String col)
    {
        super(par1World);
        this.renderDistanceWeight = 10.0D;
        this.shootingEntity = par2EntityLivingBase;
        this.color = col;
        if ((par2EntityLivingBase instanceof EntityPlayer)) {
            this.canBePickedUp = 1;
        }
        setSize(0.5F, 0.5F);
        setLocationAndAngles(par2EntityLivingBase.posX, par2EntityLivingBase.posY + par2EntityLivingBase.getEyeHeight(), par2EntityLivingBase.posZ, par2EntityLivingBase.rotationYaw, par2EntityLivingBase.rotationPitch);
        this.posX -= MathHelper.cos(this.rotationYaw / 180.0F * 3.141593F) * 0.16F;
        this.posY += 0.6000000014901161D;
        this.posZ -= MathHelper.sin(this.rotationYaw / 180.0F * 3.141593F) * 0.16F;
        setPosition(this.posX, this.posY, this.posZ);
        this.yOffset = 0.0F;
        this.motionX = (-MathHelper.sin(this.rotationYaw / 180.0F * 3.141593F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.141593F));
        this.motionZ = (MathHelper.cos(this.rotationYaw / 180.0F * 3.141593F) * MathHelper.cos(this.rotationPitch / 180.0F * 3.141593F));
        this.motionY = (-MathHelper.sin(this.rotationPitch / 180.0F * 3.141593F));
        setThrowableHeading(this.motionX, this.motionY, this.motionZ, par3 * 1.5F, 1.0F);
    }

    public String getColor()
    {
        return this.dataWatcher.getWatchableObjectString(20);
    }

    public void setColor(String clr)
    {
        this.dataWatcher.updateObject(20, clr);
    }

    protected void entityInit()
    {
        this.dataWatcher.addObject(16, Byte.valueOf((byte)0));
        this.dataWatcher.addObject(20, "r");
    }

    public void setThrowableHeading(double par1, double par3, double par5, float par7, float par8)
    {
        float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= f2;
        par3 /= f2;
        par5 /= f2;
        par1 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
        par3 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
        par5 += this.rand.nextGaussian() * (this.rand.nextBoolean() ? -1 : 1) * 0.007499999832361937D * par8;
        par1 *= par7;
        par3 *= par7;
        par5 *= par7;
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        this.prevRotationYaw = (this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D));
        this.prevRotationPitch = (this.rotationPitch = (float)(Math.atan2(par3, f3) * 180.0D / 3.141592653589793D));
        this.ticksInGround = 0;
    }

    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9)
    {
        setPosition(par1, par3, par5);
        setRotation(par7, par8);
    }

    @SideOnly(Side.CLIENT)
    public void setVelocity(double par1, double par3, double par5)
    {
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        if ((this.prevRotationPitch == 0.0F) && (this.prevRotationYaw == 0.0F))
        {
            float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
            this.prevRotationYaw = (this.rotationYaw = (float)(Math.atan2(par1, par5) * 180.0D / 3.141592653589793D));
            this.prevRotationPitch = (this.rotationPitch = (float)(Math.atan2(par3, f) * 180.0D / 3.141592653589793D));
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }

    public void onUpdate()
    {
        super.onUpdate();
        if ((this.prevRotationPitch == 0.0F) && (this.prevRotationYaw == 0.0F))
        {
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = (this.rotationYaw = (float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.141592653589793D));
            this.prevRotationPitch = (this.rotationPitch = (float)(Math.atan2(this.motionY, f) * 180.0D / 3.141592653589793D));
        }
        Block i = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
        if (i != Blocks.air)
        {
            i.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
            AxisAlignedBB axisalignedbb = i.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile, this.zTile);
            if ((axisalignedbb != null) && (axisalignedbb.isVecInside(this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ)))) {
                this.inGround = true;
            }
        }
        if (this.arrowShake > 0) {
            this.arrowShake -= 1;
        }
        if (this.inGround)
        {
            Block j = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
            int k = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
            if ((j == this.inTile) && (k == this.inData))
            {
                this.ticksInGround += 1;
                if (this.ticksInGround == 1200) {
                    setDead();
                }
            }
            else
            {
                this.inGround = false;
                this.motionX *= this.rand.nextFloat() * 0.2F;
                this.motionY *= this.rand.nextFloat() * 0.2F;
                this.motionZ *= this.rand.nextFloat() * 0.2F;
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
            this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 10.0F, true);
        }
        else
        {
            this.ticksInAir += 1;
            Vec3 vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
            Vec3 vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            MovingObjectPosition movingobjectposition = this.worldObj.rayTraceBlocks(vec3, vec31, false);
            vec3 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX, this.posY, this.posZ);
            vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            if (movingobjectposition != null) {
                vec31 = this.worldObj.getWorldVec3Pool().getVecFromPool(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord, movingobjectposition.hitVec.zCoord);
            }
            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d0 = 0.0D;
            for (int l = 0; l < list.size(); l++)
            {
                Entity entity1 = (Entity)list.get(l);
                if ((entity1.canBeCollidedWith()) && ((entity1 != this.shootingEntity) || (this.ticksInAir >= 5)))
                {
                    float f1 = 0.3F;
                    AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f1, f1, f1);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);
                    if (movingobjectposition1 != null)
                    {
                        double d1 = vec3.distanceTo(movingobjectposition1.hitVec);
                        if ((d1 < d0) || (d0 == 0.0D))
                        {
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }
            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }
            if ((movingobjectposition != null) && (movingobjectposition.entityHit != null) && ((movingobjectposition.entityHit instanceof EntityPlayer)))
            {
                EntityPlayer entityplayer = (EntityPlayer)movingobjectposition.entityHit;
                if ((entityplayer.capabilities.disableDamage) || (((this.shootingEntity instanceof EntityPlayer)) && (!((EntityPlayer)this.shootingEntity).canAttackPlayer(entityplayer)))) {
                    movingobjectposition = null;
                }
            }
            if (movingobjectposition != null) {
                if (movingobjectposition.entityHit != null)
                {
                    float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int i1 = MathHelper.ceiling_double_int(f2 * this.damage);
                    if (getIsCritical()) {
                        i1 += this.rand.nextInt(i1 / 2 + 2);
                    }
                    DamageSource damagesource = null;
                    if (this.shootingEntity == null) {
                        damagesource = DamageSource.causeThrownDamage(this, this);
                    } else {
                        damagesource = DamageSource.causeThrownDamage(this, this.shootingEntity);
                    }
                    this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 10.0F, true);
                    if ((isBurning()) && (!(movingobjectposition.entityHit instanceof EntityEnderman))) {
                        movingobjectposition.entityHit.setFire(5);
                    }
                    if (movingobjectposition.entityHit.attackEntityFrom(damagesource, i1))
                    {
                        if ((movingobjectposition.entityHit instanceof EntityLivingBase))
                        {
                            EntityLivingBase entitylivingbase = (EntityLivingBase)movingobjectposition.entityHit;
                            if (!this.worldObj.isRemote) {
                                entitylivingbase.setArrowCountInEntity(entitylivingbase.getArrowCountInEntity() + 1);
                            }
                            if (this.knockbackStrength > 0)
                            {
                                float f3 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
                                if (f3 > 0.0F) {
                                    movingobjectposition.entityHit.addVelocity(this.motionX * this.knockbackStrength * 0.6000000238418579D / f3, 0.1D, this.motionZ * this.knockbackStrength * 0.6000000238418579D / f3);
                                }
                            }
                            if ((this.shootingEntity != null) && (movingobjectposition.entityHit != this.shootingEntity) && ((movingobjectposition.entityHit instanceof EntityPlayer)) && ((this.shootingEntity instanceof EntityPlayerMP))) {
                                ((EntityPlayerMP)this.shootingEntity).playerNetServerHandler.sendPacket(new S2BPacketChangeGameState(6, 0.0F));
                            }
                        }
                        playSound("cliffieswarsmod:woosh", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                        if (!(movingobjectposition.entityHit instanceof EntityEnderman)) {
                            setDead();
                        }
                    }
                    else
                    {
                        this.motionX *= -0.1000000014901161D;
                        this.motionY *= -0.1000000014901161D;
                        this.motionZ *= -0.1000000014901161D;
                        this.rotationYaw += 180.0F;
                        this.prevRotationYaw += 180.0F;
                        this.ticksInAir = 0;
                    }
                }
                else
                {
                    this.xTile = movingobjectposition.blockX;
                    this.yTile = movingobjectposition.blockY;
                    this.zTile = movingobjectposition.blockZ;
                    this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
                    this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
                    this.motionX = ((float)(movingobjectposition.hitVec.xCoord - this.posX));
                    this.motionY = ((float)(movingobjectposition.hitVec.yCoord - this.posY));
                    this.motionZ = ((float)(movingobjectposition.hitVec.zCoord - this.posZ));
                    float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / f2 * 0.0500000007450581D;
                    this.posY -= this.motionY / f2 * 0.0500000007450581D;
                    this.posZ -= this.motionZ / f2 * 0.0500000007450581D;
                    playSound("cliffieswarsmod:woosh", 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                    this.inGround = true;
                    this.arrowShake = 7;
                    setIsCritical(false);
                    if (this.inTile != Blocks.air) {
                        this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);
                    }
                    if (!worldObj.isRemote){
                        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 10.0F, true);
                    }
                    setDead();
                }
            }
            if (getIsCritical()) {
                int l = 0;
                for (l = 0; l < 4; l++) {
                    this.worldObj.spawnParticle("crit", this.posX + this.motionX * l / 4.0D, this.posY + this.motionY * l / 4.0D, this.posZ + this.motionZ * l / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
                }
            }
            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = ((float)(Math.atan2(this.motionX, this.motionZ) * 180.0D / 3.141592653589793D));
            for (this.rotationPitch = ((float)(Math.atan2(this.motionY, f2) * 180.0D / 3.141592653589793D)); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F) {}
            while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
                this.prevRotationPitch += 360.0F;
            }
            while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
                this.prevRotationYaw -= 360.0F;
            }
            while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
                this.prevRotationYaw += 360.0F;
            }
            this.rotationPitch = (this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F);
            this.rotationYaw = (this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F);
            float f4 = 0.99F;
            float f1 = 0.005F;
            if (isInWater())
            {
                for (int j1 = 0; j1 < 4; j1++)
                {
                    float f3 = 0.25F;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3, this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
                }
                f4 = 0.8F;
            }
            this.motionX *= f4;
            this.motionY *= f4;
            this.motionZ *= f4;
            this.motionY -= f1;
            setPosition(this.posX, this.posY, this.posZ);
        }
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        par1NBTTagCompound.setShort("xTile", (short)this.xTile);
        par1NBTTagCompound.setShort("yTile", (short)this.yTile);
        par1NBTTagCompound.setShort("zTile", (short)this.zTile);
        par1NBTTagCompound.setByte("inTile", (byte)Block.getIdFromBlock(this.inTile));
        par1NBTTagCompound.setByte("inData", (byte)this.inData);
        par1NBTTagCompound.setByte("shake", (byte)this.arrowShake);
        par1NBTTagCompound.setByte("inGround", (byte)(this.inGround ? 1 : 0));
        par1NBTTagCompound.setByte("pickup", (byte)this.canBePickedUp);
        par1NBTTagCompound.setDouble("damage", this.damage);
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        this.xTile = par1NBTTagCompound.getShort("xTile");
        this.yTile = par1NBTTagCompound.getShort("yTile");
        this.zTile = par1NBTTagCompound.getShort("zTile");
        this.inTile = Block.getBlockById(par1NBTTagCompound.getByte("inTile") & 0xFF);
        this.inData = (par1NBTTagCompound.getByte("inData") & 0xFF);
        this.arrowShake = (par1NBTTagCompound.getByte("shake") & 0xFF);
        this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);
        if (par1NBTTagCompound.hasKey("damage")) {
            this.damage = par1NBTTagCompound.getDouble("damage");
        }
        if (par1NBTTagCompound.hasKey("pickup")) {
            this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
        } else if (par1NBTTagCompound.hasKey("player")) {
            this.canBePickedUp = (par1NBTTagCompound.getBoolean("player") ? 1 : 0);
        }
    }

    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer)
    {
        if ((!this.worldObj.isRemote) && (this.inGround) && (this.arrowShake <= 0)) {}
    }

    protected boolean canTriggerWalking()
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0F;
    }

    public void setDamage(double par1)
    {
        this.damage = par1;
    }

    public double getDamage()
    {
        return this.damage;
    }

    public void setKnockbackStrength(int par1)
    {
        this.knockbackStrength = par1;
    }

    public boolean canAttackWithItem()
    {
        return false;
    }

    public void setIsCritical(boolean par1)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        if (par1) {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 0x1)));
        } else {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & 0xFFFFFFFE)));
        }
    }

    public boolean getIsCritical()
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);
        return (b0 & 0x1) != 0;
    }
}
