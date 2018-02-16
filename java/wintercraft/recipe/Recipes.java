
package wintercraft.recipe;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import wintercraft.blocks.WinterBlocks;
import wintercraft.items.WinterItems;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class Recipes {

	public static void Init(FMLInitializationEvent event){
	
		ItemStack redDye = new ItemStack(Items.dye, 1, 1);
		ItemStack greenDye = new ItemStack(Items.dye, 1, 2);
		ItemStack brownDye = new ItemStack(Items.dye, 1, 3);
		ItemStack blueDye = new ItemStack(Items.dye, 1, 4);
		ItemStack purpleDye = new ItemStack(Items.dye, 1, 5);
		ItemStack cyanDye = new ItemStack(Items.dye, 1, 6);
		ItemStack lightGrayDye = new ItemStack(Items.dye, 1, 7);
		ItemStack grayDye = new ItemStack(Items.dye, 1, 8);
		ItemStack pinkDye = new ItemStack(Items.dye, 1, 9);
		ItemStack limeDye = new ItemStack(Items.dye, 1, 10);
		ItemStack yellowDye = new ItemStack(Items.dye, 1, 11);
		ItemStack lightBlueDye = new ItemStack(Items.dye, 1, 12);
		ItemStack magentaDye = new ItemStack(Items.dye, 1, 13);
		ItemStack orangeDye = new ItemStack(Items.dye, 1, 14);
		ItemStack blackDye = new ItemStack(Items.dye, 1, 0);
		ItemStack whiteDye = new ItemStack(Items.dye,1,15);
		
		ItemStack iceGem = new ItemStack(WinterItems.iceGem, 1, 1);
		ItemStack corrIceGem = new ItemStack(WinterItems.iceGem, 1, 0);
		ItemStack vanIcecream = new ItemStack(WinterItems.commonItem, 1, 1);
		ItemStack chocIcecream = new ItemStack(WinterItems.commonItem, 1, 2);
		ItemStack strawIcecream = new ItemStack(WinterItems.commonItem, 1, 3);
		ItemStack cookieIcecream = new ItemStack(WinterItems.commonItem, 1, 4);
		ItemStack magmaIcecream = new ItemStack(WinterItems.commonItem, 1, 5);
		ItemStack cone = new ItemStack(WinterItems.commonItem, 1, 6);
		ItemStack fur = new ItemStack(WinterItems.commonItem, 1, 7);
		ItemStack redFur = new ItemStack(WinterItems.commonItem, 1, 8);
		ItemStack ironStick = new ItemStack(WinterItems.commonItem, 1, 9);
		
		
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.snowBrick, 4), new Object[] {"##", "##", '#', Blocks.snow});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.eggNog), new Object[] {Items.sugar, WinterItems.commonItem,Items.egg,Items.milk_bucket.setContainerItem(Items.bucket) });
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.rockySnowball), new Object[] {Items.snowball, Blocks.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.rockySnowball), new Object[] {Items.snowball, Blocks.gravel});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.coffeeMix), new Object[] {WinterItems.marshmellow,WinterItems.commonItem,brownDye,Items.milk_bucket.setContainerItem(Items.bucket) });
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.coffeeMix), new Object[] {WinterItems.marshmellow,WinterItems.commonItem,brownDye,Items.water_bucket.setContainerItem(Items.bucket) });
		GameRegistry.addShapelessRecipe(new ItemStack(WinterBlocks.fruitCakeBricks, 16), new Object[] {WinterItems.fruitCakeItem});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.vanillaIcecream), new Object[] {cone, vanIcecream});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.chocolateIcecream), new Object[] {cone, chocIcecream});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.strawberryIcecream), new Object[] {cone, strawIcecream});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.cookieIcecream), new Object[] {cone, cookieIcecream});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.magmaIcecream), new Object[] {cone, magmaIcecream});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.decorDoorItem), new Object[] {Items.wooden_door, WinterBlocks.wreath});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.commonItem, 1, 8), new Object[] {fur, redDye});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterBlocks.stockingFull), new Object[] {WinterBlocks.stocking, WinterItems.candyCane});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.candyCane, 2), new Object[] {WinterBlocks.candyCaneBlock});
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.iceSkates), new Object[]
				{
				" R ",
				" L ",
				"I I",
				 'L', Items.leather_boots, 'I', Items.iron_ingot, 'R', redDye
				});
		
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.fireplace,2), new Object[]
				{
				" ",
				"H",
				"W",
				 'W', Blocks.log, 'H', Blocks.hay_block
				});
		
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.fireplace,2), new Object[]
				{
				" ",
				"H",
				"W",
				 'W', Blocks.log2, 'H', Blocks.hay_block
				});
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.candyCaneAxe), new Object[]
               {
                 " CC",
                 " SC",
                 " S ",
                   'C', WinterItems.candyCane, 'S', Items.stick
                });
		
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.adventCalendar), new Object[]
               {
                 "CCC",
                 "CXC",
                 "CCC",
                   'X', WinterBlocks.calendar, 'C', WinterItems.candyCane
                });
		
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.calendar), new Object[]
               {
                 "PPP",
                 "PXP",
                 "PPP",
                   'X', Items.clock, 'P', Items.paper
                });
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.marshmellow), new Object[]
               {
                 "XXX",
                 "XXX",
                 "XXX",
                   'X', Items.sugar
                });
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.commonItem), new Object[]
	           {
	             "   ",
	             "X X",
	             "RXR",
	               'X', Items.clay_ball, 'R', redDye
	           });
		
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.star), new Object[]
	           {
			     "XEX",
				 "EEE",
	             "XEX",
	               'X', Blocks.glass, 'E', Items.glowstone_dust
	           });
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.iceGem), new Object[]
		           {
				     "XSX",
					 "RDR",
		             "XSX",
		               'X', WinterItems.iceBall, 'E', Items.glowstone_dust, 'D', Items.diamond, 'R', Items.redstone, 'S', WinterItems.iceShard
		           });
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.iceStaff), new Object[]
		           {
				     "  S",
					 " X ",
		             "X  ",
		               'X', Items.stick, 'S', iceGem
		           });
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.iceStaffBad), new Object[]
		           {
				     "  S",
					 " X ",
		             "X  ",
		               'X', Items.stick, 'S', corrIceGem
		           });
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.snowStairs, 4), new Object[]
		           {
				     "  X",
					 " XX",
		             "XXX",
		               'X', Blocks.snow
		           });
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.singleSnowSlab, 12), new Object[]
		           {
				     "   ",
					 "XXX",
		             "XXX",
		               'X', Blocks.snow
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.candleItem, 3), new Object[]
		           {
				     "CSC",
					 "XCX",
		             "XXX",
		               'X', Items.quartz, 'C', whiteDye,'S', Items.string
		           });
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.freezer), new Object[]
		           {
				     "XXX",
					 "XCX",
		             "XXX",
		               'X', WinterBlocks.winterIce, 'C', Blocks.furnace
		           });
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.freezer), new Object[]
		           {
				     "XXX",
					 "XCX",
		             "XXX",
		               'X', Blocks.ice, 'C', Blocks.furnace
		           });
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.wreath), new Object[]
		           {
				     "XSX",
					 "R R",
		             "XRX",
		               'X', Blocks.leaves, 'R', Blocks.red_flower, 'S', Items.string
		           });
		
		//Adds all 16 ornaments
		for(int i=0;i<16;i++){	
			ItemStack dye = redDye;
			
			switch(i){
				case 0: dye = redDye; break;
				case 1: dye = greenDye; break;
				case 2: dye = blueDye; break;
				case 3: dye = orangeDye; break;
				case 4: dye = blackDye; break;
				case 5: dye = brownDye; break;
				case 6: dye = purpleDye; break;
				case 7: dye = cyanDye; break;
				case 8: dye = lightGrayDye; break;
				case 9: dye = grayDye; break;
				case 10: dye = pinkDye; break;
				case 11: dye = limeDye; break;
				case 12: dye = yellowDye; break;
				case 13: dye = lightBlueDye; break;
				case 14: dye = magentaDye; break;
				case 15: dye = whiteDye; break;
				
			}
			
			GameRegistry.addRecipe(new ItemStack(WinterItems.Itemornament, 1, i), new Object[]
			           {
					     " X ",
						 "XDX",
			             " X ",
			               'X', Blocks.glass, 'D', dye
			           });
		}
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.lights, 3), new Object[]
		           {
				     "RGR",
					 "XXX",
		             "GDG",
		               'X', Items.string, 'D', greenDye, 'R', redDye, 'G', Items.glowstone_dust
		           });

		GameRegistry.addRecipe(new ItemStack(WinterItems.iceChunk), new Object[]
		           {
				     "XXX",
					 "XXX",
		             "XXX",
		               'X', WinterItems.iceShard
		           });
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.chisIceAxe), new Object[]
		           {
				     " XX",
					 " SX",
		             " S ",
		               'X', WinterBlocks.icedStone, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chisIceHoe), new Object[]
		           {
				     " XX",
					 " S ",
		             " S ",
		             'X', WinterBlocks.icedStone, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chisIcePickaxe), new Object[]
		           {
				     "XXX",
					 " S ",
		             " S ",
		             'X', WinterBlocks.icedStone, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chisIceShovel), new Object[]
		           {
				     "X",
					 "S",
		             "S",
		             'X', WinterBlocks.icedStone, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chisIceSword), new Object[]
		           {
				     "X",
					 "X",
		             "S",
		             'X', WinterBlocks.icedStone, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chisIceAxe), new Object[]
		           {
				     " XX",
					 " SX",
		             " S ",
		               'X', WinterBlocks.icedCobble, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chisIceHoe), new Object[]
		           {
				     " XX",
					 " S ",
		             " S ",
		             'X', WinterBlocks.icedCobble, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chisIcePickaxe), new Object[]
		           {
				     "XXX",
					 " S ",
		             " S ",
		             'X', WinterBlocks.icedCobble, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chisIceShovel), new Object[]
		           {
				     "X",
					 "S",
		             "S",
		             'X', WinterBlocks.icedCobble, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chisIceSword), new Object[]
		           {
				     "X",
					 "X",
		             "S",
		             'X', WinterBlocks.icedCobble, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.refIceAxe), new Object[]
		           {
				     " XX",
					 " SX",
		             " S ",
		               'X', WinterItems.iceIngot, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.refIceHoe), new Object[]
		           {
				     " XX",
					 " S ",
		             " S ",
		             'X', WinterItems.iceIngot, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.refIcePickaxe), new Object[]
		           {
				     "XXX",
					 " S ",
		             " S ",
		             'X', WinterItems.iceIngot, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.refIceShovel), new Object[]
		           {
				     "X",
					 "S",
		             "S",
		             'X', WinterItems.iceIngot, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.refIceSword), new Object[]
		           {
				     "X",
					 "X",
		             "S",
		             'X', WinterItems.iceIngot, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.refHelmet), new Object[]
		           {
				     "XXX",
					 "X X",
		             "   ",
		             'X', WinterItems.iceIngot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.refPlate), new Object[]
		           {
				     "X X",
					 "XXX",
		             "XXX",
		             'X', WinterItems.iceIngot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.refLegs), new Object[]
		           {
				     "XXX",
					 "X X",
		             "X X",
		             'X', WinterItems.iceIngot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.refBoots), new Object[]
		           {
				     "   ",
					 "X X",
		             "X X",
		             'X', WinterItems.iceIngot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.crystalAxe), new Object[]
		           {
				     " XX",
					 " SX",
		             " S ",
		               'X', WinterItems.iceCrystal, 'S', ironStick, 'I', WinterItems.iceIngot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.crystalHoe), new Object[]
		           {
				     " XX",
					 " S ",
		             " S ",
		             'X', WinterItems.iceCrystal, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.crystalPickaxe), new Object[]
		           {
				     "XXX",
					 " S ",
		             " S ",
		             'X', WinterItems.iceCrystal, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.crystalShovel), new Object[]
		           {
				     "X",
					 "S",
		             "S",
		             'X', WinterItems.iceCrystal, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.crystalSword), new Object[]
		           {
				     "X",
					 "X",
		             "S",
		             'X', WinterItems.iceCrystal, 'S', ironStick, 'I', WinterItems.iceIngot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.crystalHelmet), new Object[]
		           {
				     "XXX",
					 "X X",
		             "   ",
		             'X', WinterItems.iceCrystal
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.crystalPlate), new Object[]
		           {
				     "X X",
					 "XXX",
		             "XXX",
		             'X', WinterItems.iceCrystal
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.crystalLegs), new Object[]
		           {
				     "XXX",
					 "X X",
		             "X X",
		             'X', WinterItems.iceCrystal
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.crystalBoots), new Object[]
		           {
				     "   ",
					 "X X",
		             "X X",
		             'X', WinterItems.iceCrystal
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.santaHat), new Object[]
		           {
				     " F ",
					 " R ",
		             "FFF",
		             'F', fur, 'R', redFur
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.santaSuit), new Object[]
		           {
				     "F F",
					 "RFR",
		             "FRF",
		             'F', fur, 'R', redFur
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.santaPants), new Object[]
		           {
				     "RRR",
					 "R R" ,
		             "F F",
		             'F', fur, 'R', redFur
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.santaBoots), new Object[]
		           {
				     "   ",
					 "F F" ,
		             "R R",
		             'F', fur, 'R', redFur
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.commonItem, 1, 6), new Object[]
		           {
				     "WWW",
					 "SSS" ,
		             " S ",
		             'S', Items.sugar, 'W', Items.wheat
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.commonItem, 6, 9), new Object[]
		           {
				     "  S",
					 " S " ,
		             "S  ",
		             'S', Items.iron_ingot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.fruitCakeItem), new Object[]
	             {
	     			"MCM",
	     			"FEA",
	     			"KKK",
	     			'C',Items.sugar,'K',Items.wheat,'A',Items.apple, 'F', Items.melon, 'M', Items.milk_bucket.setContainerItem(Items.bucket), 'E', Items.egg
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterItems.christmasCookie), new Object[]
	             {
	     			"SGS",
	     			"GCG",
	     			"SGS",
	     			'C',Items.cookie,'G',WinterItems.gingerbreadMan,'S',Items.sugar
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.snowGlobeBlock), new Object[]
	             {
	     			"GGG",
	     			"GCG",
	     			"BBB",
	     			'C',iceGem,'G',Blocks.glass,'B', WinterBlocks.icedStone
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.corruptSnowGlobeBlock), new Object[]
	             {
	     			"GGG",
	     			"GCG",
	     			"BBB",
	     			'C',corrIceGem,'G',Blocks.glass,'B', WinterBlocks.icedStone
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.stocking,4), new Object[]
	             {
	     			" FF",
	     			" RR",
	     			"RRR",
	     			'R', redFur, 'F', fur
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.gift,3), new Object[]
	             {
	     			"XSX",
	     			"XCX",
	     			"XXX",
	     			'S', Items.string, 'X', Items.paper,'C',Blocks.chest
	             }); 
		
		GameRegistry.addRecipe(new ItemStack(Blocks.ice, 2), new Object[]
	             {
	     			"CCC",
	     			"CWC",
	     			"CCC",
	     			'C', WinterItems.iceChunk, 'W', Items.water_bucket.setContainerItem(Items.bucket)
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.snowManHead), new Object[]
	             {
	     			"CSC",
	     			"SRS",
	     			"CCC",
	     			'C', Items.coal,'R', Items.carrot, 'S', Blocks.snow
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterItems.magicSaddle), new Object[]
	             {
	     			" C ",
	     			"CSC",
	     			"   ",
	     			'C', iceGem, 'S', Items.saddle
	             }); 	
		
		GameRegistry.addSmelting(WinterItems.coffeeMix, new ItemStack(WinterItems.coffee, 1), 0.5F);
		GameRegistry.addSmelting(WinterBlocks.icedStone, new ItemStack(Blocks.stone, 1), 0.2F);
		GameRegistry.addSmelting(WinterItems.iceIngot, new ItemStack(Items.iron_ingot, 1), 0.2F);
		GameRegistry.addSmelting(WinterItems.iceCrystal, new ItemStack(Items.diamond, 1), 0.2F);
		GameRegistry.addSmelting(WinterItems.venisonRaw, new ItemStack(WinterItems.venisonCooked,1), 0.3F);
		GameRegistry.addSmelting(Item.getItemFromBlock(WinterBlocks.icedStone), new ItemStack(Blocks.stone,1), 0.2F);
		GameRegistry.addSmelting(Item.getItemFromBlock(WinterBlocks.icedCobble), new ItemStack(Blocks.cobblestone,1), 0.2F);
	}
	
}
