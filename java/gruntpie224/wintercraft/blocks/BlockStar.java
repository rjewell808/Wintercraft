package gruntpie224.wintercraft.blocks;

import gruntpie224.wintercraft.Wintercraft;
import net.minecraft.block.BlockBush;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockStar extends BlockBush{
	
	public BlockStar(String name, Material material)
	{
		super(material);
		this.setCreativeTab(Wintercraft.wcTab);
		this.setLightLevel(0.9375F);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
}
