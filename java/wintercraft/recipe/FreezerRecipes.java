package wintercraft.recipe;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import wintercraft.blocks.WinterBlocks;
import wintercraft.items.WinterItems;

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
            return new ItemStack(WinterItems.commonItem, 4, 1);
        }
        
        //Chocolate Icecream
        if (i == WinterItems.commonItem && j == Items.dye && iM == 1 && jM == 3 || i == Items.dye && j == WinterItems.commonItem && iM == 3 && jM == 1)
        {	
            return new ItemStack(WinterItems.commonItem, 1, 2);
        }
        
        //Strawberry Icecream
        if (i == WinterItems.commonItem && j == Items.dye && iM == 1 && jM == 1 || i == Items.dye && j == WinterItems.commonItem && iM == 1 && jM == 1)
        {	
            return new ItemStack(WinterItems.commonItem, 1, 3);
        }
        
        //Cookie Icecream
        if (i == WinterItems.commonItem && j == Items.cookie && iM == 1 && jM == 0 || i == Items.cookie && j == WinterItems.commonItem && iM == 0 && jM == 1)
        {	
            return new ItemStack(WinterItems.commonItem, 1, 4);
        }
        
        //Magmacream Icecream
        if (i == WinterItems.commonItem && j == Items.magma_cream && iM == 1 && jM == 0 || i == Items.magma_cream && j == WinterItems.commonItem && iM == 0 && jM == 1)
        {	
            return new ItemStack(WinterItems.commonItem, 1, 5);
        }
        
        //Iceball
        if (i == WinterItems.rockySnowball && j == WinterItems.rockySnowball && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterItems.iceBall, 2, 0);
        }
        
        //Ice Gem
        if (i == WinterItems.iceGem && j == WinterItems.iceChunk && iM == 0 && jM == 0 || i == WinterItems.iceChunk && j == WinterItems.iceGem && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterItems.iceGem, 1, 1);
        }
        
        //Iced Stone
        if (i == Item.getItemFromBlock(Blocks.stone) && j == WinterItems.iceChunk && iM == 0 && jM == 0 || i == WinterItems.iceChunk && j == Item.getItemFromBlock(Blocks.stone) && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterBlocks.icedStone, 1, 0);
        }
        
        //Iced Cobblestone
        if (i == Item.getItemFromBlock(Blocks.cobblestone) && j == WinterItems.iceChunk && iM == 0 && jM == 0 || i == WinterItems.iceChunk && j == Item.getItemFromBlock(Blocks.stone) && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterBlocks.icedCobble, 1, 0);
        }
        
        //Iced Ingot
        if (i == Items.iron_ingot && j == WinterItems.iceChunk && iM == 0 && jM == 0 || i == WinterItems.iceChunk && j == Items.iron_ingot && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterItems.iceIngot, 1, 0);
        }
        
        //Iced Crystal
        if (i == Items.diamond && j == WinterItems.iceChunk && iM == 0 && jM == 0 || i == WinterItems.iceChunk && j == Items.diamond && iM == 0 && jM == 0)
        {	
            return new ItemStack(WinterItems.iceCrystal, 1, 0);
        }
        
		return null;
    }
    
}