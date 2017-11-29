package gruntpie224.wintercraft.blocks;

import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.helper.gui.GuiFreezer;
import gruntpie224.wintercraft.helper.gui.GuiHandler;
import gruntpie224.wintercraft.helper.tileEntity.TileEntityFreezer;
import gruntpie224.wintercraft.init.WinterBlocks;

public class BlockFreezer extends BlockContainer
{
    private final Random furnaceRand = new Random();

    /** True if this is an active furnace, false if idle */
    private final boolean isActive;
    private static boolean keepFurnaceInventory;
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);
    
    public BlockFreezer(boolean par2)
    {
        super(Material.rock);
        this.isActive = par2;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 3;
    }
    
    @Override
    public boolean isOpaqueCube() {
    	return false;
    }
    
    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }
    
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess worldIn, BlockPos pos, EnumFacing side)
    {
        return true;
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int metadata, Random rand, int fortune){
    	return Item.getItemFromBlock(WinterBlocks.freezer);
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    
    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
        this.setDefaultFacing(worldIn, pos, state);
    }

    /**
     * set a blocks direction
     */
    private void setDefaultFacing(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!worldIn.isRemote)
        {
            Block block = worldIn.getBlockState(pos.north()).getBlock();
            Block block1 = worldIn.getBlockState(pos.south()).getBlock();
            Block block2 = worldIn.getBlockState(pos.west()).getBlock();
            Block block3 = worldIn.getBlockState(pos.east()).getBlock();
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);

            if (enumfacing == EnumFacing.NORTH && block.isFullBlock() && !block1.isFullBlock())
            {
                enumfacing = EnumFacing.SOUTH;
            }
            else if (enumfacing == EnumFacing.SOUTH && block1.isFullBlock() && !block.isFullBlock())
            {
                enumfacing = EnumFacing.NORTH;
            }
            else if (enumfacing == EnumFacing.WEST && block2.isFullBlock() && !block3.isFullBlock())
            {
                enumfacing = EnumFacing.EAST;
            }
            else if (enumfacing == EnumFacing.EAST && block3.isFullBlock() && !block2.isFullBlock())
            {
                enumfacing = EnumFacing.WEST;
            }

            worldIn.setBlockState(pos, state.withProperty(FACING, enumfacing), 2);
        }
    }
    
    /**
     * Possibly modify the given BlockState before rendering it on an Entity (Minecarts, Endermen, ...)
     */
    @SideOnly(Side.CLIENT)
    public IBlockState getStateForEntityRender(IBlockState state)
    {
        return this.getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y)
        {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumFacing)state.getValue(FACING)).getIndex();
    }

    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {FACING});
    }

    public static void setState(boolean active, World worldIn, BlockPos pos)
    {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        keepFurnaceInventory = true;

        if (active)
        {
            worldIn.setBlockState(pos, WinterBlocks.freezer.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, WinterBlocks.freezerActive.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        else
        {
            worldIn.setBlockState(pos, WinterBlocks.freezer.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
            worldIn.setBlockState(pos, WinterBlocks.freezer.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }

        keepFurnaceInventory = false;

        if (tileentity != null)
        {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }
    
    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
		if (worldIn.isRemote)
			return true;
		
		playerIn.openGui(Wintercraft.instance, GuiHandler.getGuiID(), worldIn, pos.getX(), pos.getY(), pos.getZ());
		return true;
	}
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (this.isActive)
        {
            EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
            double d0 = (double)pos.getX() + 0.5D;
            double d1 = (double)pos.getY() + rand.nextDouble() * 6.0D / 16.0D;
            double d2 = (double)pos.getZ() + 0.5D;
            double d3 = 0.52D;
            double d4 = rand.nextDouble() * 0.6D - 0.3D;

            switch (BlockFreezer.SwitchEnumFacing.FACING_LOOKUP[enumfacing.ordinal()])
            {
                case 1:
                    worldIn.spawnParticle(EnumParticleTypes.TOWN_AURA, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.SNOWBALL, d0 - d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                    break;
                case 2:
                    worldIn.spawnParticle(EnumParticleTypes.TOWN_AURA, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.SNOWBALL, d0 + d3, d1, d2 + d4, 0.0D, 0.0D, 0.0D, new int[0]);
                    break;
                case 3:
                    worldIn.spawnParticle(EnumParticleTypes.TOWN_AURA, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.SNOWBALL, d0 + d4, d1, d2 - d3, 0.0D, 0.0D, 0.0D, new int[0]);
                    break;
                case 4:
                    worldIn.spawnParticle(EnumParticleTypes.TOWN_AURA, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
                    worldIn.spawnParticle(EnumParticleTypes.SNOWBALL, d0 + d4, d1, d2 + d3, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
    }
    
    

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World par1World, int meta)
    {
        return new TileEntityFreezer();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);

        if (stack.hasDisplayName())
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityFreezer)
            {
                ((TileEntityFreezer)tileentity).setCustomInventoryName(stack.getDisplayName());
            }
        }
    }

    /**
     * Called on server worlds only when the block has been replaced by a different block ID, or the same block with a
     * different metadata value, but before the new metadata value is set. Args: World, x, y, z, old block ID, old
     * metadata
     */
    
    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!keepFurnaceInventory)
        {
            TileEntityFreezer tileentityfurnace = (TileEntityFreezer)worldIn.getTileEntity(pos);

            if (tileentityfurnace != null)
            {
                for (int j1 = 0; j1 < tileentityfurnace.getSizeInventory(); ++j1)
                {
                    ItemStack itemstack = tileentityfurnace.getStackInSlot(j1);

                    if (itemstack != null)
                    {
                        float f = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f1 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float f2 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (itemstack.stackSize > 0)
                        {
                            int k1 = this.furnaceRand.nextInt(21) + 10;

                            if (k1 > itemstack.stackSize)
                            {
                                k1 = itemstack.stackSize;
                            }

                            itemstack.stackSize -= k1;
                            EntityItem entityitem = new EntityItem(worldIn, (double)((float)pos.getX() + f), (double)((float)pos.getY() + f1), (double)((float)pos.getZ() + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));

                            if (itemstack.hasTagCompound())
                            {
                                entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                            }

                            float f3 = 0.05F;
                            entityitem.motionX = (double)((float)this.furnaceRand.nextGaussian() * f3);
                            entityitem.motionY = (double)((float)this.furnaceRand.nextGaussian() * f3 + 0.2F);
                            entityitem.motionZ = (double)((float)this.furnaceRand.nextGaussian() * f3);
                            worldIn.spawnEntityInWorld(entityitem);
                        }
                    }
                }
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

    @SideOnly(Side.CLIENT)

    static final class SwitchEnumFacing
    {
        static final int[] FACING_LOOKUP = new int[EnumFacing.values().length];
        private static final String __OBFID = "CL_00002111";

        static
        {
            try
            {
                FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 1;
            }
            catch (NoSuchFieldError var4)
            {
                ;
            }

            try
            {
                FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 2;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 3;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 4;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
    
    /**
     * If this returns true, then comparators facing away from this block will use the value from
     * getComparatorInputOverride instead of the actual redstone signal strength.
     */
    public boolean hasComparatorInputOverride()
    {
        return true;
    }
    
    /**
     * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
     * strength when this block inputs to a comparator.
     */
    public int getComparatorInputOverride(World worldIn, BlockPos pos)
    {
        return Container.calcRedstoneFromInventory((IInventory)worldIn.getTileEntity(pos));
    }

    @SideOnly(Side.CLIENT)
    public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
    {
        return Item.getItemFromBlock(WinterBlocks.freezer);
    }
}
