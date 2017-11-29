package gruntpie224.wintercraft.items;

import gruntpie224.wintercraft.Wintercraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemBasicAxe extends ItemAxe{

	public Item repair;
	public Boolean candycane;
	
	public ItemBasicAxe(ToolMaterial par2EnumToolMaterial, Item parRepair) {
		super(par2EnumToolMaterial);
		this.setCreativeTab(Wintercraft.wintercraftTab);
		this.repair = parRepair;
	}
	
	public ItemBasicAxe(ToolMaterial par2Tool){
		super(par2Tool);
		this.setCreativeTab(Wintercraft.wintercraftTab);
		this.setMaxDamage(75);
	}

	@Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
    	return par2ItemStack.isItemEqual(new ItemStack(this.repair, 1, 0)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}
