package wintercraft.blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockSnowSlab extends BlockSlab
{

public BlockSnowSlab(boolean par2)
{
super(par2, Material.grass);
this.setLightOpacity(0);
//this.setHarvestLevel("shovel", 0);
}


public void registerBlockIcons(IIconRegister par1IconRegister)
{
this.blockIcon = par1IconRegister.registerIcon("Wintercraft:snowSlab");
}


public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
{
if(par1World.getBlock(par2, par3 - 1, par4) == WinterBlocks.singleSnowSlab)
{
par1World.setBlock(par2, par3, par4, Blocks.air);
par1World.setBlock(par2, par3 - 1, par4, WinterBlocks.doubleSnowSlab);
}
if(par1World.getBlock(par2, par3 + 1, par4) == WinterBlocks.doubleSnowSlab)
{
par1World.setBlock(par2, par3, par4, Blocks.air);
par1World.setBlock(par2, par3 + 1, par4, WinterBlocks.doubleSnowSlab);
}
}

protected ItemStack createStackedBlock(int par1)
{
return new ItemStack(WinterBlocks.singleSnowSlab, 2, par1 & 7);
}

public void getSubBlocks(Block par1, CreativeTabs par2CreativeTabs, List par3List)
{
         if (par1 != WinterBlocks.doubleSnowSlab)
         {
         par3List.add(new ItemStack(par1, 1, 0));
         }
}

@Override
public String func_150002_b(int p_150002_1_) {
	// TODO Auto-generated method stub
	return "SnowSlab";
}

public Item getItemDropped(int par1, Random par2Random, int par3)
{
	return Item.getItemFromBlock(WinterBlocks.singleSnowSlab);
}

}