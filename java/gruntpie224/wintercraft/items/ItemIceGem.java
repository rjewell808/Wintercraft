package gruntpie224.wintercraft.items;

import java.util.List;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemIceGem extends ItemBaseItem{

	public ItemIceGem() {
		super();
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int x = 0; x < 2; x++)
	    {
	        par3List.add(new ItemStack(this, 1, x));
	    }
	}
	
	public static final String[] names = new String[] {"0", "1"};
    
	@Override
	public String getUnlocalizedName(ItemStack stack)
    {
        return stack.getMetadata() == 1 ? "item.ice_gem" : "item.ice_gem_corrupt";
    }
	
}

