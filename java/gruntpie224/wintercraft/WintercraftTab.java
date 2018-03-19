package gruntpie224.wintercraft;

import gruntpie224.wintercraft.init.WinterBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WintercraftTab extends CreativeTabs{

	public WintercraftTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Item.getItemFromBlock(WinterBlocks.iced_stone));
	}
	
}