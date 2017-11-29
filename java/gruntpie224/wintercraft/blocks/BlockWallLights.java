package gruntpie224.wintercraft.blocks;

import java.util.Random;

import gruntpie224.wintercraft.init.WinterItems;
import gruntpie224.wintercraft.init.WinterSpecialBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockWallLights extends BlockWallBlock
{	
    public BlockWallLights()
    {
        super();
        this.setCreativeTab(null);
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	return WinterItems.lights;
    }
    
    @Override 
	public Item getItem(World worldIn, BlockPos pos)
	{
		return WinterItems.lights;
	}
    
    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos).getBlock() != WinterSpecialBlocks.lights_wall && 
        	   
        	   (worldIn.isSideSolid(pos.west(), EnumFacing.EAST, true) ||
               worldIn.isSideSolid(pos.east(), EnumFacing.WEST, true) ||
               worldIn.isSideSolid(pos.north(), EnumFacing.SOUTH, true) ||
               worldIn.isSideSolid(pos.south(), EnumFacing.NORTH, true));
    }
    
}
