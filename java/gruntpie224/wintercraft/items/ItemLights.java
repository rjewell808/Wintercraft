package gruntpie224.wintercraft.items;

import gruntpie224.wintercraft.blocks.BlockWallLights;
import gruntpie224.wintercraft.helper.tileEntity.TileEntityLightsBlock;
import gruntpie224.wintercraft.init.WinterBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockWallSign;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemLights extends ItemBaseItem{
	
private Block spawnID;
	public ItemLights(Block block)
	{
		super();
		this.spawnID = block;
	}
	
	@Override
	public int getMetadata(int par1)
    {
        return 3;
    }

	@Override
    //public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
	//{
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		
		int i1 = world.getBlockState(pos).getBlock().getMetaFromState(world.getBlockState(pos));
        Block i2 = world.getBlockState(pos).getBlock();
        int Metadata = 5;
        Block blockId = Blocks.leaves;
        
        if(i2 == Blocks.leaves || i2 == Blocks.leaves2)
        {
        	world.setBlockState(pos, WinterBlocks.lights_block.getDefaultState());
        	TileEntityLightsBlock tile = (TileEntityLightsBlock) world.getTileEntity(pos);
	        if(!world.isRemote)
	        {
	        	tile.type = i1;
	        	tile.leaf = Item.getIdFromItem(Item.getItemFromBlock(i2));
	        }
	        world.playSoundAtEntity(player, "dig.grass", 1.0F, 0.7F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        --stack.stackSize;

        	return true;
    	}
        else
        {
          
        	IBlockState block = world.getBlockState(pos);
        	
        	if (side == EnumFacing.DOWN)
            {
                return false;
            }
            else if (!world.getBlockState(pos).getBlock().getMaterial().isSolid())
            {
                return false;
            }
            else
            {
	
            	pos = pos.offset(side);
            	
	            if (!player.canPlayerEdit(pos, side, stack))
	            {
	                return false;
	            }
	            else if (stack.stackSize == 0)
	            {
	                return false;
	            }
	            else if (!this.spawnID.canPlaceBlockAt(world, pos))
	            {
	                return false;
	            }
	            else if (world.isRemote)
	            {
	                return true;
	            }
	            else
	            {
	                if (side != EnumFacing.UP && side != EnumFacing.DOWN)
	                {
	                    IBlockState i3 = this.spawnID.onBlockPlaced(world, pos, side, hitZ, hitZ, hitZ, 0, player); //(par3World, par4, par5, par6, par7, par8, par9, par10, 0);
	
	                    if (world.setBlockState(pos, this.spawnID.getDefaultState()))
	                    {
	                        if (world.getBlockState(pos) == this.spawnID.getDefaultState())
	                        {
	                        	world.setBlockState(pos, spawnID.getDefaultState().withProperty(BlockWallLights.FACING, side), 3);
	                        }
	
	                        //world.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), this.spawnID.stepSound.func_150496_b(), (this.spawnID.stepSound.getVolume() + 1.0F) / 2.0F, this.spawnID.stepSound.getPitch() * 0.8F);
	                        --stack.stackSize;
	                    }
	                }
	
	                return true;
	            }
            }
        }
	}
}