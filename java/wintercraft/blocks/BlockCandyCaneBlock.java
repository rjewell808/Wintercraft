package wintercraft.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import wintercraft.Wintercraft;
import wintercraft.items.WinterItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;

public class BlockCandyCaneBlock extends BlockLog{

	public Item drop;
	public static final String[] field_150168_M = new String[] {"candyCaneBlock"};
    private static final String __OBFID = "CL_00000281";

    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.field_150167_a = new IIcon[field_150168_M.length];
        this.field_150166_b = new IIcon[field_150168_M.length];

        for (int i = 0; i < this.field_150167_a.length; ++i)
        {
            this.field_150167_a[i] = p_149651_1_.registerIcon(Wintercraft.modid + ":" + "candyCaneBlock");
            this.field_150166_b[i] = p_149651_1_.registerIcon(Wintercraft.modid + ":" + "candyCaneBlockTop");
        }
    }
    
    @Override
    public void onBlockHarvested(World par1World, int p_149681_2_, int p_149681_3_, int p_149681_4_, int p_149681_5_, EntityPlayer par6Player) {
    	if(par6Player.getCurrentEquippedItem() != null){
    		if(par6Player.getCurrentEquippedItem().getItem() == WinterItems.candyCaneAxe){
    			//par6Player.dropItem(Item.getItemFromBlock(WinterBlocks.candyCaneBlock), 1);
    			this.drop = Item.getItemFromBlock(WinterBlocks.candyCaneBlock);
    		}else{
    			//par6Player.dropItem(WinterItems.candyCane, 3);
    			this.drop = WinterItems.candyCane;
    		}
    	}else{
    		//par6Player.dropItem(WinterItems.candyCane, 3);
    		this.drop = WinterItems.candyCane;
    	}
    }
    
    @Override
    public int quantityDropped(Random rand)
    {
    	if(drop != Item.getItemFromBlock(WinterBlocks.candyCaneBlock)){
    		return rand.nextInt(2)+1;
    	}
        return 1;
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return drop;
    }

            
  }

