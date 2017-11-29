package gruntpie224.wintercraft.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterItems;

public class ArmorRef extends ItemArmor {

	public ArmorRef(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(Wintercraft.wintercraftTab);
	}
    
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == WinterItems.ref_helmet || stack.getItem() == WinterItems.ref_plate|| stack.getItem() == WinterItems.ref_boots)
		{
			return "wc:textures/armor/refined_1.png";
		}
		if (stack.getItem() == WinterItems.ref_legs)
		{
			return "wc:textures/armor/refined_2.png";
		}
		return null;
	}
}

