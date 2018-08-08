package gruntpie224.wintercraft.blocks;

import java.util.List;
import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCandyCane extends BlockRotatedPillar
{

	private Item drop;

    public BlockCandyCane(String name, Material material)
    {
    	super(material);
    	this.setRegistryName(name);
    	this.setUnlocalizedName(name);
    	this.setCreativeTab(Wintercraft.wcTab);
    	this.setSoundType(SoundType.GLASS);
    }
    
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
    	if(player.getHeldItemMainhand() != null)
    	{
    		if(player.getHeldItemMainhand().getItem() == WinterItems.candy_cane_axe)
    		{
    			this.drop = Item.getItemFromBlock(WinterBlocks.candy_cane_block);
    		}else
    		{
    			this.drop = WinterItems.candy_cane;
    		}
    	}
    	else
    	{
    		this.drop = WinterItems.candy_cane;
    	}
    }
    
    @Override
    public int quantityDropped(Random rand)
    {
    	if(drop != Item.getItemFromBlock(WinterBlocks.candy_cane_block)){
    		return rand.nextInt(2)+1;
    	}
        return 1;
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return drop;
    }
       
  }
