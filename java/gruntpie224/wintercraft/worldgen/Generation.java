package gruntpie224.wintercraft.worldgen;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Generation {

	public static BiomeGenBase biomeCandyCane;
	
	public static void Init(FMLInitializationEvent event){
	
		GameRegistry.registerWorldGenerator(new WorldGeneratorStructure(), 1);
	}
	
}
