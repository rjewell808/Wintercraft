package wintercraft.worldgen;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.storage.WorldInfo;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class Generation {

	public static BiomeGenBase biomeCandyCane;
	
	public static void Init(FMLInitializationEvent event){
	
		GameRegistry.registerWorldGenerator(new WorldGeneratorStructure(), 1);
	}
	
}
