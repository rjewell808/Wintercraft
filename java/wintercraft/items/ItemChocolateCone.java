package wintercraft.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import wintercraft.Wintercraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemChocolateCone extends ItemFood{

	public ItemChocolateCone(int par2, float par3, boolean par4) {
		super(par2, par3, par4);
		this.setCreativeTab(Wintercraft.WintercraftTab);
	
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add("\u00a7eFills 3 Hunger");
        par3List.add("\u00a7cGives 45 Sec Strength Boost");
    }
	
	@Override
    public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
    	par3EntityPlayer.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 45 * 20, 2));    
    }
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5));
    
    }
	
}
