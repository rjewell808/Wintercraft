package wintercraft.helper.items;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ItemsConfig {
	
	public static int candyCaneID;
	public static int commonItemID;
	public static int eggNogID;
	public static int coffeeID;
	public static int gingerbreadManID;
	public static int marshmellowID;
	public static int fruitCakeItemID;
	public static int rockySnowballID;
	public static int iceBallID;
	public static int iceStaffID;
	
	public static int chisIcePickaxeID;
	public static int chisIceHoeID;
	public static int chisIceAxeID;
	public static int chisIceShovelID;
	public static int chisIceSwordID;
	
	public static int coffeeMixID;
	public static int iceGemID;
	public static int iceStaffBadID;
	public static int candyCaneSwordID;
	
	public static int refIcePickaxeID;
	public static int refIceHoeID;
	public static int refIceAxeID;
	public static int refIceShovelID;
	public static int refIceSwordID;
	
	public static int crystalPickaxeID;
	public static int crystalHoeID;
	public static int crystalAxeID;
	public static int crystalShovelID;
	public static int crystalSwordID;
	
	public static int iceShardSwordID;
	public static int decorDoorItemID;
	public static int vanillaIcecreamID;
	public static int chocolateIcecreamID;
	public static int strawberryIcecreamID;
	public static int cookieIcecreamID;
	public static int magmaIcecreamID;
	public static int spawnEggID;
	public static int snowGlobeID;
	public static int iceShardID;
	public static int christmasMusicDiskID;
	public static int deckTheHallsRecordID;
	
	public static int santaHatID;
	public static int santaSuitID;
	public static int santaPantsID;
	public static int santaBootsID;
	
	public static int lightsID;
	public static int christmasCookieID;
	public static int iceChunkID;
	public static int iceIngotID;
	public static int iceCrystalID;
	
	public static int refHelmetID;
	public static int refPlateID;
	public static int refLegsID;
	public static int refBootsID;
	
	public static int crystalHelmetID;
	public static int crystalPlateID;
	public static int crystalLegsID;
	public static int crystalBootsID;
	
	public static int magicSaddleID;
	public static int chillerStickID;

	public static void PreInit(FMLPreInitializationEvent event){
	    /*
	    Configuration config = new Configuration(event.getSuggestedConfigurationFile());
	  
		config.load();
	    
	    candyCaneID = config.get(Configuration.CATEGORY_ITEM, "Candy Cane", 8000).getInt();
	    commonItemID = config.get(Configuration.CATEGORY_ITEM, "Common-Item", 8001).getInt();
	    eggNogID = config.get(Configuration.CATEGORY_ITEM, "Egg Nog", 8002).getInt();
	    coffeeID = config.get(Configuration.CATEGORY_ITEM, "Hot Chocolate", 8003).getInt();
	    gingerbreadManID = config.get(Configuration.CATEGORY_ITEM, "GingerbreadMan", 8004).getInt();
	    marshmellowID = config.get(Configuration.CATEGORY_ITEM, "Marshmellows", 8005).getInt();
	    fruitCakeItemID = config.get(Configuration.CATEGORY_ITEM, "Fruit Cake", 8006).getInt();
	    rockySnowballID = config.get(Configuration.CATEGORY_ITEM, "Rocky Snowball", 8007).getInt();
	    iceBallID = config.get(Configuration.CATEGORY_ITEM, "Iceball", 8008).getInt();
	    iceStaffID = config.get(Configuration.CATEGORY_ITEM, "IceStaff", 8009).getInt();
	    
	    chisIcePickaxeID = config.get(Configuration.CATEGORY_ITEM, "Chiseled-Ice Pickaxe", 8010).getInt();
	    chisIceHoeID = config.get(Configuration.CATEGORY_ITEM, "Chiseled-Ice Hoe", 8011).getInt();
	    chisIceAxeID = config.get(Configuration.CATEGORY_ITEM, "Chiseled-Ice Axe", 8012).getInt();
	    chisIceShovelID = config.get(Configuration.CATEGORY_ITEM, "Chiseled-Ice Shovel", 8013).getInt();
	    chisIceSwordID = config.get(Configuration.CATEGORY_ITEM, "Chiseled-Ice Sword", 8014).getInt();
	    
	    coffeeMixID = config.get(Configuration.CATEGORY_ITEM, "Hot-Chocolate Mix", 8015).getInt();
	    iceGemID = config.get(Configuration.CATEGORY_ITEM, "Ice Gem", 8016).getInt();
	    iceStaffBadID = config.get(Configuration.CATEGORY_ITEM, "IceStaffBad", 8017).getInt();
	  
	    candyCaneSwordID = config.get(Configuration.CATEGORY_ITEM, "Candy Cane Sword", 8018).getInt();
	    
	    refIcePickaxeID = config.get(Configuration.CATEGORY_ITEM, "Refined-Ice Pickaxe", 8019).getInt();
	    refIceHoeID = config.get(Configuration.CATEGORY_ITEM, "Refined-Ice Hoe", 8020).getInt();
	    refIceAxeID = config.get(Configuration.CATEGORY_ITEM, "Refined-Ice Axe", 8021).getInt();
	    refIceShovelID = config.get(Configuration.CATEGORY_ITEM, "Refined-Ice Shovel", 8022).getInt();
	    refIceSwordID = config.get(Configuration.CATEGORY_ITEM, "Refined-Ice Sword", 8023).getInt();
	    
	    iceShardSwordID = config.get(Configuration.CATEGORY_ITEM, "Ice-Shard Sword", 8024).getInt();
	    decorDoorItemID = config.get(Configuration.CATEGORY_ITEM, "Decor-Door Item", 8025).getInt();
	    snowGlobeID = config.get(Configuration.CATEGORY_ITEM, "Snow Globe", 8026).getInt();
	    lightsID = config.get(Configuration.CATEGORY_ITEM, "Christmas Lights", 8027).getInt();
	   
	    crystalPickaxeID = config.get(Configuration.CATEGORY_ITEM, "Crystalized Pickaxe", 8028).getInt();
	    crystalHoeID = config.get(Configuration.CATEGORY_ITEM, "Crystalized Hoe", 8029).getInt();
	    crystalAxeID = config.get(Configuration.CATEGORY_ITEM, "Crystalized Axe", 8030).getInt();
	    crystalShovelID = config.get(Configuration.CATEGORY_ITEM, "Crystalized Shovel", 8031).getInt();
	    crystalSwordID = config.get(Configuration.CATEGORY_ITEM, "Crystalized Sword", 8032).getInt(); 
	    
	    vanillaIcecreamID = config.get(Configuration.CATEGORY_ITEM, "Vanilla Icecream", 8033).getInt();
	    chocolateIcecreamID = config.get(Configuration.CATEGORY_ITEM, "Chocolate Icecream", 8034).getInt();
	    strawberryIcecreamID = config.get(Configuration.CATEGORY_ITEM, "Strawberry Icecream", 8035).getInt();
	    cookieIcecreamID = config.get(Configuration.CATEGORY_ITEM, "Cookie-Dough Icecream", 8036).getInt();
	    magmaIcecreamID = config.get(Configuration.CATEGORY_ITEM, "Iced Magmacream", 8037).getInt();
	    spawnEggID = config.get(Configuration.CATEGORY_ITEM, "Spawn Egg", 8038).getInt();
	    christmasCookieID = config.get(Configuration.CATEGORY_ITEM, "Christmas Cookie", 8039).getInt();
	    christmasMusicDiskID = config.get(Configuration.CATEGORY_ITEM, "Jingle Bells Music Disk", 8040).getInt();
	    deckTheHallsRecordID = config.get(Configuration.CATEGORY_ITEM, "Deck the Halls Music Disk", 8041).getInt();
	    
	    santaHatID = config.get(Configuration.CATEGORY_ITEM, "Santa Hat", 8042).getInt();
	    santaSuitID = config.get(Configuration.CATEGORY_ITEM, "Santa Coat", 8043).getInt();
	    santaPantsID = config.get(Configuration.CATEGORY_ITEM, "Santa Pants", 8044).getInt();
	    santaBootsID = config.get(Configuration.CATEGORY_ITEM, "Santa Boots", 8045).getInt();

	    iceShardID = config.get(Configuration.CATEGORY_ITEM, "Ice Shard", 8046).getInt();
	    iceChunkID = config.get(Configuration.CATEGORY_ITEM, "Ice Chunk", 8047).getInt();
	    iceIngotID = config.get(Configuration.CATEGORY_ITEM, "Ice Ingot", 8048).getInt();
	    iceCrystalID = config.get(Configuration.CATEGORY_ITEM, "Ice Crystal", 8049).getInt();
	    
	    refHelmetID = config.get(Configuration.CATEGORY_ITEM, "Refined-Ice Helmet", 8050).getInt();
	    refPlateID = config.get(Configuration.CATEGORY_ITEM, "Refined-Ice Chestplate", 8051).getInt();
	    refLegsID = config.get(Configuration.CATEGORY_ITEM, "Refined-Ice Leggings", 8052).getInt();
	    refBootsID = config.get(Configuration.CATEGORY_ITEM, "Refined-Ice Boots", 8053).getInt();
	    
	    crystalHelmetID = config.get(Configuration.CATEGORY_ITEM, "Crystal Helmet", 8054).getInt();
	    crystalPlateID = config.get(Configuration.CATEGORY_ITEM, "Crystal Chestplate", 8055).getInt();
	    crystalLegsID = config.get(Configuration.CATEGORY_ITEM, "Crystal Leggings", 8056).getInt();
	    crystalBootsID = config.get(Configuration.CATEGORY_ITEM, "Crystal Boots", 8057).getInt();
	    
	    magicSaddleID = config.get(Configuration.CATEGORY_ITEM, "Magic Saddle", 8058).getInt();
	    chillerStickID = config.get(Configuration.CATEGORY_ITEM, "Chiller Stick", 8059).getInt();
	    
	    config.save();
	    */
	}
}
