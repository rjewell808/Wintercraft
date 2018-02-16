package wintercraft.items;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ItemCandyCaneSword extends ItemBasicSword{

	public ItemCandyCaneSword(ToolMaterial par2EnumToolMaterial) {
		super(par2EnumToolMaterial);
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		par3List.add("\u00a7cAttack + Sneak for a treat!");
    }
	
	@Override
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {	
		if(!par3EntityLivingBase.worldObj.isRemote && par3EntityLivingBase.isSneaking()){
			
			par3EntityLivingBase.dropItem(WinterItems.candyCane, 1);
			par1ItemStack.damageItem(6, par3EntityLivingBase);
			return true;
		} else {par1ItemStack.damageItem(1, par3EntityLivingBase);}
		return true;
    }
	
       
}


