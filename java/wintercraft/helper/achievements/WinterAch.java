package wintercraft.helper.achievements;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import wintercraft.blocks.WinterBlocks;
import wintercraft.blocks.WinterSpecialBlocks;
import wintercraft.items.WinterItems;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.LanguageRegistry;



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
 	
	public static void Init(FMLInitializationEvent event){
		iceShard = new Achievement("achievement.iceShard", "iceShard", 0, 1, WinterItems.iceShard, (Achievement)null).registerStat();
		iceChunk = new Achievement("achievement.iceChunk", "iceChunk", 2, 1, WinterItems.iceChunk, iceShard).registerStat();	
		freezer = new Achievement("achievement.freezer","freezer",4,1,WinterBlocks.freezer,iceChunk).registerStat();
		iceGem = new Achievement("achievement.iceGem", "iceGem", 5, -1, new ItemStack(WinterItems.iceGem, 1, 1), freezer).registerStat();	
		icedStone = new Achievement("achievement.icedStone", "icedStone", 6, 4, WinterBlocks.icedStone, freezer).registerStat();		
		iceIngot = new Achievement("achievement.iceIngot", "iceIngot", 6, 3,WinterItems.iceIngot, freezer).registerStat();			
		iceCrystal = new Achievement("achievement.iceCrystal", "iceCrystal", 6, 2, WinterItems.iceCrystal, freezer).registerStat();	
		iceStaff = new Achievement("achievement.iceStaff", "iceStaff", 3, -3, WinterItems.iceStaff, iceGem).registerStat();		
	    snowGlobe = new Achievement("achievement.snowGlobe", "snowGlobe", 7, -1, WinterBlocks.snowGlobeBlock, iceGem).registerStat();
	    snowGlobeBad = new Achievement("achievement.snowGlobeBad","snowGlobeBad", 7, 0, WinterItems.iceGem,iceGem).registerStat();
		iceStaffBad = new Achievement("achievement.iceStaffBad", "iceStaffBad", 3, -2, WinterItems.iceGem, iceGem).registerStat();	
		ornament = new Achievement("achievement.ornament", "ornament", -2, -1, WinterSpecialBlocks.ornament, (Achievement)null).registerStat();
		star = new Achievement("achievement.star", "star", -2, 1, WinterBlocks.star, ornament).registerStat();
		santa = new Achievement("achievement.santa", "santa", -1, 3, WinterBlocks.christmasPresent, star).registerStat();		
		christmas = new Achievement("achievement.christmas", "christmas", -3, 3, WinterItems.santaHat, star).registerStat();
		//iceChiller= new Achievement("achievement.iceChiller", "iceChiller", 4, -1, WinterItems.chillerStick, iceGem).registerStat();
		rareOrnament = new Achievement("achievement.rareOrnament","rareOrnament",-4,-1,WinterItems.itemOrnamentRare,ornament).registerStat();
		
		//WinterAch.addAchievementName("star", "The Star on Top");
			//WinterAch.addAchievementDesc("star", "Create a Christmas Tree");	
		
			AchievementPage.registerAchievementPage(new AchievementPage("Wintercraft",new Achievement[]{snowGlobe, iceStaff, iceShard, iceChunk, iceGem, icedStone, iceIngot, iceCrystal, iceStaffBad,
					ornament, rareOrnament, santa, christmas, star, snowGlobeBad, freezer}));
		
	}
}
