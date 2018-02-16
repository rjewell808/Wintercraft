package wintercraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import wintercraft.Wintercraft;
import wintercraft.blocks.WinterSpecialBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCandleItem extends ItemBaseItem{
	public Block ornamentBlock;  
	public ItemCandleItem(Block ornament) {
		super();
		this.ornamentBlock= ornament;
	    this.setHasSubtypes(true);
	    this.setMaxDamage(0);
	    this.setCreativeTab(Wintercraft.WintercraftTab);
	}

	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	      
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
	       icons = new IIcon[16];
	             
	       for(int i = 0; i < icons.length; i++)
	       {
	    	   icons[i] = par1IconRegister.registerIcon(Wintercraft.modid + ":" + "candle/candleItem" + i);
	       }
	}
	
	
	
	public IIcon getIconFromDamage(int par1)
	{
	return icons[par1];
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int x = 0; x < 16; x++)
	    {
	        par3List.add(new ItemStack(this, 1, x));
	    }
	    
	}
	
	public static final String[] names = new String[] {"0", "1", "2", "3", "4", "5", "6", "7" , "8", "9", "10", "11", "12", "13", "14", "15"};
    
	public String getUnlocalizedName(ItemStack par1ItemStack)
	{
	    int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
	    return super.getUnlocalizedName() + "." + names[i];
	}
	
	 public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	    {
	        Block block = p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_);

	        if (block == WinterSpecialBlocks.candle || block == Blocks.snow_layer && (p_77648_3_.getBlockMetadata(p_77648_4_, p_77648_5_, p_77648_6_) & 7) < 1)
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
	            if (p_77648_3_.canPlaceEntityOnSide(this.ornamentBlock, p_77648_4_, p_77648_5_, p_77648_6_, false, p_77648_7_, (Entity)null, p_77648_1_))
	            {
	                int i1 = this.ornamentBlock.onBlockPlaced(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_8_, p_77648_9_, p_77648_10_, 0);

	                if (p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, this.ornamentBlock, p_77648_1_.getItemDamage(), 3))
	                {
	                    if (p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_) == this.ornamentBlock)
	                    {
	                        this.ornamentBlock.onBlockPlacedBy(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, p_77648_2_, p_77648_1_);
	                        this.ornamentBlock.onPostBlockPlaced(p_77648_3_, p_77648_4_, p_77648_5_, p_77648_6_, i1);
	                    }

	                    p_77648_3_.playSoundEffect((double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), this.ornamentBlock.stepSound.func_150496_b(), (this.ornamentBlock.stepSound.getVolume() + 1.0F) / 2.0F, this.ornamentBlock.stepSound.getPitch() * 0.8F);
	                    --p_77648_1_.stackSize;
	                }
	            }

	            return true;
	        }
	    }
	}
