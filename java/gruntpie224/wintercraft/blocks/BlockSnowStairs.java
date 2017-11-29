package gruntpie224.wintercraft.blocks;

import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockSnowStairs extends BlockStairs
{
	public BlockSnowStairs(Block block) {
		super(block.getDefaultState());
		this.setCreativeTab(Wintercraft.wintercraftTab);
		this.setLightOpacity(0);
		this.setHarvestLevel("shovel", 1);
	}
	
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        this.dropBlockAsItem(worldIn, pos, state, 0);
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(WinterBlocks.snow_stairs);
	}
}
