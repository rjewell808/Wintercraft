package gruntpie224.wintercraft.init;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.WintercraftReference;
import gruntpie224.wintercraft.blocks.BlockAdventCalendar;
import gruntpie224.wintercraft.blocks.BlockBaseBlock;
import gruntpie224.wintercraft.blocks.BlockCalendar;
import gruntpie224.wintercraft.blocks.BlockCandyCane;
import gruntpie224.wintercraft.blocks.BlockChristmasPresent;
import gruntpie224.wintercraft.blocks.BlockDarkPresent;
import gruntpie224.wintercraft.blocks.BlockFirePlace;
import gruntpie224.wintercraft.blocks.BlockFreezer;
import gruntpie224.wintercraft.blocks.BlockGift;
import gruntpie224.wintercraft.blocks.BlockLightsBlock;
import gruntpie224.wintercraft.blocks.BlockPresent;
import gruntpie224.wintercraft.blocks.BlockSnowGlobeBlock;
import gruntpie224.wintercraft.blocks.BlockSnowManHead;
import gruntpie224.wintercraft.blocks.BlockSnowSlabFull;
import gruntpie224.wintercraft.blocks.BlockSnowSlabHalf;
import gruntpie224.wintercraft.blocks.BlockSnowStairs;
import gruntpie224.wintercraft.blocks.BlockStar;
import gruntpie224.wintercraft.blocks.BlockWallBlock;
import gruntpie224.wintercraft.blocks.BlockWinterSpawner;
import gruntpie224.wintercraft.items.ItemSnowSlab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class WinterBlocks {

	public static Block snow_bricks;
	public static Block snow_slab_single;
	public static Block snow_slab_double;
	public static Block snow_stairs;
	public static Block star;
	public static Block fruit_bricks;
	public static Block freezer;
	public static Block freezerActive;
	public static Block present;
	public static Block winter_present;
	public static Block wreath;
	public static Block lights_block;
	public static Block miniGolemSpawner;
	public static Block iced_stone;
	public static Block stocking;
	public static Block stocking_full;
	public static Block gift;
	public static Block snow_man_head;
	public static Block calendar;
	public static Block candy_cane_block;
	public static Block calendar_advent;
	public static Block dark_present;
	public static Block snow_globe;
	public static Block fireplace;
	public static Block fireplace_active;
	public static Block iced_cobble;
	public static Block snow_globe_corrupt;
	
	public static void Init()
	{
		// [1.8] 32 / 33 Blocks Updated
		
		star = new BlockStar(Material.GLASS).setHardness(0.8F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("star");	
		iced_stone = new BlockBaseBlock(Material.ROCK).setHardness(1.3F).setStepSound(Block.soundTypeStone).setUnlocalizedName("iced_stone");
		snow_bricks = new BlockBaseBlock(Material.ROCK).setHardness(1.3F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_bricks");
		snow_stairs = new BlockSnowStairs(Blocks.SNOW).setUnlocalizedName("snow_stairs");	
		fruit_bricks = new BlockBaseBlock(Material.ROCK).setHardness(2.5F).setStepSound(Block.soundTypeStone).setUnlocalizedName("fruit_bricks");	
		lights_block = new BlockLightsBlock(Material.LEAVES).setHardness(0.6F).setLightLevel(0.7F).setStepSound(Block.soundTypeGrass).setUnlocalizedName("lights_block");
		freezer = new BlockFreezer(false).setHardness(2.5F).setStepSound(Block.soundTypeGlass).setCreativeTab(Wintercraft.wintercraftTab).setUnlocalizedName("freezer");
		freezerActive = new BlockFreezer(true).setHardness(2.5F).setLightLevel(0.8F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("freezer");
		wreath = new BlockWallBlock().setHardness(0.3F).setStepSound(Block.soundTypeGrass).setUnlocalizedName("wreath");
		stocking = new BlockWallBlock().setHardness(0.2F).setStepSound(Block.soundTypeCloth).setUnlocalizedName("stocking");	
		stocking_full = new BlockWallBlock().setHardness(0.2F).setStepSound(Block.soundTypeCloth).setUnlocalizedName("stocking_full");	
		snow_man_head = new BlockSnowManHead(1, Material.GROUND).setHardness(0.2F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_man_head");
		miniGolemSpawner = new BlockWinterSpawner("MiniSnowGolem").setHardness(5.5F).setStepSound(Block.soundTypeMetal).setUnlocalizedName("winter_spawner");						
		gift = new BlockGift(Material.CLOTH).setHardness(0.2F).setStepSound(Block.soundTypeCloth).setUnlocalizedName("gift");	
		snow_slab_single = new BlockSnowSlabHalf().setHardness(0.5F).setResistance(7.5F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_slab_single");		
		snow_slab_double = new BlockSnowSlabFull().setHardness(0.6F).setResistance(7.5F).setStepSound(Block.soundTypeSnow).setUnlocalizedName("snow_slab_double");
		calendar = new BlockCalendar().setHardness(0.3F).setStepSound(Block.soundTypeGrass).setUnlocalizedName("calendar");
		candy_cane_block = new BlockCandyCane(Material.WOOD).setHardness(1.5F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("candy_cane_block");
		calendar_advent = new BlockAdventCalendar().setHardness(0.3F).setStepSound(Block.soundTypeGrass).setUnlocalizedName("calendar_advent");
		dark_present = new BlockDarkPresent(Material.CLOTH).setHardness(0.2F).setStepSound(Block.soundTypeCloth).setUnlocalizedName("dark_present");
		snow_globe = new BlockSnowGlobeBlock(Material.GLASS,false).setHardness(0.5F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("snow_globe");
		snow_globe_corrupt = new BlockSnowGlobeBlock(Material.GLASS,true).setHardness(0.5F).setStepSound(Block.soundTypeGlass).setUnlocalizedName("snow_globe");
		fireplace = new BlockFirePlace(Material.WOOD,false).setHardness(2.5F).setStepSound(Block.soundTypeWood).setUnlocalizedName("fireplace").setCreativeTab(Wintercraft.wintercraftTab);
		fireplace_active = new BlockFirePlace(Material.WOOD,true).setHardness(2.5F).setLightLevel(1.0F).setStepSound(Block.soundTypeWood).setUnlocalizedName("fireplace");
		iced_cobble = new BlockBaseBlock(Material.ROCK).setHardness(1.1F).setStepSound(Block.soundTypeStone).setUnlocalizedName("iced_cobble");
		winter_present = new BlockChristmasPresent(Material.CLOTH).setHardness(0.2F).setStepSound(Block.soundTypeCloth).setUnlocalizedName("winter_present");
		present = new BlockPresent(Material.CLOTH).setHardness(0.2F).setStepSound(Block.soundTypeCloth).setUnlocalizedName("present");
		
		
		GameRegistry.registerBlock(star, "star");
		GameRegistry.registerBlock(winter_present, "winter_present");
		GameRegistry.registerBlock(present, "present");
		GameRegistry.registerBlock(gift, "gift");
		GameRegistry.registerBlock(dark_present, "dark_present");
		GameRegistry.registerBlock(iced_stone, "iced_stone");
		GameRegistry.registerBlock(iced_cobble, "iced_cobble");
		GameRegistry.registerBlock(candy_cane_block, "candy_cane_block");
		GameRegistry.registerBlock(fruit_bricks, "fruit_bricks");
		GameRegistry.registerBlock(snow_bricks, "snow_bricks");
		GameRegistry.registerBlock(snow_stairs, "snow_stairs");
		GameRegistry.registerBlock(snow_slab_single, ItemSnowSlab.class, "snow_slab_single", snow_slab_single, snow_slab_double, false);
		GameRegistry.registerBlock(snow_slab_double, ItemSnowSlab.class, "snow_slab_double", snow_slab_single, snow_slab_double, true);
		GameRegistry.registerBlock(lights_block, "lights_block");
		GameRegistry.registerBlock(freezer,"freezer");
		GameRegistry.registerBlock(freezerActive, "freezerActive");
		GameRegistry.registerBlock(wreath, "wreath");
		GameRegistry.registerBlock(stocking, "stocking");
		GameRegistry.registerBlock(stocking_full, "stocking_full");
		GameRegistry.registerBlock(calendar, "calendar");
		GameRegistry.registerBlock(calendar_advent, "calendar_advent");
		GameRegistry.registerBlock(snow_man_head, "snow_man_head");
		GameRegistry.registerBlock(miniGolemSpawner, "winter_spawner");
		GameRegistry.registerBlock(snow_globe, "snow_globe");
		GameRegistry.registerBlock(snow_globe_corrupt, "snow_globe_corrupt");
		GameRegistry.registerBlock(fireplace, "fireplace");
		GameRegistry.registerBlock(fireplace_active, "fireplace_active");
	}
	
	public static void registerRenders()
	{
		registerRender(star);
		registerRender(iced_stone);
		registerRender(iced_cobble);
		registerRender(snow_bricks);
		registerRender(present);
		registerRender(winter_present);
		registerRender(lights_block);
		registerRender(calendar);
		registerRender(calendar_advent);
		registerRender(wreath);
		registerRender(stocking);
		registerRender(stocking_full);
		registerRender(candy_cane_block);
		registerRender(snow_slab_single);
		registerRender(fruit_bricks);
		registerRender(snow_stairs);
		registerRender(gift);
		registerRender(freezer);
		registerRender(snow_globe);
		registerRender(snow_globe_corrupt);
		registerRender(fireplace);
		registerRender(fireplace_active);
		registerRender(miniGolemSpawner);
		registerRender(dark_present);
		registerRender(snow_man_head);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(WintercraftReference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void registerRender(Block block, int meta)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(WintercraftReference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}

