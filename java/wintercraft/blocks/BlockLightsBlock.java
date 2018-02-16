package wintercraft.blocks;

import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import wintercraft.Wintercraft;
import wintercraft.helper.tileEntity.TileEntityAdventCal;
import wintercraft.helper.tileEntity.TileEntityLightsBlock;
import wintercraft.items.WinterItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLightsBlock extends BlockContainer{

	  String mobName;
	  @SideOnly(Side.CLIENT)
      private IIcon iconPresentTop;
	  @SideOnly(Side.CLIENT)
	  private IIcon iconPresentBottom;
	
	public BlockLightsBlock(Material par2Material) {
		super(par2Material);

	}
	
	@SideOnly(Side.CLIENT)
	private Icon iconGrassTop;
	@SideOnly(Side.CLIENT)
	private Icon iconGrassBottom;
	@SideOnly(Side.CLIENT)
	private static Icon iconGrassSideOverlay;
	
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (par1World.canLightningStrikeAt(par2, par3 + 1, par4) && !par1World.doesBlockHaveSolidTopSurface(par1World,par2, par3 - 1, par4) && par5Random.nextInt(15) == 1)
        {
            double d0 = (double)((float)par2 + par5Random.nextFloat());
            double d1 = (double)par3 - 0.05D;
            double d2 = (double)((float)par4 + par5Random.nextFloat());
            par1World.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
        }
    }
	
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5Entityplayer) {
		TileEntityLightsBlock tile = (TileEntityLightsBlock) par1World.getTileEntity(par2, par3, par4);
		
		Block leafBlock = Blocks.leaves;
        if (!par1World.isRemote){
        	par1World.setBlock(par2, par3, par4,Block.getBlockById(tile.leaf), tile.type, 2);
        	this.dropBlockAsItem(par1World, par2, par3, par4, 1, 0);
        }
	}
	
	
	
	public boolean onBlockActivated(World par3World, int par2, int par3, int par4, EntityPlayer par2EntityPlayer, int par6, float par7, float par8, float par9)
    {
		if(par2EntityPlayer.getHeldItem() == null){
			TileEntityLightsBlock tile = (TileEntityLightsBlock) par3World.getTileEntity(par2, par3, par4);
			
			Block leafBlock = Blocks.leaves;
	        
	        if (!par3World.isRemote && tile != null){
	        	par3World.setBlock(par2, par3, par4,Block.getBlockById(tile.leaf), tile.type, 2);
	        	this.dropBlockAsItem(par3World, par2, par3, par4, 1, 0);
	        }
	        return true;
		}
	return false;
    }
	public boolean isOpaqueCube()
    {
        return false;
    }
	
	public Item getItemDropped(int metadata, Random rand, int fortune){
    	return WinterItems.lights;
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
	this.iconPresentBottom = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5) + "_top");
	}
	
	public boolean isLeaves(IBlockAccess world, int x, int y, int z)
    {
        return getMaterial() == Material.leaves;
    }
	 
	 @SideOnly(Side.CLIENT)
	 public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
	 {
	     return WinterItems.lights;
	 }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityLightsBlock();
	}

}
