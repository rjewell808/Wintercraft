package gruntpie224.wintercraft.helper.achievements;

import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import gruntpie224.wintercraft.init.WinterSpecialBlocks;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;



public class WinterAch {

	public static AchievementPage wintercraftAch;
	public static Achievement iceShard;
	public static Achievement iceChunk;
	public static Achievement iceGem;
	public static Achievement icedStone;
	public static Achievement iceCrystal;
	public static Achievement iceIngot;
	public static Achievement iceStaff;
	public static Achievement snowGlobe;
	public static Achievement iceStaffBad;
	public static Achievement iceChiller;
	
	public static Achievement ornament;
	public static Achievement star;
	public static Achievement santa;
	public static Achievement christmas;
	public static Achievement rareOrnament;
	
	public static Achievement snowGlobeBad;
	public static Achievement freezer;
 	
	public static void Init()
	{
		iceShard = (Achievement) new Achievement("achievement.iceShard", "iceShard", 0, 1, WinterItems.ice_shard, (Achievement)null).registerStat();
		iceChunk = (Achievement) new Achievement("achievement.iceChunk", "iceChunk", 2, 1, WinterItems.ice_chunk, iceShard).registerStat();	
		freezer = (Achievement) new Achievement("achievement.freezer","freezer",4,1,WinterBlocks.freezer,iceChunk).registerStat();
		iceGem = (Achievement) new Achievement("achievement.iceGem", "iceGem", 5, -1, new ItemStack(WinterItems.ice_gem, 1, 1), freezer).registerStat();	
		icedStone = (Achievement) new Achievement("achievement.icedStone", "icedStone", 6, 4, WinterBlocks.iced_stone, freezer).registerStat();		
		iceIngot = (Achievement) new Achievement("achievement.iceIngot", "iceIngot", 6, 3,WinterItems.ice_ingot, freezer).registerStat();			
		iceCrystal = (Achievement) new Achievement("achievement.iceCrystal", "iceCrystal", 6, 2, WinterItems.ice_crystal, freezer).registerStat();	
		iceStaff = (Achievement) new Achievement("achievement.iceStaff", "iceStaff", 3, -3, WinterItems.ice_staff, iceGem).registerStat();		
	    snowGlobe = (Achievement) new Achievement("achievement.snowGlobe", "snowGlobe", 7, -1, WinterBlocks.snow_globe, iceGem).registerStat();
	    snowGlobeBad = (Achievement) new Achievement("achievement.snowGlobeBad","snowGlobeBad", 7, 0, WinterItems.ice_gem,iceGem).registerStat();
		iceStaffBad = (Achievement) new Achievement("achievement.iceStaffBad", "iceStaffBad", 3, -2, WinterItems.ice_gem, iceGem).registerStat();	
		ornament = (Achievement) new Achievement("achievement.ornament", "ornament", -2, -1, new ItemStack(WinterItems.ornament_item, 1, 14), (Achievement)null).registerStat();
		star = (Achievement) new Achievement("achievement.star", "star", -2, 1, WinterBlocks.star, ornament).registerStat();
		santa = (Achievement) new Achievement("achievement.santa", "santa", -1, 3, WinterBlocks.winter_present, star).registerStat();		
		christmas = (Achievement) new Achievement("achievement.christmas", "christmas", -3, 3, WinterItems.santa_helmet, star).registerStat();
		//iceChiller= new Achievement("achievement.iceChiller", "iceChiller", 4, -1, WinterItems.chillerStick, iceGem).registerStat();
		rareOrnament = (Achievement) new Achievement("achievement.rareOrnament","rareOrnament",-4,-1,WinterItems.ornament_item_rare,ornament).registerStat();
		
		//WinterAch.addAchievementName("star", "The Star on Top");
			//WinterAch.addAchievementDesc("star", "Create a Christmas Tree");	
		
			AchievementPage.registerAchievementPage(new AchievementPage("Wintercraft",new Achievement[]{snowGlobe, iceStaff, iceShard, iceChunk, iceGem, icedStone, iceIngot, iceCrystal, iceStaffBad,
					ornament, rareOrnament, santa, christmas, star, snowGlobeBad, freezer}));
	}
}
