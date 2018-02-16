package wintercraft.items;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wintercraft.blocks.WinterBlocks;
import wintercraft.helper.tileEntity.TileEntityLightsBlock;

public class ItemLights extends ItemBaseItem{
	
private Block spawnID;
	public ItemLights(Block block) {
		super();
		this.spawnID = block;
	}
	
	@Override
	 public int getMetadata(int par1)
	    {
	        return 3;
	    }

	@Override
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
		{
		
		int i1 = par3World.getBlockMetadata(par4, par5, par6);
        Block i2 = par3World.getBlock(par4, par5, par6);
        int Metadata = 5;
        Block blockId = Blocks.leaves;
        
        if(i2 == Blocks.leaves || i2 == Blocks.leaves2){
        
        par3World.setBlock(par4, par5, par6, WinterBlocks.lightsBlock);
        TileEntityLightsBlock tile = (TileEntityLightsBlock) par3World.getTileEntity(par4, par5, par6);
        if(!par3World.isRemote){
        	tile.type = i1;
        	tile.leaf = Item.getIdFromItem(Item.getItemFromBlock(i2));
        }
        par3World.playSoundAtEntity(par2EntityPlayer, "dig.grass", 1.0F, 0.7F / (itemRand.nextFloat() * 0.4F + 0.8F));
        par1ItemStack.stackSize -= 1;

        	return true;
        	}
        else{
          
            	Block block = par3World.getBlock(par4, par5, par6);
            	
            	if (par7 == 0)
                {
                    return false;
                }
                else if (!par3World.getBlock(par4, par5, par6).getMaterial().isSolid())
                {
                    return false;
                }
                else
                {
            	if (block == Blocks.snow_layer && (par3World.getBlockMetadata(par4, par5, par6) & 7) < 1)
                {
            		par7 = 1;
                }
                else if (block != Blocks.vine && block != Blocks.tallgrass && block != Blocks.deadbush)
                {
                    if (par7 == 0)
                    {
                        --par5;
                    }

                    if (par7 == 1)
                    {
                        ++par5;
                    }

                    if (par7 == 2)
                    {
                        --par6;
                    }

                    if (par7 == 3)
                    {
                        ++par6;
                    }

                    if (par7 == 4)
                    {
                        --par4;
                    }

                    if (par7 == 5)
                    {
                        ++par4;
                    }
                }

                if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6, par7, par1ItemStack))
                {
                    return false;
                }
                else if (par1ItemStack.stackSize == 0)
                {
                    return false;
                }
                else if (!this.spawnID.canPlaceBlockAt(par3World, par4, par5, par6))
                {
                    return false;
                }
                else if (par3World.isRemote)
                {
                    return true;
                }
                else
                {
                    if (par3World.canPlaceEntityOnSide(this.spawnID, par4, par5, par6, false, par7, (Entity)null, par1ItemStack))
                    {
                        int i3 = this.spawnID.onBlockPlaced(par3World, par4, par5, par6, par7, par8, par9, par10, 0);

                        if (par3World.setBlock(par4, par5, par6, this.spawnID, i3, 3))
                        {
                            if (par3World.getBlock(par4, par5, par6) == this.spawnID)
                            {
                                this.spawnID.onBlockPlacedBy(par3World, par4, par5, par6, par2EntityPlayer, par1ItemStack);
                                this.spawnID.onPostBlockPlaced(par3World, par4, par5, par6, i3);
                            }

                            par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), this.spawnID.stepSound.func_150496_b(), (this.spawnID.stepSound.getVolume() + 1.0F) / 2.0F, this.spawnID.stepSound.getPitch() * 0.8F);
                            --par1ItemStack.stackSize;
                        }
                    }

                    return true;
                }
            }
        }
	}
}