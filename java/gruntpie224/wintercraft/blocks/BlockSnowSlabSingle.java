package gruntpie224.wintercraft.blocks;

import net.minecraft.block.material.Material;

public class BlockSnowSlabSingle extends BlockSnowSlab{
	public BlockSnowSlabSingle(String name, Material material)
	{
		super(name, material);
	}
	
	@Override
	public boolean isDouble()
	{
		return false;
	}
}
