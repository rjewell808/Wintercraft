package wintercraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import wintercraft.Wintercraft;
import wintercraft.entity.passive.EntitySnowMan;
import wintercraft.helper.FeatureConfig;
import wintercraft.helper.tileEntity.TileEntitySnowManHead;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSnowManHead extends BlockContainer{

	public BlockSnowManHead(int texture, Material material) {
		super(material);
		this.setCreativeTab(Wintercraft.WintercraftTab);
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, 0.5F, 0.75F);
}


/**
* The type of render function that is called for this block
*/
public int getRenderType()
{
	return -2;
}

public void onBlockAdded(World par1World, int par2, int par3, int par4)
{
    super.onBlockAdded(par1World, par2, par3, par4);

    if (par1World.getBlock(par2, par3 - 1, par4) == Blocks.snow && par1World.getBlock(par2, par3 - 2, par4) == Blocks.snow)
    {
        if (!par1World.isRemote && FeatureConfig.peacefulMobs)
        {
            par1World.setBlock(par2, par3, par4, Blocks.air, 0, 2);
            par1World.setBlock(par2, par3 - 1, par4, Blocks.air, 0, 2);
            par1World.setBlock(par2, par3 - 2, par4, Blocks.air, 0, 2);
            EntitySnowMan entitysnowman = new EntitySnowMan(par1World);
            entitysnowman.setLocationAndAngles((double)par2 + 0.5D, (double)par3 - 1.95D, (double)par4 + 0.5D, 0.0F, 0.0F);
            par1World.spawnEntityInWorld(entitysnowman);
            par1World.notifyBlockChange(par2, par3, par4, Blocks.air);
            par1World.notifyBlockChange(par2, par3 - 1, par4, Blocks.air);
            par1World.notifyBlockChange(par2, par3 - 2, par4, Blocks.air);
        }

        for (int l = 0; l < 120; ++l)
        {
            par1World.spawnParticle("snowshovel", (double)par2 + par1World.rand.nextDouble(), (double)(par3 - 2) + par1World.rand.nextDouble() * 2.5D, (double)par4 + par1World.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }
}

/**
 * set a blocks direction
 */
private void setDefaultDirection(World par1World, int par2, int par3, int par4)
{
    if (!par1World.isRemote)
    {
        Block block1 = par1World.getBlock(par2, par3, par4 - 1);
        Block block2 = par1World.getBlock(par2, par3, par4 + 1);
        Block block3 = par1World.getBlock(par2 - 1, par3, par4);
        Block block4 = par1World.getBlock(par2 + 1, par3, par4);
        byte b0 = 3;

        if (block1.func_149730_j() && !block2.func_149730_j())
        {
            b0 = 3;
        }

        if (block2.func_149730_j() && !block1.func_149730_j())
        {
            b0 = 2;
        }

        if (block3.func_149730_j() && !block4.func_149730_j())
        {
            b0 = 5;
        }

        if (block4.func_149730_j() && !block3.func_149730_j())
        {
            b0 = 4;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, b0, 2);
    }
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
 * Called when the block is placed in the world.
 */
public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack stack)
{
    if(entity == null){
    	return;
    }
    TileEntitySnowManHead tile = (TileEntitySnowManHead) world.getTileEntity(x, y, z);
    tile.direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
}

public boolean renderAsNormalBlock()
{
	return false;
}


public TileEntity createNewTileEntity(World par1World, int i)
{
return new TileEntitySnowManHead();
}

@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister par1IconRegister)
{
    this.blockIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5));
}

}
