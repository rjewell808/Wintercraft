package gruntpie224.wintercraft.helper.tileEntity;

import gruntpie224.wintercraft.blocks.BlockFreezer;
import gruntpie224.wintercraft.helper.gui.ContainerFreezer;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import gruntpie224.wintercraft.recipe.FreezerRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.common.registry.GameRegistry;


public class TileEntityFreezer extends TileEntity implements IInventory, ITickable
{
	private ItemStack blastItemStacks[];
	private Boolean debug = true;
	
	public int dualBurnTime;
	public int currentItemBurnTime;
	public int dualCookTime;
	private String customName;
	public int smeltTime;
	
	public static final int FUEL_SLOTS_COUNT = 1;
	public static final int INPUT_SLOTS_COUNT = 2;
	public static final int OUTPUT_SLOTS_COUNT = 1;
	public static final int TOTAL_SLOTS_COUNT = FUEL_SLOTS_COUNT + INPUT_SLOTS_COUNT + OUTPUT_SLOTS_COUNT;
	
	public TileEntityFreezer()
	{
		 blastItemStacks = new ItemStack[4];
		 dualBurnTime = 0;
		 currentItemBurnTime = 0;
		 dualCookTime = 0;
		 smeltTime = 500;
	}
	
	/**
	 * Returns the number of slots in the inventory.
	 */
	@Override
	public int getSizeInventory()
	{
		return blastItemStacks.length;
	}
	
	/**
	 * Returns the stack in slot i
	 */
	public ItemStack getStackInSlot(int i)
	{
		return blastItemStacks[i];
	}
	
