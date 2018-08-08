package gruntpie224.wintercraft.worldgen;

import java.util.Random;

import gruntpie224.wintercraft.helper.Config;
import gruntpie224.wintercraft.worldgen.structure.StructureCandyCane;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenStructure implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
	  switch (world.provider.getDimension())
	  {
	  	case -1: 
	  		generateNether(world, random, chunkX*16, chunkZ*16);
	  	case 0: 
	  		if (random.nextFloat() < 0.25F)
	  		{
	  			generateSurface(world, random, chunkX * 16, chunkZ * 16);
	  		}
	  } 
	}
	private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
		//StructureIgloo igloo = new StructureIgloo();
		StructureCandyCane candy = new StructureCandyCane();
		//StructureElfHouse elf = new StructureElfHouse();
		
		/*
	    if (rand.nextFloat() < ConfigHandler.iglooRarity / 100F){
			int i = chunkX + rand.nextInt(16);
			int k = chunkZ + rand.nextInt(16);
			int j = world.getChunksLowestHorizon(i, k);
			igloo.generate(world, rand, new BlockPos(i, j ,k));
	    }
	    */
	     
	    if (rand.nextFloat() < (Config.candyCaneRarity / 100F))
	    {
			int i = chunkX + rand.nextInt(16);
			int k = chunkZ + rand.nextInt(16);
			int j = world.getChunksLowestHorizon(i, k);
			
			candy.generate(world, rand, new BlockPos(i, j, k));
    	}
	    
	    /*
	    if (rand.nextFloat() < ConfigHandler.elfRarity / 100F){

			int i = chunkX + rand.nextInt(16);
			int k = chunkZ + rand.nextInt(16);
			int j = world.getChunksLowestHorizon(i, k);
			
			if(world.getBiomeGenForCoords(new BlockPos(chunkX, j, chunkZ)) == BiomeGenBase.plains 
					|| world.getBiomeGenForCoords(new BlockPos(chunkX, j, chunkZ)) == BiomeGenBase.taiga 
					|| world.getBiomeGenForCoords(new BlockPos(chunkX, j, chunkZ)) == BiomeGenBase.forest 
					|| world.getBiomeGenForCoords(new BlockPos(chunkX, j, chunkZ)) == BiomeGenBase.coldTaiga 
					|| world.getBiomeGenForCoords(new BlockPos(chunkX, j, chunkZ)) == BiomeGenBase.coldTaigaHills)
			{
				elf.generate(world, rand, new BlockPos(i, j, k));
			}
    	}
    	*/

	}
	

	private void generateNether(World world, Random random, int blockX, int blockZ)
	{
	}
}