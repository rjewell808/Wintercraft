package gruntpie224.wintercraft.items;

import gruntpie224.wintercraft.Wintercraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ItemBasicSword extends ItemSword{

	public static Item repair;
	
	public ItemBasicSword(ToolMaterial par2EnumToolMaterial,Item repair) {
		super(par2EnumToolMaterial);
		this.setCreativeTab(Wintercraft.wintercraftTab);
		this.repair = repair;
	}
	
	public ItemBasicSword(ToolMaterial par2Tool){
		super(par2Tool);
		this.setCreativeTab(Wintercraft.wintercraftTab);
	}
	
	@Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
    	return par2ItemStack.isItemEqual(new ItemStack(this.repair, 1, 0)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

}
