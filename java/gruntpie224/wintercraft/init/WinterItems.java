package gruntpie224.wintercraft.init;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.WintercraftReference;
import gruntpie224.wintercraft.entity.EntityBase;
import gruntpie224.wintercraft.items.ArmorAntlerHat;
import gruntpie224.wintercraft.items.ArmorCrystal;
import gruntpie224.wintercraft.items.ArmorIceSkates;
import gruntpie224.wintercraft.items.ArmorRef;
import gruntpie224.wintercraft.items.ArmorSanta;
import gruntpie224.wintercraft.items.ArmorSantaHat;
import gruntpie224.wintercraft.items.ItemBaseItem;
import gruntpie224.wintercraft.items.ItemBasicAxe;
import gruntpie224.wintercraft.items.ItemBasicHoe;
import gruntpie224.wintercraft.items.ItemBasicPickaxe;
import gruntpie224.wintercraft.items.ItemBasicShovel;
import gruntpie224.wintercraft.items.ItemBasicSword;
import gruntpie224.wintercraft.items.ItemCandleItem;
import gruntpie224.wintercraft.items.ItemCandyCaneSword;
import gruntpie224.wintercraft.items.ItemChristmasMusicDisk;
import gruntpie224.wintercraft.items.ItemCommonItem;
import gruntpie224.wintercraft.items.ItemDecorDoorItem;
import gruntpie224.wintercraft.items.ItemFruitCakeItem;
import gruntpie224.wintercraft.items.ItemHotChoc;
import gruntpie224.wintercraft.items.ItemIceBall;
import gruntpie224.wintercraft.items.ItemIceGem;
import gruntpie224.wintercraft.items.ItemIceStaff;
import gruntpie224.wintercraft.items.ItemLights;
import gruntpie224.wintercraft.items.ItemOrnamentItem;
import gruntpie224.wintercraft.items.ItemOrnamentRareItem;
import gruntpie224.wintercraft.items.ItemRockySnowball;
import gruntpie224.wintercraft.items.ItemWinterFood;
import gruntpie224.wintercraft.items.ItemWinterIcecream;
import gruntpie224.wintercraft.items.MagicSaddle;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WinterItems {

	public static Item candy_cane;
	public static Item common_items;
	public static Item egg_nog;
	public static Item hot_choc;
	public static Item gingerbread_man;
	public static Item marshmallow;
	public static Item fruit_cake_item;
	public static Item snowball_rock;
	public static Item snowball_ice;
	public static Item ice_staff;
	
	public static Item chis_ice_pickaxe;
	public static Item chis_ice_hoe;
	public static Item chis_ice_axe;
	public static Item chis_ice_shovel;
	public static Item chis_ice_sword;
	
	public static Item choc_milk;
	public static Item ice_gem;
	public static Item ice_staff_corrupt;
	public static Item candy_cane_sword;
	
	public static Item ref_ice_pickaxe;
	public static Item ref_ice_hoe;
	public static Item ref_ice_axe;
	public static Item ref_ice_shovel;
	public static Item ref_ice_sword;
	
	public static Item cry_pickaxe;
	public static Item cry_hoe;
	public static Item cry_axe;
	public static Item cry_shovel;
	public static Item cry_sword;
	
	public static Item shard_sword;
	public static Item decor_door_item;
	public static Item cone_vanilla;
	public static Item cone_magma;
	public static Item cone_chocolate;
	public static Item cone_strawberry;
	public static Item cone_cookie;
	public static Item ice_shard;
	public static Item music_disk_jingle;
	public static Item music_disk_halls;
	
	public static Item santa_helmet;
	public static Item santa_plate;
	public static Item santa_legs;
	public static Item santa_boots;
	public static Boolean santa_armour = false;
	
	public static Item lights;
	public static Item christmas_cookie;
	public static Item ice_chunk;
	public static Item ice_ingot;
	public static Item ice_crystal;
	
	public static Item ref_helmet;
	public static Item ref_plate;
	public static Item ref_legs;
	public static Item ref_boots;
	
	public static Item cry_helmet;
	public static Item cry_plate;
	public static Item cry_legs;
	public static Item cry_boots;
	
	public static Item reindeer_saddle;
	
	public static Item ornament_item;
	public static Item candle_item;
	public static Item ornament_item_rare;
	public static Item venison_raw;
	public static Item venison_cooked;
	public static Item candy_cane_axe;
	public static Item ice_skates;
	public static Item antlers;
	
	public static ToolMaterial toolChisIce = EnumHelper.addToolMaterial("CHISICE", 1, 180, 6.0F, 1F, 5);
	public static ToolMaterial toolCandyCane = EnumHelper.addToolMaterial("CANDYCANE", 1, 250, 6.0F, 3F, 15);
	public static ToolMaterial toolRefIce = EnumHelper.addToolMaterial("REFICE", 2, 350, 7.5F, 2F, 15);
	public static ToolMaterial toolCrystal = EnumHelper.addToolMaterial("CRYSTAL", 3, 1800, 9.0F, 3F, 25);
	public static ToolMaterial toolShard = EnumHelper.addToolMaterial("SHARD", 3, 850, 6.5F, 8F, 25);
	
	
	public static ArmorMaterial armorSanta = EnumHelper.addArmorMaterial("SANTA", "santa", 7, new int[]{1, 4, 2, 1}, 16);
	public static ArmorMaterial armorRef = EnumHelper.addArmorMaterial("REFINED", "refined" ,18, new int[]{3, 6, 5, 2}, 10);
	public static ArmorMaterial armorCrystal = EnumHelper.addArmorMaterial("CRYSTAL", "crystal",42, new int[]{3, 8, 6, 3}, 11);
	public static ArmorMaterial armorSkates = EnumHelper.addArmorMaterial("SKATES", "skates", 10, new int[]{2, 4, 2, 1}, 3);
	
	public static void Init(){
		// [1.8] 64 / 65 Items Updated
		
		santa_armour = false;
		candy_cane = new ItemWinterFood(3, 0.6F, false).setUnlocalizedName("candy_cane");
		ice_chunk = new ItemBaseItem().setUnlocalizedName("ice_chunk");
		ice_shard = new ItemBaseItem().setUnlocalizedName("ice_shard");
		ice_ingot = new ItemBaseItem().setUnlocalizedName("ice_ingot");
		ice_crystal = new ItemBaseItem().setUnlocalizedName("ice_crystal");
		ice_staff = new ItemIceStaff(false).setCreativeTab(Wintercraft.wintercraftTab).setMaxDamage(350).setUnlocalizedName("ice_staff");
		ice_staff_corrupt = new ItemIceStaff(true).setMaxDamage(1).setUnlocalizedName("ice_staff");
		snowball_ice = new ItemIceBall().setUnlocalizedName("snowball_ice");
		ice_gem = new ItemIceGem().setUnlocalizedName("ice_gem");
		common_items = new ItemCommonItem().setUnlocalizedName("common_items");
		egg_nog = new ItemWinterFood(12, 0.7F, false, true).setUnlocalizedName("egg_nog");
		hot_choc = new ItemHotChoc(16, 1.0F, false).setUnlocalizedName("hot_choc");
		gingerbread_man = new ItemWinterFood(3, 0.5F, false).setUnlocalizedName("gingerbread_man");
		marshmallow = new ItemWinterFood(1, 0.3F, false).setUnlocalizedName("marshmallow");
		fruit_cake_item = new ItemFruitCakeItem(WinterSpecialBlocks.fruit_cake_block).setUnlocalizedName("fruit_cake_item");
		snowball_rock = new ItemRockySnowball().setUnlocalizedName("snowball_rock");
		chis_ice_pickaxe = new ItemBasicPickaxe(toolChisIce,Item.getItemFromBlock(WinterBlocks.iced_stone)).setUnlocalizedName("chis_ice_pickaxe");
		chis_ice_axe = new ItemBasicAxe(toolChisIce,Item.getItemFromBlock(WinterBlocks.iced_stone)).setUnlocalizedName("chis_ice_axe");
		chis_ice_hoe = new ItemBasicHoe(toolChisIce,Item.getItemFromBlock(WinterBlocks.iced_stone)).setUnlocalizedName("chis_ice_hoe");
		chis_ice_shovel = new ItemBasicShovel(toolChisIce,Item.getItemFromBlock(WinterBlocks.iced_stone)).setUnlocalizedName("chis_ice_shovel");
		chis_ice_sword = new ItemBasicSword(toolChisIce,Item.getItemFromBlock(WinterBlocks.iced_stone)).setUnlocalizedName("chis_ice_sword");
		choc_milk = new ItemWinterFood(8, 0.8F, false, true, "\u00a77\u00a7oWarm it up for a tastier drink!").setUnlocalizedName("choc_milk");
		candy_cane_sword = new ItemCandyCaneSword(toolCandyCane).setUnlocalizedName("candy_cane_sword");	
		ref_ice_pickaxe = new ItemBasicPickaxe(toolRefIce,ice_ingot).setUnlocalizedName("ref_ice_pickaxe");	
		ref_ice_axe = new ItemBasicAxe(toolRefIce,ice_ingot).setUnlocalizedName("ref_ice_axe");		
		ref_ice_hoe = new ItemBasicHoe(toolRefIce, ice_ingot).setUnlocalizedName("ref_ice_hoe");		
		ref_ice_shovel = new ItemBasicShovel(toolRefIce,ice_ingot).setUnlocalizedName("ref_ice_shovel");		
		ref_ice_sword = new ItemBasicSword(toolRefIce,ice_ingot).setUnlocalizedName("ref_ice_sword");		
		cry_pickaxe = new ItemBasicPickaxe(toolCrystal,ice_crystal).setUnlocalizedName("cry_pickaxe");		
		cry_axe = new ItemBasicAxe(toolCrystal,ice_crystal).setUnlocalizedName("cry_axe");
		cry_hoe = new ItemBasicHoe(toolCrystal, ice_crystal).setUnlocalizedName("cry_hoe");		
		cry_shovel = new ItemBasicShovel(toolCrystal,ice_crystal).setUnlocalizedName("cry_shovel");		
		cry_sword = new ItemBasicSword(toolCrystal,ice_crystal).setUnlocalizedName("cry_sword");
		shard_sword = new ItemBasicSword(toolShard).setUnlocalizedName("shard_sword");
		decor_door_item = new ItemDecorDoorItem(WinterSpecialBlocks.decor_door_block).setUnlocalizedName("decor_door_item");
		lights = new ItemLights(WinterSpecialBlocks.lights_wall).setUnlocalizedName("lights");
		cone_vanilla = new ItemWinterIcecream(6, 1.0F, -1, "").setUnlocalizedName("cone_vanilla");
		cone_chocolate = new ItemWinterIcecream(6, 1.0F, Potion.damageBoost.id, "\u00a7cGives 45 Sec Strength Boost").setUnlocalizedName("cone_chocolate");
		cone_strawberry = new ItemWinterIcecream(6, 1.0F, Potion.regeneration.id, "\u00a7dGives 45 Sec of Health Regen").setUnlocalizedName("cone_strawberry");
		cone_cookie = new ItemWinterIcecream(6, 1.0F, Potion.moveSpeed.id, "\u00a7bGives 45 Sec Speed Boost").setUnlocalizedName("cone_cookie");
		cone_magma = new ItemWinterIcecream(6, 1.0F, Potion.fireResistance.id, "\u00a76Gives 45 Sec of Fire Protect").setUnlocalizedName("cone_magma");
		music_disk_jingle = new ItemChristmasMusicDisk("wc:jingleBells").setUnlocalizedName("music_disk_jingle");
		music_disk_halls = new ItemChristmasMusicDisk("wc:deckTheHalls").setUnlocalizedName("music_disk_halls");
		santa_helmet = new ArmorSantaHat(armorSanta, 0, 0).setUnlocalizedName("santa_helmet");
		santa_plate = new ArmorSanta(armorSanta, 0, 1, "santa").setUnlocalizedName("santa_plate");
		santa_legs = new ArmorSanta(armorSanta, 0, 2, "santa").setUnlocalizedName("santa_legs");
		santa_boots = new ArmorSanta(armorSanta, 0, 3, "santa").setUnlocalizedName("santa_boots");
		christmas_cookie = new ItemWinterFood(11, 1.2F, false).setUnlocalizedName("christmas_cookie");
		ref_helmet = new ArmorRef(armorRef, 0, 0).setUnlocalizedName("ref_helmet");
		ref_plate = new ArmorRef(armorRef, 0, 1).setUnlocalizedName("ref_plate");
		ref_legs = new ArmorRef(armorRef, 0, 2).setUnlocalizedName("ref_legs");
		ref_boots = new ArmorRef(armorRef, 0, 3).setUnlocalizedName("ref_boots");
		cry_helmet = new ArmorCrystal(armorCrystal, 0, 0).setUnlocalizedName("cry_helmet");
		cry_plate = new ArmorCrystal(armorCrystal, 0, 1).setUnlocalizedName("cry_plate");
		cry_legs = new ArmorCrystal(armorCrystal, 0, 2).setUnlocalizedName("cry_legs");
		cry_boots = new ArmorCrystal(armorCrystal, 0, 3).setUnlocalizedName("cry_boots");
		reindeer_saddle = new MagicSaddle().setUnlocalizedName("reindeer_saddle");
		ornament_item = new ItemOrnamentItem(WinterSpecialBlocks.ornament.getDefaultState()).setUnlocalizedName("ornament_item");
		candle_item = new ItemCandleItem(WinterSpecialBlocks.candle.getDefaultState()).setUnlocalizedName("candle_item");
		ornament_item_rare = new ItemOrnamentRareItem(WinterSpecialBlocks.ornament_rare.getDefaultState()).setUnlocalizedName("ornament_item_rare");
		venison_raw = new ItemWinterFood(4, 0.3F, true).setUnlocalizedName("venison_raw");
		venison_cooked = new ItemWinterFood(10, 0.9F, true).setUnlocalizedName("venison_cooked");
		candy_cane_axe = new ItemBasicAxe(toolCandyCane).setUnlocalizedName("candy_cane_axe");	
		ice_skates = new ArmorIceSkates(armorSkates, 0, 3,"skates").setUnlocalizedName("ice_skates");
		antlers = new ArmorAntlerHat(armorSkates, 0, 0).setUnlocalizedName("antlers");
		
		GameRegistry.registerItem(snowball_rock,"snowball_rock");
		GameRegistry.registerItem(snowball_ice, "snowball_ice");
		GameRegistry.registerItem(lights, "lights");
		GameRegistry.registerItem(ice_staff,"ice_staff");
		GameRegistry.registerItem(ice_staff_corrupt,"ice_staff_corrupt");
		GameRegistry.registerItem(shard_sword, "shard_sword");
		GameRegistry.registerItem(candy_cane_sword,"candy_cane_sword");
		GameRegistry.registerItem(candy_cane_axe,"candy_cane_axe");
		GameRegistry.registerItem(reindeer_saddle, "reindeer_saddle");
		GameRegistry.registerItem(ice_skates, "ice_skates");
		GameRegistry.registerItem(christmas_cookie,"christmas_cookie");
		GameRegistry.registerItem(venison_raw, "venison_raw");
		GameRegistry.registerItem(venison_cooked, "venison_cooked");
		GameRegistry.registerItem(candy_cane, "candy_cane");
		GameRegistry.registerItem(egg_nog,"egg_nog");
		GameRegistry.registerItem(choc_milk,"choc_milk");
		GameRegistry.registerItem(hot_choc,"hot_choc");
		GameRegistry.registerItem(gingerbread_man,"gingerbread_man");
		GameRegistry.registerItem(marshmallow,"marshmallow");
		GameRegistry.registerItem(cone_vanilla, "cone_vanilla");
		GameRegistry.registerItem(cone_chocolate, "cone_chocolate");
		GameRegistry.registerItem(cone_strawberry, "cone_strawberry");
		GameRegistry.registerItem(cone_cookie, "cone_cookie");
		GameRegistry.registerItem(cone_magma, "cone_magma");
		GameRegistry.registerItem(fruit_cake_item,"fruit_cake_item");
		GameRegistry.registerItem(decor_door_item, "decor_door_item");
		GameRegistry.registerItem(ice_shard,"ice_shard");
		GameRegistry.registerItem(ice_chunk, "ice_chunk");
		GameRegistry.registerItem(ice_gem, "ice_gem");
		GameRegistry.registerItem(ice_ingot, "ice_ingot");
		GameRegistry.registerItem(ice_crystal, "ice_crystal");;
		GameRegistry.registerItem(antlers,"antlers");
		GameRegistry.registerItem(common_items, "common_items");
		GameRegistry.registerItem(santa_helmet,"santa_helmet");
		GameRegistry.registerItem(santa_plate,"santa_plate");
		GameRegistry.registerItem(santa_legs,"santa_legs");
		GameRegistry.registerItem(santa_boots,"santa_boots");
		GameRegistry.registerItem(chis_ice_pickaxe,"chis_ice_pickaxe");
		GameRegistry.registerItem(chis_ice_axe,"chis_ice_axe");
		GameRegistry.registerItem(chis_ice_hoe,"chis_ice_hoe");
		GameRegistry.registerItem(chis_ice_shovel,"chis_ice_shovel");
		GameRegistry.registerItem(chis_ice_sword,"chis_ice_sword");
		GameRegistry.registerItem(ref_ice_pickaxe,"ref_ice_pickaxe");
		GameRegistry.registerItem(ref_ice_axe,"ref_ice_axe");
		GameRegistry.registerItem(ref_ice_hoe,"ref_ice_hoe");
		GameRegistry.registerItem(ref_ice_shovel,"ref_ice_shovel");
		GameRegistry.registerItem(ref_ice_sword,"ref_ice_sword");
		GameRegistry.registerItem(ref_helmet,"ref_helmet");
		GameRegistry.registerItem(ref_plate,"ref_plate");
		GameRegistry.registerItem(ref_legs,"ref_legs");
		GameRegistry.registerItem(ref_boots,"ref_boots");
		GameRegistry.registerItem(cry_pickaxe,"cry_pickaxe");
		GameRegistry.registerItem(cry_axe,"cry_axe");
		GameRegistry.registerItem(cry_hoe,"cry_hoe");
		GameRegistry.registerItem(cry_shovel,"cry_shovel");
		GameRegistry.registerItem(cry_sword,"cry_sword");
		GameRegistry.registerItem(cry_helmet,"cry_helmet");
		GameRegistry.registerItem(cry_plate,"cry_plate");
		GameRegistry.registerItem(cry_legs,"cry_legs");
		GameRegistry.registerItem(cry_boots,"cry_boots");
		GameRegistry.registerItem(music_disk_jingle, "music_disk_jingle");
		GameRegistry.registerItem(music_disk_halls, "music_disk_halls");
		GameRegistry.registerItem(ornament_item, "ornament_item");
		GameRegistry.registerItem(ornament_item_rare, "ornament_item_rare");
		GameRegistry.registerItem(candle_item, "candle_item");
		
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(shard_sword),1,1,15));
		ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem(new WeightedRandomChestContent(new ItemStack(reindeer_saddle),1,1,10));

	}
	
	public static void registerRenders(){
		registerRender(cry_helmet);
		registerRender(cry_plate);
		registerRender(cry_legs);
		registerRender(cry_boots);
		registerRender(ref_helmet);
		registerRender(ref_plate);
		registerRender(ref_legs);
		registerRender(ref_boots);
		registerRender(cry_pickaxe);
		registerRender(cry_axe);
		registerRender(cry_hoe);
		registerRender(cry_shovel);
		registerRender(cry_sword);
		registerRender(ref_ice_pickaxe);
		registerRender(ref_ice_axe);
		registerRender(ref_ice_hoe);
		registerRender(ref_ice_shovel);
		registerRender(ref_ice_sword);
		registerRender(chis_ice_pickaxe);
		registerRender(chis_ice_axe);
		registerRender(chis_ice_hoe);
		registerRender(chis_ice_shovel);
		registerRender(chis_ice_sword);
		registerRender(fruit_cake_item);
		registerRender(decor_door_item);
		registerRender(ice_skates);
		registerRender(santa_helmet);
		registerRender(santa_legs);
		registerRender(santa_plate);
		registerRender(santa_boots);
		registerRender(antlers);
		registerRender(reindeer_saddle);
		registerRender(venison_cooked);
		registerRender(venison_raw);
		registerRender(christmas_cookie);
		registerRender(cone_magma);
		registerRender(cone_cookie);
		registerRender(cone_strawberry);
		registerRender(cone_chocolate);
		registerRender(cone_vanilla);
		registerRender(music_disk_halls);
		registerRender(music_disk_jingle);
		registerRender(candy_cane_axe);
		registerRender(candy_cane_sword);
		registerRender(shard_sword);
		registerRender(ice_staff);
		registerRender(ice_staff_corrupt);
		registerRender(snowball_ice);
		registerRender(snowball_rock);
		registerRender(candy_cane);
		registerRender(ice_shard);
		registerRender(ice_ingot);
		registerRender(ice_chunk);
		registerRender(ice_crystal);
		registerRender(egg_nog);
		registerRender(hot_choc);
		registerRender(gingerbread_man);
		registerRender(marshmallow);
		registerRender(choc_milk);
		registerRenderMeta(ice_gem, 2);
		registerRenderMeta(common_items, 10);
		registerRender(lights);
		registerRenderMeta(ornament_item, 16);
		registerRenderMeta(ornament_item_rare, 3);
		registerRenderMeta(candle_item, 16);
	}

	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(WintercraftReference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerRenderMeta(Item item, int metaMax){
		ModelResourceLocation itemModelResourceLocation;
		
		for(int i=0; i<metaMax; i++){
			ModelBakery.addVariantName(item, WintercraftReference.MOD_ID + ":" + item.getUnlocalizedName(new ItemStack(ice_gem, 1, i)).substring(5)); 
			itemModelResourceLocation = new ModelResourceLocation(WintercraftReference.MOD_ID + ":" + item.getUnlocalizedName(new ItemStack(ice_gem, 1, i)).substring(5), "inventory");
		    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, i, itemModelResourceLocation);
		}
		
	}

}