package gruntpie224.wintercraft.init;

import java.util.ArrayList;

import gruntpie224.wintercraft.blocks.BlockBasic;
import gruntpie224.wintercraft.blocks.BlockFreezer;
import gruntpie224.wintercraft.blocks.BlockSnowSlab;
import gruntpie224.wintercraft.blocks.BlockSnowStairs;
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
	
	@GameRegistry.ObjectHolder("wc:snow_stairs")
	public static Block snow_stairs;
	
	@GameRegistry.ObjectHolder("wc:snow_slab_single")
	public static BlockSnowSlab snow_slab_single;
	
	@GameRegistry.ObjectHolder("wc:snow_slab_double")
	public static BlockSnowSlab snow_slab_double;
	
	@GameRegistry.ObjectHolder("wc:freezer")
	public static BlockFreezer freezer;
	
	@GameRegistry.ObjectHolder("wc:freezer_active")
	public static BlockFreezer freezer_active;
	
	public static void initBlocks()
	{
		iced_cobble = new BlockBasic("iced_cobble", Material.ROCK, SoundType.STONE).setHardness(2.0f).setResistance(10.0F);
		all_blocks.add(iced_cobble);
		
		iced_stone = new BlockBasic("iced_stone", Material.ROCK, SoundType.STONE).setHardness(1.5f).setResistance(10.0F);
		all_blocks.add(iced_stone);
		
		snow_bricks = new BlockBasic("snow_bricks", Material.ROCK, SoundType.SNOW).setHardness(1.5f).setResistance(8.0F);
		all_blocks.add(snow_bricks);
		
		snow_stairs = new BlockSnowStairs("snow_stairs", Blocks.SNOW.getBlockState().getBaseState());
		all_blocks.add(snow_stairs);
		
		snow_slab_single = new BlockSnowSlab.Half("snow_slab_single", Material.SNOW);
		//all_blocks.add(snow_slab_single);
		
		snow_slab_double = new BlockSnowSlab.Double("snow_slab_double", Material.SNOW);
		//all_blocks.add(snow_slab_double);
		
		freezer = new BlockFreezer("freezer", false);
		//all_blocks.add(freezer);
		
		freezer_active = new BlockFreezer("freezer_active", true);
		//all_blocks.add(freezer_active);
	}
	
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		for(Block block : all_blocks)
			event.getRegistry().register(block);
		
		event.getRegistry().register(snow_slab_single);
		event.getRegistry().register(snow_slab_double);
		event.getRegistry().register(freezer);
		event.getRegistry().register(freezer_active);
	}
	
	public static void registerBlockItems(RegistryEvent.Register<Item> event)
	{
		for(Block block : all_blocks)
			event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		
		event.getRegistry().register(new ItemSlab(snow_slab_single, snow_slab_single, snow_slab_double).setRegistryName(snow_slab_single.getRegistryName()));
		
		event.getRegistry().register(new ItemBlock(freezer).setRegistryName(freezer.getRegistryName()));
		event.getRegistry().register(new ItemBlock(freezer_active).setRegistryName(freezer_active.getRegistryName()));
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		for(Block block : all_blocks)
			try{
				((BlockBasic) block).initModel();
			} catch (Exception e){
				
			}
		
		((BlockSnowStairs)snow_stairs).initModel();
		registerRender(Item.getItemFromBlock(snow_slab_single));
		freezer.initModel();
		freezer_active.initModel();
	}
	
	public static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
}
