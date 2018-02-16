package wintercraft.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import wintercraft.Wintercraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBasicAxe extends ItemAxe{

	public Item repair;
	public Boolean candycane;
	
	public ItemBasicAxe(ToolMaterial par2EnumToolMaterial, Item parRepair) {
		super(par2EnumToolMaterial);
		this.setCreativeTab(Wintercraft.WintercraftTab);
		this.repair = parRepair;
	}
	
	public ItemBasicAxe(ToolMaterial par2Tool){
		super(par2Tool);
		this.setCreativeTab(Wintercraft.WintercraftTab);
		this.setMaxDamage(75);
	}
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5));
    }
	@Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
    	return par2ItemStack.isItemEqual(new ItemStack(this.repair, 1, 0)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
    }
}
