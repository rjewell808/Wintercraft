package gruntpie224.wintercraft.blocks;

import java.util.List;
import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

abstract class BlockSnowSlab extends BlockSlab
{
	private static final PropertyBool VARIANT_PROPERTY = PropertyBool.create("variant");
	private static final int HALF_META_BIT = 8;
	
	public BlockSnowSlab()
	{
		super(Material.grass);
		this.setLightOpacity(0);
		this.useNeighborBrightness = !this.isDouble();
		
		if (!this.isDouble()) 
		{
            setCreativeTab(Wintercraft.wintercraftTab);
        }
		
		
		IBlockState blockState = this.blockState.getBaseState();
        blockState = blockState.withProperty(VARIANT_PROPERTY, false);
        if (!this.isDouble()) {
            blockState = blockState.withProperty(HALF, EnumBlockHalf.BOTTOM);
        }

        setDefaultState(blockState);
	}
	
	 /**
     * Gets the unlocalized name based on metadata/damage.
     * @param metadata block metadata.
     * @return the unlocalized name.
     */
    @Override
    public final String getUnlocalizedName(final int metadata) {
        return this.getUnlocalizedName();
    }

    /**
     * Gets the value of the variant property based on the item.
     * @param itemStack item stack.
     * @return the variant value null.
     */
    @Override
    public final Object getVariant(final ItemStack itemStack) {
        return false;
    }

    /**
     * Gets the variant property.
     * @return the variant property null.
     */
    @Override
    public final IProperty getVariantProperty() {
        return VARIANT_PROPERTY;
    }

    /**
     * Gets a block state from metadata.
     * @param meta the metadata or color value.
     * @return a block state with the meta encoded as the variant property.
     */
    @Override
    public final IBlockState getStateFromMeta(final int meta) {
        IBlockState blockState = this.getDefaultState();
        blockState = blockState.withProperty(VARIANT_PROPERTY, false);
        if (!this.isDouble()) {
            EnumBlockHalf value = EnumBlockHalf.BOTTOM;
            if ((meta & HALF_META_BIT) != 0) {
                value = EnumBlockHalf.TOP;
            }

            blockState = blockState.withProperty(HALF, value);
        }

        return blockState;
    }

    /**
     * Gets the metadata value from a block state.
     * @param state the block state.
     * @return the metadata or color value.
     */
    @Override
    public final int getMetaFromState(final IBlockState state) {
        if (this.isDouble()) {
           return 0;
        }

        if ((EnumBlockHalf) state.getValue(HALF) == EnumBlockHalf.TOP) {
            return HALF_META_BIT;
        } else {
            return 0;
        }
    }

    /**
     * Gets the damage for the block's item when dropped.
     * @param state the block's state.
     * @return the metadata or color value.
     */
    @Override
    public final int damageDropped(final IBlockState state) {
        return 0;
    }
    
    /**
     * Creates the block state object.
     * @return the block state with properties defined.
     */
    @Override
    protected final BlockState createBlockState() {
        if (this.isDouble()) {
            return new BlockState(this, new IProperty[] {VARIANT_PROPERTY});
        } else {
            return new BlockState(
                this,
                new IProperty[] {VARIANT_PROPERTY, HALF});
        }
    }
    
    @Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(WinterBlocks.snow_slab_single);
	}
}
