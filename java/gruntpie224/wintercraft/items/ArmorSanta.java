package gruntpie224.wintercraft.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterItems;

public class ArmorSanta extends ItemArmor {

	public String armorNamePrefix;
	public ArmorSanta(ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String armornamePrefix) 
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(Wintercraft.wintercraftTab);
		armorNamePrefix = armornamePrefix;
	}
  
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == WinterItems.santa_plate || stack.getItem() == WinterItems.santa_boots) 
		{
			return "wc:textures/armor/santa_1.png";
		}
		
		if (stack.getItem() == WinterItems.santa_legs) 
		{
			return "wc:textures/armor/santa_2.png";
		}
		return null;
	}
	 
	 @Override
	 public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
	     
	     if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) 
	     {
	     	   ItemStack helmet = player.getCurrentArmor(3);
	     	   ItemStack plate = player.getCurrentArmor(2);
	     	   ItemStack legs = player.getCurrentArmor(1);
	     	   ItemStack boots = player.getCurrentArmor(0);
	     	   
	     	   if (helmet.getItem() == WinterItems.santa_helmet && plate.getItem() == WinterItems.santa_plate && legs.getItem() == WinterItems.santa_legs && boots.getItem() == WinterItems.santa_boots) {
	     		   WinterItems.santa_armour = true;
	     	   } 
	     	 
     	 }
	     else 
	     {
	    	 WinterItems.santa_armour = false;
    	 }
	     
	 }

}

