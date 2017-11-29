package gruntpie224.wintercraft.items;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCommonItem extends ItemBaseItem{  
	
	public ItemCommonItem() {
		super();
	    this.setHasSubtypes(true);
	    this.setMaxDamage(0);
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int x = 0; x < 10; x++)
	    {
	        par3List.add(new ItemStack(this, 1, x));
	    }
	    
	}	
	
	public static final String[] names = new String[] {
			"empty_mug", 
			"icecream_vanilla", 
			"icecream_chocolate", 
			"icecream_strawberry",
			"icecream_cookie",
			"icecream_magma",
			"icecream_cone",
			"polarbear_fur",
			"polarbear_fur_red",
			"iron_stick",
			};
    
	public String getUnlocalizedName(ItemStack stack)
	{
	    int i = MathHelper.clamp_int(stack.getItemDamage(), 0, 15);
	    return "item." + names[i];
	}
	
}
