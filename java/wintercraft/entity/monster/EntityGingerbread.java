package wintercraft.entity.monster;

import wintercraft.entity.passive.EntityElf;
import wintercraft.items.WinterItems;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityGingerbread extends EntityMob{

	EntityPlayer player;
	
	public EntityGingerbread(World par1World) {
		super(par1World);
		this.experienceValue = 5;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 0.5D, false));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, EntityElf.class, 0.5D, true));
		this.tasks.addTask(6, new EntityAIWander(this, 0.4D));
        this.tasks.addTask(7, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityElf.class, 0, false));
	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(18.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(3.0D);
    }

	
	protected boolean isAIEnabled() {
		
		return true;
	}
	

	protected String getLivingSound()
    {
        return null;
    }

    protected String getHurtSound()
    {
	     return "wintercraft:gingerBreadHit";
    }

    protected String getDeathSound()
    {
        return "wintercraft:gingerBreadDeath";
    }

    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        return;
    }
    
    protected Item getDropItem()
    {
        return WinterItems.gingerbreadMan;
    }
    
    protected void dropFewItems(boolean par1, int par2)
    {
    	int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
        int k;
        
        
        if(this.rand.nextInt(2) + 1 == 1){
	        for (k = 0; k < j+1; ++k)
	        {
	        	this.entityDropItem(new ItemStack(Items.dye, 1, 3), 1.0F);
	        }
        }
        else{
        	j = this.rand.nextInt(2) + this.rand.nextInt(1 + par2);
	        for (k = 0; k < j; ++k)
	        {
	        	this.dropItem(WinterItems.gingerbreadMan, 1);
	        }
        }
    }
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
		return EnumCreatureAttribute.UNDEAD;
    	
    }
    
    @Override
    protected void dropRareDrop(int par1)
    {
            this.entityDropItem(new ItemStack(WinterItems.deckTheHallsRecord, 1, 0), 0.0F);   
    }
    
    @Override
	public ItemStack getHeldItem() {
		return new ItemStack(WinterItems.commonItem, 1, 7);
	}
    
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    }
}