package gruntpie224.wintercraft.items;

import java.util.List;

import javax.annotation.Nullable;

import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCandyCaneSword extends ItemBasicSword {
	public ItemCandyCaneSword(String name, ToolMaterial material) {
		super(name, material, null);
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add("\u00a7cSneak + Attack for a treat!");
    }
	
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {	
		if(!par3EntityLivingBase.world.isRemote && par3EntityLivingBase.isSneaking()){
			par3EntityLivingBase.dropItem(WinterItems.candy_cane, 1);
			par1ItemStack.damageItem(6, par3EntityLivingBase);
			return true;
		} else {
			par1ItemStack.damageItem(1, par3EntityLivingBase);
		}
		return true;
    }
}
