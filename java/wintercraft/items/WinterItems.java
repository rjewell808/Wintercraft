package wintercraft.items;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;
import wintercraft.Wintercraft;
import wintercraft.blocks.WinterBlocks;
import wintercraft.blocks.WinterSpecialBlocks;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class WinterItems {

	public static Item candyCane;
	public static Item commonItem;
	public static Item eggNog;
	public static Item coffee;
	public static Item gingerbreadMan;
	public static Item marshmellow;
	public static Item fruitCakeItem;
	public static Item rockySnowball;
	public static Item iceBall;
	public static Item iceStaff;
	
	public static Item chisIcePickaxe;
	public static Item chisIceHoe;
	public static Item chisIceAxe;
	public static Item chisIceShovel;
	public static Item chisIceSword;
	
	public static Item coffeeMix;
	public static Item iceGem;
	public static Item iceStaffBad;
	public static Item candyCaneSword;
	
	public static Item refIcePickaxe;
	public static Item refIceHoe;
	public static Item refIceAxe;
	public static Item refIceShovel;
	public static Item refIceSword;
	
	public static Item crystalPickaxe;
	public static Item crystalHoe;
	public static Item crystalAxe;
	public static Item crystalShovel;
	public static Item crystalSword;
	
	public static Item iceShardSword;
	public static Item decorDoorItem;
	public static Item vanillaIcecream;
	public static Item magmaIcecream;
	public static Item chocolateIcecream;
	public static Item strawberryIcecream;
	public static Item cookieIcecream;
	public static Item iceShard;
	public static Item christmasMusicDisk;
	public static Item deckTheHallsRecord;
	
	public static Item santaHat;
	public static Item santaSuit;
	public static Item santaPants;
	public static Item santaBoots;
	public static Boolean santaArmour = false;
	
	public static Item lights;
	public static Item christmasCookie;
	public static Item iceChunk;
	public static Item iceIngot;
	public static Item iceCrystal;
	
	public static Item refHelmet;
	public static Item refPlate;
	public static Item refLegs;
	public static Item refBoots;
	
	public static Item crystalHelmet;
	public static Item crystalPlate;
	public static Item crystalLegs;
	public static Item crystalBoots;
	
	public static Item magicSaddle;
	public static Item chillerStick;
	
	public static Item Itemornament;
	public static Item candleItem;
	public static Item itemOrnamentRare;
	public static Item venisonRaw;
	public static Item venisonCooked;
	public static Item candyCaneAxe;
	public static Item iceSkates;
	public static Item antlers;
	
	public static ToolMaterial toolChisIce = EnumHelper.addToolMaterial("CHISICE", 1, 180, 6.0F, 1F, 5);
	public static ToolMaterial toolCandyCane = EnumHelper.addToolMaterial("CANDYCANE", 1, 250, 6.0F, 3F, 15);
	public static ToolMaterial toolRefIce = EnumHelper.addToolMaterial("REFICE", 2, 350, 7.5F, 2F, 15);
	public static ToolMaterial toolCrystal = EnumHelper.addToolMaterial("CRYSTAL", 3, 1800, 9.0F, 3F, 25);
	public static ToolMaterial toolShard = EnumHelper.addToolMaterial("SHARD", 3, 850, 6.5F, 8F, 25);
	
	
	public static ArmorMaterial armorSanta = EnumHelper.addArmorMaterial("SANTA", 7, new int[]{1, 4, 2, 1}, 16);
	public static ArmorMaterial armorRef = EnumHelper.addArmorMaterial("REFINED", 18, new int[]{3, 6, 5, 2}, 10);
	public static ArmorMaterial armorCrystal = EnumHelper.addArmorMaterial("CRYSTAL", 42, new int[]{3, 8, 6, 3}, 11);
	public static ArmorMaterial armorSkates = EnumHelper.addArmorMaterial("SKATES", 10, new int[]{2, 4, 2, 1}, 3);
	
public static void Init(FMLPreInitializationEvent event){
	santaArmour = false;
	candyCane = new ItemWinterFood(3, 0.4F, false,"\u00a7eFills 1.5 Hunger").setUnlocalizedName("candyCane");
	iceChunk = new ItemBaseItem().setUnlocalizedName("iceChunk");
	iceShard = new ItemBaseItem().setUnlocalizedName("iceShard");
	iceIngot = new ItemBaseItem().setUnlocalizedName("iceIngot");
	iceCrystal = new ItemBaseItem().setUnlocalizedName("iceCrystal");
	chillerStick = new ItemChillerStick().setUnlocalizedName("chillerStick");
	iceStaff = new ItemIceStaff(false).setCreativeTab(Wintercraft.WintercraftTab).setMaxDamage(350).setUnlocalizedName("iceStaff").setTextureName("rockySnowball2");
	iceStaffBad = new ItemIceStaff(true).setMaxDamage(1).setUnlocalizedName("iceStaff").setTextureName("rockySnowball2");
	iceBall = new ItemIceBall().setUnlocalizedName("iceBall").setTextureName("iceBall");
	iceGem = new ItemIceGem().setUnlocalizedName("iceGem");
	commonItem = new ItemCommonItem().setUnlocalizedName("commonItem");
	eggNog = new ItemEggNog(12, 0.7F, false).setUnlocalizedName("eggNog");
	coffee = new ItemCoffee(16, 0.8F, false).setUnlocalizedName("coffee");
	gingerbreadMan = new ItemWinterFood(3, 0.3F, false,"\u00a7eFills 1.5 Hunger").setUnlocalizedName("gingerbreadMan");
	marshmellow = new ItemWinterFood(1, 0, false, "\u00a7eFills 0.5 Hunger").setUnlocalizedName("marshmellow2");
	fruitCakeItem = new ItemFruitCakeItem(WinterSpecialBlocks.fruitCake).setUnlocalizedName("fruitCake");
	rockySnowball = new ItemRockySnowball().setUnlocalizedName("rockySnowball2").setTextureName("rockySnowball2");
	chisIcePickaxe = new ItemBasicPickaxe(toolChisIce,Item.getItemFromBlock(WinterBlocks.icedStone)).setUnlocalizedName("chisIcePickaxe");
	chisIceAxe = new ItemBasicAxe(toolChisIce,Item.getItemFromBlock(WinterBlocks.icedStone)).setUnlocalizedName("chisIceAxe");
	chisIceHoe = new ItemBasicHoe(toolChisIce,Item.getItemFromBlock(WinterBlocks.icedStone)).setUnlocalizedName("chisIceHoe");
	chisIceShovel = new ItemBasicShovel(toolChisIce,Item.getItemFromBlock(WinterBlocks.icedStone)).setUnlocalizedName("chisIceShovel");
	chisIceSword = new ItemBasicSword(toolChisIce,Item.getItemFromBlock(WinterBlocks.icedStone)).setUnlocalizedName("chisIceSword");
	coffeeMix = new ItemCoffeeMix(8, 0.4F, false).setUnlocalizedName("coffeeMix");
	candyCaneSword = new ItemCandyCaneSword(toolCandyCane).setUnlocalizedName("candyCaneSword");	
	refIcePickaxe = new ItemBasicPickaxe(toolRefIce,iceIngot).setUnlocalizedName("refIcePickaxe");	
	refIceAxe = new ItemBasicAxe(toolRefIce,iceIngot).setUnlocalizedName("refIceAxe");		
	refIceHoe = new ItemBasicHoe(toolRefIce, iceIngot).setUnlocalizedName("refIceHoe");		
	refIceShovel = new ItemBasicShovel(toolRefIce,iceIngot).setUnlocalizedName("refIceShovel");		
	refIceSword = new ItemBasicSword(toolRefIce,iceIngot).setUnlocalizedName("refIceSword");		
	crystalPickaxe = new ItemBasicPickaxe(toolCrystal,iceCrystal).setUnlocalizedName("crystalPickaxe");		
	crystalAxe = new ItemBasicAxe(toolCrystal,iceCrystal).setUnlocalizedName("crystalAxe");
	crystalHoe = new ItemBasicHoe(toolCrystal, iceCrystal).setUnlocalizedName("crystalHoe");		
	crystalShovel = new ItemBasicShovel(toolCrystal,iceCrystal).setUnlocalizedName("crystalShovel");		
	crystalSword = new ItemBasicSword(toolCrystal,iceCrystal).setUnlocalizedName("crystalSword");
	iceShardSword = new ItemBasicSword(toolShard).setUnlocalizedName("iceShardSword");
	decorDoorItem = new ItemDecorDoorItem(WinterSpecialBlocks.decorDoor).setUnlocalizedName("decorDoorItem");
	lights = new ItemLights(WinterSpecialBlocks.lightsBlockWall).setUnlocalizedName("lights");
	vanillaIcecream = new ItemVanillaCone(6, 0, false).setUnlocalizedName("vanillaCone");
	chocolateIcecream = new ItemChocolateCone(6, 0, false).setUnlocalizedName("chocolateCone");
	strawberryIcecream = new ItemStrawberryCone(6, 0, false).setUnlocalizedName("strawberryCone");
	cookieIcecream = new ItemCookieCone(6, 0, false).setUnlocalizedName("cookieCone");
	magmaIcecream = new ItemMagmaCone(6, 0, false).setUnlocalizedName("magmaCone");
	christmasMusicDisk = new ItemChristmasMusicDisk("wintercraft:jingleBells").setUnlocalizedName("jingleBells");
	deckTheHallsRecord = new ItemChristmasMusicDisk("wintercraft:deckTheHalls").setUnlocalizedName("deckTheHalls");
	santaHat = new ArmorSantaHat(armorSanta, 0, 0).setUnlocalizedName("santaHat");
	santaSuit = new ArmorSanta(armorSanta, 0, 1, "santa").setUnlocalizedName("santaSuit");
	santaPants = new ArmorSanta(armorSanta, 0, 2, "santa").setUnlocalizedName("santaPants");
	santaBoots = new ArmorSanta(armorSanta, 0, 3, "santa").setUnlocalizedName("santaBoots");
	christmasCookie = new ItemWinterFood(11, 0.5F, false, "\u00a7eFills 5.5 Hunger").setUnlocalizedName("christmasCookie");
	refHelmet = new ArmorRef(armorRef, 0, 0, "refined").setUnlocalizedName("refHelmet");
	refPlate = new ArmorRef(armorRef, 0, 1, "refined").setUnlocalizedName("refPlate");
	refLegs = new ArmorRef(armorRef, 0, 2, "refined").setUnlocalizedName("refLegs");
	refBoots = new ArmorRef(armorRef, 0, 3, "refined").setUnlocalizedName("refBoots");
	crystalHelmet = new ArmorCrystal(armorCrystal, 0, 0, "crystal").setUnlocalizedName("crystalHelmet");
	crystalPlate = new ArmorCrystal(armorCrystal, 0, 1, "crystal").setUnlocalizedName("crystalPlate");
	crystalLegs = new ArmorCrystal(armorCrystal, 0, 2, "crystal").setUnlocalizedName("crystalLegs");
	crystalBoots = new ArmorCrystal(armorCrystal, 0, 3, "crystal").setUnlocalizedName("crystalBoots");
	magicSaddle = new MagicSaddle().setUnlocalizedName("magicSaddle");
	Itemornament = new ItemOrnamentItem(WinterSpecialBlocks.ornament).setUnlocalizedName("ornamentItem");
	candleItem = new ItemCandleItem(WinterSpecialBlocks.candle).setUnlocalizedName("candleItem");
	itemOrnamentRare = new ItemOrnamentRareItem(WinterSpecialBlocks.ornamentRare).setUnlocalizedName("ornamentRareItem");
	venisonRaw = new ItemWinterFood(4, 0.3F, true,"\u00a7eFills 2 Hunger").setUnlocalizedName("venisonRaw");
	venisonCooked = new ItemWinterFood(10, 0.9F, true,"\u00a7eFills 5 Hunger").setUnlocalizedName("venisonCooked");
	candyCaneAxe = new ItemBasicAxe(toolCandyCane).setUnlocalizedName("candyCaneAxe");	
	iceSkates = new ArmorIceSkates(armorSkates, 0, 3,"skates").setUnlocalizedName("iceSkates");
	antlers = new ArmorAntlerHat(armorSkates, 0, 0).setUnlocalizedName("antlers");
	
	GameRegistry.registerItem(rockySnowball,"rockySnowball");
	GameRegistry.registerItem(iceBall, "iceBall");
	GameRegistry.registerItem(lights, "lights");
	GameRegistry.registerItem(iceStaff,"iceStaff");
	GameRegistry.registerItem(iceStaffBad,"iceStaffBad");
	//GameRegistry.registerItem(chillerStick, "chillerStick");
	GameRegistry.registerItem(iceShardSword, "iceShardSword");
	GameRegistry.registerItem(candyCaneSword,"candyCaneSword");
	GameRegistry.registerItem(candyCaneAxe,"candyCaneAxe");
	GameRegistry.registerItem(magicSaddle, "magicSaddle");
	GameRegistry.registerItem(iceSkates, "iceSkates");
	GameRegistry.registerItem(christmasCookie,"christmasCookie");
	GameRegistry.registerItem(venisonRaw, "venisonRaw");
	GameRegistry.registerItem(venisonCooked, "venisonCooked");
	GameRegistry.registerItem(candyCane, "candyCane");
	GameRegistry.registerItem(eggNog,"eggNog");
	GameRegistry.registerItem(coffeeMix,"chocolateMilk");
	GameRegistry.registerItem(coffee,"hotChocolate");
	GameRegistry.registerItem(gingerbreadMan,"gingerbreadMan");
	GameRegistry.registerItem(marshmellow,"marshmellow");
	GameRegistry.registerItem(vanillaIcecream, "vanillaIcecream");
	GameRegistry.registerItem(chocolateIcecream, "chocolateIcecream");
	GameRegistry.registerItem(strawberryIcecream, "strawberryIcecream");
	GameRegistry.registerItem(cookieIcecream, "cookieIcecream");
	GameRegistry.registerItem(magmaIcecream, "magmaIcecream");
	GameRegistry.registerItem(fruitCakeItem,"fruitCakeItem");
	GameRegistry.registerItem(decorDoorItem, "decorDoorItem");
	GameRegistry.registerItem(iceShard,"iceShard");
	GameRegistry.registerItem(iceChunk, "iceChunk");
	GameRegistry.registerItem(iceGem, "iceGem");
	GameRegistry.registerItem(iceIngot, "iceIngot");
	GameRegistry.registerItem(iceCrystal, "iceCrystal");;
	GameRegistry.registerItem(antlers,"antlers");
	GameRegistry.registerItem(commonItem, "commonItem");
	GameRegistry.registerItem(santaHat,"santaHat");
	GameRegistry.registerItem(santaSuit,"santaSuit");
	GameRegistry.registerItem(santaPants,"santaPants");
	GameRegistry.registerItem(santaBoots,"santaBoots");
	GameRegistry.registerItem(chisIcePickaxe,"chisIcePickaxe");
	GameRegistry.registerItem(chisIceAxe,"chisIceAxe");
	GameRegistry.registerItem(chisIceHoe,"chisIceHoe");
	GameRegistry.registerItem(chisIceShovel,"chisIceShovel");
	GameRegistry.registerItem(chisIceSword,"chisIceSword");
	GameRegistry.registerItem(refIcePickaxe,"refIcePickaxe");
	GameRegistry.registerItem(refIceAxe,"refIceAxe");
	GameRegistry.registerItem(refIceHoe,"refIceHoe");
	GameRegistry.registerItem(refIceShovel,"refIceShovel");
	GameRegistry.registerItem(refIceSword,"refIceSword");
	GameRegistry.registerItem(refHelmet,"refHelmet");
	GameRegistry.registerItem(refPlate,"refPlate");
	GameRegistry.registerItem(refLegs,"refLegs");
	GameRegistry.registerItem(refBoots,"refBoots");
	GameRegistry.registerItem(crystalPickaxe,"crystalPickaxe");
	GameRegistry.registerItem(crystalAxe,"crystalAxe");
	GameRegistry.registerItem(crystalHoe,"crystalHoe");
	GameRegistry.registerItem(crystalShovel,"crystalShovel");
	GameRegistry.registerItem(crystalSword,"crystalSword");
	GameRegistry.registerItem(crystalHelmet,"crystalHelmet");
	GameRegistry.registerItem(crystalPlate,"crystalPlate");
	GameRegistry.registerItem(crystalLegs,"crystalLegs");
	GameRegistry.registerItem(crystalBoots,"crystalBoots");
	GameRegistry.registerItem(christmasMusicDisk, "christmasMusicDisk");
	GameRegistry.registerItem(deckTheHallsRecord, "deckTheHallsRecord");
	GameRegistry.registerItem(Itemornament, "ornamentItem");
	GameRegistry.registerItem(itemOrnamentRare, "itemOrnamentRare");
	GameRegistry.registerItem(candleItem, "candleItem");
	/*
	 * 
	 * 
		
	commonItem = new ItemCommonItem(ItemsConfig.commonItemID).setUnlocalizedName("commonItem");
		LanguageRegistry.addName(new ItemStack(commonItem, 1, 0), "Mug");
		LanguageRegistry.addName(new ItemStack(commonItem, 1, 1), "Vanilla Icecream");
		LanguageRegistry.addName(new ItemStack(commonItem, 1, 2), "Chocoalate Icecream");
		LanguageRegistry.addName(new ItemStack(commonItem, 1, 3), "Strawberry Icecream");
		LanguageRegistry.addName(new ItemStack(commonItem, 1, 4), "Cookie-Dough Icecream");
		LanguageRegistry.addName(new ItemStack(commonItem, 1, 5), "Iced Magma-cream");
		LanguageRegistry.addName(new ItemStack(commonItem, 1, 6), "Waffle-Cone");
		LanguageRegistry.addName(new ItemStack(commonItem, 1, 7), "Polarbear Fur");
		LanguageRegistry.addName(new ItemStack(commonItem, 1, 8), "Red-Dyed Fur");
		LanguageRegistry.addName(new ItemStack(commonItem, 1, 9), "Iron Stick");
		
	eggNog = new ItemEggNog(ItemsConfig.eggNogID, 12, 0.7F, false).setUnlocalizedName("eggNog");
		LanguageRegistry.addName(eggNog, "Egg Nog");
		
	coffee = new ItemCoffee(ItemsConfig.coffeeID, 16, 0.8F, false).setUnlocalizedName("coffee");
		LanguageRegistry.addName(coffee, "Hot Chocolate");
		
	gingerbreadMan = new ItemWinterFood(ItemsConfig.gingerbreadManID, 3, 0.3F, false,"\u00a7eFills 1.5 Hunger").setUnlocalizedName("gingerbreadMan");
		LanguageRegistry.addName(gingerbreadMan, "Gingerbread Man");
		
	marshmellow = new ItemWinterFood(ItemsConfig.marshmellowID, 1, 0, false, "\u00a7eFills 0.5 Hunger").setUnlocalizedName("marshmellow2");
		LanguageRegistry.addName(marshmellow, "Marshmallows");
		
	fruitCakeItem = new ItemFruitCakeItem(ItemsConfig.fruitCakeItemID, WinterBlocks.fruitCake).setUnlocalizedName("fruitCake");
		LanguageRegistry.addName(fruitCakeItem, "Fruit Cake");
		
	rockySnowball = new ItemRockySnowball(ItemsConfig.rockySnowballID).setUnlocalizedName("rockySnowball2").setTextureName("rockySnowball2");
		LanguageRegistry.addName(rockySnowball, "Rocky Snowball");
		
	iceBall = new ItemIceBall(ItemsConfig.iceBallID).setUnlocalizedName("iceBall").setTextureName("iceBall");
		LanguageRegistry.addName(iceBall, "Iceball");
		
	iceStaffBad = new ItemIceStaff(ItemsConfig.iceStaffBadID, true).setMaxDamage(1).setUnlocalizedName("iceStaff").setTextureName("rockySnowball2");
		LanguageRegistry.addName(iceStaffBad , "Ice Staff");
		
	chisIcePickaxe = new ItemChisPickaxe(toolChisIce).setUnlocalizedName("chisIcePickaxe");
		LanguageRegistry.addName(chisIcePickaxe, "Chiseled-Ice Pickaxe");
		
	chisIceAxe = new ItemChisAxe(ItemsConfig.chisIceAxeID, toolChisIce).setUnlocalizedName("chisIceAxe");
		LanguageRegistry.addName(chisIceAxe, "Chiseled-Ice Axe");
		
	chisIceHoe = new ItemChisHoe(ItemsConfig.chisIceHoeID, toolChisIce).setUnlocalizedName("chisIceHoe");
		LanguageRegistry.addName(chisIceHoe, "Chiseled-Ice Hoe");
		
	chisIceShovel = new ItemChisShovel(ItemsConfig.chisIceShovelID, toolChisIce).setUnlocalizedName("chisIceShovel");
		LanguageRegistry.addName(chisIceShovel, "Chiseled-Ice Shovel");
		
	chisIceSword = new ItemChisSword(ItemsConfig.chisIceSwordID, toolChisIce).setUnlocalizedName("chisIceSword");
		LanguageRegistry.addName(chisIceSword, "Chiseled-Ice Sword");
		
	coffeeMix = new ItemCoffeeMix(ItemsConfig.coffeeMixID, 8, 0.4F, false).setUnlocalizedName("coffeeMix");
		LanguageRegistry.addName(coffeeMix, "Chocolate Milk");
	
	candyCaneSword = new ItemCandyCaneSword(ItemsConfig.candyCaneSwordID, toolCandyCane).setUnlocalizedName("candyCaneSword");
		LanguageRegistry.addName(candyCaneSword, "CandyCane Sword");
		
	refIcePickaxe = new ItemChisPickaxe(ItemsConfig.refIcePickaxeID, toolRefIce).setUnlocalizedName("refIcePickaxe");
		LanguageRegistry.addName(refIcePickaxe, "Refined-Ice Pickaxe");
		
	refIceAxe = new ItemChisAxe(ItemsConfig.refIceAxeID, toolRefIce).setUnlocalizedName("refIceAxe");
		LanguageRegistry.addName(refIceAxe, "Refined-Ice Axe");
		
	refIceHoe = new ItemChisHoe(ItemsConfig.refIceHoeID, toolRefIce).setUnlocalizedName("refIceHoe");
		LanguageRegistry.addName(refIceHoe, "Refined-Ice Hoe");
		
	refIceShovel = new ItemChisShovel(ItemsConfig.refIceShovelID, toolRefIce).setUnlocalizedName("refIceShovel");
		LanguageRegistry.addName(refIceShovel, "Refined-Ice Shovel");
		
	refIceSword = new ItemChisSword(ItemsConfig.refIceSwordID, toolRefIce).setUnlocalizedName("refIceSword");
		LanguageRegistry.addName(refIceSword, "Refined-Ice Sword");
		
	crystalPickaxe = new ItemChisPickaxe(ItemsConfig.crystalPickaxeID, toolCrystal).setUnlocalizedName("crystalPickaxe");
		LanguageRegistry.addName(crystalPickaxe, "Crystalized Pickaxe");
		
	crystalAxe = new ItemChisAxe(ItemsConfig.crystalAxeID, toolCrystal).setUnlocalizedName("crystalAxe");
		LanguageRegistry.addName(crystalAxe, "Crystalized Axe");
		
	crystalHoe = new ItemChisHoe(ItemsConfig.crystalHoeID, toolCrystal).setUnlocalizedName("crystalHoe");
		LanguageRegistry.addName(crystalHoe, "Crystalized Hoe");
		
	crystalShovel = new ItemChisShovel(ItemsConfig.crystalShovelID, toolCrystal).setUnlocalizedName("crystalShovel");
		LanguageRegistry.addName(crystalShovel, "Crystalized Shovel");
		
	crystalSword = new ItemChisSword(ItemsConfig.crystalSwordID, toolCrystal).setUnlocalizedName("crystalSword");
		LanguageRegistry.addName(crystalSword, "Crystalized Sword");
		
	iceShardSword = new ItemChisSword(ItemsConfig.iceShardSwordID, toolShard).setUnlocalizedName("iceShardSword");
		LanguageRegistry.addName(iceShardSword, "Ice-Shard Sword");
		
	decorDoorItem = new ItemDecorDoorItem(ItemsConfig.decorDoorItemID, Block.decorDoor).setUnlocalizedName("decorDoorItem");
		LanguageRegistry.addName(decorDoorItem, "Decorated Door");
		
	vanillaIcecream = new ItemVanillaCone(ItemsConfig.vanillaIcecreamID, 6, 0, false).setUnlocalizedName("vanillaCone");
		LanguageRegistry.addName(vanillaIcecream, "Vanilla Cone");
		
	chocolateIcecream = new ItemChocolateCone(ItemsConfig.chocolateIcecreamID, 6, 0, false).setUnlocalizedName("chocolateCone");
		LanguageRegistry.addName(chocolateIcecream, "Chocolate Cone");
		
	strawberryIcecream = new ItemStrawberryCone(ItemsConfig.strawberryIcecreamID, 6, 0, false).setUnlocalizedName("strawberryCone");
		LanguageRegistry.addName(strawberryIcecream, "Strawberry Cone");
		
	cookieIcecream = new ItemCookieCone(ItemsConfig.cookieIcecreamID, 6, 0, false).setUnlocalizedName("cookieCone");
		LanguageRegistry.addName(cookieIcecream, "Cookie-Dough Cone");
		
	magmaIcecream = new ItemMagmaCone(ItemsConfig.magmaIcecreamID, 6, 0, false).setUnlocalizedName("magmaCone");
		LanguageRegistry.addName(magmaIcecream, "Iced Magmacream Cone");
		
	christmasMusicDisk = new ItemChristmasMusicDisk(ItemsConfig.christmasMusicDiskID, "wintercraft:jingleBells").setUnlocalizedName("jingleBells");
		LanguageRegistry.addName(christmasMusicDisk, "Jingle Bells");
		
	deckTheHallsRecord = new ItemDeckTheHallsRecord(ItemsConfig.deckTheHallsRecordID, "wintercraft:deckTheHalls").setUnlocalizedName("deckTheHalls");
		LanguageRegistry.addName(deckTheHallsRecord, "Deck the Halls");
		
	santaHat = new ArmorSantaHat(ItemsConfig.santaHatID, armorSanta, 0, 0).setUnlocalizedName("santaHat");
		LanguageRegistry.addName(santaHat, "Santa Hat");
	
	santaSuit = new ArmorSanta(ItemsConfig.santaSuitID, armorSanta, 0, 1, "santa").setUnlocalizedName("santaSuit");
		LanguageRegistry.addName(santaSuit, "Santa Coat");
	
	santaPants = new ArmorSanta(ItemsConfig.santaPantsID, armorSanta, 0, 2, "santa").setUnlocalizedName("santaPants");
		LanguageRegistry.addName(santaPants, "Santa Pants");
	
	santaBoots = new ArmorSanta(ItemsConfig.santaBootsID, armorSanta, 0, 3, "santa").setUnlocalizedName("santaBoots");
		LanguageRegistry.addName(santaBoots, "Santa Boots");
		
	lights = new ItemLights(ItemsConfig.lightsID, Block.lightsBlockWall).setUnlocalizedName("lights");
		LanguageRegistry.addName(lights, "Christmas Lights");
		
	christmasCookie = new ItemWinterFood(ItemsConfig.christmasCookieID, 11, 0.5F, false, "\u00a7eFills 5.5 Hunger").setUnlocalizedName("christmasCookie");
		LanguageRegistry.addName(christmasCookie, "\u00a7aC\u00a7ch\u00a7ar\u00a7ci\u00a7as\u00a7ct\u00a7am\u00a7ca\u00a7as \u00a7cC\u00a7ao\u00a7co\u00a7ak\u00a7ci\u00a7ae");

	refHelmet = new ArmorRef(ItemsConfig.refHelmetID, armorRef, 0, 0, "refined").setUnlocalizedName("refHelmet");
		LanguageRegistry.addName(refHelmet, "Refined-Ice Helmet");
	
	refPlate = new ArmorRef(ItemsConfig.refPlateID, armorRef, 0, 1, "refined").setUnlocalizedName("refPlate");
		LanguageRegistry.addName(refPlate, "Refined-Ice Chestplate");
	
	refLegs = new ArmorRef(ItemsConfig.refLegsID, armorRef, 0, 2, "refined").setUnlocalizedName("refLegs");
		LanguageRegistry.addName(refLegs, "Refined-Ice Leggings");
	
	refBoots = new ArmorRef(ItemsConfig.refBootsID, armorRef, 0, 3, "refined").setUnlocalizedName("refBoots");
		LanguageRegistry.addName(refBoots, "Refined-Ice Boots");	
		
	crystalHelmet = new ArmorCrystal(ItemsConfig.crystalHelmetID, armorCrystal, 0, 0, "crystal").setUnlocalizedName("crystalHelmet");
		LanguageRegistry.addName(crystalHelmet, "Crystal Helmet");
	
	crystalPlate = new ArmorCrystal(ItemsConfig.crystalPlateID, armorCrystal, 0, 1, "crystal").setUnlocalizedName("crystalPlate");
		LanguageRegistry.addName(crystalPlate, "Crystal Chestplate");
		
	crystalLegs = new ArmorCrystal(ItemsConfig.crystalLegsID, armorCrystal, 0, 2, "crystal").setUnlocalizedName("crystalLegs");
		LanguageRegistry.addName(crystalLegs, "Crystal Leggings");
	
	crystalBoots = new ArmorCrystal(ItemsConfig.crystalBootsID, armorCrystal, 0, 3, "crystal").setUnlocalizedName("crystalBoots");
		LanguageRegistry.addName(crystalBoots, "Crystal Boots");
		
	magicSaddle = new MagicSaddle(ItemsConfig.magicSaddleID).setUnlocalizedName("magicSaddle");
		LanguageRegistry.addName(magicSaddle, "Magic Saddle");
		
	*/
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(iceShardSword),1,1,15));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(magicSaddle),1,1,10));

}

}