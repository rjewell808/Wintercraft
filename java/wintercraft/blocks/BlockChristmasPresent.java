package wintercraft.blocks;

import java.util.ArrayList;
import java.util.Random;

import wintercraft.items.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockChristmasPresent extends BlockPresent{

	
	public BlockChristmasPresent(Material par2Material) {	
		super(par2Material);
	}
	
	public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer) {
		par1World.playSoundAtEntity(par6EntityPlayer, "wintercraft:rip", 1F, 1F);
	}
	
	
	@Override
    public int quantityDropped(Random par1Random)
	{
		return 1;
    }
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune){
		return null;
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	{
		Item[][] itemList = {{WinterItems.rockySnowball,Item.getItemFromBlock(WinterBlocks.icedCobble),WinterItems.Itemornament,WinterItems.commonItem,Item.getItemFromBlock(WinterBlocks.snowStairs),WinterItems.iceShard,WinterItems.commonItem,WinterItems.commonItem,Item.getItemFromBlock(WinterBlocks.icedStone),WinterItems.marshmellow},
							 {WinterItems.iceIngot,WinterItems.candyCane,WinterItems.commonItem,WinterItems.christmasCookie,WinterItems.coffee,WinterItems.chisIceSword,WinterItems.chisIceShovel,WinterItems.chisIcePickaxe,WinterItems.chisIceHoe,WinterItems.chisIceAxe},
							 {WinterItems.magicSaddle,WinterItems.iceGem,WinterItems.candyCaneSword,Item.getItemFromBlock(WinterBlocks.snowGlobeBlock),WinterItems.iceShardSword,WinterItems.crystalSword,WinterItems.candyCaneAxe,WinterItems.crystalPickaxe,WinterItems.crystalSword,Item.getItemFromBlock(WinterBlocks.adventCalendar)}};
		
		int[][] metaList = {{0,0,0,7,0,0,0,6,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,1,0,0,0,0,0,0,0,0}};
		
		int tempValue = world.rand.nextInt(itemList[0].length);
		int rarity = world.rand.nextInt(101);
		
		if(rarity >= 0 && rarity <= 10){
			rarity = 2;
		}else
		if(rarity > 10 && rarity <= 40){
			rarity = 1;
		}else
		if(rarity > 40){
			rarity = 0;
		}
		
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(itemList[rarity][tempValue], 1, tempValue == 2 && rarity == 0 ? world.rand.nextInt(16) : tempValue == 2 && rarity == 1 ? world.rand.nextInt(5)+1 : metaList[rarity][tempValue]));
		return ret;
	}
	
	/*
	@Override
	 public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune)
	    {
	        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

	        int count = quantityDropped(metadata, fortune, world.rand);
	        
	        int luckDraw = 0;
	        Item idDropped = null;
	        int metaDropped = 0;
	        int randomItem = 0;
	        
	        for(int i = 0; i < count; i++)
	        {
	                // Gets a number between 0 and 4
	                luckDraw = world.rand.nextInt(100);
	                randomItem = world.rand.nextInt(9);
	                metaDropped = 0;
	                
	                // Choose what will be on the list
	                if (luckDraw <= 10 && luckDraw >= 0) { 
	                	if (randomItem == 9){
	                		idDropped= Item.getItemFromBlock(WinterBlocks.adventCalendar);
	            			metaDropped = 0;
	            		}
	            		else if (randomItem == 8){
	            			idDropped=WinterItems.crystalSword;
	            			 metaDropped = 0;
	            		}
	            		else if (randomItem == 7){
	            			idDropped= WinterItems.refIcePickaxe;
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 6){
	            			idDropped= WinterItems.candyCaneAxe;
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 5){
	            			idDropped= WinterItems.refIceSword;
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 4){
	            			idDropped= WinterItems.commonItem;
	            			metaDropped = 4;
	            			
	            		}
	            		else if (randomItem == 3){
	            			idDropped= WinterItems.commonItem;
	            			metaDropped = 5;
	            			
	            		}
	            		else if (randomItem == 2){
	            			idDropped= WinterItems.candyCaneSword;
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 1){
	            			idDropped= WinterItems.iceGem;
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 0){
	            			idDropped= WinterItems.magicSaddle;
	            			metaDropped = 0;
	            			
	            		} 
	                }
	                else if (luckDraw <= 40 && luckDraw >= 11) { 
	                	if (randomItem == 9){
	                		idDropped=WinterItems.chisIceAxe;
	                		metaDropped = 0;
	            		}
	            		else if (randomItem == 8){
	            			idDropped=WinterItems.chisIceHoe;
	            			 metaDropped = 0;
	            		}
	            		else if (randomItem == 7){
	            			idDropped= WinterItems.chisIcePickaxe;
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 6){
	            			idDropped= WinterItems.chisIceShovel;
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 5){
	            			idDropped= WinterItems.chisIceSword;
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 4){
	            			idDropped= WinterItems.commonItem;
	            			metaDropped = 1;
	            			
	            		}
	            		else if (randomItem == 3){
	            			idDropped= WinterItems.commonItem;
	            			metaDropped = 2;
	            			
	            		}
	            		else if (randomItem == 2){
	            			idDropped= WinterItems.commonItem;
	            			metaDropped = 3;
	            			
	            		}
	            		else if (randomItem == 1){
	            			idDropped= WinterItems.candyCane;
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 0){
	            			idDropped= WinterItems.iceIngot;
	            			metaDropped = 0;
	            			
	            		} 
	 
	                }
	                else if (luckDraw <= 99 && luckDraw >= 41) { 
	                	if (randomItem == 9){
	                		idDropped=WinterItems.marshmellow;
	                		metaDropped = 0;
	            		}
	            		else if (randomItem == 8){
	            			idDropped=Item.getItemFromBlock(Blocks.snow);
	            			 metaDropped = 0;
	            		}
	            		else if (randomItem == 7){
	            			idDropped= WinterItems.commonItem;
	            			metaDropped = 6;
	            			
	            		}
	            		else if (randomItem == 6){
	            			idDropped= WinterItems.commonItem;
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 5){
	            			idDropped= WinterItems.iceShard;
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 4){
	            			idDropped= Item.getItemFromBlock(WinterBlocks.snowStairs);
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 3){
	            			idDropped= WinterItems.commonItem;
	            			metaDropped = 7;
	            			
	            		}
	            		else if (randomItem == 2){
	            			idDropped= WinterItems.Itemornament;
	            			metaDropped = world.rand.nextInt(17);
	            			
	            		}
	            		else if (randomItem == 1){
	            			idDropped= Item.getItemFromBlock(WinterBlocks.icedCobble);
	            			metaDropped = 0;
	            			
	            		}
	            		else if (randomItem == 0){
	            			idDropped= WinterItems.rockySnowball;
	            			metaDropped = 0;
	            			
	            		}
	                        
	                }

	                // Adds the block to the return list
	                if (idDropped != null) {
	                        ret.add(new ItemStack(idDropped, 1, metaDropped));
	                }
	    }
	        return ret;
	    }
		*/
	 protected boolean canSilkHarvest()
	    {
	        return true;
	    }
}
