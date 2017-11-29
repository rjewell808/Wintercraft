package gruntpie224.wintercraft.items;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterItems;

public class ArmorCrystal extends ItemArmor
{

	public ArmorCrystal(ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(Wintercraft.wintercraftTab);
	}
    
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == WinterItems.cry_helmet || stack.getItem() == WinterItems.cry_plate|| stack.getItem() == WinterItems.cry_boots)
		{
			return "wc:textures/armor/crystal_1.png";
		}
		if (stack.getItem() == WinterItems.cry_legs)
		{
			return "wc:textures/armor/crystal_2.png";
		}
		
		return null;
	}
	 
}

