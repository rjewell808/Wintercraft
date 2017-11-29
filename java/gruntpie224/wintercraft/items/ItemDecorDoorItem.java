package gruntpie224.wintercraft.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemDecorDoorItem extends ItemBaseItem
{
	public Block doorBlock;    
    public ItemDecorDoorItem(Block block)
    {
    	super();
    	this.doorBlock= block;
    	this.maxStackSize = 1;
    }

    /**
	* Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	* True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	*/
    
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
    	if (side != EnumFacing.UP)
        {
            return false;
        }
    	else
        {
            IBlockState iblockstate = worldIn.getBlockState(pos);
            Block block = iblockstate.getBlock();

            if (!block.isReplaceable(worldIn, pos))
            {
                pos = pos.offset(side);
            }

            if (!playerIn.canPlayerEdit(pos, side, stack))
            {
                return false;
            }
            else if (!this.doorBlock.canPlaceBlockAt(worldIn, pos))
            {
                return false;
            }
            else
            {
                ItemDoor.placeDoor(worldIn, pos, EnumFacing.fromAngle((double)playerIn.rotationYaw), this.doorBlock);
                --stack.stackSize;
                return true;
            }
        }
    }
    }
