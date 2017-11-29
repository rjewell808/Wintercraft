package gruntpie224.wintercraft.worldgen.structure;

import java.util.Random;

import gruntpie224.wintercraft.helper.config.ConfigHandler;
import gruntpie224.wintercraft.init.WinterBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureCandyCane extends WorldGenerator
{
	Block[] present = {WinterBlocks.dark_present, WinterBlocks.dark_present, WinterBlocks.winter_present, WinterBlocks.present};
	Random rand;
	protected Block[] GetValidSpawnBlocks() {
		return new Block[] {
			Blocks.grass,
			Blocks.dirt,
			Blocks.sand,
			Blocks.snow,
			Blocks.snow_layer
		};
	}
	
	public boolean LocationIsValidSpawn(World world, int i, int j, int k)
	{
		int distanceToAir = 0;
		BlockPos pos = new BlockPos(i ,j, k);
		
		Block checkID = world.getBlockState(pos).getBlock();
		
		while (!checkID.isAir(world, pos))
		{
			distanceToAir++;
			pos = new BlockPos(i ,j + distanceToAir, k);
			checkID = world.getBlockState(pos).getBlock();
		}
		
		if (distanceToAir > 3)
		{
			return false;
		}

		pos = new BlockPos(i ,j + distanceToAir - 1, k);
		
		Block blockID = world.getBlockState(pos).getBlock();
		Block blockIDAbove = world.getBlockState(pos.up()).getBlock();
		Block blockIDBelow = world.getBlockState(pos.down()).getBlock();
		
		for (Block x : GetValidSpawnBlocks())
		{
			if (blockIDAbove != Blocks.air)
			{
				return false;
			}
			
			if (blockID == x)
			{
				return true;
			}
			else if (blockID == Blocks.snow && blockIDBelow == x)
			{
				return true;
			}
		}
		return false;
	}

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		BlockPos pos = new BlockPos(x, y, z);
		Block b1 = world.getBlockState(pos).getBlock();
		world.setBlockState(pos, block.getStateFromMeta(metadata));

	}
	
	public void setBlock(World world, int x, int y, int z, Block block)
	{
		BlockPos pos = new BlockPos(x, y, z);
		Block b1 = world.getBlockState(pos).getBlock();
		world.setBlockState(pos, block.getDefaultState());

	}

	public boolean generate(World worldIn, Random rand, BlockPos pos) {
		//check that each corner is one of the valid spawn blocks
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();
		
		if(!LocationIsValidSpawn(worldIn, i, j, k) || !LocationIsValidSpawn(worldIn, i + 14, j, k) || !LocationIsValidSpawn(worldIn, i + 14, j, k + 16) || !LocationIsValidSpawn(worldIn, i, j, k + 16))
		{
			return false;
		}
		
		if(ConfigHandler.showSpawnCoords){
			System.out.println("Candy Cane X:" + i);
	 		System.out.println("Candy Cane Z:" + k);
		}
		
		j += -1;
		setBlock(worldIn, i + 0, j + 0, k + 0, present[rand.nextInt(4)]);
		setBlock(worldIn, i + 0, j + 1, k + 0, WinterBlocks.candy_cane_block);
		setBlock(worldIn, i + 0, j + 2, k + 0, WinterBlocks.candy_cane_block);
		setBlock(worldIn, i + 0, j + 3, k + 0, WinterBlocks.candy_cane_block);
		setBlock(worldIn, i + 0, j + 4, k + 0, WinterBlocks.candy_cane_block);
		setBlock(worldIn, i + 0, j + 5, k + 0, WinterBlocks.candy_cane_block);
		setBlock(worldIn, i + 0, j + 6, k + 0, WinterBlocks.candy_cane_block);
		//world.setBlock(i + 1, j + 0, k + 0, Blocks.snow);
		setBlock(worldIn, i + 1, j + 6, k + 0, WinterBlocks.candy_cane_block, 1);
		//world.setBlock(i + 2, j + 0, k + 0, Blocks.snow);
		setBlock(worldIn, i + 2, j + 4, k + 0, WinterBlocks.candy_cane_block);
		setBlock(worldIn, i + 2, j + 5, k + 0, WinterBlocks.candy_cane_block);
		setBlock(worldIn, i + 2, j + 6, k + 0, WinterBlocks.candy_cane_block, 1);

		return true;
	}
}