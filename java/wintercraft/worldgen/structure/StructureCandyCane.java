package wintercraft.worldgen.structure;

import java.util.Random;





import wintercraft.blocks.WinterBlocks;
import wintercraft.helper.FeatureConfig;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructureCandyCane extends WorldGenerator
{
	Block[] present = {WinterBlocks.darkPresent, WinterBlocks.darkPresent, WinterBlocks.christmasPresent, WinterBlocks.present};
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
	
	public boolean LocationIsValidSpawn(World world, int i, int j, int k){
		int distanceToAir = 0;
		Block checkID = world.getBlock(i, j, k);

		while (checkID != Blocks.air){
			distanceToAir++;
			checkID = world.getBlock(i, j + distanceToAir, k);
		}

		if (distanceToAir > 3){
			return false;
		}
		j += distanceToAir - 1;

		Block blockID = world.getBlock(i, j, k);
		Block blockIDAbove = world.getBlock(i, j+1, k);
		Block blockIDBelow = world.getBlock(i, j-1, k);
		for (Block x : GetValidSpawnBlocks()){
			if (blockIDAbove != Blocks.air){
				return false;
			}
			if (blockID == x){
				return true;
			}else if (blockID == Blocks.snow && blockIDBelow == x){
				return true;
			}
		}
		return false;
	}
	
	public StructureCandyCane() { }

	public void setBlock(World world, int x, int y, int z, Block block, int metadata)
	{
		Block b1 = world.getBlock(x, y, z);

		if(b1.isAir(world, x, y, z) || b1.isLeaves(world, x, y, z))
		{
			world.setBlock(x, y, z, block, metadata, 2);
		}
	}

	public boolean generate(World world, Random rand, int i, int j, int k) {
		//check that each corner is one of the valid spawn blocks
		if(!LocationIsValidSpawn(world, i, j, k) || !LocationIsValidSpawn(world, i + 14, j, k) || !LocationIsValidSpawn(world, i + 14, j, k + 16) || !LocationIsValidSpawn(world, i, j, k + 16))
		{
			return false;
		}
		
		if(FeatureConfig.showSpawnLocation){
			System.out.println("Candy Cane X:" + i);
	 		System.out.println("Candy Cane Z:" + k);
		}
		
		j += -1;
		world.setBlock(i + 0, j + 0, k + 0, present[rand.nextInt(4)]);
		world.setBlock(i + 0, j + 1, k + 0, WinterBlocks.candyCaneBlock);
		world.setBlock(i + 0, j + 2, k + 0, WinterBlocks.candyCaneBlock);
		world.setBlock(i + 0, j + 3, k + 0, WinterBlocks.candyCaneBlock);
		world.setBlock(i + 0, j + 4, k + 0, WinterBlocks.candyCaneBlock);
		world.setBlock(i + 0, j + 5, k + 0, WinterBlocks.candyCaneBlock);
		world.setBlock(i + 0, j + 6, k + 0, WinterBlocks.candyCaneBlock);
		//world.setBlock(i + 1, j + 0, k + 0, Blocks.snow);
		world.setBlock(i + 1, j + 6, k + 0, WinterBlocks.candyCaneBlock, 4, 2);
		//world.setBlock(i + 2, j + 0, k + 0, Blocks.snow);
		world.setBlock(i + 2, j + 4, k + 0, WinterBlocks.candyCaneBlock);
		world.setBlock(i + 2, j + 5, k + 0, WinterBlocks.candyCaneBlock);
		world.setBlock(i + 2, j + 6, k + 0, WinterBlocks.candyCaneBlock, 4, 2);

		return true;
	}
}