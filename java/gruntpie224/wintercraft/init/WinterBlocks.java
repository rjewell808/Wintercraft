package gruntpie224.wintercraft.init;

import java.util.ArrayList;

import gruntpie224.wintercraft.blocks.BlockBasic;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WinterBlocks {
	private static ArrayList<BlockBasic> all_blocks = new ArrayList<BlockBasic>();
	
	@GameRegistry.ObjectHolder("wc:iced_cobble")
	public static BlockBasic iced_cobble;
	
	public static void initBlocks()
	{
		iced_cobble = new BlockBasic("iced_cobble", Material.ROCK);
		all_blocks.add(iced_cobble);
	}
	
	public static void registerBlocks(RegistryEvent.Register<Block> event)
	{
		for(BlockBasic block : all_blocks)
			event.getRegistry().register(block);
	}
	
	public static void registerBlockItems(RegistryEvent.Register<Item> event)
	{
		for(BlockBasic block : all_blocks)
			event.getRegistry().register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
		
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		for(BlockBasic block : all_blocks)
			block.initModel();
	}
}
