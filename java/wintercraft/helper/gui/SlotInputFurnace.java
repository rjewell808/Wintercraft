package wintercraft.helper.gui;

import wintercraft.blocks.WinterBlocks;
import wintercraft.helper.achievements.WinterAch;
import wintercraft.items.WinterItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotInputFurnace extends Slot
{
	public SlotInputFurnace(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
	{
		super(iinventory, i, j, k);
	}
	/**
	 * Check if the stack is a valid item for this slot. Always true beside for the armor slots.
	 */
	public boolean isItemValid(ItemStack itemstack)
	{
		return false;
	}
	/**
	 * Called when the player picks up an item from an inventory slot
	 */
	public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
	{
		 this.onCrafting(par2ItemStack);
		 if(par2ItemStack.getItem() == Item.getItemFromBlock(WinterBlocks.icedStone)){
			 par1EntityPlayer.addStat(WinterAch.icedStone, 1);
		 }
		 if(par2ItemStack.getItem() == WinterItems.iceCrystal){
			 par1EntityPlayer.addStat(WinterAch.iceCrystal, 1);
		 }
		 if(par2ItemStack.getItem() == WinterItems.iceIngot){
			par1EntityPlayer.addStat(WinterAch.iceIngot, 1);
		 }
		 super.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
	}
}