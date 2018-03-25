package gruntpie224.wintercraft.blocks;

import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterBlocks;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ForgeBlockStateV1.Variant;

public class BlockSnowSlab extends BlockSlab{
	
	public BlockSnowSlab(String name, Material material)
	{
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(Wintercraft.wcTab);
		
		IBlockState iblockstate = this.blockState.getBaseState();
		if(!this.isDouble())
			iblockstate.withProperty(HALF, BlockSlab.EnumBlockHalf.BOTTOM);
		
		this.setDefaultState(iblockstate);
		this.useNeighborBrightness = !this.isDouble();
	}
	
	@Override
    public Comparable<?> getTypeForItem(ItemStack stack) {
        return EnumBlockHalf.BOTTOM;
    }

    @Override
    public IProperty<?> getVariantProperty() {
        return HALF;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	return Item.getItemFromBlock(WinterBlocks.snow_slab_single);
    }
    
    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state)
    {
    	return new ItemStack(WinterBlocks.snow_slab_single);
    }
    
    @Override
	public final IBlockState getStateFromMeta(final int meta) {
		IBlockState blockstate = this.getDefaultState();
		
		if(!this.isDouble()) {
			blockstate = blockstate.withProperty(HALF, EnumBlockHalf.values()[meta % EnumBlockHalf.values().length]);
		}
		
		return blockstate;
	}
    
    @Override
	public final int getMetaFromState(final IBlockState state) {
		
    	if(!this.isDouble())
    	{
    		return 0;
    	}
    	
		return ((EnumBlockHalf)state.getValue(HALF)).ordinal() + 1;
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {HALF});
	}

	@Override
	public String getUnlocalizedName(int meta) {
		return super.getUnlocalizedName();
	}

	@Override
	public boolean isDouble() {
		return false;
	}
}
