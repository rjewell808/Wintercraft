package gruntpie224.wintercraft.helper;

import gruntpie224.wintercraft.helper.achievements.WinterAch;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class CraftingHandler{

	@SubscribeEvent
	public void smeltEvent(ItemSmeltedEvent event){
	}
	
	@SubscribeEvent
	public void pickUpEvent(PlayerEvent.ItemPickupEvent event){
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(WinterItems.ice_shard))){
			event.player.addStat(WinterAch.iceShard, 1);
		}
		if(event.pickedUp.getEntityItem().getItem() == WinterItems.ornament_item){
			event.player.addStat(WinterAch.ornament, 1);
		}
		if(event.pickedUp.getEntityItem().getItem() == WinterItems.ornament_item_rare){
			event.player.addStat(WinterAch.rareOrnament, 1);
		}
	}
	
	@SubscribeEvent
	public void craftingEvent(PlayerEvent.ItemCraftedEvent event){
		if(event.crafting.isItemEqual(new ItemStack(WinterBlocks.freezer))){
			event.player.addStat(WinterAch.freezer, 1);
		}
		
		if(event.crafting.isItemEqual(new ItemStack(WinterItems.ice_chunk))){
			event.player.addStat(WinterAch.iceChunk, 1);
		}
		
		if(event.crafting.isItemEqual(new ItemStack(WinterItems.ice_gem))){
			event.player.addStat(WinterAch.iceGem, 1);
		}
		
		if(event.crafting.getItem() == WinterItems.ornament_item){
			event.player.addStat(WinterAch.ornament, 1);
		}
	}

}
