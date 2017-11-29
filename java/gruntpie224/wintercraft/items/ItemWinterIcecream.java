package gruntpie224.wintercraft.items;

import java.util.List;
import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemWinterIcecream extends ItemFood{

	private int food_amount;
	private String extra_info;
	private int potionID;
	
	public ItemWinterIcecream(int amount, float saturation, int potionID, String info) {
		super(amount, saturation, false);
		this.setCreativeTab(Wintercraft.wintercraftTab);
		this.food_amount = amount;
		this.extra_info = info;
		this.potionID = potionID;
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		par3List.add("\u00a7eFills " + (this.food_amount / 2.0) + " Hunger");
		if(extra_info.length() > 0)
			par3List.add(extra_info);
    }
	
	@Override
	public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(potionID != -1)
			par3EntityPlayer.addPotionEffect(new PotionEffect(potionID, 45 * 20, 2));    
    }
}
