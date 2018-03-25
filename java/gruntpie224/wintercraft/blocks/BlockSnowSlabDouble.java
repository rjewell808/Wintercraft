package gruntpie224.wintercraft.blocks;

import net.minecraft.block.material.Material;

public class BlockSnowSlabDouble extends BlockSnowSlab{
	public BlockSnowSlabDouble(String name, Material material)
	{
		super(name, material);
	}
	
	@Override
	public boolean isDouble()
	{
		return true;
	}
}
