package gruntpie224.wintercraft.items;

import gruntpie224.wintercraft.entity.passive.EntityReindeer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MagicSaddle extends ItemBaseItem
{
    public MagicSaddle()
    {
        super();
        this.maxStackSize = 1;
    }

    /**
     * Returns true if the item can be used on the given entity, e.g. shears on sheep.
     */
    public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par3EntityLivingBase)
    {
        if (par3EntityLivingBase instanceof EntityReindeer)
        {
        	EntityReindeer entitypig = (EntityReindeer)par3EntityLivingBase;

            if (!entitypig.getSaddled() && !entitypig.isChild())
            {
                entitypig.setSaddled(true);
                --par1ItemStack.stackSize;
            }

            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
    {
        this.itemInteractionForEntity(par1ItemStack, (EntityPlayer)null, par2EntityLivingBase);
        return true;
    }
}
