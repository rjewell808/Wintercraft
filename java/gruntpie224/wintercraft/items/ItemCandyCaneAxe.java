package gruntpie224.wintercraft.items;

import gruntpie224.wintercraft.Wintercraft;
import net.minecraft.item.ItemAxe;

public class ItemCandyCaneAxe extends ItemAxe {
	public ItemCandyCaneAxe(String name, ToolMaterial material) {
		super(material, 6.0F, -3.0F);
		this.setCreativeTab(Wintercraft.wcTab);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}

}