	public void setInventorySlotConatainers(int i, ItemStack itemstack)
	{
	     blastItemStacks[i] = itemstack;
	     if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
	     {
	         itemstack.stackSize = getInventoryStackLimit();
	     }
	}
	
	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound nbttagcompound)
	{
		 super.readFromNBT(nbttagcompound);
		 NBTTagList nbttaglist = nbttagcompound.getTagList("Items", 10);
		 blastItemStacks = new ItemStack[getSizeInventory()];
		 for (int i = 0; i < nbttaglist.tagCount(); i++)
		 {
		     NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.getCompoundTagAt(i);
		     byte byte0 = nbttagcompound1.getByte("Slot");
		     if (byte0 >= 0 && byte0 < blastItemStacks.length)
		     {
		                     blastItemStacks[byte0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
		     }
		 }
		 dualBurnTime = nbttagcompound.getShort("BurnTime");
		 dualCookTime = nbttagcompound.getShort("CookTime");
		 currentItemBurnTime = getItemBurnTime(blastItemStacks[1]);
	}
	
	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound nbttagcompound)
	{
	     super.writeToNBT(nbttagcompound);
	     nbttagcompound.setShort("BurnTime", (short)dualBurnTime);
	     nbttagcompound.setShort("CookTime", (short)dualCookTime);
	     NBTTagList nbttaglist = new NBTTagList();
	     for (int i = 0; i < blastItemStacks.length; i++)
	     {
	                     if (blastItemStacks[i] != null)
	                     {
	                                     NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                                     nbttagcompound1.setByte("Slot", (byte)i);
	                                     blastItemStacks[i].writeToNBT(nbttagcompound1);
	                                     nbttaglist.appendTag(nbttagcompound1);
	                     }
	     }
	     nbttagcompound.setTag("Items", nbttaglist);
	}
	
	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
	 * this more of a set than a get?*
	 */
	public int getInventoryStackLimit()
	{
		return 64;
	}
	
	public int getCookProgressScaled(int i)
	{
		return (dualCookTime * i) / smeltTime;
	}
	
	public int getBurnTimeRemainingScaled(int i)
	{
		 if (currentItemBurnTime == 0)
		 {
	         currentItemBurnTime = smeltTime;
		 }
		 return (dualBurnTime * i) / currentItemBurnTime;
	}
	
	public boolean isBurning()
	{
		return dualBurnTime > 0;
	}
	
	/**
	 * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
	 * ticks and creates a new spawn inside its implementation.
	 */
	@Override
	public void update()
	{
	     boolean flag = this.isBurning();
	     boolean flag1 = false;
	     
	     if (dualBurnTime > 0)
	     {
	         dualBurnTime--;
	     }
	     if (!worldObj.isRemote)
	     {
	         if (dualBurnTime == 0 && canSmelt())
	         {
	        	 currentItemBurnTime = dualBurnTime = getItemBurnTime(blastItemStacks[2]);
		         if (dualBurnTime > 0)
		         {
	                 flag1 = true;
	             
	                 if (blastItemStacks[2] != null)
	                 {
	                     if (blastItemStacks[2].stackSize == 0)
	                     {
	                         blastItemStacks[2] = new ItemStack(blastItemStacks[2].getItem().setFull3D());
	                     }
	                     else
	                     {
	                         blastItemStacks[2].stackSize--;
	                     }
	                     if (blastItemStacks[2].stackSize == 0)
	                     {
	                         blastItemStacks[2] = null;
	                     }
	                 }
		         }
	         }
	         if (isBurning() && canSmelt())
	         {
	             dualCookTime++;
	             if (dualCookTime == smeltTime)
	             {
	                 dualCookTime = 0;
	                 smeltItem();
	                 flag1 = true;
	             }
	         }
	         else
	         {
	             dualCookTime = 0;
	         }
	         if (flag != (dualBurnTime > 0))
	         {
	             flag1 = true;
	             BlockFreezer.setState(this.isBurning(), this.worldObj, this.pos);
	         }
	     }
	     if (flag1)
	     {
	    	 this.markDirty();
	     }
	}
	private boolean canSmelt()
	{
		 if (blastItemStacks[0] == null || blastItemStacks[1] == null)
		 {
			 return false;
		 }
		 ItemStack itemstack = FreezerRecipes.getSmeltingResult(blastItemStacks[0].getItem(), blastItemStacks[1].getItem(), blastItemStacks[0].getItemDamage(), blastItemStacks[1].getItemDamage());
		 if (itemstack == null)
		 {
			 return false;
		 }
		 if (blastItemStacks[3] == null)
		 {
			 return true;
		 }
		 if (!blastItemStacks[3].isItemEqual(itemstack))
		 {
			 return false;
		 }
		 if (blastItemStacks[3].stackSize < getInventoryStackLimit() && blastItemStacks[3].stackSize < blastItemStacks[3].getMaxStackSize())
		 {
			 return true;
		 }
		 else
		 {
			 return blastItemStacks[3].stackSize < itemstack.getMaxStackSize();
		 }
	}
	
	public void bucketCheck(){
		for(int i=0;i<2;i++){
			if (blastItemStacks[i].getItem() == Items.water_bucket || blastItemStacks[i].getItem() == Items.milk_bucket){
				blastItemStacks[i] = new ItemStack(Items.bucket);
			}
		}
	}
	
	public void smeltItem()
	{
		 if (!canSmelt())
		 {
			 if(debug) System.out.println("Cannot Smelt");
			 return;
		 }
		 ItemStack itemstack = FreezerRecipes.getSmeltingResult(blastItemStacks[0].getItem(), blastItemStacks[1].getItem(), blastItemStacks[0].getItemDamage(), blastItemStacks[1].getItemDamage());
		 if (blastItemStacks[3] == null)
		 {
			 blastItemStacks[3] = itemstack.copy();
			 System.out.println("Replace");
		 }
		 else if (blastItemStacks[3].getItem() == itemstack.getItem())
		 {
			 blastItemStacks[3].stackSize += itemstack.stackSize;
			 System.out.println(itemstack.stackSize);
		 }else{
			 System.out.println("Nothing");
			 System.out.println(blastItemStacks[3]);
			 System.out.println(itemstack);
		 }
		 bucketCheck();
		 for (int i = 0; i < 2; i++)
		 {
			 if (blastItemStacks[i].stackSize <= 0)
			 {
				 blastItemStacks[i] = new ItemStack(blastItemStacks[i].getItem().setFull3D());
			 }
			 else
			 {
				 if(blastItemStacks[i].getItem() != Items.bucket){
					 blastItemStacks[i].stackSize--;
				 }
			 }
			 if (blastItemStacks[i].stackSize <= 0)
			 {
				 blastItemStacks[i] = null;
			 }
		 }
	}
	
	public static int getItemBurnTime(ItemStack itemstack)
	{
	     if (itemstack == null)
	     {
	             return 0;
	     }
	     Item i = itemstack.getItem();
	     if (i == Items.snowball)
	     {
	             return 100;
	     }
	     if (i == Item.getItemFromBlock(Blocks.snow_layer))
	     {
	             return 150;
	     }
	     if (i == Item.getItemFromBlock(WinterBlocks.snow_slab_single))
	     {
	             return 150;
	     }
	     if (i == WinterItems.snowball_ice)
	     {
	             return 300;
	     }
	     if (i == Item.getItemFromBlock(Blocks.snow))
	     {
	             return 400;
	     }
	     if (i == Item.getItemFromBlock(WinterBlocks.snow_bricks))
	     {
	             return 500;
	     }
	     if (i == Item.getItemFromBlock(WinterBlocks.snow_stairs))
	     {
	             return 1800;
	     }
	     if (i == Item.getItemFromBlock(Blocks.ice))
	     {
	             return 2400;
	     }
	     if (i == Item.getItemFromBlock(Blocks.packed_ice))
	     {
	             return 2600;
	     }
	     else
	     {
	    	 return GameRegistry.getFuelValue(itemstack);
	     }
	}
	
	
	//Return true if the given player is able to use this block. In this case it checks that
		// 1) the world tileentity hasn't been replaced in the meantime, and
		// 2) the player isn't too far away from the centre of the block
		@Override
		/**
	     * Do not make give this method the name canInteractWith because it clashes with Container
	     */
	    public boolean isUseableByPlayer(EntityPlayer player)
	    {
	        return this.worldObj.getTileEntity(this.pos) != this ? false : player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
	    }
	
	
	/**
	 * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
	 * stack.
	 */
	public ItemStack decrStackSize(int i, int j)
	{
	     if (blastItemStacks[i] != null)
	     {
	         if (blastItemStacks[i].stackSize <= j)
	         {
	             ItemStack itemstack = blastItemStacks[i];
	             blastItemStacks[i] = null;
	             return itemstack;
	         }
	         ItemStack itemstack1 = blastItemStacks[i].splitStack(j);
	         if (blastItemStacks[i].stackSize == 0)
	         {
	             blastItemStacks[i] = null;
	         }
	         return itemstack1;
	     }
	     else
	     {
	         return null;
	     }
	}
	
	/**
	* Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
	*/
	public void setInventorySlotContents(int i, ItemStack itemstack)
	{
		 blastItemStacks[i] = itemstack;
		 if (itemstack != null && itemstack.stackSize > getInventoryStackLimit())
		 {
	         itemstack.stackSize = getInventoryStackLimit();
		 }
	}
	/**
	 * Returns the name of the inventory.
	 */
	public String getInventoryName()
	{
	   return "Freezer";
	}
	
	/**
	 * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	public ItemStack getStackInSlotOnClosing(int i)
	{
		 if (blastItemStacks[i] != null)
		 {
	         ItemStack itemstack = blastItemStacks[i];
	         blastItemStacks[i] = null;
	         return itemstack;
		 }
		 else
		 {
	         return null;
		 }
	}
	
	public boolean hasCustomInventoryName()
	{
		return (this.customName != null) && (this.customName.length() > 0);
	}
	
	public void setCustomName(String name)
	{
		this.customName = name;
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}
	
	public void setCustomInventoryName(String displayName) {
	
		displayName="Freezer";
	        
	}
	
	/**
	* Return true if item is an energy source (i.e. a charged rune)
	*/
	public static boolean isItemFuel(ItemStack itemstack)
	{
	return getItemBurnTime(itemstack) > 0;
	}
	
	@Override
	public String getName()
	{
		return "Freezer";
	}
	
	@Override
	public boolean hasCustomName()
	{
		return (this.customName != null) && (this.customName.length() > 0);
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void openInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void closeInventory(EntityPlayer player) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public int getField(int id) {
		switch(id)
		{
			case 0:
				return this.dualBurnTime;
			case 1:
				return this.currentItemBurnTime;
			case 2:
				return this.dualCookTime;
			case 3:
				return this.smeltTime;
			default:
				return 0;
		}
	}
	
	@Override
	public void setField(int id, int value) {
		switch(id)
		{
			case 0:
				this.dualBurnTime = value;
			case 1:
				this.currentItemBurnTime = value;
			case 2:
				this.dualCookTime = value;
			case 3:
				this.smeltTime = value;
		}	
	}
	
	@Override
	public int getFieldCount()
	{
		return 4;
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public IChatComponent getDisplayName() {
		// TODO Auto-generated method stub
		return null;
	}

}
