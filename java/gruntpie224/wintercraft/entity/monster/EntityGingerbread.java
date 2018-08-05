package gruntpie224.wintercraft.entity.monster;

import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.WintercraftReference;
import gruntpie224.wintercraft.helper.WCSounds;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityGingerbread extends EntityMob {

	private EntityPlayer player;
	public static final ResourceLocation LOOT = new ResourceLocation(WintercraftReference.MOD_ID, "models/gingerbreadman");
	
	public EntityGingerbread(World par1World) {
		super(par1World);
		this.experienceValue = 5;
	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(18.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(15.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.0D);
    }

	
	protected boolean isAIEnabled() {
		
		return true;
	}
	
	@Override
	protected void initEntityAI() {
		this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIAttackMelee(this, 0.5D, false));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.4D));
        this.tasks.addTask(7, new EntityAIWander(this, 0.4D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
//        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityElf.class, false));
	}

	protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
	     return WCSounds.snd_gingerbread_hit;
    }

    protected SoundEvent getDeathSound()
    {
        return WCSounds.snd_gingerbread_death;
    }
    
    @Override
    protected Item getDropItem()
    {
        Random rand = new Random();
        
//        if(rand.nextInt(200) <= 3 && !world.isDaytime())
//        	return WinterItems.music_disk_halls;
        
    	return WinterItems.gingerbread_man;
    }
    
    @Override
    protected void dropFewItems(boolean par1, int par2)
    {
    	int j = this.rand.nextInt(3) + this.rand.nextInt(1 + par2);
        int k;
        
        
        this.dropItem(this.getDropItem(), 1);
        if(this.rand.nextInt(3) > 1)
        {
	        for (k = 0; k < j+1; ++k)
	        {
	        	this.entityDropItem(new ItemStack(Items.DYE, 1, 3), 1.0F);
	        }
        }
    }
    
    @Override
    public EnumCreatureAttribute getCreatureAttribute()
    {
		return EnumCreatureAttribute.UNDEAD;	
    }
    
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    }
}