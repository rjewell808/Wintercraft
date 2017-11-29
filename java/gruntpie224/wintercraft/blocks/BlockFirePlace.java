package gruntpie224.wintercraft.blocks;

import java.util.Random;

import gruntpie224.wintercraft.helper.tileEntity.TileEntityFirePlace;
import gruntpie224.wintercraft.init.WinterBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockFirePlace extends BlockContainer{

	private final boolean isActive;
	
	public BlockFirePlace(Material material, boolean active) {
		super(material);
		this.isActive = active;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.2F, 1.0F);
	}
	
	 /**
     * Returns the ID of the items to drop on destruction.
     */
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
    	return Item.getItemFromBlock(WinterBlocks.fireplace);
    }
    
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn)
	{
    	if(this.isActive == true){
    		entityIn.setFire(3);
    	}
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	TileEntityFirePlace tileEntity = (TileEntityFirePlace) worldIn.getTileEntity(pos);
    	if(isActive == true){
    		tileEntity.isOn = true;
    	}
    	
        if (worldIn.isRemote)
		{
        	 return true;
		}
		else if (!playerIn.isSneaking())
		{
		if (tileEntity != null)
		{
			if(tileEntity.isOn == false && this.isActive == false){
				if(playerIn.getCurrentEquippedItem() != null){
					if(playerIn.getCurrentEquippedItem().getItem() == Items.flint_and_steel){
						worldIn.playSoundAtEntity(playerIn, "fire.ignite", 1.0F, 1.0F);
						playerIn.getCurrentEquippedItem().damageItem(1, playerIn);
						worldIn.setBlockState(pos, WinterBlocks.fireplace_active.getDefaultState());
						tileEntity.isOn = true;
					}
				}
			}else{
				if(playerIn.getCurrentEquippedItem() != null){
					if(playerIn.getCurrentEquippedItem().getItem() != Items.flint_and_steel){
						worldIn.playSoundAtEntity(playerIn, "random.fizz", 0.5F, 1.0F);
						worldIn.setBlockState(pos, WinterBlocks.fireplace.getDefaultState());
						tileEntity.isOn = false;
					}
				}else{
					worldIn.playSoundAtEntity(playerIn, "random.fizz", 0.5F, 1.0F);
					worldIn.setBlockState(pos, WinterBlocks.fireplace.getDefaultState());
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
    
    @Override
	public int getRenderType()
	{
		return 3;
	}
	
	/**
	* Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
	* adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
	*/
    @Override
	public boolean isFullCube()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
	
	/**
	 * 
	* If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
	*/

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		
		return new TileEntityFirePlace();
	}
	
	@SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(WinterBlocks.fireplace);
    }
	
	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (this.isActive)
        {
        	if (rand.nextInt(12) == 0)
            {
        		worldIn.playSound((double)((float)pos.getX() + 0.5F), (double)((float)pos.getY() + 0.5F), (double)((float)pos.getZ() + 0.5F), "fire.fire", 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F, false);
            }
        	
            float f = (float)pos.getX() + 1.0F;
            float f1 = (float)pos.getY() + 0.0F + rand.nextFloat() * 6.0F / 16.0F;
            float f2 = (float)pos.getZ() + 0.5F;
            float f3 = 0.52F;
            float f4 = rand.nextFloat() * 0.6F - 0.3F;
                
            worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)(f - f3), (double)f1+0.5F, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)(f - f3), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)(f - f3-0.2F), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)(f - f3+0.2F), (double)f1, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)(f - f3), (double)f1+0.5F, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
            worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)(f - f3), (double)f1+0.1F, (double)(f2 + f4), 0.0D, 0.0D, 0.0D);
           
        }
    }

}
