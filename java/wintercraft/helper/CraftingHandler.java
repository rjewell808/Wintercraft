package wintercraft.helper;

import wintercraft.Wintercraft;
import wintercraft.blocks.WinterBlocks;
import wintercraft.helper.achievements.WinterAch;
import wintercraft.items.WinterItems;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.ItemSmeltedEvent;

public class CraftingHandler{

	@SubscribeEvent
	public void smeltEvent(ItemSmeltedEvent event){
	}
	
	@SubscribeEvent
	public void pickUpEvent(PlayerEvent.ItemPickupEvent event){
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(WinterItems.iceShard))){
			event.player.addStat(WinterAch.iceShard, 1);
		}
		if(event.pickedUp.getEntityItem().isItemEqual(new ItemStack(WinterItems.itemOrnamentRare))){
			event.player.addStat(WinterAch.rareOrnament, 1);
		}
	}
	
	@SubscribeEvent
	public void craftingEvent(PlayerEvent.ItemCraftedEvent event){
		if(event.crafting.isItemEqual(new ItemStack(WinterBlocks.freezer))){
			event.player.addStat(WinterAch.freezer, 1);
		}
		
		if(event.crafting.isItemEqual(new ItemStack(WinterItems.iceChunk))){
			event.player.addStat(WinterAch.iceChunk, 1);
		}
		
		if(event.crafting.isItemEqual(new ItemStack(WinterItems.iceGem))){
			event.player.addStat(WinterAch.iceGem, 1);
		}
		
		if(event.crafting.isItemEqual(new ItemStack(WinterItems.Itemornament))){
			event.player.addStat(WinterAch.ornament, 1);
		}
		
		if(event.crafting.isItemEqual(new ItemStack(WinterItems.chillerStick))){
			event.player.addStat(WinterAch.iceChiller, 1);
		}
	}

}
