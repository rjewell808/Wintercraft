package wintercraft.items;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityStaff extends EntityThrowable {
	
	public EntityStaff(World par1World) {
		super(par1World);
	}

	public EntityStaff(World par1World, EntityLivingBase par2EntityLivingBase) {
		super(par1World, par2EntityLivingBase);
	}

	public EntityStaff(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
	}

	/**
	 * Called when this EntityThrowable hits a block or entity.
	 */
	@Override
	protected void onImpact(MovingObjectPosition m) {
			if (m.typeOfHit == MovingObjectType.ENTITY){
				AxisAlignedBB axisalignedbb = this.boundingBox.expand(4.0D, 2.0D, 4.0D);
				List list1 = this.worldObj.getEntitiesWithinAABB(EntityLivingBase.class, axisalignedbb);
				if (list1 != null && !list1.isEmpty())
                {
					Iterator iterator = list1.iterator();
					EntityLivingBase entitylivingbase = (EntityLivingBase)iterator.next();
					if (entitylivingbase == m.entityHit)
	                {
						((EntityLivingBase) m.entityHit).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 60, 10));
						((EntityLivingBase) m.entityHit).addPotionEffect(new PotionEffect(Potion.digSlowdown.id, 60, 10));
	                }
				} 
				
			}
			byte b0 = 1;
			for (int i = 0; i < 8; ++i) {
				this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
			}
			if (!this.worldObj.isRemote) {
				this.setDead();
		}
	}

}
