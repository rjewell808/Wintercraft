package gruntpie224.wintercraft.init;

import java.util.ArrayList;

import gruntpie224.wintercraft.WintercraftReference;
import gruntpie224.wintercraft.blocks.BlockBasic;
import gruntpie224.wintercraft.blocks.BlockCandle;
import gruntpie224.wintercraft.blocks.BlockFreezer;
import gruntpie224.wintercraft.blocks.BlockFruitCake;
import gruntpie224.wintercraft.blocks.BlockOrnament;
import gruntpie224.wintercraft.blocks.BlockOrnamentRare;
import gruntpie224.wintercraft.blocks.BlockSnowSlabDouble;
import gruntpie224.wintercraft.blocks.BlockSnowSlabSingle;
import gruntpie224.wintercraft.blocks.BlockSnowStairs;
import gruntpie224.wintercraft.blocks.BlockStar;
import gruntpie224.wintercraft.items.ItemCandle;
import gruntpie224.wintercraft.items.ItemOrnamentRare;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WinterBlocks {
	private static ArrayList<Block> all_blocks = new ArrayList<Block>();
	
	@GameRegistry.ObjectHolder("wc:iced_cobble")
	public static Block iced_cobble;
	
	@GameRegistry.ObjectHolder("wc:iced_stone")
	public static Block iced_stone;
	
	@GameRegistry.ObjectHolder("wc:snow_bricks")
	public static Block snow_bricks;
	
	@GameRegistry.ObjectHolder("wc:fruit_cake_bricks")
	public static Block fruit_cake_bricks;
	
	@GameRegistry.ObjectHolder("wc:snow_stairs")
	public static Block snow_stairs;
	
	@GameRegistry.ObjectHolder("wc:snow_slab_single")
	public static BlockSnowSlabSingle snow_slab_single;
	
	@GameRegistry.ObjectHolder("wc:snow_slab_double")
	public static BlockSnowSlabDouble snow_slab_double;
	
	@GameRegistry.ObjectHolder("wc:freezer")
	public static Block freezer;
	
	@GameRegistry.ObjectHolder("wc:freezer_active")
	public static Block freezer_active;
	
	@GameRegistry.ObjectHolder("wc:fruit_cake")
	public static Block fruit_cake;
	
	@GameRegistry.ObjectHolder("wc:candle")
	public static Block candle;
	
	@GameRegistry.ObjectHolder("wc:star")
	public static Block star;
	
	@GameRegistry.ObjectHolder("wc:ornament")
	public static Block ornament;
	
	@GameRegistry.ObjectHolder("wc:ornament_rare")
	public static Block ornament_rare;
	
	public static void initBlocks()
	{
		iced_cobble = new BlockBasic("iced_cobble", Material.ROCK, SoundType.STONE).setHardness(2.0f).setResistance(10.0F);
		all_blocks.add(iced_cobble);
		
		iced_stone = new BlockBasic("iced_stone", Material.ROCK, SoundType.STONE).setHardness(1.5f).setResistance(10.0F);
		all_blocks.add(iced_stone);
		
		snow_bricks = new BlockBasic("snow_bricks", Material.ROCK, SoundType.SNOW).setHardness(1.5f).setResistance(8.0F);
		all_blocks.add(snow_bricks);
		
		fruit_cake_bricks = new BlockBasic("fruit_cake_bricks", Material.ROCK, SoundType.STONE).setHardness(1.5f).setResistance(10.0F);
		all_blocks.add(fruit_cake_bricks);
		
		snow_stairs = new BlockSnowStairs("snow_stairs", Blocks.SNOW.getBlockState().getBaseState());
		all_blocks.add(snow_stairs);
		
		snow_slab_single = new BlockSnowSlabSingle("snow_slab_single", Material.SNOW);
		
		snow_slab_double = new BlockSnowSlabDouble("snow_slab_double", Material.SNOW);
		
		freezer = new BlockFreezer("freezer", false).setHardness(2.5F);
		all_blocks.add(freezer);
		
		freezer_active = new BlockFreezer("freezer_active", true).setHardness(2.5F);
		all_blocks.add(freezer_active);
		
		fruit_cake = new BlockFruitCake("fruit_cake").setHardness(0.5F);
		all_blocks.add(fruit_cake);
		
		candle = new BlockCandle("candle").setHardness(0.4f);
		//all_blocks.add(candle);
		
		star = new BlockStar("star", Material.GLASS).setHardness(0.2f);
		
		ornament = new BlockOrnament("ornament").setHardness(0.3f);
		
		ornament_rare = new BlockOrnamentRare("ornament_rare").setHardness(0.3f);
	}
	
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		for(Block block : all_blocks)
			event.getRegistry().register(block);
		
		event.getRegistry().register(snow_slab_single);
		event.getRegistry().register(snow_slab_double);
		event.getRegistry().register(candle);
		event.getRegistry().register(star);
		event.getRegistry().register(ornament);
		event.getRegistry().register(ornament_rare);
		
	}
	
	public static void registerBlockItems(RegistryEvent.Register<Item> event)
	{
		for(Block block : all_blocks)
			event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		
		event.getRegistry().register(new ItemSlab(snow_slab_single, snow_slab_single, snow_slab_double).setRegistryName(snow_slab_single.getRegistryName()));
		event.getRegistry().register(new ItemCandle("candle", candle).setRegistryName(candle.getRegistryName()));
		event.getRegistry().register(new ItemCandle("ornament", ornament).setRegistryName(ornament.getRegistryName()));
		event.getRegistry().register(new ItemOrnamentRare("ornament_rare", ornament_rare).setRegistryName(ornament_rare.getRegistryName()));
		event.getRegistry().register(new ItemBlock(star).setRegistryName(star.getRegistryName()));
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		for(Block block : all_blocks)
			registerRender(Item.getItemFromBlock(block));
		
		registerRender(Item.getItemFromBlock(snow_slab_single));
		registerRender(Item.getItemFromBlock(snow_slab_double));
		registerRender(Item.getItemFromBlock(star));
		
		for(int i = 0; i < 16; i++)
		{
			registerRender(Item.getItemFromBlock(candle), i, "candle" + ItemCandle.names[i]);
			registerRender(Item.getItemFromBlock(ornament), i, "ornament" + ItemCandle.names[i]);
		}
		
		for(int i = 0; i < ItemOrnamentRare.names.length; i++)
		{
			registerRender(Item.getItemFromBlock(ornament_rare), i, "ornament_rare" + ItemOrnamentRare.names[i]);
		}
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	public static void registerRender(Item item, int meta, String name) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(WintercraftReference.MOD_ID + ":" + name, "inventory"));
	}
}
