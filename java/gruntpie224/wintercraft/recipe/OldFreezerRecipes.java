package gruntpie224.wintercraft.recipe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class OldFreezerRecipes
{
private static final OldFreezerRecipes smeltingBase = new OldFreezerRecipes();
private HashMap<List<ItemStack>, ItemStack> metaSmeltingList = new HashMap<List<ItemStack>, ItemStack>();
private Map smeltingList = new HashMap();
private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();


/**
* Used to call methods addInscribing and getInscribingResult.
*/
public static final OldFreezerRecipes smelting() {
	return smeltingBase;
}


/**
* Adds all recipes to the HashMap
*/
private OldFreezerRecipes()
{
	//this.addSmelting(Arrays.asList(Item.sugar.itemID, 0, Item.bucketMilk.itemID, 0), new ItemStack(Items.commonItem.itemID, 4, 1), 0.3F);
	//this.addSmelting(Arrays.asList(Items.commonItem.itemID, 1, Item.dyePowder.itemID, 3), new ItemStack(Items.commonItem.itemID, 1, 2), 0.3F);
	this.addSmelting(Arrays.asList(new ItemStack(Items.water_bucket, 1, 0),new ItemStack(Items.water_bucket, 1, 0)), new ItemStack(Blocks.ice, 4, 0), 0.2F);
	//this.addSmelting(Arrays.asList(Items.commonItem.itemID, 1, Item.dyePowder.itemID, 1), new ItemStack(Items.commonItem.itemID, 1, 3), 0.3F);
	//this.addSmelting(Arrays.asList(Items.commonItem.itemID, 1, Item.cookie.itemID, 0), new ItemStack(Items.commonItem.itemID, 1, 4), 0.3F);
	//this.addSmelting(Arrays.asList(Items.commonItem.itemID, 1, Item.magmaCream.itemID, 0), new ItemStack(Items.commonItem.itemID, 1, 5), 0.3F);
	//this.addSmelting(Arrays.asList(Items.rockySnowball.itemID, 0, Items.rockySnowball.itemID, 0), new ItemStack(Items.iceBall.itemID, 2, 0), 0.2F);
	//this.addSmelting(Arrays.asList(Items.iceChunk.itemID, 0, Items.iceGem.itemID, 0), new ItemStack(Items.iceGem.itemID, 1, 1), 0.7F);
	//this.addSmelting(Arrays.asList(Items.iceChunk.itemID, 0, Block.stone.blockID, 0), new ItemStack(Blocks.icedStone.blockID, 1, 0), 0.4F);
	//this.addSmelting(Arrays.asList(Items.iceChunk.itemID, 0, Item.ingotIron.itemID, 0), new ItemStack(Items.iceIngot.itemID, 1, 0), 0.4F);
	//this.addSmelting(Arrays.asList(Items.iceChunk.itemID, 0, Item.diamond.itemID, 0), new ItemStack(Items.iceCrystal.itemID, 1, 0), 0.4F);
}

public void addSmelting(List<ItemStack> items, ItemStack out, float experience)
{
	smeltingList.put(items, out);
	metaExperience.put(Arrays.asList(Item.getIdFromItem(out.getItem()), out.getItemDamage()), experience);
}

/**
 * Used to get the resulting ItemStack form a source ItemStack
 * @param item The Source ItemStack
 * @return The result ItemStack
 */
public ItemStack getSmeltingResult(ItemStack item, ItemStack item2) 
{
        if (item==null||item2==null)
        {
                return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item, item.getItemDamage(), item2, item2.getItemDamage()));
        if (ret != null) 
        {
                return ret;
        }
        return (ItemStack)smeltingList.get(item);
}

/**
* Grabs the amount of base experience for this item to give when pulled from the furnace slot.
*/
public float getExperience(ItemStack item)
{
	if (item == null || item.getItem() == null)
	{
		return 0;
	}
	float ret = -1; // value returned by "item.getItem().getSmeltingExperience(item);" when item doesn't specify experience to give
	if (ret < 0 && metaExperience.containsKey(Arrays.asList(item, item.getItemDamage())))
	{
		ret = metaExperience.get(Arrays.asList(item, item.getItemDamage()));
	}

return (ret < 0 ? 0 : ret);
}

public Map<List<ItemStack>, ItemStack> getMetaInscribingList()
	{
		return metaSmeltingList;
	}
}