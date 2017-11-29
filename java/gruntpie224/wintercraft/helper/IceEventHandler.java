package gruntpie224.wintercraft.helper;

import java.util.Calendar;
import java.util.Random;

import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.INetHandlerPlayClient;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class IceEventHandler {
	
	Random rand = new Random();
	public static boolean userSpecial = false;
	
	@SubscribeEvent
	public void onBlockHarvest(HarvestDropsEvent event)
	{
		if (event.state == Blocks.ice.getDefaultState())
		{
			event.drops.add(new ItemStack(WinterItems.ice_shard, rand.nextInt(3)));
			event.dropChance = 0.8f;
		}
	}
	
	@SubscribeEvent
	public void onCreatureDrop(LivingDropsEvent event){
		Random random = new Random();
		double rand = random.nextInt(20);
		
		if(event.entityLiving instanceof EntityCreeper && rand < 5)
		{
			event.entityLiving.entityDropItem(new ItemStack(WinterItems.ornament_item_rare,1,0), 1);
		}
		
		if(event.entityLiving instanceof EntityEnderman && rand < 7)
		{
			event.entityLiving.entityDropItem(new ItemStack(WinterItems.ornament_item_rare,1,1), 1);
		}
		
		if(event.entityLiving instanceof EntityBlaze && rand < 5)
		{
			event.entityLiving.entityDropItem(new ItemStack(WinterItems.ornament_item_rare,1,2), 1);
		}
	}

}
