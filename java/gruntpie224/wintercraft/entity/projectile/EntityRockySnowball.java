package gruntpie224.wintercraft.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityRockySnowball extends EntityThrowable
{
    public EntityRockySnowball(World par1World)
    {
        super(par1World);
    }

    public EntityRockySnowball(World par1World, EntityLivingBase par2EntityLivingBase)
    {
        super(par1World, par2EntityLivingBase);
    }

    public EntityRockySnowball(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }

    
    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    @Override
	protected void onImpact(RayTraceResult result) 
    {
        if (result.entityHit != null)
        {
            byte b0 = 2; 

            if (result.entityHit instanceof EntityBlaze)
            {
                b0 = 5;
            }

            result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), (float)b0);
        }

        for (int i = 0; i < 8; ++i)
        {
            this.world.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.world.isRemote)
        {
            this.setDead();
        }
    }
}
