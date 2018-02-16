package wintercraft.blocks;

import java.util.Random;

import wintercraft.Wintercraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;

public class BlockSnowStairs extends BlockStairs {

public BlockSnowStairs(Block par2Block, int par3) {
super(par2Block, par3);
	this.setCreativeTab(Wintercraft.WintercraftTab);
	this.setLightOpacity(0);
}
	public int quantityDropped(Random par1Random){
	
	    return 1;
	}
}
