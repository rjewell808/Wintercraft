package gruntpie224.wintercraft.worldgen;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Generation {
	
	public static void Init(FMLInitializationEvent event){
	
		GameRegistry.registerWorldGenerator(new WorldGenStructure(), 1);
	}
	
}
