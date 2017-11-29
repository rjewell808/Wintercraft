package gruntpie224.wintercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemOrnamentRareBlock extends ItemBlock
{
	final static String[] subBlocks = new String[] {"0", "1", "2"};
	
       public ItemOrnamentRareBlock(Block par1)
       {
             super(par1);
             setHasSubtypes(true);
       }
      
       public String getUnlocalizedName(ItemStack itemstack)
       {
    	   int i = itemstack.getItemDamage();
    	   if(i < 0 || i >= subBlocks.length){
    		   i = 0;
    	   }
             
             return super.getUnlocalizedName() + "." + subBlocks[i];
       }
      
       public int getMetadata(int par1)
       {
             return par1;
       }
}


