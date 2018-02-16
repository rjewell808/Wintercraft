package wintercraft.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wintercraft.Wintercraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCoffeeMix extends ItemFood{

	public ItemCoffeeMix(int par2, float par3, boolean par4) {
		super(par2, par3, par4);
		this.setCreativeTab(Wintercraft.WintercraftTab);
		this.setMaxStackSize(1);
	}
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		par3List.add("\u00a7eFills 4 Hunger");
		par3List.add("\u00a77\u00a7oWarm it up for a tastier drink!");
    }
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        super.onEaten(par1ItemStack, par2World, par3EntityPlayer);
        return new ItemStack(WinterItems.commonItem);
    }
	
	 public EnumAction getItemUseAction(ItemStack par1ItemStack)
	    {
	        return EnumAction.drink;
	    }

	 @SideOnly(Side.CLIENT)
	    public void registerIcons(IIconRegister par1IconRegister)
	    {
	        this.itemIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5));
	    
	    }
}
