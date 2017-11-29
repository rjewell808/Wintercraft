package gruntpie224.wintercraft.entity.monster;

import gruntpie224.wintercraft.entity.projectiles.EntityRockySnowballGolem;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityMiniSnowGolem extends EntityMob implements IRangedAttackMob{

	private World world;
	
	public EntityMiniSnowGolem(World par1World) {
		super(par1World);
		this.world = par1World;
		this.experienceValue = 5;
        this.setSize(0.4F, 1.0F);
        ((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAIArrowAttack(this, 1.25D, 20, 10.0F));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}

	protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
    }

	 public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLivingBase, float par2)
	    {
		    EntityRockySnowballGolem entitysnowball = new EntityRockySnowballGolem(this.worldObj, this);
	        double d0 = par1EntityLivingBase.posX - this.posX;
	        double d1 = par1EntityLivingBase.posY + (double)par1EntityLivingBase.getEyeHeight() - 1.100000023841858D - entitysnowball.posY;
	        double d2 = par1EntityLivingBase.posZ - this.posZ;
	        float f1 = MathHelper.sqrt_double(d0 * d0 + d2 * d2) * 0.2F;
	        entitysnowball.setThrowableHeading(d0, d1 + (double)f1, d2, 1.6F, 12.0F);
	        this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
	        this.worldObj.spawnEntityInWorld(entitysnowball);
	    }
	
	
	protected boolean isAIEnabled() {
		
		return true;
	}
	

	protected String getLivingSound()
    {
        return "wc:golemSay";
    }

    protected String getHurtSound()
    {
       return "wc:golemHurt";
    }

    protected String getDeathSound()
    {
        return "wc:golemDeath";
    }

    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
    	this.playSound("wc:golemStep", 0.7F, 1.0F);
    }
    
    
    protected Item getDropItem()
    {
    	int randomItem = worldObj.rand.nextInt(200);
    	
    	if(randomItem <= 3 && !world.isDaytime())
    		return WinterItems.music_disk_jingle;
    	
    	if(randomItem <= 60)
    		return Item.getItemFromBlock(Blocks.ice);
    	
    	return WinterItems.ice_chunk;	
    }
    
    /*
    @Override
    protected void dropRareDrop(int par1)
    {
    	this.entityDropItem(new ItemStack(WinterItems.christmasMusicDisk, 1, 0), 0.0F);   
    }
    */
    
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
    
    public EnumCreatureAttribute getCreatureAttribute()
    {
		return EnumCreatureAttribute.UNDEAD;
    	
    }
    
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    }
}