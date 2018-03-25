package gruntpie224.wintercraft.helper;

import java.util.Random;

import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
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
}
