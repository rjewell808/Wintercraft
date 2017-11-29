package gruntpie224.wintercraft.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterBlocks;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockQuartz;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockCandyCane extends Block
{

	private Item drop;
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockCandyCane.EnumType.class);
    
    public BlockCandyCane(Material material)
    {
    	super(material);
    	this.setCreativeTab(Wintercraft.wintercraftTab);
    }
    
    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
    {
	    switch (BlockCandyCane.SwitchAxis.AXIS_LOOKUP[facing.getAxis().ordinal()])
	    {
	        case 1:
	            return this.getDefaultState().withProperty(VARIANT, BlockCandyCane.EnumType.LINES_Z);
	        case 2:
	            return this.getDefaultState().withProperty(VARIANT, BlockCandyCane.EnumType.LINES_X);
	        case 3:
	        default:
	            return this.getDefaultState().withProperty(VARIANT, BlockCandyCane.EnumType.LINES_Y);
	    }
    }
    
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT});
    }
    
    public boolean rotateBlock(World world, BlockPos pos, EnumFacing axis)
    {
        IBlockState state = world.getBlockState(pos);
        for (IProperty prop : (java.util.Set<IProperty>)state.getProperties().keySet())
        {
            if (prop.getName().equals("variant") && prop.getValueClass() == EnumType.class)
            {
                EnumType current = (EnumType)state.getValue(prop);
                EnumType next = current == EnumType.LINES_X ? EnumType.LINES_Y :
                                current == EnumType.LINES_Y ? EnumType.LINES_Z :
                                current == EnumType.LINES_Z ? EnumType.LINES_X : current;
                if (next == current)
                    return false;
                world.setBlockState(pos, state.withProperty(prop, next));
                return true;
            }
        }
        return false;
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(itemIn, 1, BlockCandyCane.EnumType.LINES_Y.getMetadata()));
    }
    
    public static enum EnumType implements IStringSerializable
    {
        LINES_Y(0, "lines_y", "lines"),
        LINES_X(1, "lines_x", "lines"),
        LINES_Z(2, "lines_z", "lines");
        private static final BlockCandyCane.EnumType[] META_LOOKUP = new BlockCandyCane.EnumType[values().length];
        private final int meta;
        private final String field_176805_h;
        private final String unlocalizedName;

        private static final String __OBFID = "CL_00002074";

        private EnumType(int meta, String name, String unlocalizedName)
        {
            this.meta = meta;
            this.field_176805_h = name;
            this.unlocalizedName = unlocalizedName;
        }

        public int getMetadata()
        {
            return this.meta;
        }

        public String toString()
        {
            return this.unlocalizedName;
        }

        public static BlockCandyCane.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public String getName()
        {
            return this.field_176805_h;
        }

        static
        {
        	BlockCandyCane.EnumType[] var0 = values();
            int var1 = var0.length;

            for (int var2 = 0; var2 < var1; ++var2)
            {
            	BlockCandyCane.EnumType var3 = var0[var2];
                META_LOOKUP[var3.getMetadata()] = var3;
            }
        }
    }
    
    /**
     * Convert the given metadata into a BlockState for this Block
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockCandyCane.EnumType.byMetadata(meta));
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockCandyCane.EnumType)state.getValue(VARIANT)).getMetadata();
    }
    
    static final class SwitchAxis
    {
        static final int[] AXIS_LOOKUP = new int[EnumFacing.Axis.values().length];
        private static final String __OBFID = "CL_00002075";

        static
        {
            try
            {
                AXIS_LOOKUP[EnumFacing.Axis.Z.ordinal()] = 1;
            }
            catch (NoSuchFieldError var3)
            {
                ;
            }

            try
            {
                AXIS_LOOKUP[EnumFacing.Axis.X.ordinal()] = 2;
            }
            catch (NoSuchFieldError var2)
            {
                ;
            }

            try
            {
                AXIS_LOOKUP[EnumFacing.Axis.Y.ordinal()] = 3;
            }
            catch (NoSuchFieldError var1)
            {
                ;
            }
        }
    }
    
    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
    	if(player.getCurrentEquippedItem() != null)
    	{
    		if(player.getCurrentEquippedItem().getItem() == WinterItems.candy_cane_axe)
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

