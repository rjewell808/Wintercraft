package wintercraft.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import wintercraft.Wintercraft;
import wintercraft.helper.tileEntity.TileEntityAdventCal;
import wintercraft.helper.tileEntity.TileEntityFirePlace;
import wintercraft.helper.tileEntity.TileEntityFreezer;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockFirePlace extends BlockContainer{

	private final boolean isActive;
	
	protected BlockFirePlace(Material material, boolean active) {
		super(material);
		this.isActive = active;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.1F, 1.0F);
	}
	
	 /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int metadata, Random rand, int fortune){
    	return Item.getItemFromBlock(WinterBlocks.fireplace);
    }
    
    public void onEntityCollidedWithBlock(World par1World, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity par5Entity)
    {
    	if(this.isActive == true){
    		par5Entity.setFire(3);
    	}
    }
    
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
    	TileEntityFirePlace tileEntity = (TileEntityFirePlace) par1World.getTileEntity(par2, par3, par4);
    	if(isActive == true){
    		tileEntity.isOn = true;
    	}
    	
        if (par1World.isRemote)
		{
        	 return true;
		}
		else if (!par5EntityPlayer.isSneaking())
		{
		if (tileEntity != null)
		{
			if(tileEntity.isOn == false && this.isActive == false){
				if(par5EntityPlayer.getCurrentEquippedItem() != null){
					if(par5EntityPlayer.getCurrentEquippedItem().getItem() == Items.flint_and_steel){
						par1World.playSoundAtEntity(par5EntityPlayer, "fire.ignite", 1.0F, 1.0F);
						par5EntityPlayer.getCurrentEquippedItem().damageItem(1, par5EntityPlayer);
						par1World.setBlock(par2, par3, par4, WinterBlocks.fireplaceActive);
						tileEntity.isOn = true;
					}
				}
			}else{
				if(par5EntityPlayer.getCurrentEquippedItem() != null){
					if(par5EntityPlayer.getCurrentEquippedItem().getItem() != Items.flint_and_steel){
						par1World.playSoundAtEntity(par5EntityPlayer, "random.fizz", 0.5F, 1.0F);
						par1World.setBlock(par2, par3, par4, WinterBlocks.fireplace);
						tileEntity.isOn = false;
					}
				}else{
					par1World.playSoundAtEntity(par5EntityPlayer, "random.fizz", 0.5F, 1.0F);
					par1World.setBlock(par2, par3, par4, WinterBlocks.fireplace);
					tileEntity.isOn = false;
				}
			}
		}
			return true;
		}
		else
		{
			return false;
		}
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
    
    /**
     * set a blocks direction
     */
    private void setDefaultDirection(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            Block block1 = par1World.getBlock(par2, par3, par4 - 1);
            Block block2 = par1World.getBlock(par2, par3, par4 + 1);
            Block block3 = par1World.getBlock(par2 - 1, par3, par4);
            Block block4 = par1World.getBlock(par2 + 1, par3, par4);
            byte b0 = 3;

            if (block1.func_149730_j() && !block2.func_149730_j())
            {
                b0 = 3;
            }

            if (block2.func_149730_j() && !block1.func_149730_j())
            {
                b0 = 2;
            }

            if (block3.func_149730_j() && !block4.func_149730_j())
            {
                b0 = 5;
            }

            if (block4.func_149730_j() && !block3.func_149730_j())
            {
                b0 = 4;
            }

            par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
        }
    }
    
    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLivingBase par5EntityLivingBase, ItemStack par6ItemStack)
    {
        int l = MathHelper.floor_double((double)(par5EntityLivingBase.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 2, 2);
        }

        if (l == 1)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 5, 2);
        }

        if (l == 2)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 3, 2);
        }

        if (l == 3)
        {
            par1World.setBlockMetadataWithNotify(par2, par3, par4, 4, 2);
        }

        if (par6ItemStack.hasDisplayName())
        {
        	((TileEntityFreezer)par1World.getTileEntity(par2, par3, par4)).setCustomName(par6ItemStack.getDisplayName());
        }
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		
		return new TileEntityFirePlace();
	}
	
	@SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemFromBlock(WinterBlocks.fireplace);
    }
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5));
    
    }
	
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (this.isActive)
        {
        	if (par5Random.nextInt(12) == 0)
            {
        		par1World.playSound((double)((float)par2 + 0.5F), (double)((float)par2 + 0.5F), (double)((float)par4 + 0.5F), "fire.fire", 1.0F + par5Random.nextFloat(), par5Random.nextFloat() * 0.7F + 0.3F, false);
            }
        	
            int l = par1World.getBlockMetadata(par2, par3, par4);
            float f = (float)par2 + 1.0F;
            float f1 = (float)par3 + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)par4 + 0.5F;
            float f3 = 0.52F;
            float f4 = par5Random.nextFloat() * 0.6F - 0.3F;
                
            par1World.spawnParticle("flame", (double)(f - f3), (double)f1+0.5F, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", (double)(f - f3-0.2F), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("flame", (double)(f - f3+0.2F), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("largesmoke", (double)(f - f3), (double)f1+0.5F, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            par1World.spawnParticle("largesmoke", (double)(f - f3), (double)f1+0.1F, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
           
        }
    }

}
