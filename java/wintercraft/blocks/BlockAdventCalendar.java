package wintercraft.blocks;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.Random;

import wintercraft.BiomeControl;
import wintercraft.Wintercraft;
import wintercraft.helper.tileEntity.TileEntityAdventCal;
import wintercraft.helper.tileEntity.TileEntityGift;
import wintercraft.items.WinterItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockAdventCalendar extends BlockContainer{

	public BlockAdventCalendar() {
		super(Material.circuits);
		this.setCreativeTab(Wintercraft.WintercraftTab);
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
	{
		TileEntityAdventCal tile = (TileEntityAdventCal) par1World.getTileEntity(par2, par3, par4);
		
		if(!par5EntityPlayer.worldObj.isRemote){
			int month = BiomeControl.month;
			int day = BiomeControl.day+1;
			int year = BiomeControl.year;
			int dayCount = 0;
			Random generator = new Random();
			Item[] gift = {WinterItems.gingerbreadMan, WinterItems.vanillaIcecream, WinterItems.strawberryIcecream,
							WinterItems.marshmellow, WinterItems.chocolateIcecream, WinterItems.cookieIcecream,
							WinterItems.candyCane, WinterItems.magmaIcecream};
			
			if(month == 11 && day > 25){
				par5EntityPlayer.addChatMessage(new ChatComponentText("\u00a7rChristmas already happened this year ;("));
			}else
			if(month == 11 && day == 25){
				par5EntityPlayer.addChatMessage(new ChatComponentText("\u00a7aToday is Christmas :D"));
			}
			else{
				for(int i=month;i<=11;i++){
					if(i == month){
						switch(i){
							case 9:
							case 7:
							case 6:
							case 4:
							case 2:
							case 0:
								dayCount += (31 - day);
								break;
							case 10:
							case 8:
							case 5:
							case 3:
								dayCount += (30 - day);
								break;
							case 1:
								if(year % 4 == 0){
									dayCount += (29 - day);
								}else{
									dayCount += (28 - day);
								}
								break;
							case 11: 
								dayCount += (25 - day);
								break;
						}
					}else{
						switch(i){
							case 9:
							case 7:
							case 6:
							case 4:
							case 2:
							case 0: 
								dayCount += 31;
								break;
							case 10:
							case 8:
							case 5:
							case 3: 
								dayCount += 30;
								break;
							case 1:
								if(year % 4 == 0){
									dayCount += 29;
								}else{
									dayCount += 28;
								}
								break;
							case 11:
								dayCount += 25;
								break;
						}
					}
				}
				if(tile.nextDay != dayCount){
					par5EntityPlayer.addChatMessage(new ChatComponentText("Day: \u00a7c\u00a7l" + dayCount + " - \u00a7r\u00a7oHere's a treat!"));
					par5EntityPlayer.entityDropItem(new ItemStack(gift[generator.nextInt(8)],generator.nextInt(2)+1), 1);
				}else{
					par5EntityPlayer.addChatMessage(new ChatComponentText("\u00a78You already recieved your treat!"));
				}
			}
			par1World.playSoundAtEntity(par5EntityPlayer, "wintercraft:calendar", 1F, 1F);
			tile.nextDay = dayCount;
		}
		
		return true;
			
	}
	
	
	/**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
    {
        this.setBlockBoundsBasedOnState(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
        return super.getCollisionBoundingBoxFromPool(p_149668_1_, p_149668_2_, p_149668_3_, p_149668_4_);
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess p_149719_1_, int p_149719_2_, int p_149719_3_, int p_149719_4_)
    {
        this.func_149797_b(p_149719_1_.getBlockMetadata(p_149719_2_, p_149719_3_, p_149719_4_));
    }

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World p_149633_1_, int p_149633_2_, int p_149633_3_, int p_149633_4_)
    {
        this.setBlockBoundsBasedOnState(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
        return super.getSelectedBoundingBoxFromPool(p_149633_1_, p_149633_2_, p_149633_3_, p_149633_4_);
    }

    public void func_149797_b(int p_149797_1_)
    {
        float f = 0.125F;

        if (p_149797_1_ == 2)
        {
            this.setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }

        if (p_149797_1_ == 3)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }

        if (p_149797_1_ == 4)
        {
            this.setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (p_149797_1_ == 5)
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
    public boolean canPlaceBlockAt(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_)
    {
        return p_149742_1_.isSideSolid(p_149742_2_ - 1, p_149742_3_, p_149742_4_, EAST ) ||
               p_149742_1_.isSideSolid(p_149742_2_ + 1, p_149742_3_, p_149742_4_, WEST ) ||
               p_149742_1_.isSideSolid(p_149742_2_, p_149742_3_, p_149742_4_ - 1, SOUTH) ||
               p_149742_1_.isSideSolid(p_149742_2_, p_149742_3_, p_149742_4_ + 1, NORTH);
    }

    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z, side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced(World p_149660_1_, int p_149660_2_, int p_149660_3_, int p_149660_4_, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_)
    {
        int j1 = p_149660_9_;

        if ((p_149660_9_ == 0 || p_149660_5_ == 2) && p_149660_1_.isSideSolid(p_149660_2_, p_149660_3_, p_149660_4_ + 1, NORTH))
        {
            j1 = 2;
        }

        if ((j1 == 0 || p_149660_5_ == 3) && p_149660_1_.isSideSolid(p_149660_2_, p_149660_3_, p_149660_4_ - 1, SOUTH))
        {
            j1 = 3;
        }

        if ((j1 == 0 || p_149660_5_ == 4) && p_149660_1_.isSideSolid(p_149660_2_ + 1, p_149660_3_, p_149660_4_, WEST))
        {
            j1 = 4;
        }

        if ((j1 == 0 || p_149660_5_ == 5) && p_149660_1_.isSideSolid(p_149660_2_ - 1, p_149660_3_, p_149660_4_, EAST))
        {
            j1 = 5;
        }

        return j1;
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
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
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    @Override
    public boolean isLadder(IBlockAccess world, int x, int y, int z, EntityLivingBase entity)
    {
        return false;
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Item getItemDropped(int metadata, Random rand, int fortune){
    	return Item.getItemFromBlock(WinterBlocks.calendar);
    }
    

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister par1IconRegister)
    {
        this.blockIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5));
    }

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityAdventCal();
	}
    
    
}