package wintercraft.items;

import wintercraft.blocks.WinterBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
public class ItemSnowSlab extends ItemSlab
{
    public ItemSnowSlab(Block block)
    {
	    super(block, (BlockSlab)WinterBlocks.singleSnowSlab, (BlockSlab)WinterBlocks.doubleSnowSlab, false);
	    this.setMaxDamage(0);
	    this.setHasSubtypes(true);
    }
}