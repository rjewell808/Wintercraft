package gruntpie224.wintercraft.blocks;

import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.helper.WCSounds;
import gruntpie224.wintercraft.tileentity.TileEntityGift;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockGift extends BlockContainer{
	
	private String giftGiver = "This gift is empty.";
    private Item giftID;
    private int giftMeta;
    private int giftStack;
    private int testVar;
	
	public BlockGift(String name, Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
		this.setCreativeTab(Wintercraft.wcTab);
		this.setSoundType(SoundType.CLOTH);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
		TileEntityGift tile = (TileEntityGift) worldIn.getTileEntity(pos);
		
		if(!playerIn.world.isRemote && playerIn.isSneaking() == true){
			
			if(tile.stack == 0){
				playerIn.sendStatusMessage(new TextComponentString("This gift is empty"), true);
			}else
			if(tile.stack != 0){
				playerIn.sendStatusMessage(new TextComponentString(tile.giver), true);
			}
			
		}
	
		
		if(!playerIn.world.isRemote && playerIn.isSneaking() == false && playerIn.getHeldItemMainhand() != null && tile.stack == 0){
			
			tile.item = Item.getIdFromItem(playerIn.getHeldItemMainhand().getItem());
			tile.meta = playerIn.getHeldItemMainhand().getItemDamage();
			tile.stack = playerIn.getHeldItemMainhand().getCount();
			tile.giver = "Gift from: \u00a7d" + playerIn.getDisplayName().getUnformattedText();
			
			worldIn.playSound(null, pos, SoundEvents.ENTITY_CHICKEN_EGG, SoundCategory.BLOCKS,1F,1F);
			playerIn.getHeldItemMainhand().shrink(playerIn.getHeldItemMainhand().getCount());
			
		} else {
			
			if(!playerIn.world.isRemote && playerIn.isSneaking() == false && tile.item != 0){
				
				playerIn.sendStatusMessage(new TextComponentString("This Gift is full!"), true);
			}
			
		}
		
		return true;
	
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player)
	{
		worldIn.playSound(player, pos, WCSounds.snd_present_rip, SoundCategory.BLOCKS, 1F, 1F);
		TileEntityGift tile = (TileEntityGift) worldIn.getTileEntity(pos);
		
		if(!player.world.isRemote){
			player.sendStatusMessage(new TextComponentString(tile.giver), true);
		}
		tile.giver = "This gift is empty.";
		
		player.entityDropItem(new ItemStack(Item.getItemById(tile.item), tile.stack, tile.meta), 1);
		tile.item = 0;
		tile.meta = 0;
		tile.stack = 0;

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
	public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }
    
	@Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return true;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return true;
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityGift();
	}
}
