package wintercraft.helper;

import java.util.Calendar;
import java.util.Random;

import wintercraft.Wintercraft;
import wintercraft.blocks.BlockStar;
import wintercraft.blocks.WinterBlocks;
import wintercraft.helper.achievements.WinterAch;
import wintercraft.items.WinterItems;
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
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ServerConnectionFromClientEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class IceEventHandler {
	
	Random rand = new Random();
	public static boolean userSpecial = false;
	

	
	@SubscribeEvent
	public void onBlockHarvest(HarvestDropsEvent event) {
		if (event.block == Blocks.ice){
			event.drops.clear(); // remove vanilla drops
			event.drops.add(new ItemStack(WinterItems.iceShard,0 + rand.nextInt(3)));
			event.dropChance = 0.9f;
		}
	}
	
	@SubscribeEvent
	public void onCreatureDrop(LivingDropsEvent event){
		Random random = new Random();
		double rand = random.nextInt(20);
		
		if(event.entityLiving instanceof EntityCreeper && rand < 5)
		{
			event.entityLiving.entityDropItem(new ItemStack(WinterItems.itemOrnamentRare,1,0), 1);
		}
		
		if(event.entityLiving instanceof EntityEnderman && rand < 7)
		{
			event.entityLiving.entityDropItem(new ItemStack(WinterItems.itemOrnamentRare,1,1), 1);
		}
		
		if(event.entityLiving instanceof EntityBlaze && rand < 5)
		{
			event.entityLiving.entityDropItem(new ItemStack(WinterItems.itemOrnamentRare,1,2), 1);
		}
	}

}
