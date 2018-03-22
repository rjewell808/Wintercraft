package gruntpie224.wintercraft.init;

import java.util.ArrayList;

import gruntpie224.wintercraft.blocks.BlockBasic;
import gruntpie224.wintercraft.blocks.BlockSnowSlab;
import gruntpie224.wintercraft.blocks.BlockSnowSlabDouble;
import gruntpie224.wintercraft.blocks.BlockSnowStairs;
import gruntpie224.wintercraft.blocks.SlabBasic;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
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
	public static Block snow_slab_single;
	
	@GameRegistry.ObjectHolder("wc:snow_slab_double")
	public static Block snow_slab_double;
	
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
		
		snow_slab_single = new BlockSnowSlab("snow_slab_single");
		all_blocks.add(snow_slab_single);
		
		snow_slab_double = new BlockSnowSlabDouble("snow_slab_double");
		all_blocks.add(snow_slab_double);
	}
	
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		for(Block block : all_blocks)
			event.getRegistry().register(block);
	}
	
	public static void registerBlockItems(RegistryEvent.Register<Item> event)
	{
		for(Block block : all_blocks)
			event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		
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
		((SlabBasic)snow_slab_single).initModel();
		((SlabBasic)snow_slab_double).initModel();
	}
}
