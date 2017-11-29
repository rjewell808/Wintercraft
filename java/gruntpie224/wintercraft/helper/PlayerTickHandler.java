package gruntpie224.wintercraft.helper;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Random;
import java.util.Stack;

import gruntpie224.wintercraft.helper.achievements.WinterAch;
import gruntpie224.wintercraft.helper.config.ConfigHandler;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

public class PlayerTickHandler {	
	
	//public static BlockPos[] starPos = new BlockPos[10];
	public static Stack<BlockPos> starPos = new Stack<BlockPos>();
	
	public static boolean presentTimer = false;
	int month = Calendar.getInstance().get(Calendar.MONTH);
	int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	Random generator = new Random();
	
	@SubscribeEvent
	public void playerTick(PlayerTickEvent event) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{	
		EntityPlayer player = event.player;
		
		if(this.presentTimer == true){
			player.addStat(WinterAch.star, 1);
		}
		
		if(player.isPlayerSleeping())
		{
			Random generator = new Random();		
			
			//Gets sleepTimer from Player
			Object sleepTimer = ReflectionHelper.getPrivateValue(EntityPlayer.class, player, "sleepTimer", "field_71076_b");
			
			if(generator.nextInt(2) == 1 && sleepTimer.equals(76))
			{
				if(presentTimer == true)
				{
					if(player.inventory.hasItem(WinterItems.hot_choc) && player.inventory.hasItem(WinterItems.christmas_cookie))
					{
						int extraPresentCount = 0;
						
						if(WinterItems.santa_armour == true)
						{
							extraPresentCount += 2;
						}
						
						if(month == 11 && day == 25)
						{
							extraPresentCount += 6;
							player.addStat(WinterAch.christmas, 1);
							player.addChatMessage(new ChatComponentText("\u00a7aMerry \u00a7cChristmas!"));
						}
						
						if(!player.worldObj.isRemote)
						{
							while(!starPos.isEmpty())
							{
								BlockPos star = starPos.pop();
								
								player.worldObj.setBlockState(new BlockPos(star.getX() - 1, star.getY()-5, star.getZ()), WinterBlocks.winter_present.getBlockState().getBaseState()); 
								player.worldObj.setBlockState(new BlockPos(star.getX() + 1, star.getY()-5, star.getZ()), WinterBlocks.winter_present.getBlockState().getBaseState()); 
								player.worldObj.setBlockState(new BlockPos(star.getX() - 1, star.getY()-5, star.getZ() - 1), WinterBlocks.present.getBlockState().getBaseState()); 
								player.worldObj.setBlockState(new BlockPos(star.getX() + 1, star.getY()-5, star.getZ() - 1), WinterBlocks.present.getBlockState().getBaseState()); 
								player.worldObj.setBlockState(new BlockPos(star.getX() - 1, star.getY()-5, star.getZ() + 1), WinterBlocks.present.getBlockState().getBaseState()); 
								player.worldObj.setBlockState(new BlockPos(star.getX() + 1, star.getY()-5, star.getZ() + 1), WinterBlocks.present.getBlockState().getBaseState()); 
								player.worldObj.setBlockState(new BlockPos(star.getX(), star.getY()-5, star.getZ() - 1), WinterBlocks.winter_present.getBlockState().getBaseState()); 
								player.worldObj.setBlockState(new BlockPos(star.getX(), star.getY()-5, star.getZ() + 1), WinterBlocks.winter_present.getBlockState().getBaseState()); 
								
								player.inventory.addItemStackToInventory(new ItemStack(WinterBlocks.winter_present, extraPresentCount));
								player.inventory.addItemStackToInventory(new ItemStack(WinterBlocks.present, extraPresentCount));
							}
							
							player.worldObj.playSoundAtEntity(player, "wc:santa", 0.1F, 1.0F);
							player.addStat(WinterAch.santa, 1);
							presentTimer = false;
							player.inventory.consumeInventoryItem(WinterItems.hot_choc);
							player.inventory.consumeInventoryItem(WinterItems.christmas_cookie);
						}
						extraPresentCount = 0;
					}else
					if(ConfigHandler.winterTips && !player.worldObj.isRemote){
						if(player.inventory.hasItem(WinterItems.hot_choc)){
							player.addChatMessage(new ChatComponentText("\u00a77\u00a7o[Hint: " + "You still need a Christmas Cookie" + "]"));
						}else
						if(player.inventory.hasItem(WinterItems.christmas_cookie)){
							player.addChatMessage(new ChatComponentText("\u00a77\u00a7o[Hint: " + "You still need a Hot Chocolate" + "]"));
						}else{
							player.addChatMessage(new ChatComponentText("\u00a77\u00a7o[Hint: " + "You still need a Hot Chocolate and a Christmas Cookie" + "]"));
						}
					}
				}else{
					if(ConfigHandler.winterTips && !player.worldObj.isRemote){
						if(player.inventory.hasItem(WinterItems.hot_choc) && player.inventory.hasItem(WinterItems.christmas_cookie)){
							player.addChatMessage(new ChatComponentText("\u00a77\u00a7o[Hint: " + "Your Christmas tree isn't set up correctly" + "]"));
						}
					}
				}
			}
		}
	}
}
