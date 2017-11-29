package gruntpie224.wintercraft.recipe;

import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipes {

	public static void Init(){
	
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
		
		ItemStack iceGem = new ItemStack(WinterItems.ice_gem, 1, 1);
		ItemStack corrIceGem = new ItemStack(WinterItems.ice_gem, 1, 0);
		ItemStack vanIcecream = new ItemStack(WinterItems.common_items, 1, 1);
		ItemStack chocIcecream = new ItemStack(WinterItems.common_items, 1, 2);
		ItemStack strawIcecream = new ItemStack(WinterItems.common_items, 1, 3);
		ItemStack cookieIcecream = new ItemStack(WinterItems.common_items, 1, 4);
		ItemStack magmaIcecream = new ItemStack(WinterItems.common_items, 1, 5);
		ItemStack cone = new ItemStack(WinterItems.common_items, 1, 6);
		ItemStack fur = new ItemStack(WinterItems.common_items, 1, 7);
		ItemStack redFur = new ItemStack(WinterItems.common_items, 1, 8);
		ItemStack ironStick = new ItemStack(WinterItems.common_items, 1, 9);
		
		
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.snow_bricks, 4), new Object[] {"##", "##", '#', Blocks.snow});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.egg_nog), new Object[] {Items.sugar, WinterItems.common_items,Items.egg,Items.milk_bucket.setContainerItem(Items.bucket) });
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.snowball_rock), new Object[] {Items.snowball, Blocks.cobblestone});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.snowball_rock), new Object[] {Items.snowball, Blocks.gravel});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.choc_milk), new Object[] {WinterItems.marshmallow,WinterItems.common_items,brownDye,Items.milk_bucket.setContainerItem(Items.bucket) });
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.choc_milk), new Object[] {WinterItems.marshmallow,WinterItems.common_items,brownDye,Items.water_bucket.setContainerItem(Items.bucket) });
		GameRegistry.addShapelessRecipe(new ItemStack(WinterBlocks.fruit_bricks, 16), new Object[] {WinterItems.fruit_cake_item});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.cone_vanilla), new Object[] {cone, vanIcecream});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.cone_chocolate), new Object[] {cone, chocIcecream});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.cone_strawberry), new Object[] {cone, strawIcecream});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.cone_cookie), new Object[] {cone, cookieIcecream});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.cone_magma), new Object[] {cone, magmaIcecream});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.decor_door_item), new Object[] {Items.oak_door, WinterBlocks.wreath});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.common_items, 1, 8), new Object[] {fur, redDye});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterBlocks.stocking_full), new Object[] {WinterBlocks.stocking, WinterItems.candy_cane});
		GameRegistry.addShapelessRecipe(new ItemStack(WinterItems.candy_cane, 2), new Object[] {WinterBlocks.candy_cane_block});
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.ice_skates), new Object[]
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
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.candy_cane_axe), new Object[]
               {
                 " CC",
                 " SC",
                 " S ",
                   'C', WinterItems.candy_cane, 'S', Items.stick
                });
		
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.calendar_advent), new Object[]
               {
                 "CCC",
                 "CXC",
                 "CCC",
                   'X', WinterBlocks.calendar, 'C', WinterItems.candy_cane
                });
		
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.calendar), new Object[]
               {
                 "PPP",
                 "PXP",
                 "PPP",
                   'X', Items.clock, 'P', Items.paper
                });
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.marshmallow), new Object[]
               {
                 "XXX",
                 "XXX",
                 "XXX",
                   'X', Items.sugar
                });
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.common_items), new Object[]
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
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.ice_gem), new Object[]
		           {
				     "XSX",
					 "RDR",
		             "XSX",
		               'X', WinterItems.snowball_ice, 'E', Items.glowstone_dust, 'D', Items.diamond, 'R', Items.redstone, 'S', WinterItems.ice_shard
		           });
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.ice_staff), new Object[]
		           {
				     "  S",
					 " X ",
		             "X  ",
		               'X', Items.stick, 'S', iceGem
		           });
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.ice_staff_corrupt), new Object[]
		           {
				     "  S",
					 " X ",
		             "X  ",
		               'X', Items.stick, 'S', corrIceGem
		           });
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.snow_stairs, 4), new Object[]
		           {
				     "  X",
					 " XX",
		             "XXX",
		               'X', Blocks.snow
		           });
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.snow_slab_single, 12), new Object[]
		           {
				     "   ",
					 "XXX",
		             "XXX",
		               'X', Blocks.snow
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
				case 0: dye = whiteDye; break;
				case 1: dye = orangeDye; break;
				case 2: dye = magentaDye; break;
				case 3: dye = lightBlueDye; break;
				case 4: dye = yellowDye; break;
				case 5: dye = limeDye; break;
				case 6: dye = pinkDye; break;
				case 7: dye = grayDye; break;
				case 8: dye = lightGrayDye; break;
				case 9: dye = cyanDye; break;
				case 10: dye = purpleDye; break;
				case 11: dye = blueDye; break;
				case 12: dye = brownDye; break;
				case 13: dye = greenDye; break;
				case 14: dye = redDye; break;
				case 15: dye = blackDye; break;
				
			}
			
			GameRegistry.addRecipe(new ItemStack(WinterItems.ornament_item, 1, i), new Object[]
			           {
					     " X ",
						 "XDX",
			             " X ",
			               'X', Blocks.glass, 'D', dye
			           });
			
			GameRegistry.addRecipe(new ItemStack(WinterItems.candle_item, 3, i), new Object[]
			           {
					     "CSC",
						 "XCX",
			             "XXX",
			               'X', Items.quartz, 'C', dye,'S', Items.string
			           });
		}
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.lights, 3), new Object[]
		           {
				     "RGR",
					 "XXX",
		             "GDG",
		               'X', Items.string, 'D', greenDye, 'R', redDye, 'G', Items.glowstone_dust
		           });

		GameRegistry.addRecipe(new ItemStack(WinterItems.ice_chunk), new Object[]
		           {
				     "XXX",
					 "XXX",
		             "XXX",
		               'X', WinterItems.ice_shard
		           });
		
		GameRegistry.addRecipe(new ItemStack(WinterItems.chis_ice_axe), new Object[]
		           {
				     " XX",
					 " SX",
		             " S ",
		               'X', WinterBlocks.iced_stone, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chis_ice_hoe), new Object[]
		           {
				     " XX",
					 " S ",
		             " S ",
		             'X', WinterBlocks.iced_stone, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chis_ice_pickaxe), new Object[]
		           {
				     "XXX",
					 " S ",
		             " S ",
		             'X', WinterBlocks.iced_stone, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chis_ice_shovel), new Object[]
		           {
				     "X",
					 "S",
		             "S",
		             'X', WinterBlocks.iced_stone, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chis_ice_sword), new Object[]
		           {
				     "X",
					 "X",
		             "S",
		             'X', WinterBlocks.iced_stone, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chis_ice_axe), new Object[]
		           {
				     " XX",
					 " SX",
		             " S ",
		               'X', WinterBlocks.iced_cobble, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chis_ice_hoe), new Object[]
		           {
				     " XX",
					 " S ",
		             " S ",
		             'X', WinterBlocks.iced_cobble, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chis_ice_pickaxe), new Object[]
		           {
				     "XXX",
					 " S ",
		             " S ",
		             'X', WinterBlocks.iced_cobble, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chis_ice_shovel), new Object[]
		           {
				     "X",
					 "S",
		             "S",
		             'X', WinterBlocks.iced_cobble, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.chis_ice_sword), new Object[]
		           {
				     "X",
					 "X",
		             "S",
		             'X', WinterBlocks.iced_cobble, 'S', Items.stick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.ref_ice_axe), new Object[]
		           {
				     " XX",
					 " SX",
		             " S ",
		               'X', WinterItems.ice_ingot, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.ref_ice_hoe), new Object[]
		           {
				     " XX",
					 " S ",
		             " S ",
		             'X', WinterItems.ice_ingot, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.ref_ice_pickaxe), new Object[]
		           {
				     "XXX",
					 " S ",
		             " S ",
		             'X', WinterItems.ice_ingot, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.ref_ice_shovel), new Object[]
		           {
				     "X",
					 "S",
		             "S",
		             'X', WinterItems.ice_ingot, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.ref_ice_sword), new Object[]
		           {
				     "X",
					 "X",
		             "S",
		             'X', WinterItems.ice_ingot, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.ref_helmet), new Object[]
		           {
				     "XXX",
					 "X X",
		             "   ",
		             'X', WinterItems.ice_ingot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.ref_plate), new Object[]
		           {
				     "X X",
					 "XXX",
		             "XXX",
		             'X', WinterItems.ice_ingot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.ref_legs), new Object[]
		           {
				     "XXX",
					 "X X",
		             "X X",
		             'X', WinterItems.ice_ingot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.ref_boots), new Object[]
		           {
				     "   ",
					 "X X",
		             "X X",
		             'X', WinterItems.ice_ingot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.cry_axe), new Object[]
		           {
				     " XX",
					 " SX",
		             " S ",
		               'X', WinterItems.ice_crystal, 'S', ironStick, 'I', WinterItems.ice_ingot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.cry_hoe), new Object[]
		           {
				     " XX",
					 " S ",
		             " S ",
		             'X', WinterItems.ice_crystal, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.cry_pickaxe), new Object[]
		           {
				     "XXX",
					 " S ",
		             " S ",
		             'X', WinterItems.ice_crystal, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.cry_shovel), new Object[]
		           {
				     "X",
					 "S",
		             "S",
		             'X', WinterItems.ice_crystal, 'S', ironStick
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.cry_sword), new Object[]
		           {
				     "X",
					 "X",
		             "S",
		             'X', WinterItems.ice_crystal, 'S', ironStick, 'I', WinterItems.ice_ingot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.cry_helmet), new Object[]
		           {
				     "XXX",
					 "X X",
		             "   ",
		             'X', WinterItems.ice_crystal
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.cry_plate), new Object[]
		           {
				     "X X",
					 "XXX",
		             "XXX",
		             'X', WinterItems.ice_crystal
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.cry_legs), new Object[]
		           {
				     "XXX",
					 "X X",
		             "X X",
		             'X', WinterItems.ice_crystal
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.cry_boots), new Object[]
		           {
				     "   ",
					 "X X",
		             "X X",
		             'X', WinterItems.ice_crystal
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.santa_helmet), new Object[]
		           {
				     " F ",
					 " R ",
		             "FFF",
		             'F', fur, 'R', redFur
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.santa_plate), new Object[]
		           {
				     "F F",
					 "RFR",
		             "FRF",
		             'F', fur, 'R', redFur
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.santa_legs), new Object[]
		           {
				     "RRR",
					 "R R" ,
		             "F F",
		             'F', fur, 'R', redFur
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.santa_boots), new Object[]
		           {
				     "   ",
					 "F F" ,
		             "R R",
		             'F', fur, 'R', redFur
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.common_items, 1, 6), new Object[]
		           {
				     "WWW",
					 "SSS" ,
		             " S ",
		             'S', Items.sugar, 'W', Items.wheat
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.common_items, 6, 9), new Object[]
		           {
				     "  S",
					 " S " ,
		             "S  ",
		             'S', Items.iron_ingot
		           });
		GameRegistry.addRecipe(new ItemStack(WinterItems.fruit_cake_item), new Object[]
	             {
	     			"MCM",
	     			"FEA",
	     			"KKK",
	     			'C',Items.sugar,'K',Items.wheat,'A',Items.apple, 'F', Items.melon, 'M', Items.milk_bucket.setContainerItem(Items.bucket), 'E', Items.egg
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterItems.christmas_cookie), new Object[]
	             {
	     			"SGS",
	     			"GCG",
	     			"SGS",
	     			'C',Items.cookie,'G',WinterItems.gingerbread_man,'S',Items.sugar
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.snow_globe), new Object[]
	             {
	     			"GGG",
	     			"GCG",
	     			"BBB",
	     			'C',iceGem,'G',Blocks.glass,'B', WinterBlocks.iced_stone
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.snow_globe_corrupt), new Object[]
	             {
	     			"GGG",
	     			"GCG",
	     			"BBB",
	     			'C',corrIceGem,'G',Blocks.glass,'B', WinterBlocks.iced_stone
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
	     			'C', WinterItems.ice_chunk, 'W', Items.water_bucket.setContainerItem(Items.bucket)
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterBlocks.snow_man_head), new Object[]
	             {
	     			"CSC",
	     			"SRS",
	     			"CCC",
	     			'C', Items.coal,'R', Items.carrot, 'S', Blocks.snow
	             }); 
		GameRegistry.addRecipe(new ItemStack(WinterItems.reindeer_saddle), new Object[]
	             {
	     			" C ",
	     			"CSC",
	     			"   ",
	     			'C', iceGem, 'S', Items.saddle
	             }); 	
		
		GameRegistry.addSmelting(WinterItems.choc_milk, new ItemStack(WinterItems.hot_choc, 1), 0.5F);
		GameRegistry.addSmelting(WinterBlocks.iced_stone, new ItemStack(Blocks.stone, 1), 0.2F);
		GameRegistry.addSmelting(WinterItems.ice_ingot, new ItemStack(Items.iron_ingot, 1), 0.2F);
		GameRegistry.addSmelting(WinterItems.ice_crystal, new ItemStack(Items.diamond, 1), 0.2F);
		GameRegistry.addSmelting(WinterItems.venison_raw, new ItemStack(WinterItems.venison_cooked,1), 0.3F);
		GameRegistry.addSmelting(Item.getItemFromBlock(WinterBlocks.iced_stone), new ItemStack(Blocks.stone,1), 0.2F);
		GameRegistry.addSmelting(Item.getItemFromBlock(WinterBlocks.iced_cobble), new ItemStack(Blocks.cobblestone,1), 0.2F);
	}
	
}
