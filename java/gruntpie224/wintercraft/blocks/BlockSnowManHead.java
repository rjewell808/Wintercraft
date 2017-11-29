package gruntpie224.wintercraft.blocks;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.entity.passive.EntitySnowMan;
import gruntpie224.wintercraft.helper.config.ConfigHandler;
import gruntpie224.wintercraft.helper.tileEntity.TileEntitySnowManHead;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockSnowManHead extends BlockDirectional
{
	
	public BlockSnowManHead(int texture, Material material)
	{
		super(material);
		this.setCreativeTab(Wintercraft.wintercraftTab);
		this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
	}

	public int getRenderType()
	{
		return 3;
	}
	
	public int getMetaFromState(IBlockState state)
	{
	    return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
	}
	
	protected BlockState createBlockState()
	{
	    return new BlockState(this, new IProperty[] {FACING});
	}
	
	public AxisAlignedBB getCollisionBoundingBox(World worldIn, BlockPos pos, IBlockState state)
	{
	    this.setBlockBoundsBasedOnState(worldIn, pos);
	    return super.getCollisionBoundingBox(worldIn, pos, state);
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	public TileEntity createNewTileEntity(World par1World, int i)
	{
		return new TileEntitySnowManHead();
	}
	
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
	    super.onBlockAdded(worldIn, pos, state);
	    
	    if(ConfigHandler.peacefulMobs && worldIn.getBlockState(pos.down()).getBlock() == Blocks.snow && worldIn.getBlockState(pos.down(2)).getBlock() == Blocks.snow)
	    {
			worldIn.setBlockToAir(pos);
		    worldIn.setBlockToAir(pos.down());
		    worldIn.setBlockToAir(pos.down(2));
	    
		    EntitySnowMan entitysnowman = new EntitySnowMan(worldIn);
	        BlockPos blockpos2 = pos.down(2);
	        entitysnowman.setLocationAndAngles((double)blockpos2.getX() + 0.5D, (double)blockpos2.getY() + 0.05D, (double)blockpos2.getZ() + 0.5D, 0.0F, 0.0F);
	        worldIn.spawnEntityInWorld(entitysnowman);    
	    } 
	    
    }
	
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{	
		return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}
	
	public IBlockState getStateFromMeta(int meta)
	{
	    return this.getDefaultState().withProperty(FACING, EnumFacing.getHorizontal(meta));
	}
	

}
