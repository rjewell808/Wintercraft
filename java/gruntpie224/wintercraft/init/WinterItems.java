package gruntpie224.wintercraft.init;

import java.util.ArrayList;

import gruntpie224.wintercraft.items.ItemBasic;
import gruntpie224.wintercraft.items.ItemFruitCake;
import net.minecraft.item.Item;
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
	
	public static void initItems()
	{
		ice_shard = new ItemBasic("ice_shard");
		all_items.add(ice_shard);
		
		ice_chunk = new ItemBasic("ice_chunk");
		all_items.add(ice_chunk);
		
		empty_mug = new ItemBasic("empty_mug");
		all_items.add(empty_mug);
		
		polarbear_fur = new ItemBasic("polarbear_fur");
		all_items.add(polarbear_fur);
		
		polarbear_fur_red = new ItemBasic("polarbear_fur_red");
		all_items.add(polarbear_fur_red);
		
		fruit_cake_item = new ItemFruitCake("fruit_cake_item", WinterBlocks.fruit_cake);
		all_items.add(fruit_cake_item);
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
