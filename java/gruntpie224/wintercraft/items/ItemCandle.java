package gruntpie224.wintercraft.items;

import java.util.List;

import gruntpie224.wintercraft.Wintercraft;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCandle extends ItemBlock{
	public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);   
	
	public ItemCandle(String name, Block candle)
	{
		super(candle);
	    this.setHasSubtypes(true);
	    this.setMaxDamage(0);
	    this.setUnlocalizedName(name);
	    this.setCreativeTab(Wintercraft.wcTab);
	}
	
	public int getMetadata(int damage)
    {
        return damage;
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int x = 0; x < 16; x++)
	    {
	        par3List.add(new ItemStack(this, 1, x));
	    }
	    
	}	
	
	public static final String[] names = new String[] {
			"candle_white", 
			"candle_orange", 
			"candle_magenta", 
			"candle_ltblue",
			"candle_yellow",
			"candle_lime",
			"candle_pink",
			"candle_dkgray",
			"candle_ltgray",
			"candle_cyan",
			"candle_purple",
			"candle_blue",
			"candle_brown",
			"candle_green",
			"candle_red",
			"candle_black"
			};
	
	public String getUnlocalizedName(ItemStack stack)
	{
	    int i = MathHelper.clamp(stack.getItemDamage(), 0, 16);
	    return "item." + names[i];
	}
}