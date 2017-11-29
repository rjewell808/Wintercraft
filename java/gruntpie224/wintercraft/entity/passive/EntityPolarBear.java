package gruntpie224.wintercraft.entity.passive;

import com.google.common.base.Predicate;

import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITargetNonTamed;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityPolarBear extends EntityTameable{

	public EntityPolarBear(World par1World) {
		super(par1World);
		this.experienceValue = 7;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(6, new EntityAIWander(this, 0.4D));
		this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAITempt(this, 1.2D, Items.fish, false));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(4, new EntityAITargetNonTamed(this, EntityPenguin.class, false, (Predicate)null));
        this.setSize(1.3F,1.0F);
	}

	 protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(26.0D);
	        
	    }


	public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
        if (this.isEntityInvulnerable(par1DamageSource))
        {
            return false;
        }
        else
        {
            Entity entity = par1DamageSource.getEntity();

            if (entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow))
            {
                par2 = (par2 + 1.0F) / 2.0F;
            }

            return super.attackEntityFrom(par1DamageSource, par2);
        }
    }
	
	public boolean attackEntityAsMob(Entity par1Entity)
    {
        int i = this.isTamed() ? 4 : 2;
        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
    }
	
	public void setAttackTarget(EntityLivingBase par1EntityLivingBase)
    {
        super.setAttackTarget(par1EntityLivingBase);

            this.setAngry(true);
        
    }
	
	 public void setAngry(boolean par1)
	    {
	        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

	        if (par1)
	        {
	            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 | 4)));
	        }
	        else
	        {
	            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b0 & -3)));
	        }
	    }
	 

	
	protected boolean isAIEnabled() {
		
		return true;
	}
	

	protected String getLivingSound()
    {
        return "wc:bearSay";
    }

    protected String getHurtSound()
    {
       return "wc:bearHurt";
    }

    protected String getDeathSound()
    {
        return "wc:bearDeath";
    }

    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        return;
    }
    protected int getDropItemId()
    {
    	return 0;
    }
   
    protected void dropFewItems(boolean par1, int par2)
    {
        int j = this.rand.nextInt(3 + par2) + 0;

        for (int k = 0; k < j; ++k)
        {
            this.entityDropItem(new ItemStack(WinterItems.common_items, 1, 7), 0.0F);
        }
    }
    public EntityPolarBear spawnBabyAnimal(EntityAgeable par1EntityAgeable)
    {
        return new EntityPolarBear(this.worldObj);
    }
    
    public boolean isBreedingItem(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.getItem() == Items.fish;
    }
    
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    }

	@Override
	 public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.spawnBabyAnimal(par1EntityAgeable);
    }
}