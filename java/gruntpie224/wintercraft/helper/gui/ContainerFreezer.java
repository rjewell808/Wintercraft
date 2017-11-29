package gruntpie224.wintercraft.helper.gui;

import gruntpie224.wintercraft.helper.tileEntity.TileEntityFreezer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;


public class ContainerFreezer extends Container
{
	private TileEntityFreezer blast;
	private int dualCookTime;
	private int dualBurnTime;
	private int lastItemBurnTime;
	public static final int INPUT_1 = 0, INPUT_2 = 1, FUEL = 2, OUTPUT = 3;

	public ContainerFreezer(InventoryPlayer inventoryplayer, TileEntityFreezer tileentityInputFurnace)
	{
		 dualCookTime = 0;
		 dualBurnTime = 0;
		 lastItemBurnTime = 0;
		 blast = tileentityInputFurnace;
		 this.addSlotToContainer(new Slot(tileentityInputFurnace, INPUT_1, 38, 17));
		 this.addSlotToContainer(new Slot(tileentityInputFurnace, INPUT_2, 73, 17));
		 this.addSlotToContainer(new Slot(tileentityInputFurnace, FUEL, 56, 53));
		 this.addSlotToContainer(new SlotInputFurnace(inventoryplayer.player, tileentityInputFurnace, OUTPUT, 116, 35));
		
		 for (int i = 0; i < 3; i++)
		 {
		         for (int k = 0; k < 9; k++)
		         {
		                 this.addSlotToContainer(new Slot(inventoryplayer, k + i * 9 + 9, 8 + k * 18, 84 + i * 18));
		         }
		 }
		 for (int j = 0; j < 9; j++)
		 {
		         this.addSlotToContainer(new Slot(inventoryplayer, j, 8 + j * 18, 142));
		 }
	}

	/*
	@Override
	public void addCraftingToCrafters(ICrafting par1ICrafting)
	{
         super.addCraftingToCrafters(par1ICrafting);
         par1ICrafting.sendProgressBarUpdate(this, 0, this.blast.dualCookTime);
         par1ICrafting.sendProgressBarUpdate(this, 1, this.blast.dualBurnTime);
         par1ICrafting.sendProgressBarUpdate(this, 2, this.blast.currentItemBurnTime);
	}
	*/
	/**
     * Looks for changes made in the container, sends them to every listener.
     */
	@Override
	public void detectAndSendChanges()
	{
	     super.detectAndSendChanges();
	     for (int var1 = 0; var1 < this.crafters.size(); ++var1)
	     {
	             ICrafting var2 = (ICrafting)this.crafters.get(var1);
	             if (this.dualCookTime != this.blast.dualCookTime)
	             {
	                     var2.sendProgressBarUpdate(this, 0, this.blast.dualCookTime);
	             }
	             if (this.dualBurnTime != this.blast.dualBurnTime)
	             {
	                     var2.sendProgressBarUpdate(this, 1, this.blast.dualBurnTime);
	             }
	             if (this.lastItemBurnTime != this.blast.currentItemBurnTime)
	             {
	                     var2.sendProgressBarUpdate(this, 2, this.blast.currentItemBurnTime);
	             }
	     }
	     this.dualCookTime = this.blast.dualCookTime;
	     this.dualBurnTime = this.blast.dualBurnTime;
	     this.lastItemBurnTime = this.blast.currentItemBurnTime;
	}

	@Override
	public void updateProgressBar(int i, int j)
	{
	     if (i == 0)
	     {
         	blast.dualCookTime = j;
	     }
	     if (i == 1)
	     {
             blast.dualBurnTime = j;
	     }
	     if (i == 2)
	     {
             blast.currentItemBurnTime = j;
	     }
	}

@Override
/**
* Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
*/
public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
{
	ItemStack itemstack = null;
	
	Slot slot = (Slot)this.inventorySlots.get(par2);
	
	if (slot != null && slot.getHasStack())
	{
		ItemStack itemstack1 = slot.getStack();
		itemstack = itemstack1.copy();
		
		// If itemstack is in Output stack
		if (par2 == OUTPUT)
		{
			// try to place in player inventory / action bar; add 36+1 because mergeItemStack uses < index,
			// so the last slot in the inventory won't get checked if you don't add 1
			if (!this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+36+1, true))
			{
				return null;
			}
			
			slot.onSlotChange(itemstack1, itemstack);
		}
		// itemstack is in player inventory, try to place in appropriate furnace slot
		else if (par2 != FUEL && par2 != INPUT_1 && par2 != INPUT_2)
		{
			// if it can be smelted, place in the input slots
			System.out.println(TileEntityFreezer.isItemFuel(itemstack1));
			if (TileEntityFreezer.isItemFuel(itemstack1))
			{
				if (!this.mergeItemStack(itemstack1, FUEL, FUEL+1, false))
				{
					return null;
				}
			}
			// item in player's inventory, but not in action bar
			else if (par2 >= OUTPUT+1 && par2 < OUTPUT+28)
			{
			// place in action bar
			if (!this.mergeItemStack(itemstack1, OUTPUT+28, OUTPUT+37, false))
			{
			return null;
			}
			}
			// item in action bar - place in player inventory
			else if (par2 >= OUTPUT+28 && par2 < OUTPUT+37 && !this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+28, false))
			{
			return null;
			}
		}
		// In one of the infuser slots; try to place in player inventory / action bar
		else if (!this.mergeItemStack(itemstack1, OUTPUT+1, OUTPUT+37, false))
		{
		return null;
		}
		
		if (itemstack1.stackSize == 0)
		{
		slot.putStack((ItemStack)null);
		}
		else
		{
		slot.onSlotChanged();
		}
		
		if (itemstack1.stackSize == itemstack.stackSize)
		{
		return null;
		}
		
		slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
	}
	return itemstack;
}

@Override
public boolean canInteractWith(EntityPlayer entityplayer)
{
         return blast.isUseableByPlayer(entityplayer);
}
}