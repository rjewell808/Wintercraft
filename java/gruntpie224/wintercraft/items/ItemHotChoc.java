package gruntpie224.wintercraft.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterItems;

public class ItemHotChoc extends ItemFood{

	public ItemHotChoc(int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setMaxStackSize(1);
		this.setCreativeTab(Wintercraft.wintercraftTab);
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		par3List.add("\u00a7eFills 8 Hunger");
		par3List.add("\u00a7bGives a Speed Boost");
    }
	
	@Override
    public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
		par3EntityPlayer.inventory.addItemStackToInventory(new ItemStack(WinterItems.common_items));
		par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 15 * 20, 1));    
    }
	
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
		return EnumAction.DRINK;
    }
	
	@SideOnly(Side.CLIENT)
	public boolean isFull3D() {
		return true;
	}

}
