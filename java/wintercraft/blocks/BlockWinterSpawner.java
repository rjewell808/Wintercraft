package wintercraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockMobSpawner;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import wintercraft.Wintercraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class BlockWinterSpawner extends BlockMobSpawner{

	    String mobName;
	    @SideOnly(Side.CLIENT)
		private IIcon iconPresentTop;
		@SideOnly(Side.CLIENT)
		private IIcon iconPresentBottom;
	    
	    public BlockWinterSpawner(String mobName) {
	            this.mobName = mobName;
	    }

	    @Override
	    public TileEntity createNewTileEntity(World world, int i) {
	        TileEntityMobSpawner spawner = new TileEntityMobSpawner();
	        spawner.func_145881_a().setEntityName(mobName);

	            return spawner;
	    }
	    
	String Name;

	public BlockWinterSpawner setTexture(String name){
	        Name = name;
	        return this;
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
	    
	    
	    @Override
	public int quantityDropped(Random par1Random) {
	    return 0;
	}
	    
	    @Override
	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7) {
	    super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);
	    int var8 = 15 + par1World.rand.nextInt(15) + par1World.rand.nextInt(15);
	    this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
	}
	    
	    @Override
	public boolean isOpaqueCube() {
	    return false;
	}
	    
  
	}