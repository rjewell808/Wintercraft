package wintercraft.helper;

import java.util.Calendar;
import java.util.Random;

import wintercraft.Wintercraft;
import wintercraft.blocks.WinterBlocks;
import wintercraft.helper.achievements.WinterAch;
import wintercraft.items.WinterItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.terraingen.WorldTypeEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.WorldTickEvent;

public class ConnectionHandler {
	public static boolean userSpecial = false;

	@SubscribeEvent
	public void onServerJoin(PlayerEvent.PlayerLoggedInEvent event){
		
		String[] teamUsername = {"gruntpie224","XxlinexX","EpicEric33","darkster9757","dgerr123","vetleice","dogman1123","Dr_Mr_Boss"};
		String[] teamColor = {"\u00a72\u00a7l","\u00a75\u00a7l","\u00a75\u00a7l","\u00a75\u00a7l","\u00a75\u00a7l","\u00a75\u00a7l","\u00a75\u00a7l","\u00a75\u00a7l"};
		String[] teamTitle = {"Creator","Creator's Inspiration","Texture Artist","Texture Artist","Texture Artist","Idea Provider","Idea Provider","Texture Artist"};
		String[] betaMembers = {"itzz_danniexd","Wottler","tailousFTW","YuukiAkane","Lizzybeth04","DMSledge","pawprint1423","tanman12345","dmx6","Phoenix1024","Yoshi6601","Cachirulo_14","Mined17","Thunderwolf2200","minecrafterora9","Pureace2012","xZaynsPrincessx","kayla","Elliegirl9","Mnecraft368","nmaatx","sealand","th3doctor999","mopy234","Jonathan","g_larock","TheOrigsrc80","JollyPretsel","Jesse405","nvhgamer","007crafter49","Fletchan898","angusfox","JadeHunterKato","bcole4","Dr_Mr_Boss","tomskids","gruntpie224","XxlinexX","dogman1123","abrindles97","shamin99","SepyMondialu","notdd","QWERTYman2020","Stevie13185"};
		
		event.player.addChatMessage(new ChatComponentText("\u00a7n\u00a7lWintercraft Version:\u00a7r\u00a7b\u00a7o " + Wintercraft.version));
		event.player.addChatMessage(new ChatComponentText(""));
		
		for(int i=0;i<teamUsername.length;i++){
			if(teamUsername[i].equals(event.player.getDisplayName())){
				MinecraftServer.getServer().getConfigurationManager().sendChatMsg(new ChatComponentText("Welcome "+ teamTitle[i] + teamColor[i]+ " " + teamUsername[i] + " \u00a7rto the game!"));
				userSpecial = true;
				break;
			}else if(i == teamUsername.length-1 && !teamUsername[teamUsername.length-1].equals(event.player.getDisplayName())){
				event.player.addChatMessage(new ChatComponentText("Welcome " + event.player.getDisplayName() + " to Wintercraft!"));	
			}
		}
		
		if(userSpecial != true){
			for(int i=0;i<betaMembers.length;i++){
				if(betaMembers[i].equals(event.player.getDisplayName())){
					userSpecial = true;
				}
			}
		}
	}
}
