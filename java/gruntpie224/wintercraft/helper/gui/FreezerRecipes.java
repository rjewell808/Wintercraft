package gruntpie224.wintercraft.helper.gui;

import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FreezerRecipes {
	
	public static ItemStack getFreezerRecipe(ItemStack item1, ItemStack item2)
	{
		//Ice
		if(itemsEqual(item1, item2, new ItemStack(Items.WATER_BUCKET, 1), new ItemStack(Items.WATER_BUCKET, 1)))
			return new ItemStack(Item.getItemFromBlock(Blocks.ICE), 4);
		
		//Iced Stone
		if(itemsEqual(item1, item2, new ItemStack(Item.getItemFromBlock(Blocks.STONE), 1), new ItemStack(WinterItems.ice_chunk, 1)))
			return new ItemStack(Item.getItemFromBlock(WinterBlocks.iced_stone), 1);
		
		//Iced Cobblestone
		if(itemsEqual(item1, item2, new ItemStack(Item.getItemFromBlock(Blocks.COBBLESTONE), 1), new ItemStack(WinterItems.ice_chunk, 1)))
			return new ItemStack(Item.getItemFromBlock(WinterBlocks.iced_cobble), 1);
			
		return ItemStack.EMPTY;
	}
	
	private static boolean itemsEqual(ItemStack input1, ItemStack input2, ItemStack item1, ItemStack item2)
	{
		return (input1.isItemEqual(item1) && input2.isItemEqual(item2)) || (input1.isItemEqual(item2) && input2.isItemEqual(item1));
	}
}
