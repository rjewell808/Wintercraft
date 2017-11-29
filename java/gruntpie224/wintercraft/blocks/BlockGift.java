package gruntpie224.wintercraft.blocks;

import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.helper.tileEntity.TileEntityGift;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGift extends BlockContainer{

	private String giftGiver = "This gift is empty.";
    Item giftID;
	int giftMeta;
	int giftStack;
	int testVar;
	
	public BlockGift(Material par2Material) {
		super(par2Material);
		this.setCreativeTab(Wintercraft.wintercraftTab);
	}

	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		TileEntityGift tile = (TileEntityGift) worldIn.getTileEntity(pos);
		
		if(!playerIn.worldObj.isRemote && playerIn.isSneaking() == true){
			
			if(tile.stack == 0){
				playerIn.addChatMessage(new ChatComponentText("This gift is empty."));
			}else
			if(tile.stack != 0){
				playerIn.addChatMessage(new ChatComponentText(tile.giver));
			}
			
		}
	
		
		if(!playerIn.worldObj.isRemote && playerIn.isSneaking() == false && playerIn.getCurrentEquippedItem() != null && tile.stack == 0){
			
			tile.item = Item.getIdFromItem(playerIn.getCurrentEquippedItem().getItem());
			tile.meta = playerIn.getCurrentEquippedItem().getItemDamage();
			tile.stack = playerIn.getCurrentEquippedItem().stackSize;
			tile.giver = "Gift from: \u00a7d" + playerIn.getDisplayName().getUnformattedText();
			
			worldIn.playSoundAtEntity(playerIn, "mob.chicken.plop",1F,1F);
			playerIn.getCurrentEquippedItem().stackSize -= playerIn.getCurrentEquippedItem().stackSize;
			
		} else {
			
			if(!playerIn.worldObj.isRemote && playerIn.isSneaking() == false && tile.item != 0){
				
				playerIn.addChatMessage(new ChatComponentText("This gift is full!"));
			}
			
		}
		
		return true;
	
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		worldIn.playSoundAtEntity(player, "wintercraft:rip", 1F, 1F);
		TileEntityGift tile = (TileEntityGift) worldIn.getTileEntity(pos);
		
		if(!player.worldObj.isRemote){
			player.addChatMessage(new ChatComponentText(tile.giver));
		}
		tile.giver = "This gift is empty.";
		
		player.entityDropItem(new ItemStack(Item.getItemById(tile.item), tile.stack, tile.meta), 1);
		tile.item = 0;
		tile.meta = 0;
		tile.stack = 0;
		
	
	}
	
	@Override
	public int getRenderType()
    {
        return 3;
    }
	
	@Override
	public boolean isOpaqueCube()
    {
        return true;
    }
	
	@Override
    public boolean isFullCube()
    {
        return true;
    }
	
	@Override
	public Item getItemDropped(IBlockState state, Random r, int fortune)
	{
		return null;
	}

	protected boolean canSilkHarvest()
    {
        return true;
    }


	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityGift();
	}

}
