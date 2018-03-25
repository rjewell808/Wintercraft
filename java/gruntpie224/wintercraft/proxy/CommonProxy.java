package gruntpie224.wintercraft.proxy;

import java.io.File;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.WintercraftReference;
import gruntpie224.wintercraft.helper.Config;
import gruntpie224.wintercraft.helper.gui.GuiProxy;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import gruntpie224.wintercraft.tileentity.TileEntityFreezer;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber
public class CommonProxy {
	
	public static Configuration config;
	
	public void preInit(FMLPreInitializationEvent event){
		File directory = event.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "wintercraft.cfg"));
		Config.readConfig();
	}
	
	public void init(FMLInitializationEvent event){
		NetworkRegistry.INSTANCE.registerGuiHandler(Wintercraft.instance, new GuiProxy());
	}
	
	public void postInit(FMLPostInitializationEvent event){
		if(config.hasChanged())
			config.save();
	}
	public void serverStarting(FMLServerStartingEvent event){}
	public void serverStopping(FMLServerStoppingEvent event){}
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		WinterBlocks.initBlocks();
		WinterBlocks.registerBlocks(event);
		
		GameRegistry.registerTileEntity(TileEntityFreezer.class, WintercraftReference.MOD_ID + "_freezer");
	}
	
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		WinterItems.initItems();
		WinterItems.registerItems(event);
		WinterBlocks.registerBlockItems(event);
	}
}
