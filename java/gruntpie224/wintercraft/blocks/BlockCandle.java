package gruntpie224.wintercraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import gruntpie224.wintercraft.init.WinterItems;
import gruntpie224.wintercraft.init.WinterSpecialBlocks;

public class BlockCandle extends Block {
	public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);   	
	
	public BlockCandle(int texture, Material material)
	{
		super(material);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumDyeColor.WHITE));
		float f = 0.2F;
		this.setBlockBounds(0.6F - f, 0.0F, 0.6F - f, 0.4F + f, f * 2.0F, 0.4F + f);
		this.setLightLevel(0.7F);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return WinterItems.candle_item;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, BlockPos pos)
	{
	    return WinterItems.candle_item;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	     for (int var4 = 0; var4 < 16; ++var4)
	     {
	         par3List.add(new ItemStack(par1, 1, var4));
	     }
	}


	/**
	* The type of render function that is called for this block
	*/

	@Override
	public int getRenderType()
	{
		return 3;
	}

	/**
	* Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
	* adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	*/
	@Override
	public boolean isFullCube()
	{
	    return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
	    return false;
	}

	/**
	 * Convert the given metadata into a BlockState for this Block
	 */
	public IBlockState getStateFromMeta(int meta)
	{
	    return this.getDefaultState().withProperty(COLOR, EnumDyeColor.byMetadata(meta));
	}

	/**
	 * Convert the BlockState into the correct metadata value
	 */
	public int getMetaFromState(IBlockState state)
	{
	    return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
	}

	protected BlockState createBlockState()
	{
	    return new BlockState(this, new IProperty[] {COLOR});
	}

	/**
	 * Get the damage value that this Block should drop
	 */
	public int damageDropped(IBlockState state)
	{
	    return ((EnumDyeColor)state.getValue(COLOR)).getMetadata();
	}
	
	@Override
	public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
    {
	    if (!worldIn.isSideSolid(pos.down(), EnumFacing.UP))
	    {
	        this.dropBlockAsItem(worldIn, pos, state, 0);
	        worldIn.setBlockToAir(pos);
	    }
    }
	
	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		
		 double d0 = (double)pos.getX() + 0.5D;
	        double d1 = (double)pos.getY() + 0.3D;
	        double d2 = (double)pos.getZ() + 0.325D;
	        double d3 = 0.2199999988079071D;
	        double d4 = 0.17000001072883606D;
	    super.randomDisplayTick(worldIn, pos, state, rand);
	
	    for (int l = pos.getX() - 2; l <= pos.getX() + 2; ++l)
	    {
	        for (int i1 = pos.getZ() - 2; i1 <= pos.getZ() + 2; ++i1)
	        {
	            if (l > pos.getX() - 2 && l < pos.getX() + 2 && i1 == pos.getZ() - 1)
	            {
	                i1 = pos.getZ() + 2;
	            }
	
	            if (rand.nextInt(5) == 0)
	            {
	                for (int j1 = pos.getY(); j1 <= pos.getY() + 1; ++j1)
	                {
	                		worldIn.spawnParticle(EnumParticleTypes.FLAME, d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
	                	}
	                }
	            }
	        }
	    }

}
