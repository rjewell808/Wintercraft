package wintercraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import wintercraft.Wintercraft;
import wintercraft.helper.tileEntity.TileEntityGift;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGift extends BlockContainer{

	private String giftGiver = "This gift is empty.";
    Item giftID;
	int giftMeta;
	int giftStack;
	int testVar;
	
	
	@SideOnly(Side.CLIENT)
	private IIcon iconPresentTop;
	@SideOnly(Side.CLIENT)
	private IIcon iconPresentBottom;
	
	public BlockGift(Material par2Material) {
		super(par2Material);
		this.setCreativeTab(Wintercraft.WintercraftTab);
	}

	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		TileEntityGift tile = (TileEntityGift) par1World.getTileEntity(par2, par3, par4);
		
		if(!par5EntityPlayer.worldObj.isRemote && par5EntityPlayer.isSneaking() == true){
			
			if(tile.stack == 0){
				par5EntityPlayer.addChatMessage(new ChatComponentText("This gift is empty."));
			}else
			if(tile.stack != 0){
				par5EntityPlayer.addChatMessage(new ChatComponentText(tile.giver));
			}
			
		}
	
		
		if(!par5EntityPlayer.worldObj.isRemote && par5EntityPlayer.isSneaking() == false && par5EntityPlayer.getCurrentEquippedItem() != null && tile.stack == 0){
			
			tile.item = Item.getIdFromItem(par5EntityPlayer.getCurrentEquippedItem().getItem());
			tile.meta = par5EntityPlayer.getCurrentEquippedItem().getItemDamage();
			tile.stack = par5EntityPlayer.getCurrentEquippedItem().stackSize;
			tile.giver = "Gift from: \u00a7d" + par5EntityPlayer.getDisplayName();
			
			par1World.playSoundAtEntity(par5EntityPlayer, "mob.chicken.plop",1F,1F);
			par5EntityPlayer.getCurrentEquippedItem().stackSize -= par5EntityPlayer.getCurrentEquippedItem().stackSize;
			
		} else {
			
			if(!par5EntityPlayer.worldObj.isRemote && par5EntityPlayer.isSneaking() == false && tile.item != 0){
				
				par5EntityPlayer.addChatMessage(new ChatComponentText("This gift is full!"));
			}
			
		}
		
		return true;
	
	}

	
	public void onBlockHarvested(World par1World, int par2, int par3, int par4, int par5, EntityPlayer par6EntityPlayer) {
		par1World.playSoundAtEntity(par6EntityPlayer, "wintercraft:rip", 1F, 1F);
		TileEntityGift tile = (TileEntityGift) par1World.getTileEntity(par2, par3, par4);
		
		if(!par6EntityPlayer.worldObj.isRemote){
			par6EntityPlayer.addChatMessage(new ChatComponentText(tile.giver));
		}
		tile.giver = "This gift is empty.";
		
		par6EntityPlayer.entityDropItem(new ItemStack(Item.getItemById(tile.item), tile.stack, tile.meta), 1);
		tile.item = 0;
		tile.meta = 0;
		tile.stack = 0;
		
	
	}
	
	@Override
	public Item getItemDropped(int metadata, Random r, int fortune){
		return null;
	}

	@SideOnly(Side.CLIENT)

	/**
	* From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
	*/
	public IIcon getIcon(int par1, int par2)
	{
	return par1 == 1 ? this.iconPresentTop : (par1 == 0 ? this.iconPresentBottom : this.blockIcon);
	}
	
	public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
	{
	if (par5 == 1)
	{
	return this.iconPresentTop;
	}
	else if (par5 == 0)
	{
	return this.iconPresentBottom;
	}
	else
	{

	return this.blockIcon;
	}
	}

	@SideOnly(Side.CLIENT)

	/**
	* When this method is called, your block should register all the icons it needs with the given IconRegister. This
	* is the only chance you get to register icons.
	*/
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
	  
	//Trying Something making it easier to make dirt blocks
	this.blockIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_side");
	this.iconPresentTop = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_top");
	this.iconPresentBottom = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_side");
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
