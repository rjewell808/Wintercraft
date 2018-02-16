package wintercraft.worldgen;

import java.util.Random;

import wintercraft.helper.FeatureConfig;
import wintercraft.worldgen.structure.StructureCandyCane;
import wintercraft.worldgen.structure.StructureElfHouse;
import wintercraft.worldgen.structure.StructureIgloo;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenPlains;
import net.minecraft.world.biome.BiomeGenSnow;
import net.minecraft.world.biome.BiomeGenTaiga;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.storage.WorldInfo;
import cpw.mods.fml.common.IWorldGenerator;



public class WorldGeneratorStructure implements IWorldGenerator {

	BiomeGenBase biomegenbase;
	
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
	  switch (world.provider.dimensionId)
	  {
	  case -1: 
		  generateNether(world, random, chunkX*16, chunkZ*16);
	  case 0: 
		  if (random.nextFloat() < 0.25F){
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
		  }
	  } 
	}
	private void generateSurface(World world, Random rand, int chunkX, int chunkZ)
	{
		StructureIgloo igloo = new StructureIgloo();
		StructureCandyCane candy = new StructureCandyCane();
		StructureElfHouse elf = new StructureElfHouse();
		
	    if (rand.nextFloat() < FeatureConfig.iglooRarity / 100F){
			for(int x = 0;x<1;x++)
			{
				int i = chunkX + rand.nextInt(16);
				int k = chunkZ + rand.nextInt(16);
				int j = world.getHeightValue(i, k);
				igloo.generate(world, rand, i, j, k);
			}
	    }
	     
	    if (rand.nextFloat() < FeatureConfig.candyCaneRarity / 100F){
			for(int x = 0;x<1;x++)
			{
				int i = chunkX + rand.nextInt(16);
				int k = chunkZ + rand.nextInt(16);
				int j = world.getHeightValue(i, k);
				candy.generate(world, rand, i, j, k);
			}
    	}
	    
	    if (rand.nextFloat() < FeatureConfig.elfHouseRarity / 100F){
			for(int x = 0;x<1;x++)
			{
				if(world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.plains || world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.taiga || world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.forest || world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.coldTaiga || world.getBiomeGenForCoords(chunkX, chunkZ) == BiomeGenBase.coldTaigaHills){
					int i = chunkX + rand.nextInt(16);
					int k = chunkZ + rand.nextInt(16);
					int j = world.getHeightValue(i, k);
					elf.generate(world, rand, i, j, k);
				}
			}
    	}
	}
	

	private void generateNether(World world, Random random, int blockX, int blockZ)
	{
	}
}
