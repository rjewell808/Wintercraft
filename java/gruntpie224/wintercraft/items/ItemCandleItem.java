package gruntpie224.wintercraft.items;

import java.util.List;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterSpecialBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCandleItem extends ItemBaseItem
{
	public IBlockState placerBlock;  
	public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);   
	
	public ItemCandleItem(IBlockState candle)
	{
		super();
		this.placerBlock = candle;
	    this.setHasSubtypes(true);
	    this.setMaxDamage(0);
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
	    int i = MathHelper.clamp_int(stack.getItemDamage(), 0, 16);
	    return "item." + names[i];
	}
	
	/**
     * Called when a Block is right-clicked with this Item
     *  
     * @param pos The block being right-clicked
     * @param side The side being right-clicked
     */
	
	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(worldIn.getBlockState(pos).getBlock().isFullCube() && side == EnumFacing.UP && worldIn.isAirBlock(pos.up()))
		{
			worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()), placerBlock.withProperty(COLOR, EnumDyeColor.byMetadata(stack.getItemDamage())));
			stack.stackSize--;
			return true;
		}
		
		return false;
	}
}
