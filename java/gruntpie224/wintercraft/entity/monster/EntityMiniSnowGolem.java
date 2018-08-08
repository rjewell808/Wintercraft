package gruntpie224.wintercraft.entity.monster;

import java.util.Random;

import gruntpie224.wintercraft.WintercraftReference;
import gruntpie224.wintercraft.helper.WCSounds;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMiniSnowGolem extends EntityMob {
	private EntityPlayer player;
	public static final ResourceLocation LOOT = new ResourceLocation(WintercraftReference.MOD_ID, "models/minisnowgolem");
	
	public EntityMiniSnowGolem(World par1World) {
		super(par1World);
		this.experienceValue = 5;
	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
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
	     return WCSounds.snd_minisnowgolem_hurt;
    }

    protected SoundEvent getDeathSound()
    {
        return WCSounds.snd_minisnowgolem_death;
    }
    
    protected SoundEvent getAmbientSound()
    {
    	return WCSounds.snd_minisnowgolem_say;
    }
    
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound(WCSounds.snd_minisnowgolem_step, 0.15F, 1.0F);
    }
    
    @Override
    protected Item getDropItem()
    {
    	int randomItem = world.rand.nextInt(200);
    	
    	if(randomItem <= 3 && !world.isDaytime())
    		return WinterItems.music_disk_jingle;
    	
    	if(randomItem <= 60)
    		return Item.getItemFromBlock(Blocks.ICE);
    	
    	return WinterItems.ice_chunk;	
    }
    
    @Override
    protected void dropFewItems(boolean par1, int par2)
    {
        Item j = this.getDropItem();

        if (j != null)
        {
            int k = this.rand.nextInt(3);

            if (par2 > 0)
            {
                k += this.rand.nextInt(par2 + 1);
            }

            for (int l = 0; l < k; ++l)
            {
                this.dropItem(j, 1);
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
