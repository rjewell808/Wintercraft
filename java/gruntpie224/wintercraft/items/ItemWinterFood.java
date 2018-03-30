package gruntpie224.wintercraft.items;

import java.util.List;

import javax.annotation.Nullable;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemWinterFood extends ItemFood{

	private int food_amount;
	private boolean is_drink;
	private String extra_info;
	
	public ItemWinterFood(String name, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setCreativeTab(Wintercraft.wcTab);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.food_amount = amount;
		this.extra_info = "";
	}
	
	public ItemWinterFood(String name, int amount, float saturation, boolean isWolfFood, boolean isDrink) {
		super(amount, saturation, isWolfFood);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Wintercraft.wcTab);
		this.food_amount = amount;
		this.is_drink = isDrink;
		this.extra_info = "";
	}
	
	public ItemWinterFood(String name, int amount, float saturation, boolean isWolfFood, boolean isDrink, String info) {
		super(amount, saturation, isWolfFood);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Wintercraft.wcTab);
		this.food_amount = amount;
		this.is_drink = isDrink;
		this.extra_info = info;
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add("\u00a7eFills " + (this.food_amount / 2.0) + " Hunger");
		if(extra_info.length() > 0)
			tooltip.add(extra_info);
    }
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
		if(is_drink)
			return EnumAction.DRINK;
		
		return EnumAction.EAT;
    }
	
	@Override
	public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if(is_drink)
        	par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WinterItems.empty_mug));
    }
}