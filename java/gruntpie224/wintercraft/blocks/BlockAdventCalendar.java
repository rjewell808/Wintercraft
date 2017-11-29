package gruntpie224.wintercraft.blocks;

import java.util.Random;

import gruntpie224.wintercraft.BiomeControl;
import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.helper.tileEntity.TileEntityAdventCal;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAdventCalendar extends BlockCalendar implements ITileEntityProvider{

	public BlockAdventCalendar() {
		super();
		this.setCreativeTab(Wintercraft.wintercraftTab);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		TileEntityAdventCal tile = (TileEntityAdventCal) worldIn.getTileEntity(pos);
		
		if(!playerIn.worldObj.isRemote){
			int month = BiomeControl.month;
			int day = BiomeControl.day+1;
			int year = BiomeControl.year;
			int dayCount = 0;
			Random generator = new Random();
			Item[] gift = {WinterItems.gingerbread_man, WinterItems.cone_vanilla, WinterItems.cone_strawberry,
							WinterItems.marshmallow, WinterItems.cone_chocolate, WinterItems.cone_cookie,
							WinterItems.candy_cane, WinterItems.cone_magma};
			
			if(month == 11 && day > 25){
				playerIn.addChatMessage(new ChatComponentText("\u00a7rChristmas already happened this year ;("));
			}else
			if(month == 11 && day == 25){
				playerIn.addChatMessage(new ChatComponentText("\u00a7aToday is Christmas :D"));
			}
			else{
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
				if(tile.nextDay != dayCount)
				{
					playerIn.addChatMessage(new ChatComponentText("Day: \u00a7c\u00a7l" + dayCount + " - \u00a7r\u00a7oHere's a treat!"));
					playerIn.entityDropItem(new ItemStack(gift[generator.nextInt(8)],generator.nextInt(2)+1), 1);
				}else{
					playerIn.addChatMessage(new ChatComponentText("\u00a78You already recieved your treat!"));
				}
			}
			worldIn.playSoundAtEntity(playerIn, "wc:calendar", 1F, 1F);
			tile.nextDay = dayCount;
		}
		
		return true;
			
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileEntityAdventCal();
	}
    
    
}