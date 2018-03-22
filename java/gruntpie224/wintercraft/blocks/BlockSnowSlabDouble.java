package gruntpie224.wintercraft.blocks;

import java.util.Random;

import gruntpie224.wintercraft.init.WinterBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockSnowSlabDouble extends BlockSnowSlab{

	public BlockSnowSlabDouble(String name) {
		super(name);
	}
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return Item.getItemFromBlock(WinterBlocks.snow_slab_single);
    }
	
	@Override
    public boolean isDouble() {
        return true;
    }

}
