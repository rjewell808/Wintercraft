package wintercraft.blocks;

import net.minecraftforge.common.util.ForgeDirection;
import static net.minecraftforge.common.util.ForgeDirection.*;

import java.util.Random;

import wintercraft.items.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Direction;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockStocking extends BlockBaseBlock
{
	private boolean isFull;
	
    protected BlockStocking(Boolean full)
    {
        super(Material.circuits);
        this.isFull = false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4)
    {
        this.updateLadderBounds(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }

    /**
     * Update the ladder block bounds based on the given metadata value.
     */
    public void updateLadderBounds(int par1)
    {
        float f = 0.125F;

        if (par1 == 2)
        {
            this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }

        if (par1 == 3)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }

        if (par1 == 4)
        {
            this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (par1 == 5)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
    }

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
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

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 8;
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.isSideSolid(par2 - 1, par3, par4, EAST ) ||
               par1World.isSideSolid(par2 + 1, par3, par4, WEST ) ||
               par1World.isSideSolid(par2, par3, par4 - 1, SOUTH) ||
               par1World.isSideSolid(par2, par3, par4 + 1, NORTH);
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int j1 = par9;

        if ((j1 == 0 || par5 == 2) && par1World.isSideSolid(par2, par3, par4 + 1, NORTH))
        {
            j1 = 2;
        }

        if ((j1 == 0 || par5 == 3) && par1World.isSideSolid(par2, par3, par4 - 1, SOUTH))
        {
            j1 = 3;
        }

        if ((j1 == 0 || par5 == 4) && par1World.isSideSolid(par2 + 1, par3, par4, WEST))
        {
            j1 = 4;
        }

        if ((j1 == 0 || par5 == 5) && par1World.isSideSolid(par2 - 1, par3, par4, EAST))
        {
            j1 = 5;
        }

        return j1;
    }

    
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        int l = p_149695_1_.getBlockMetadata(p_149695_2_, p_149695_3_, p_149695_4_);
        boolean flag = false;

        if (l == 2 && p_149695_1_.isSideSolid(p_149695_2_, p_149695_3_, p_149695_4_ + 1, NORTH))
        {
            flag = true;
        }

        if (l == 3 && p_149695_1_.isSideSolid(p_149695_2_, p_149695_3_, p_149695_4_ - 1, SOUTH))
        {
            flag = true;
        }

        if (l == 4 && p_149695_1_.isSideSolid(p_149695_2_ + 1, p_149695_3_, p_149695_4_, WEST))
        {
            flag = true;
        }

        if (l == 5 && p_149695_1_.isSideSolid(p_149695_2_ - 1, p_149695_3_, p_149695_4_, EAST))
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


    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return 1;
    }

}