package gruntpie224.wintercraft.blocks;

import java.util.Random;

import gruntpie224.wintercraft.BiomeControl;
import gruntpie224.wintercraft.init.WinterBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockCalendar extends BlockWallBlock{

	public BlockCalendar() 
	{
		super();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!playerIn.worldObj.isRemote)
		{
			int month = BiomeControl.month;
			int day = BiomeControl.day+1;
			int year = BiomeControl.year;
			int dayCount = 0;
			
			if(month == 11 && day > 25)
			{
				playerIn.addChatMessage(new ChatComponentText("\u00a7rChristmas already happened this year ;("));
			}else
			if(month == 11 && day == 25)
			{
				playerIn.addChatMessage(new ChatComponentText("\u00a7aToday is Christmas :D"));
			}
			else
			{
				for(int i=month;i<=11;i++){
					if(i == month){
						switch(i){
							case 9:
							case 7:
							case 6:
							case 4:
							case 2:
							case 0:
								dayCount += (31 - day);
								break;
							case 10:
							case 8:
							case 5:
							case 3:
								dayCount += (30 - day);
								break;
							case 1:
								if(year % 4 == 0){
									dayCount += (29 - day);
								}else{
									dayCount += (28 - day);
								}
								break;
							case 11: 
								dayCount += (25 - day);
								break;
						}
					}else{
						switch(i){
							case 9:
							case 7:
							case 6:
							case 4:
							case 2:
							case 0: 
								dayCount += 31;
								break;
							case 10:
							case 8:
							case 5:
							case 3: 
								dayCount += 30;
								break;
							case 1:
								if(year % 4 == 0){
									dayCount += 29;
								}else{
									dayCount += 28;
								}
								break;
							case 11:
								dayCount += 25;
								break;
						}
					}
				}
				
				playerIn.addChatMessage(new ChatComponentText("Only: \u00a7a\u00a7l" + dayCount + "\u00a7r day" + (dayCount > 1 ? "s" : "") + " 'til Christmas!"));
			}
			worldIn.playSoundAtEntity(playerIn, "wc:calendar", 1F, 1F);
		}
		
		return true;		
	}
 
}