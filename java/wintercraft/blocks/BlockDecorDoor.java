package wintercraft.blocks;

import java.util.Random;

import javax.swing.Icon;

import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import wintercraft.items.WinterItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDecorDoor extends BlockDoor
{
public Item placerItem = WinterItems.decorDoorItem;
public IIcon topDoorIcon;
public IIcon[] flippedIcons = new IIcon[2];
@SideOnly(Side.CLIENT)
private IIcon[] field_150017_a;
@SideOnly(Side.CLIENT)
private IIcon[] field_150016_b;

public BlockDecorDoor(Material par2Material)
    {
    super(par2Material);
    float f = 0.5F;
    float f1 = 1.0F;
    this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f1, 0.5F + f);
    this.setStepSound(soundTypeWood);
    }

public IIcon getIcon(int par1, int par2)
{
  return this.field_150016_b[0];
}

@SideOnly(Side.CLIENT)
public IIcon getIcon(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_)
{
    if (p_149673_5_ != 1 && p_149673_5_ != 0)
    {
        int i1 = this.func_150012_g(p_149673_1_, p_149673_2_, p_149673_3_, p_149673_4_);
        int j1 = i1 & 3;
        boolean flag = (i1 & 4) != 0;
        boolean flag1 = false;
        boolean flag2 = (i1 & 8) != 0;

        if (flag)
        {
            if (j1 == 0 && p_149673_5_ == 2)
            {
                flag1 = !flag1;
            }
            else if (j1 == 1 && p_149673_5_ == 5)
            {
                flag1 = !flag1;
            }
            else if (j1 == 2 && p_149673_5_ == 3)
            {
                flag1 = !flag1;
            }
            else if (j1 == 3 && p_149673_5_ == 4)
            {
                flag1 = !flag1;
            }
        }
        else
        {
            if (j1 == 0 && p_149673_5_ == 5)
            {
                flag1 = !flag1;
            }
            else if (j1 == 1 && p_149673_5_ == 3)
            {
                flag1 = !flag1;
            }
            else if (j1 == 2 && p_149673_5_ == 4)
            {
                flag1 = !flag1;
            }
            else if (j1 == 3 && p_149673_5_ == 2)
            {
                flag1 = !flag1;
            }

            if ((i1 & 16) != 0)
            {
                flag1 = !flag1;
            }
        }

        return flag2 ? this.field_150017_a[flag1?1:0] : this.field_150016_b[flag1?1:0];
    }
    else
    {
        return this.field_150016_b[0];
    }
}

@Override
public Item getItemDropped(int metadata, Random rand, int fortune){
	return WinterItems.decorDoorItem;
}

@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister p_149651_1_)
{
    this.field_150017_a = new IIcon[2];
    this.field_150016_b = new IIcon[2];
    this.field_150017_a[0] = p_149651_1_.registerIcon("Wintercraft:"+this.getUnlocalizedName().substring(5)+"_upper");
    this.field_150016_b[0] = p_149651_1_.registerIcon("Wintercraft:"+this.getUnlocalizedName().substring(5)+"_lower");
    this.field_150017_a[1] = new IconFlipped(this.field_150017_a[0], true, false);
    this.field_150016_b[1] = new IconFlipped(this.field_150016_b[0], true, false);
}

@SideOnly(Side.CLIENT)
public Item getItem(World p_149694_1_, int p_149694_2_, int p_149694_3_, int p_149694_4_)
{
    return WinterItems.decorDoorItem;
}

}