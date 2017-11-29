package gruntpie224.wintercraft.items;

import gruntpie224.wintercraft.blocks.BlockSnowSlabFull;
import gruntpie224.wintercraft.blocks.BlockSnowSlabHalf;
import gruntpie224.wintercraft.init.WinterBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
public class ItemSnowSlab extends ItemSlab
{
    public ItemSnowSlab(Block block, BlockSnowSlabHalf half, BlockSnowSlabFull full, final Boolean stacked)
    {
	    super(block, half, full);
    }
}