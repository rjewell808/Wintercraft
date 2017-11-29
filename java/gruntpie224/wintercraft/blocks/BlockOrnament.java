package gruntpie224.wintercraft.blocks;

import java.util.List;
import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterItems;
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
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockOrnament extends Block {

public static final PropertyEnum COLOR = PropertyEnum.create("color", EnumDyeColor.class);   	
	
public BlockOrnament(int texture, Material material) {
	super(material);
	
	this.setDefaultState(this.blockState.getBaseState().withProperty(COLOR, EnumDyeColor.WHITE));
	this.setBlockBounds(0.4F, 0.5F, 0.4F, 0.7F, 1F, 0.7F);
}

@Override
public Item getItemDropped(IBlockState state, Random rand, int fortune)
{
	return WinterItems.ornament_item;
}

@Override
@SideOnly(Side.CLIENT)
public Item getItem(World world, BlockPos pos)
{
    return WinterItems.ornament_item;
}

@Override
public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
{
	boolean fall = false;
	
	if(worldIn.isAirBlock(new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ())))
		fall = true;
		
	if(fall)
	{
		this.dropBlockAsItem(worldIn, pos, state, 1);
		worldIn.setBlockToAir(pos);
	}
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

}
