package gruntpie224.wintercraft.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
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
	public Item getItemDropped(IBlockState state, Random r, int fortune)
	{
		return null;
	}
	
	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		Item[][] itemList = {{WinterItems.snowball_rock,Item.getItemFromBlock(WinterBlocks.iced_cobble),WinterItems.ornament_item,WinterItems.common_items,Item.getItemFromBlock(WinterBlocks.snow_stairs),WinterItems.ice_shard,WinterItems.common_items,WinterItems.common_items,Item.getItemFromBlock(WinterBlocks.iced_stone),WinterItems.marshmallow},
							 {WinterItems.ice_ingot,WinterItems.candy_cane,WinterItems.common_items,WinterItems.christmas_cookie,WinterItems.hot_choc,WinterItems.chis_ice_sword,WinterItems.chis_ice_shovel,WinterItems.chis_ice_pickaxe,WinterItems.chis_ice_hoe,WinterItems.chis_ice_axe},
							 {WinterItems.reindeer_saddle,WinterItems.ice_gem,WinterItems.candy_cane_sword,Item.getItemFromBlock(WinterBlocks.snow_globe),WinterItems.shard_sword,WinterItems.cry_sword,WinterItems.candy_cane_axe,WinterItems.cry_pickaxe,WinterItems.cry_sword,Item.getItemFromBlock(WinterBlocks.calendar_advent)}};
		
		int[][] metaList = {{0,0,0,7,0,0,0,6,0,0},
							{0,0,0,0,0,0,0,0,0,0},
							{0,1,0,0,0,0,0,0,0,0}};
		
		int tempValue = ((World)world).rand.nextInt(itemList[0].length);
		int rarity = ((World)world).rand.nextInt(101);
		
		if(rarity >= 0 && rarity <= 10)
		{
			rarity = 2;
		}
		
		else
		
		if(rarity > 10 && rarity <= 40)
		{
			rarity = 1;
		}
		
		else
		
		if(rarity > 40)
		{
			rarity = 0;
		}
		
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(itemList[rarity][tempValue], 1, tempValue == 2 && rarity == 0 ? ((World)world).rand.nextInt(16) : tempValue == 2 && rarity == 1 ? ((World)world).rand.nextInt(5)+1 : metaList[rarity][tempValue]));
		
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
