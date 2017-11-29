package gruntpie224.wintercraft;


import gruntpie224.wintercraft.entity.EntityBase;
import gruntpie224.wintercraft.entity.projectiles.EntityIceball;
import gruntpie224.wintercraft.entity.projectiles.EntityRockySnowball;
import gruntpie224.wintercraft.entity.projectiles.EntityRockySnowballGolem;
import gruntpie224.wintercraft.helper.ConnectionHandler;
import gruntpie224.wintercraft.helper.CraftingHandler;
import gruntpie224.wintercraft.helper.IceEventHandler;
import gruntpie224.wintercraft.helper.PlayerTickHandler;
import gruntpie224.wintercraft.helper.achievements.WinterAch;
import gruntpie224.wintercraft.helper.config.ConfigGuiEventHandler;
import gruntpie224.wintercraft.helper.config.ConfigHandler;
import gruntpie224.wintercraft.helper.gui.GuiHandler;
import gruntpie224.wintercraft.helper.gui.GuiHandlerRegistry;
import gruntpie224.wintercraft.helper.proxy.CommonProxy;
import gruntpie224.wintercraft.helper.tileEntity.TileEntityAdventCal;
import gruntpie224.wintercraft.helper.tileEntity.TileEntityDarkPresent;
import gruntpie224.wintercraft.helper.tileEntity.TileEntityFirePlace;
import gruntpie224.wintercraft.helper.tileEntity.TileEntityFreezer;
import gruntpie224.wintercraft.helper.tileEntity.TileEntityGift;
import gruntpie224.wintercraft.helper.tileEntity.TileEntitySnowManHead;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import gruntpie224.wintercraft.init.WinterSpecialBlocks;
import gruntpie224.wintercraft.recipe.Recipes;
import gruntpie224.wintercraft.worldgen.Generation;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = WintercraftReference.MOD_ID, name = WintercraftReference.MOD_NAME, version = WintercraftReference.VERSION, guiFactory = "gruntpie224.wintercraft.helper.config.GuiFactory")

public class Wintercraft {
	@SidedProxy(clientSide = WintercraftReference.CLIENT_PROXY_CLASS, serverSide = WintercraftReference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.Instance(WintercraftReference.MOD_ID)
	public static Wintercraft instance;
	
	public static final WintercraftTab wintercraftTab = new WintercraftTab("wintercraftTab");
	
	private GuiHandler guiInputHandler = new GuiHandler();
	private static int modEntityID = 0;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
		{	
			FMLCommonHandler.instance().bus().register(new ConnectionHandler());
	    	FMLCommonHandler.instance().bus().register(new PlayerTickHandler());
	    	//MinecraftForge.EVENT_BUS.register(new ConnectionHandler());
			WinterSpecialBlocks.Init();
			proxy.ignoreProperties();
			WinterItems.Init();
	    	WinterBlocks.Init();
	    	MinecraftForge.EVENT_BUS.register(new IceEventHandler());
	    	
	    	MinecraftForge.EVENT_BUS.register(new ConfigHandler());
	    	ConfigHandler.init(event.getSuggestedConfigurationFile());
	    	
		}

	@EventHandler
	public void Init(FMLInitializationEvent event)
		{
			proxy.registerRenders();
			Recipes.Init();
			BiomeControl.Init();
			EntityBase.Init();
			Generation.Init(event);
			WinterAch.Init();
			TileEntity.addMapping(TileEntitySnowManHead.class, "TileEntitySnowManHead");
			GameRegistry.registerTileEntity(TileEntityFirePlace.class, "TileEntityFirePlace");
			GameRegistry.registerTileEntity(TileEntityDarkPresent.class, "TileEntityDarkPresent");
			GameRegistry.registerTileEntity(TileEntityFreezer.class,"TileEntityFreezer");
			NetworkRegistry.INSTANCE.registerGuiHandler(Wintercraft.instance, GuiHandlerRegistry.getInstance());
			GuiHandlerRegistry.getInstance().registerGuiHandler(new GuiHandler(), GuiHandler.getGuiID());
			GameRegistry.registerTileEntity(TileEntityGift.class, "GiftStorage");
			GameRegistry.registerTileEntity(TileEntityAdventCal.class, "TileEntityAdvent");
			//GameRegistry.registerTileEntity(TileEntityLightsBlock.class, "TileEntityLightsBlock");
			FMLCommonHandler.instance().bus().register(new CraftingHandler());
			EntityRegistry.registerModEntity(EntityIceball.class, "Iceball", ++modEntityID, this, 64, 10, true);
			EntityRegistry.registerModEntity(EntityRockySnowball.class, "Rocky Snowball", ++modEntityID, this, 64, 10, true);
			EntityRegistry.registerModEntity(EntityRockySnowballGolem.class, "Rocky Snowball Golem", ++modEntityID, this, 64, 10, true);
			//MinecraftForge.EVENT_BUS.register(new ConfigGuiEventHandler());
		}
}
