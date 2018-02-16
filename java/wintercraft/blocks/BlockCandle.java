package wintercraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import wintercraft.Wintercraft;
import wintercraft.helper.tileEntity.TileEntityGift;
import wintercraft.items.WinterItems;
import wintercraft.render.tileEntity.TileEntityCandle;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCandle extends BlockContainer {
	
	public BlockCandle(int texture, Material material) {
		super(material);
		float f = 0.2F;
		this.setBlockBounds(0.6F - f, 0.0F, 0.6F - f, 0.4F + f, f * 2.0F, 0.4F + f);
		this.setLightLevel(0.7F);
	}
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
	      this.icons = new IIcon[16];
	     
	      for(int i = 0; i < icons.length; i++)
	      {
	             this.icons[i] = par1IconRegister.registerIcon(Wintercraft.modid + ":" + (this.getUnlocalizedName().substring(5)) + i);
	      }
	}
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2)
	{
	      return icons[par2];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	     for (int var4 = 0; var4 < 16; ++var4)
	     {
	         par3List.add(new ItemStack(par1, 1, var4));
	     }
	}
	
	public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
	{
		int rotation = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 2.5D) & 3;
		world.setBlock(i, j, k, WinterSpecialBlocks.candle, rotation - 1, rotation - 1);
	}
	
	/**
	* The type of render function that is called for this block
	*/
	public int getRenderType()
	{
	return -2;
	}
	
	/**
	* Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
	* adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	*/
	public boolean isOpaqueCube()
	{
	return false;
	}
	
	/**
	 * 
	* If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	*/
	public boolean renderAsNormalBlock()
	{
	return false;
	}
	     
	ItemStack redDye = new ItemStack(Items.dye, 1, 1);
	ItemStack greenDye = new ItemStack(Items.dye, 1, 2);
	ItemStack brownDye = new ItemStack(Items.dye, 1, 3);
	ItemStack blueDye = new ItemStack(Items.dye, 1, 4);
	ItemStack purpleDye = new ItemStack(Items.dye, 1, 5);
	ItemStack cyanDye = new ItemStack(Items.dye, 1, 6);
	ItemStack lightGrayDye = new ItemStack(Items.dye, 1, 7);
	ItemStack grayDye = new ItemStack(Items.dye, 1, 8);
	ItemStack pinkDye = new ItemStack(Items.dye, 1, 9);
	ItemStack limeDye = new ItemStack(Items.dye, 1, 10);
	ItemStack yellowDye = new ItemStack(Items.dye, 1, 11);
	ItemStack lightBlueDye = new ItemStack(Items.dye, 1, 12);
	ItemStack magentaDye = new ItemStack(Items.dye, 1, 13);
	ItemStack orangeDye = new ItemStack(Items.dye, 1, 14);
	ItemStack blackDye = new ItemStack(Items.dye, 1, 0);
	ItemStack normalDye = new ItemStack(Items.dye);
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		int blockMeta = par1World.getBlockMetadata(par2, par3, par4);
		
		if(par5EntityPlayer.getCurrentEquippedItem() != null){
			if(blockMeta == 0 && par5EntityPlayer.getCurrentEquippedItem().getItem() == Items.dye){
				if(par5EntityPlayer.getCurrentEquippedItem().getItemDamage() != 15){
					if(par5EntityPlayer.getCurrentEquippedItem().getItemDamage() == 0){
						par1World.setBlockMetadataWithNotify(par2, par3, par4, 15, 2);
					}else{
						par1World.setBlockMetadataWithNotify(par2, par3, par4, par5EntityPlayer.getCurrentEquippedItem().getItemDamage(), 2);
					}
					par5EntityPlayer.getCurrentEquippedItem().stackSize--;
				}
			}
		}
	
		
	    return false;
	}
	
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
	{
		
		 double d0 = (double)par2 + 0.5D;
	        double d1 = (double)par3 + 0.3D;
	        double d2 = (double)par4 + 0.325D;
	        double d3 = 0.2199999988079071D;
	        double d4 = 0.17000001072883606D;
	    super.randomDisplayTick(par1World, par2, par3, par4, par5Random);
	
	    for (int l = par2 - 2; l <= par2 + 2; ++l)
	    {
	        for (int i1 = par4 - 2; i1 <= par4 + 2; ++i1)
	        {
	            if (l > par2 - 2 && l < par2 + 2 && i1 == par4 - 1)
	            {
	                i1 = par4 + 2;
	            }
	
	            if (par5Random.nextInt(5) == 0)
	            {
	                for (int j1 = par3; j1 <= par3 + 1; ++j1)
	                {
	                		par1World.spawnParticle("flame", d0, d1 + d3, d2 + d4, 0.0D, 0.0D, 0.0D);
	                	}
	                }
	            }
	        }
	    }
	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityCandle();
	}
	
	@Override
	public int damageDropped(int par1)
    {
        return par1;
    }
	
	@SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return WinterItems.candleItem;
    }
	
	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune){
    	return WinterItems.candleItem;
    }
}
