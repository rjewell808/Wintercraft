package wintercraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class ItemFruitCakeItem extends ItemBaseItem {

public Block cakeBlock; 
	public ItemFruitCakeItem(Block block) {
		super();
		this.cakeBlock= block;
		
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		par3List.add("\u00a77\u00a7oPer Slice");
		par3List.add("\u00a7eFills 2 Hunger");
        par3List.add("\u00a7cGives 10 Second Strength Boost");
    }
	/**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
     */
	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
    {
        Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);

        if (block == Blocks.snow_layer && (p_77648_3_.getBlockMetadata(p_77648_4_, p_77648_5_, p_77648_6_) & 7) < 1)
        {
            p_77648_7_ = 1;
        }
        else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush)
        {
            if (p_77648_7_ == 0)
            {
                --p_77648_5_;
            }

            if (p_77648_7_ == 1)
            {
                ++p_77648_5_;
            }

            if (p_77648_7_ == 2)
            {
                --p_77648_6_;
            }

            if (p_77648_7_ == 3)
            {
                ++p_77648_6_;
            }

            if (p_77648_7_ == 4)
            {
                --p_77648_4_;
            }

            if (p_77648_7_ == 5)
            {
                ++p_77648_4_;
            }
        }

        if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
        {
            return false;
        }
        else if (p_77648_1_.stackSize == 0)
        {
            return false;
        }
        else
        {
            if (p_77648_3_.canPlaceEntityOnSide(this.cakeBlock, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, (Entity)null, p_77648_1_))
            {
                int i1 = this.cakeBlock.onBlockPlaced(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0);

                if (p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, this.cakeBlock, i1, 3))
                {
                    if (p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == this.cakeBlock)
                    {
                        this.cakeBlock.onBlockPlacedBy(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_2_, p_77648_1_);
                        this.cakeBlock.onPostBlockPlaced(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i1);
                    }

                    p_77648_3_.playSoundEffect((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), this.cakeBlock.stepSound.func_150496_b(), (this.cakeBlock.stepSound.getVolume() + 1.0F) / 2.0F, this.cakeBlock.stepSound.getPitch() * 0.8F);
                    --p_77648_1_.stackSize;
                }
            }

            return true;
        }
    }
}
