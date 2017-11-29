package gruntpie224.wintercraft.helper.config;

import java.io.File;

import gruntpie224.wintercraft.WintercraftReference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler 
{	
	public static Configuration configuration;
	
	public static boolean snowMonth;
	public static boolean snowAll;
	public static boolean winterMobs;
	public static boolean hostileMobs, peacefulMobs, neutralMobs;
	public static boolean showSpawnCoords;
	public static boolean mobIDCustom;
	public static boolean winterTips;
	public static boolean winterBetaHat;
	public static int mobID;
	public static int iglooRarity, candyCaneRarity, elfRarity;
	
	public static void init(File configFile)
	{	
		//create the configuration object from the given configuration file
		if (configuration == null)
		{	
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}
	
	public static void loadConfiguration()
	{
		configuration.load();
		snowMonth = configuration.getBoolean("Dec/Jan Snow", Configuration.CATEGORY_GENERAL, true, "Enable snowing in all biomes during the months Dec and Jan");
		snowAll = configuration.getBoolean("Always Snow", Configuration.CATEGORY_GENERAL, false, "Enable snowing in all biomes all the time");
		winterMobs = configuration.getBoolean("Wintercraft Mobs - All", Configuration.CATEGORY_GENERAL, true, "Enable all Wintercraft mobs");
		peacefulMobs = configuration.getBoolean("Wintercraft Mobs - Peaceful", Configuration.CATEGORY_GENERAL, true, "Enable peaceful Wintercraft mobs");
		neutralMobs = configuration.getBoolean("Wintercraft Mobs - Neutral", Configuration.CATEGORY_GENERAL, true, "Enable neutral Wintercraft mobs");
		hostileMobs = configuration.getBoolean("Wintercraft Mobs - Hostile", Configuration.CATEGORY_GENERAL, true, "Enable hostile Wintercraft mobs");
		showSpawnCoords = configuration.getBoolean("Show Structure Coords", Configuration.CATEGORY_GENERAL, false, "Enable wintercraft structure spawn coordinates to be posted in the console when spawned");
		mobIDCustom = configuration.getBoolean("Custom Wintercraft Mob IDs", Configuration.CATEGORY_GENERAL, false, "Enable custom mob ids instead of using the auto-assign");
		mobID = configuration.getInt("Wintercraft Mob ID Start", Configuration.CATEGORY_GENERAL, 110, 0, 255, "ID that Wintercraft Mobs start spawning from");
		winterTips = configuration.getBoolean("Wintercraft Tips", Configuration.CATEGORY_GENERAL, true, "Enable helpful tips that assist you in Wintercraft");
		winterBetaHat = configuration.getBoolean("Wintercraft Beta Golden Hat", Configuration.CATEGORY_GENERAL, true, "Enable golden santa hat for devs/beta testers");
		iglooRarity = configuration.getInt("Igloo Spawn Rarity", Configuration.CATEGORY_GENERAL, 2, 0, 100, "Igloo structure spawn rarity");
		candyCaneRarity = configuration.getInt("Giant Candycane Spawn Rarity", Configuration.CATEGORY_GENERAL, 7, 0, 100, "Giant Candycane structure spawn rarity");
		elfRarity = configuration.getInt("Elf House Spawn Rarity", Configuration.CATEGORY_GENERAL, 1, 0, 100, "Elf House structure spawn rarity");
	}
	
	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{			
		if(event.modID.equalsIgnoreCase(WintercraftReference.MOD_ID))
		{
			//loadConfiguration();
			configuration.save();

		}
	}
}
