package gruntpie224.wintercraft.blocks;

import gruntpie224.wintercraft.Wintercraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBaseBlock extends Block{

	public BlockBaseBlock(Material par2Material) {
		super(par2Material);
		this.setCreativeTab(Wintercraft.wintercraftTab);
	}
}
