package gruntpie224.wintercraft.blocks;

import java.util.List;
import java.util.Random;

import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockOrnamentRare extends BlockOrnament {

public BlockOrnamentRare(int texture, Material material) {
	super(texture, material);
}

@Override
@SideOnly(Side.CLIENT)
public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List)
{
     for (int var4 = 0; var4 < 3; ++var4)
     {
         par3List.add(new ItemStack(par1, 1, var4));
     }
}

@Override
public Item getItemDropped(IBlockState state, Random rand, int fortune)
{
	return WinterItems.ornament_item_rare;
}

@Override
@SideOnly(Side.CLIENT)
public Item getItem(World world, BlockPos pos)
{
    return WinterItems.ornament_item_rare;
}

}
