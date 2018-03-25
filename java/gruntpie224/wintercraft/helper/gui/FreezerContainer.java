package gruntpie224.wintercraft.helper.gui;

import gruntpie224.wintercraft.tileentity.TileEntityFreezer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnaceOutput;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class FreezerContainer extends Container
{
	private TileEntityFreezer tileFreezer;
	private int cookTime;
	private int totalCookTime;
	private int furnaceBurnTime;
	private int currentItemBurnTime;
	public static final int INPUT_1 = 0, INPUT_2 = 1, FUEL = 2, OUTPUT = 3;

	public FreezerContainer(InventoryPlayer inventoryplayer, TileEntityFreezer tileentityInputFurnace)
	{
		 cookTime = 0;
		 furnaceBurnTime = 0;
		 currentItemBurnTime = 0;
		 tileFreezer = tileentityInputFurnace;
		 this.addSlotToContainer(new Slot(tileentityInputFurnace, INPUT_1, 38, 17));
		 this.addSlotToContainer(new Slot(tileentityInputFurnace, INPUT_2, 73, 17));
		 this.addSlotToContainer(new Slot(tileentityInputFurnace, FUEL, 56, 53));
		 this.addSlotToContainer(new SlotFurnaceOutput(inventoryplayer.player, tileentityInputFurnace, OUTPUT, 116, 35));
		
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

	public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, this.tileFreezer);
    }
	
	/**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener icontainerlistener = this.listeners.get(i);

            if (this.cookTime != this.tileFreezer.getField(2))
            {
                icontainerlistener.sendWindowProperty(this, 2, this.tileFreezer.getField(2));
            }

            if (this.furnaceBurnTime != this.tileFreezer.getField(0))
            {
                icontainerlistener.sendWindowProperty(this, 0, this.tileFreezer.getField(0));
            }

            if (this.currentItemBurnTime != this.tileFreezer.getField(1))
            {
                icontainerlistener.sendWindowProperty(this, 1, this.tileFreezer.getField(1));
            }

            if (this.totalCookTime != this.tileFreezer.getField(3))
            {
                icontainerlistener.sendWindowProperty(this, 3, this.tileFreezer.getField(3));
            }
        }

        this.cookTime = this.tileFreezer.getField(2);
        this.furnaceBurnTime = this.tileFreezer.getField(0);
        this.currentItemBurnTime = this.tileFreezer.getField(1);
        this.totalCookTime = this.tileFreezer.getField(3);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.tileFreezer.setField(id, data);
    }

    /**
     * Handle when the stack in slot {@code index} is shift-clicked. Normally this moves the stack between the player
     * inventory and the other inventory(s).
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 1 && index != 0)
            {
                if (!FurnaceRecipes.instance().getSmeltingResult(itemstack1).isEmpty())
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

	/**
	 * Determines whether supplied player can use this container
	 */
	public boolean canInteractWith(EntityPlayer playerIn)
	{
	    return this.tileFreezer.isUsableByPlayer(playerIn);
	}

}
