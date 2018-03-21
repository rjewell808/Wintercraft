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
	private static ArrayList<ItemBasic> all_items = new ArrayList<ItemBasic>();
	
	@GameRegistry.ObjectHolder("wc:ice_shard")
	public static ItemBasic ice_shard;
	
	public static void initItems()
	{
		ice_shard = new ItemBasic("ice_shard");
		all_items.add(ice_shard);
	}
	
	@SideOnly(Side.CLIENT)
	public static void initModels()
	{
		for(ItemBasic item : all_items)
			item.initModel();
	}
	
	public static void registerItems(RegistryEvent.Register<Item> event)
	{
		for(ItemBasic item : all_items)
			event.getRegistry().register(item);
	}
}
