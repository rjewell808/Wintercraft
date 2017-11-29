package gruntpie224.wintercraft.recipe;

import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FreezerRecipes
{
	private float exp = 0.7f;
    public FreezerRecipes()
    {
    }

    public static ItemStack getSmeltingResult(Item i, Item j, int iM, int jM)
    {
        return getOutput(i, j, iM, jM);
    }

    private static ItemStack getOutput(Item i, Item j, int iM, int jM)
    {
        
        //Ice
        if (i == Items.water_bucket && j == Items.water_bucket && iM == 0 && jM == 0)
        {	
            return new ItemStack(Blocks.ice, 4, 0);
        }
        
        //Vanilla Icecream
        if (i == Items.milk_bucket && j == Items.sugar && iM == 0 && jM == 0 || i == Items.sugar && j == Items.milk_bucket && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterItems.common_items, 4, 1);
        }
        
        //Chocolate Icecream
        if (i == WinterItems.common_items && j == Items.dye && iM == 1 && jM == 3 || i == Items.dye && j == WinterItems.common_items && iM == 3 && jM == 1)
        {	
            return new ItemStack(WinterItems.common_items, 1, 2);
        }
        
        //Strawberry Icecream
        if (i == WinterItems.common_items && j == Items.dye && iM == 1 && jM == 1 || i == Items.dye && j == WinterItems.common_items && iM == 1 && jM == 1)
        {	
            return new ItemStack(WinterItems.common_items, 1, 3);
        }
        
        //Cookie Icecream
        if (i == WinterItems.common_items && j == Items.cookie && iM == 1 && jM == 0 || i == Items.cookie && j == WinterItems.common_items && iM == 0 && jM == 1)
        {	
            return new ItemStack(WinterItems.common_items, 1, 4);
        }
        
        //Magmacream Icecream
        if (i == WinterItems.common_items && j == Items.magma_cream && iM == 1 && jM == 0 || i == Items.magma_cream && j == WinterItems.common_items && iM == 0 && jM == 1)
        {	
            return new ItemStack(WinterItems.common_items, 1, 5);
        }
        
        //Iceball
        if (i == WinterItems.snowball_rock && j == WinterItems.snowball_rock && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterItems.snowball_ice, 2, 0);
        }
        
        //Ice Gem
        if (i == WinterItems.ice_gem && j == WinterItems.ice_chunk && iM == 0 && jM == 0 || i == WinterItems.ice_chunk && j == WinterItems.ice_gem && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterItems.ice_gem, 1, 1);
        }
        
        //Iced Stone
        if (i == Item.getItemFromBlock(Blocks.stone) && j == WinterItems.ice_chunk && iM == 0 && jM == 0 || i == WinterItems.ice_chunk && j == Item.getItemFromBlock(Blocks.stone) && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterBlocks.iced_stone, 1, 0);
        }
        
        //Iced Cobblestone
        if (i == Item.getItemFromBlock(Blocks.cobblestone) && j == WinterItems.ice_chunk && iM == 0 && jM == 0 || i == WinterItems.ice_chunk && j == Item.getItemFromBlock(Blocks.stone) && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterBlocks.iced_cobble, 1, 0);
        }
        
        //Iced Ingot
        if (i == Items.iron_ingot && j == WinterItems.ice_chunk && iM == 0 && jM == 0 || i == WinterItems.ice_chunk && j == Items.iron_ingot && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterItems.ice_ingot, 1, 0);
        }
        
        //Iced Crystal
        if (i == Items.diamond && j == WinterItems.ice_chunk && iM == 0 && jM == 0 || i == WinterItems.ice_chunk && j == Items.diamond && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterItems.ice_crystal, 1, 0);
        }
        
		return null;
    }
    
}