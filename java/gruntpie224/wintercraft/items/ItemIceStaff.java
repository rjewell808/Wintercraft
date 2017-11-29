package gruntpie224.wintercraft.items;

import gruntpie224.wintercraft.entity.projectiles.EntityStaff;
import gruntpie224.wintercraft.helper.achievements.WinterAch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemIceStaff extends Item{

	 private final boolean isActive;
	
	public ItemIceStaff(boolean par2) {
		super();
		this.isActive = par2;
		this.setMaxStackSize(1);
		this.setFull3D();
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(par3EntityPlayer.dimension != 1)
		{
	        if (!par3EntityPlayer.capabilities.isCreativeMode)
	        {    	
	        	if (this.isActive)
	        	{
	        		par1ItemStack.damageItem(2, par3EntityPlayer);
	        	} 
	        	else 
	        	{
	        		par1ItemStack.damageItem(1, par3EntityPlayer);
        		}
	        }
	
	        if (this.isActive)
	        {
	        	par2World.playSoundAtEntity(par3EntityPlayer, "random.breath", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        }
	        else
	        {
	        	par3EntityPlayer.addStat(WinterAch.iceStaff, 1);
	        	par2World.playSoundAtEntity(par3EntityPlayer, "random.orb", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        }
	
	        
            if (this.isActive)
            {
            	if(!par3EntityPlayer.worldObj.isRemote)
            	{
		            par3EntityPlayer.addStat(WinterAch.iceStaffBad, 1);
		            par2World.createExplosion(par3EntityPlayer, par3EntityPlayer.posX, par3EntityPlayer.posY, par3EntityPlayer.posZ, 3F, true);
		            
            	}
            }
            else
            {
            	par2World.spawnEntityInWorld(new EntityStaff(par2World, par3EntityPlayer));
        	}
		}
        return par1ItemStack;
    }
}

