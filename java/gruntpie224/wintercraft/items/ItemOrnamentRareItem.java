package gruntpie224.wintercraft.items;

import java.util.List;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterBlocks;
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

public class ItemOrnamentRareItem extends ItemBaseItem{
	public IBlockState ornamentBlock;  
	public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);   
	
	public ItemOrnamentRareItem(IBlockState ornament) {
		super();
		this.ornamentBlock= ornament;
	    this.setHasSubtypes(true);
	    this.setMaxDamage(0);
	    this.setCreativeTab(Wintercraft.wintercraftTab);
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int x = 0; x < 3; x++)
	    {
	        par3List.add(new ItemStack(this, 1, x));
	    }
	    
	}
	
	public static final String[] names = new String[] {
			"ornament_rare_creeper", 
			"ornament_rare_enderman", 
			"ornament_rare_blaze"
			};
    
	@Override
	public String getUnlocalizedName(ItemStack stack)
	{
	    int i = MathHelper.clamp_int(stack.getItemDamage(), 0, 16);
	    return "item." + names[i];
	}
	
	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if (side == EnumFacing.DOWN && (worldIn.getBlockState(pos).getBlock() == WinterBlocks.lights_block || worldIn.getBlockState(pos).getBlock() == Blocks.leaves || worldIn.getBlockState(pos).getBlock() == Blocks.leaves2))
        {
    		worldIn.setBlockState(new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()), ornamentBlock.withProperty(COLOR, EnumDyeColor.byMetadata(stack.getItemDamage())));
    		stack.stackSize--;
    		
    		return true;
        }
    	
    	return false;
	}
}
