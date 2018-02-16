package wintercraft.helper;

import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import wintercraft.blocks.BlockStar;
import wintercraft.blocks.WinterBlocks;
import wintercraft.helper.achievements.WinterAch;
import wintercraft.items.WinterItems;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class PlayerTickHandler {	
	
	public static int[] starX = {888,888,888,888,888,888,888,888,888,888};
	public static int[] starY = {888,888,888,888,888,888,888,888,888,888};
	public static int[] starZ = {888,888,888,888,888,888,888,888,888,888};
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
		
		if(player.isPlayerSleeping()){
			Random generator = new Random();		
			//Gets sleepTimer from Player
			Object sleepTimer = ReflectionHelper.getPrivateValue(EntityPlayer.class, player, "sleepTimer", "field_71076_b");
			
			if(generator.nextInt(2) == 1 && sleepTimer.equals(66)){
				if(presentTimer == true){
					if(player.inventory.hasItem(WinterItems.coffee) && player.inventory.hasItem(WinterItems.christmasCookie)){
						int extraPresentCount = 0;
						
						if(WinterItems.santaArmour == true){
							extraPresentCount += 2;
						}
						if(month == 11 && day == 25){
							extraPresentCount += 6;
							player.addStat(WinterAch.christmas, 1);
							player.addChatMessage(new ChatComponentText("\u00a7aMerry \u00a7cChristmas!"));
						}
						
						if(!player.worldObj.isRemote){
							for(int i=0;i<starY.length;i++){
								if(starY[i] != 888){
									player.worldObj.setBlock(starX[i]-1, starY[i]-5,starZ[i], WinterBlocks.christmasPresent);
									player.worldObj.setBlock(starX[i]+1, starY[i]-5,starZ[i], WinterBlocks.christmasPresent);
									player.worldObj.setBlock(starX[i]-1, starY[i]-5,starZ[i]-1, WinterBlocks.present);
									player.worldObj.setBlock(starX[i]+1, starY[i]-5,starZ[i]-1, WinterBlocks.present);
									player.worldObj.setBlock(starX[i], starY[i]-5,starZ[i]+1, WinterBlocks.christmasPresent);
									player.worldObj.setBlock(starX[i], starY[i]-5,starZ[i]-1, WinterBlocks.christmasPresent);
									player.worldObj.setBlock(starX[i]-1, starY[i]-5,starZ[i]+1, WinterBlocks.present);
									player.worldObj.setBlock(starX[i]+1, starY[i]-5,starZ[i]+1, WinterBlocks.present);
									player.worldObj.playSoundAtEntity(player, "wintercraft:santa", 0.1F, 1.0F);
									player.addStat(WinterAch.santa, 1);
									player.inventory.addItemStackToInventory(new ItemStack(WinterBlocks.christmasPresent, extraPresentCount));
									player.inventory.addItemStackToInventory(new ItemStack(WinterBlocks.present, extraPresentCount));
									starX[i] = 888;
									starY[i] = 888;
									starZ[i] = 888;
									presentTimer = false;
								}
							}
							player.inventory.consumeInventoryItem(WinterItems.coffee);
							player.inventory.consumeInventoryItem(WinterItems.christmasCookie);
						}
						extraPresentCount = 0;
					}else
					if(FeatureConfig.winterTips && !player.worldObj.isRemote){
						if(player.inventory.hasItem(WinterItems.coffee)){
							player.addChatMessage(new ChatComponentText("\u00a77\u00a7o[Hint: " + "You still need a Christmas Cookie" + "]"));
						}else
						if(player.inventory.hasItem(WinterItems.christmasCookie)){
							player.addChatMessage(new ChatComponentText("\u00a77\u00a7o[Hint: " + "You still need a Hot Chocolate" + "]"));
						}else{
							player.addChatMessage(new ChatComponentText("\u00a77\u00a7o[Hint: " + "You still need a Hot Chocolate and a Christmas Cookie" + "]"));
						}
					}
				}else{
					if(FeatureConfig.winterTips && !player.worldObj.isRemote){
						if(player.inventory.hasItem(WinterItems.coffee) && player.inventory.hasItem(WinterItems.christmasCookie)){
							player.addChatMessage(new ChatComponentText("\u00a77\u00a7o[Hint: " + "Your Christmas tree isn't set up correctly" + "]"));
						}
					}
				}
			}
		}
	}
}
