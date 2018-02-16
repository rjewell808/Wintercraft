package wintercraft.blocks;

import static net.minecraftforge.common.util.ForgeDirection.DOWN;
import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.UP;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import wintercraft.Wintercraft;
import wintercraft.items.WinterItems;
import wintercraft.render.tileEntity.TileEntityOrnament;
import wintercraft.render.tileEntity.TileEntityOrnamentRare;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOrnamentRare extends BlockContainer {

public BlockOrnamentRare(int texture, Material material) {
	super(material);
	this.setBlockBounds(0.4F, 0.5F, 0.3F, 0.7F, 1F, 0.65F);
}

public Item getItemDropped(int par1, Random par2Random, int par3)
{
	return WinterItems.itemOrnamentRare;
}

@SideOnly(Side.CLIENT)
public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
{
    return WinterItems.itemOrnamentRare;
}


public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
{
    return p_149742_1_.isSideSolid(p_149742_2_, p_149742_3_ + 1, p_149742_4_, DOWN );
}
/**
 * checks to see if you can place this block can be placed on that side of a block: BlockLever overrides
 */
public boolean canPlaceBlockOnSide(World par1World, int par2, int par3, int par4, int par5)
{
    ForgeDirection dir = ForgeDirection.getOrientation(par5);
    return dir == DOWN  && !par1World.isSideSolid(par2, par3 + 1, par4, DOWN);

}

public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
{
    int l = p_149695_1_.getBlockMetadata(p_149695_2_, p_149695_3_, p_149695_4_);
    boolean flag = false;
    
    if (!p_149695_1_.isSideSolid(p_149695_2_, p_149695_3_ + 1, p_149695_4_, DOWN) && p_149695_1_.getBlock(p_149695_2_, p_149695_3_ + 1, p_149695_4_) != Blocks.air)
    {
        flag = true;
    }
    
    if (!flag)
    {
        this.dropBlockAsItem(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, l, 0);
        p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
    }

    super.onNeighborBlockChange(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
}

@SideOnly(Side.CLIENT)
private IIcon[] icons;

@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
      this.icons = new IIcon[3];
     
      for(int i = 0; i < icons.length; i++)
      {
             this.icons[i] = par1IconRegister.registerIcon(Wintercraft.modid + ":"+"ornamentItem/rare/" + (this.getUnlocalizedName().substring(5)) + i);
      }
}
@SideOnly(Side.CLIENT)
public IIcon getIcon(int par1, int par2)
{
      return icons[par2];
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

protected boolean canThisPlantGrowOnThisBlock(Block par1)
{
    return par1 == Blocks.leaves;
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
* If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
*/
public boolean renderAsNormalBlock()
{
return false;
}

public void onBlockPlacedBy(World world, int i, int j, int k, EntityLiving entityliving)
{
	int rotation = MathHelper.floor_double((double)((entityliving.rotationYaw * 4F) / 360F) + 2.5D) & 3;
	world.setBlock(i, j, k, this, rotation - 1, rotation - 1);
}

public TileEntity createNewTileEntity(World par1World, int i)
{
	return new TileEntityOrnamentRare();
}

public int damageDropped(int par1)
{
    return par1;

}

}
