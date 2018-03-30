package gruntpie224.wintercraft.helper;

import java.util.Random;

import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemDropHandler {
	Random rand = new Random();
	public static boolean userSpecial = false;
	
	@SubscribeEvent
	public void onBlockHarvest(HarvestDropsEvent event)
	{
		if (event.getState() == Blocks.ICE.getDefaultState())
		{
			event.getDrops().add(new ItemStack(WinterItems.ice_shard, rand.nextInt(3)));
			event.setDropChance(0.4f);
		}
	}
	
	@SubscribeEvent
	public void onCreatureDrop(LivingDropsEvent event)
	{
		Random random = new Random();
		double rand = random.nextInt(20);
		EntityLivingBase entity = event.getEntityLiving();
		
		if(entity instanceof EntityPolarBear && rand < 10)
			entity.entityDropItem(new ItemStack(WinterItems.polarbear_fur, 1 + random.nextInt(2)), 1);
		
		if(entity instanceof EntityCreeper && rand < 5)
		{
			entity.entityDropItem(new ItemStack(Item.getItemFromBlock(WinterBlocks.ornament_rare),1,0), 1);
		}
		
		if(entity instanceof EntityEnderman && rand < 7)
		{
			entity.entityDropItem(new ItemStack(Item.getItemFromBlock(WinterBlocks.ornament_rare),1,1), 1);
		}
		
		if(entity instanceof EntityBlaze && rand < 5)
		{
			entity.entityDropItem(new ItemStack(Item.getItemFromBlock(WinterBlocks.ornament_rare),1,2), 1);
		}
	}	
}
