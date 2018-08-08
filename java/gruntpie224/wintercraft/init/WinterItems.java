package gruntpie224.wintercraft.init;

import java.util.ArrayList;

import gruntpie224.wintercraft.helper.WCSounds;
import gruntpie224.wintercraft.items.ArmorAntlers;
import gruntpie224.wintercraft.items.ArmorSanta;
import gruntpie224.wintercraft.items.ItemBasic;
import gruntpie224.wintercraft.items.ItemBasicSword;
import gruntpie224.wintercraft.items.ItemCandle;
import gruntpie224.wintercraft.items.ItemCandyCaneAxe;
import gruntpie224.wintercraft.items.ItemCandyCaneSword;
import gruntpie224.wintercraft.items.ItemChristmasDisk;
import gruntpie224.wintercraft.items.ItemFruitCake;
import gruntpie224.wintercraft.items.ItemOrnamentRare;
import gruntpie224.wintercraft.items.ItemRockySnowball;
import gruntpie224.wintercraft.items.ItemWinterFood;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WinterItems {
	private static ArrayList<Item> all_items = new ArrayList<Item>();
	
	@GameRegistry.ObjectHolder("wc:ice_shard")
	public static Item ice_shard;
	
	@GameRegistry.ObjectHolder("wc:ice_chunk")
	public static Item ice_chunk;
	
	@GameRegistry.ObjectHolder("wc:empty_mug")
	public static Item empty_mug;
	
	@GameRegistry.ObjectHolder("wc:polarbear_fur")
	public static Item polarbear_fur;
	
	@GameRegistry.ObjectHolder("wc:polarbear_fur_red")
	public static Item polarbear_fur_red;
	
	@GameRegistry.ObjectHolder("wc:fruit_cake_item")
	public static Item fruit_cake_item;
	
	@GameRegistry.ObjectHolder("wc:candle_item")
	public static Item candle_item;
	
	@GameRegistry.ObjectHolder("wc:ornament_item")
	public static Item ornament_item;
	
	@GameRegistry.ObjectHolder("wc:ornament_rare_item")
	public static Item ornament_rare_item;
	
	@GameRegistry.ObjectHolder("wc:candy_cane")
	public static Item candy_cane;
	
	@GameRegistry.ObjectHolder("wc:marshmallow")
	public static Item marshmallow;
	
	@GameRegistry.ObjectHolder("wc:gingerbread_man")
	public static Item gingerbread_man;
	
	@GameRegistry.ObjectHolder("wc:venison")
	public static Item venison;
	
	@GameRegistry.ObjectHolder("wc:venison_cooked")
	public static Item venison_cooked;
	
	@GameRegistry.ObjectHolder("wc:christmas_cookie")
	public static Item christmas_cookie;
	
	@GameRegistry.ObjectHolder("wc:egg_nog")
	public static Item egg_nog;
	
	@GameRegistry.ObjectHolder("wc:choc_milk")
	public static Item choc_milk;
	
	@GameRegistry.ObjectHolder("wc:hot_choc")
	public static Item hot_choc;
	
	@GameRegistry.ObjectHolder("wc:antlers")
	public static Item antlers;
	
	@GameRegistry.ObjectHolder("wc:waffle_cone")
	public static Item waffle_cone;

	@GameRegistry.ObjectHolder("wc:icecream_vanilla")
	public static Item icecream_vanilla;
	
	@GameRegistry.ObjectHolder("wc:icecream_chocolate")
	public static Item icecream_chocolate;
	
	@GameRegistry.ObjectHolder("wc:icecream_strawberry")
	public static Item icecream_strawberry;
	
	@GameRegistry.ObjectHolder("wc:icecream_cookie_dough")
	public static Item icecream_cookie_dough;
	
	@GameRegistry.ObjectHolder("wc:icecream_magma_cream")
	public static Item icecream_magma_cream;
	
	@GameRegistry.ObjectHolder("wc:cone_vanilla")
	public static Item cone_vanilla;
	
	@GameRegistry.ObjectHolder("wc:cone_chocolate")
	public static Item cone_chocolate;
	
	@GameRegistry.ObjectHolder("wc:cone_strawberry")
	public static Item cone_strawberry;
	
	@GameRegistry.ObjectHolder("wc:cone_cookie_dough")
	public static Item cone_cookie_dough;
	
	@GameRegistry.ObjectHolder("wc:cone_magma_cream")
	public static Item cone_magma_cream;
	
	@GameRegistry.ObjectHolder("wc:santa_helmet")
	public static Item santa_helmet;
	
	@GameRegistry.ObjectHolder("wc:santa_plate")
	public static Item santa_plate;
	
	@GameRegistry.ObjectHolder("wc:santa_legs")
	public static Item santa_legs;
	
	@GameRegistry.ObjectHolder("wc:santa_boots")
	public static Item santa_boots;
	
	@GameRegistry.ObjectHolder("wc:music_disk_jingle")
	public static Item music_disk_jingle;
	
	@GameRegistry.ObjectHolder("wc:music_disk_halls")
	public static Item music_disk_halls;
	
	@GameRegistry.ObjectHolder("wc:candy_cane_sword")
	public static Item candy_cane_sword;
	
	@GameRegistry.ObjectHolder("wc:candy_cane_axe")
	public static Item candy_cane_axe;
	
	@GameRegistry.ObjectHolder("wc:shard_sword")
	public static Item shard_sword;
	
	@GameRegistry.ObjectHolder("wc:rocky_snowball")
	public static Item rocky_snowball;
	
	public static ToolMaterial toolCandyCane = EnumHelper.addToolMaterial("CANDYCANE", 1, 250, 6.0F, 3F, 15);
	public static ToolMaterial toolShard = EnumHelper.addToolMaterial("SHARD", 3, 850, 6.5F, 8F, 25);
	
	public static ArmorMaterial armorSkates = EnumHelper.addArmorMaterial("SKATES", "skates", 10, new int[]{2, 4, 2, 1}, 3, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
	public static ArmorMaterial armorSanta = EnumHelper.addArmorMaterial("SANTA", "santa", 7, new int[]{1, 4, 2, 1}, 16, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0);
	
	public static void initItems()
	{
		ice_shard = new ItemBasic("ice_shard");
		all_items.add(ice_shard);
		
		ice_chunk = new ItemBasic("ice_chunk");
		all_items.add(ice_chunk);
		
		empty_mug = new ItemBasic("empty_mug");
		all_items.add(empty_mug);
		
		waffle_cone = new ItemBasic("icecream_cone");
		all_items.add(waffle_cone);
		
		polarbear_fur = new ItemBasic("polarbear_fur");
		all_items.add(polarbear_fur);
		
		polarbear_fur_red = new ItemBasic("polarbear_fur_red");
		all_items.add(polarbear_fur_red);
		
		fruit_cake_item = new ItemFruitCake("fruit_cake_item", WinterBlocks.fruit_cake);
		all_items.add(fruit_cake_item);
		
		candle_item = new ItemCandle("candle_item", WinterBlocks.candle);
			
		ornament_item = new ItemCandle("ornament_item", WinterBlocks.ornament);
		
		ornament_rare_item = new ItemOrnamentRare("ornament_rare", WinterBlocks.ornament_rare);
	
		candy_cane = new ItemWinterFood("candy_cane", 3, 0.6F, false);
		all_items.add(candy_cane);
		
		marshmallow = new ItemWinterFood("marshmallow", 1, 0.3F, false);
		all_items.add(marshmallow);
		
		gingerbread_man = new ItemWinterFood("gingerbread_man", 3, 0.5F, false);
		all_items.add(gingerbread_man);
		
		venison = new ItemWinterFood("venison_raw", 4, 0.3F, true);
		all_items.add(venison);
		
		venison_cooked = new ItemWinterFood("venison_cooked", 10, 0.9F, true);
		all_items.add(venison_cooked);
		
		christmas_cookie = new ItemWinterFood("christmas_cookie", 11, 1.2F, false);
		all_items.add(christmas_cookie);
		
		egg_nog = new ItemWinterFood("egg_nog", 12, 0.7F, false, true);
		all_items.add(egg_nog);
		
		choc_milk = new ItemWinterFood("choc_milk", 8, 0.8F, false, true, "\u00a77\u00a7oWarm it up for a tastier drink!");
		all_items.add(choc_milk);
		
		hot_choc = new ItemWinterFood("hot_choc", 16, 1.0F, false, true, "\u00a7bGives a Speed Boost").setPotion(1, 45, 2);
		all_items.add(hot_choc);
		
		antlers = new ArmorAntlers("antlers", armorSkates, 0, EntityEquipmentSlot.HEAD);
		all_items.add(antlers);
		
		santa_helmet = new ArmorSanta("santa_helmet", armorSanta, 0, EntityEquipmentSlot.HEAD);
		all_items.add(santa_helmet);
		
		santa_plate = new ArmorSanta("santa_plate", armorSanta, 0, EntityEquipmentSlot.CHEST);
		all_items.add(santa_plate);
		
		santa_legs = new ArmorSanta("santa_legs", armorSanta, 0, EntityEquipmentSlot.LEGS);
		all_items.add(santa_legs);
		
		santa_boots = new ArmorSanta("santa_boots", armorSanta, 0, EntityEquipmentSlot.FEET);
		all_items.add(santa_boots);
		
		music_disk_jingle = new ItemChristmasDisk("music_disk_jingle", WCSounds.snd_disk_jingle);
		all_items.add(music_disk_jingle);
		
		music_disk_halls = new ItemChristmasDisk("music_disk_halls", WCSounds.snd_disk_halls);
		all_items.add(music_disk_halls);
		
		candy_cane_sword = new ItemCandyCaneSword("candy_cane_sword", toolCandyCane);
		all_items.add(candy_cane_sword);
		
		candy_cane_axe = new ItemCandyCaneAxe("candy_cane_axe", toolCandyCane);
		all_items.add(candy_cane_axe);
		
		shard_sword = new ItemBasicSword("shard_sword", toolShard, null);
		all_items.add(shard_sword);
		
		rocky_snowball = new ItemRockySnowball("snowball_rock");
		all_items.add(rocky_snowball);
		
		icecream_vanilla = new ItemBasic("icecream_vanilla");
		all_items.add(icecream_vanilla);
		
		icecream_chocolate = new ItemBasic("icecream_chocolate");
		all_items.add(icecream_chocolate);
		
		icecream_strawberry = new ItemBasic("icecream_strawberry");
		all_items.add(icecream_strawberry);
		
		icecream_cookie_dough = new ItemBasic("icecream_cookie_dough");
		all_items.add(icecream_cookie_dough);
		
		icecream_magma_cream = new ItemBasic("icecream_magma_cream");
		all_items.add(icecream_magma_cream);
		
		cone_vanilla = new ItemWinterFood("cone_vanilla", 6, 1.0F, false);
		all_items.add(cone_vanilla);
		
		cone_chocolate = new ItemWinterFood("cone_chocolate", 6, 1.0F, false, false, "\u00a7cGives a Strength Boost").setPotion(5, 45, 2);
		all_items.add(cone_chocolate);
		
		cone_strawberry = new ItemWinterFood("cone_strawberry", 6, 1.0F, false, false, "\u00a7cGives Health Regen").setPotion(10, 30, 2);
		all_items.add(cone_strawberry);
		
		cone_cookie_dough = new ItemWinterFood("cone_cookie_dough", 6, 1.0F, false, false, "\u00a7cGives a Speed Boost").setPotion(1, 45, 1);
		all_items.add(cone_cookie_dough);
		
		cone_magma_cream = new ItemWinterFood("cone_magma_cream", 6, 1.0F, false, false, "\u00a7cGives Fire Resistance").setPotion(12, 45, 2);
		all_items.add(cone_magma_cream);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		for(Item item : all_items)
			registerRender(item);
	}
	
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		for(Item item : all_items)
			event.getRegistry().register(item);
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
