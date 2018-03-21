package gruntpie224.wintercraft.worldgen;

import java.lang.reflect.Field;
import static java.lang.System.out;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.helper.Config;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeOcean;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class BiomeControl {
	
	@SubscribeEvent
	public void registerBiomes(RegistryEvent.Register<Biome> event)
	{
		if (Config.isSnowEnabled)
		{
			Wintercraft.logger.info("Overriding Biome Temperatures...");
			
			IForgeRegistry<Biome> registry = event.getRegistry();
			
				try{
					for(Biome biome : registry.getValues())
					{
						Class<?> c = biome.getClass();
						
						while(c != Biome.class)
						{
							c = c.getSuperclass();
						}
						
						Field temp = c.getDeclaredField("temperature");
						temp.setAccessible(true);
						
						if(biome.getDefaultTemperature() > 0.0f)
						{
							temp.setFloat(biome, 0.0f);
						}
					}
				}
				catch (IllegalAccessException x) {
				    x.printStackTrace();
				} catch (NoSuchFieldException e) {
					e.printStackTrace();
				} catch (SecurityException e) {
					e.printStackTrace();
				}
		}
	}
	
	private void register(RegistryEvent.Register<Biome> event, Biome biome)
	{
		event.getRegistry().register(biome);
	}
}
