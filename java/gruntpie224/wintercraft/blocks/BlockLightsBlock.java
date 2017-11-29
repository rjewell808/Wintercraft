package gruntpie224.wintercraft.blocks;

import java.util.Random;

import javax.swing.Icon;

import gruntpie224.wintercraft.helper.tileEntity.TileEntityLightsBlock;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLightsBlock extends Block{

	public BlockLightsBlock(Material par2Material)
	{
		super(par2Material);
		this.setHardness(0.2F);
        //this.setLightOpacity(1);
        this.setStepSound(soundTypeGrass);
	}
	
	@SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (worldIn.canLightningStrike(pos.up()) && !World.doesBlockHaveSolidTopSurface(worldIn, pos.down()) && rand.nextInt(15) == 1)
        {
            double d0 = (double)((float)pos.getX() + rand.nextFloat());
            double d1 = (double)pos.getY() - 0.05D;
            double d2 = (double)((float)pos.getZ() + rand.nextFloat());
            worldIn.spawnParticle(EnumParticleTypes.DRIP_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
        }
    }
    	
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if(playerIn.getHeldItem() == null)
		{
			//TileEntityLightsBlock tile = (TileEntityLightsBlock) par3World.getTileEntity(par2, par3, par4);
	        
	        if (!worldIn.isRemote)
	        {
	        	worldIn.setBlockState(pos, Blocks.leaves.getStateFromMeta(1));
	        	this.dropBlockAsItem(worldIn, pos, this.getDefaultState(), 0);
	        }
	        return true;
		}
		
	return false;
    }
	
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }
	
	@SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return worldIn.getBlockState(pos).getBlock() == this ? false : super.shouldSideBeRendered(worldIn, pos, side);
    }
	
	@Override
	public boolean isLeaves(IBlockAccess world, BlockPos pos)
    {
        return getMaterial() == Material.leaves;
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

}
