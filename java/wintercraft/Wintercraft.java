package wintercraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.MinecraftForge;
import wintercraft.blocks.WinterBlocks;
import wintercraft.blocks.WinterSpecialBlocks;
import wintercraft.entity.EntityBase;
import wintercraft.entity.projectiles.EntityIceball;
import wintercraft.entity.projectiles.EntityRockySnowball;
import wintercraft.entity.projectiles.EntityRockySnowballGolem;
import wintercraft.helper.ConnectionHandler;
import wintercraft.helper.CraftingHandler;
import wintercraft.helper.FeatureConfig;
import wintercraft.helper.IceEventHandler;
import wintercraft.helper.PlayerTickHandler;
import wintercraft.helper.achievements.WinterAch;
import wintercraft.helper.gui.GuiHandler;
import wintercraft.helper.proxy.CommonProxy;
import wintercraft.helper.tileEntity.TileEntityAdventCal;
import wintercraft.helper.tileEntity.TileEntityDarkPresent;
import wintercraft.helper.tileEntity.TileEntityFirePlace;
import wintercraft.helper.tileEntity.TileEntityFreezer;
import wintercraft.helper.tileEntity.TileEntityGift;
import wintercraft.helper.tileEntity.TileEntityLightsBlock;
import wintercraft.helper.tileEntity.TileEntitySnowManHead;
import wintercraft.items.WinterItems;
import wintercraft.recipe.Recipes;
import wintercraft.render.tileEntity.TileEntityCandle;
import wintercraft.render.tileEntity.TileEntityOrnament;
import wintercraft.render.tileEntity.TileEntityOrnamentRare;
import wintercraft.render.tileEntity.TileEntitySnowGlobe;
import wintercraft.worldgen.Generation;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid="Wintercraft", name="Wintercraft", version="1.1.2")

public class Wintercraft {
	@SidedProxy(clientSide = "wintercraft.helper.proxy.ClientProxy", serverSide = "wintercraft.helper.proxy.CommonProxy")
	public static CommonProxy proxy;
	@Instance("Wintercraft")
	public static Wintercraft instance;
	
	public static final String modid = "Wintercraft";
	public static final String version = "1.1.2";
	public static CreativeTabs WintercraftTab;
	//public static boolean beta = true;
	//public static String[] betaMem = {"itzz_danniexd","Wottler","tailousFTW","YuukiAkane","Lizzybeth04","DMSledge","pawprint1423","tanman12345","dmx6","Phoenix1024","Yoshi6601","Cachirulo_14","Mined17","Thunderwolf2200","minecrafterora9","Pureace2012","xZaynsPrincessx","kayla","Elliegirl9","Mnecraft368","nmaatx","sealand","th3doctor999","mopy234","Jonathan","g_larock","TheOrigsrc80","JollyPretsel","Jesse405","nvhgamer","007crafter49","Fletchan898","angusfox","JadeHunterKato","bcole4","Dr_Mr_Boss","tomskids","gruntpie224","XxlinexX","dogman1123","abrindles97","shamin99","SepyMondialu","notdd","QWERTYman2020","Stevie13185"};
	
	
	private GuiHandler guiInputHandler = new GuiHandler();
	private static int modEntityID = 0;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event)
		{	
			FMLCommonHandler.instance().bus().register(new ConnectionHandler());
	    	FMLCommonHandler.instance().bus().register(new PlayerTickHandler());
	    	MinecraftForge.EVENT_BUS.register(new ConnectionHandler());
				WintercraftTab = new CreativeTabs("Wintercraft"){
					public Item getTabIconItem() {
						return Item.getItemFromBlock(WinterBlocks.icedStone);
					}
		    	};
				FeatureConfig.PreInit(event);
				WinterSpecialBlocks.Init(event);
				WinterItems.Init(event);
		    	WinterBlocks.Init(event);
		    	MinecraftForge.EVENT_BUS.register(new IceEventHandler());
		}

	@EventHandler
	public void Init(FMLInitializationEvent event)
		{
				Recipes.Init(event);
				BiomeControl.Init(event);
				EntityBase.Init();
				Generation.Init(event);
				WinterAch.Init(event);
				TileEntity.addMapping(TileEntityCandle.class, "Candle");
				TileEntity.addMapping(TileEntityOrnament.class, "Ornament");
				TileEntity.addMapping(TileEntityOrnamentRare.class, "OrnamentRare");
				TileEntity.addMapping(TileEntitySnowManHead.class, "Snowman Head");
				TileEntity.addMapping(TileEntitySnowGlobe.class, "SnowGlobe");
				proxy.registerRenderThings();
				TileEntity.addMapping(TileEntityGift.class, "TileEntityGift");
				GameRegistry.registerTileEntity(TileEntityFirePlace.class, "TileEntityFirePlace");
				GameRegistry.registerTileEntity(TileEntityDarkPresent.class, "TileEntityDarkPresent");
				GameRegistry.registerTileEntity(TileEntityFreezer.class,"TileEntityFreezer");
				GameRegistry.registerTileEntity(TileEntityGift.class, "GiftStorage");
				GameRegistry.registerTileEntity(TileEntityAdventCal.class, "TileEntityAdvent");
				GameRegistry.registerTileEntity(TileEntityLightsBlock.class, "TileEntityLightsBlock");
				FMLCommonHandler.instance().bus().register(new CraftingHandler());
				NetworkRegistry.INSTANCE.registerGuiHandler(this, guiInputHandler);
				EntityRegistry.registerModEntity(EntityIceball.class, "Iceball", ++modEntityID, this, 64, 10, true);
				EntityRegistry.registerModEntity(EntityRockySnowball.class, "Rocky Snowball", ++modEntityID, this, 64, 10, true);
				EntityRegistry.registerModEntity(EntityRockySnowballGolem.class, "Rocky Snowball Golem", ++modEntityID, this, 64, 10, true);
		}
}
