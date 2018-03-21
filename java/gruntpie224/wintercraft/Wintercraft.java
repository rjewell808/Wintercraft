package gruntpie224.wintercraft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import gruntpie224.wintercraft.proxy.CommonProxy;
import gruntpie224.wintercraft.worldgen.BiomeControl;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomePlains;
import net.minecraft.world.biome.BiomeTaiga;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod(modid = WintercraftReference.MOD_ID, name = WintercraftReference.MOD_NAME, version = WintercraftReference.VERSION, dependencies="required-after:forge@[14.23.2.2611,)", useMetadata=true)

public class Wintercraft {
	@SidedProxy(clientSide = WintercraftReference.CLIENT_PROXY, serverSide = WintercraftReference.SERVER_PROXY)
	public static CommonProxy proxy;
	
	@Mod.Instance
	public static Wintercraft instance;
	
	public static Logger logger = LogManager.getLogger(WintercraftReference.MOD_ID);
	public static final WintercraftTab wcTab = new WintercraftTab("wcTab");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		logger.info("Starting Pre-Init...");
		MinecraftForge.EVENT_BUS.register(new BiomeControl());
		proxy.preInit(event);
	}
	
	@EventHandler
    public void init(FMLInitializationEvent event)
    {
    	logger.info("Starting Init...");
    	proxy.init(event);
    }
	    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	logger.info("Starting Post-Init...");
    	proxy.postInit(event);
    }
}
