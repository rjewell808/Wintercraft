package gruntpie224.wintercraft;

import gruntpie224.wintercraft.init.WinterBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class WintercraftTab extends CreativeTabs{

	public WintercraftTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(WinterBlocks.iced_stone);
	}
	
}