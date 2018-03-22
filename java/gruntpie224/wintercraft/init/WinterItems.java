package gruntpie224.wintercraft.init;

import java.util.ArrayList;

import gruntpie224.wintercraft.items.ItemBasic;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistryEntry;

public class WinterItems {
	private static ArrayList<Item> all_items = new ArrayList<Item>();
	
	@GameRegistry.ObjectHolder("wc:ice_shard")
	public static Item ice_shard;
	
	@GameRegistry.ObjectHolder("wc:ice_chunk")
	public static Item ice_chunk;
	
	@GameRegistry.ObjectHolder("wc:empty_mug")
	public static Item empty_mug;
	
	public static void initItems()
	{
		ice_shard = new ItemBasic("ice_shard");
		all_items.add(ice_shard);
		
		ice_chunk = new ItemBasic("ice_chunk");
		all_items.add(ice_chunk);
		
		empty_mug = new ItemBasic("empty_mug");
		all_items.add(empty_mug);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		for(Item item : all_items)
			((ItemBasic)item).initModel();
	}
	
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		for(Item item : all_items)
			event.getRegistry().register(item);
	}
}
