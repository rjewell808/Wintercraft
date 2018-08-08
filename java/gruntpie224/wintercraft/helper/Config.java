package gruntpie224.wintercraft.helper;

import org.apache.logging.log4j.Level;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;

public class Config {
	private static final String CATEGORY_GENERAL = "general";
	
	public static boolean isSnowEnabled = true;
	public static boolean showSpawnCoords = false;
	public static int candyCaneRarity;
	
	public static void readConfig()
	{
		Configuration cfg = CommonProxy.config;
		
		try{
			cfg.load();
			initGeneralConfig(cfg);
		} catch (Exception e) {
			Wintercraft.logger.log(Level.ERROR, "Issue loading config file!", e);
		} finally {
			if (cfg.hasChanged())
			{
				cfg.save();
			}
		}
	}
	
	private static void initGeneralConfig(Configuration cfg)
	{
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General Configuration");
		isSnowEnabled = cfg.getBoolean("snowEnabled", CATEGORY_GENERAL, isSnowEnabled, "Set to false to disable snow in all biomes");
		showSpawnCoords = cfg.getBoolean("showSpawnCoords", CATEGORY_GENERAL, showSpawnCoords, "Set to true to enable coordinate output in the console");
		candyCaneRarity = cfg.getInt("candyCaneRarity", CATEGORY_GENERAL, 7, 0, 100, "Giant Candy Cane structure spawn rarity");
	}
}
