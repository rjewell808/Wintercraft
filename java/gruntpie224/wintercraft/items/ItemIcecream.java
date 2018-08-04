package gruntpie224.wintercraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemIcecream extends ItemWinterFood {
	
	private int potionID;
	
	public ItemIcecream(String name, int amount, float saturation, int potionID, String info) {
		super(name, amount, saturation, false, false, info);
		this.potionID = potionID;
	}
	
	@Override
	public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		if(potionID != -1)
			par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.getPotionById(potionID), 45 * 20, 2)); 
    }
}
