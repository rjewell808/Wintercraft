package wintercraft.helper;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class FeatureConfig {

	public static boolean snowMonth;
	public static boolean winterMobs;
	public static boolean hostileMobs;
	public static boolean peacefulMobs;
	public static boolean neutralMobs;
	public static boolean snowAll;
	public static boolean showSpawnLocation;
	public static int mobID;
	public static boolean winterTips;
	public static boolean mobIDCustom;
	public static boolean betaGoldenHat;
	public static int iglooRarity;
	public static int candyCaneRarity;
	public static int elfHouseRarity;
	static Configuration config;
	
	public static void PreInit(FMLPreInitializationEvent event){
		config = new Configuration(event.getSuggestedConfigurationFile());
	    config.load();
	    snowMonth = config.get(Configuration.CATEGORY_GENERAL, "Enable Snowing in Every Biome During December/January", true).getBoolean(false);
	    winterMobs = config.get(Configuration.CATEGORY_GENERAL, "Enable the Mobs", true).getBoolean(false);
	    hostileMobs = config.get(Configuration.CATEGORY_GENERAL, "Enable the Hostile Mobs", true).getBoolean(false);
	    neutralMobs = config.get(Configuration.CATEGORY_GENERAL, "Enable the Neutral Mobs", true).getBoolean(false);
	    peacefulMobs = config.get(Configuration.CATEGORY_GENERAL, "Enable the Peaceful Mobs", true).getBoolean(false);
	    snowAll = config.get(Configuration.CATEGORY_GENERAL, "Enable Snowing in Every Biome All the Time", false).getBoolean(false);
	    showSpawnLocation = config.get(Configuration.CATEGORY_GENERAL, "Enable coordinates to Wintercraft structures to be posted in the console", false).getBoolean(false);
	    mobIDCustom = config.get(Configuration.CATEGORY_GENERAL, "Enable custom Wintercraft Mob IDs", false).getBoolean(false);
	    mobID = config.get(Configuration.CATEGORY_GENERAL, "Wintercraft Mob ID Starts", 110).getInt(110);
	    winterTips = config.get(Configuration.CATEGORY_GENERAL, "Enable Wintercraft Tips", true).getBoolean(true);
	    betaGoldenHat = config.get(Configuration.CATEGORY_GENERAL, "Enable Beta Tester/Team Member Hat", true).getBoolean(true);
	    iglooRarity = config.get(Configuration.CATEGORY_GENERAL, "The spawn rate for Igloos", 2).getInt(2);
	    candyCaneRarity = config.get(Configuration.CATEGORY_GENERAL, "The spawn rate for Giant Candy Canes", 7).getInt(7);
	    elfHouseRarity = config.get(Configuration.CATEGORY_GENERAL, "The spawn rate for Elf Houses", 1).getInt(1);
	    config.save();
	}
	
}
