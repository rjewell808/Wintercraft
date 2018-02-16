package wintercraft.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import wintercraft.Wintercraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBaseItem extends Item{

	
	
	public ItemBaseItem() {
		super();
		this.setCreativeTab(Wintercraft.WintercraftTab);
	}
	
	@SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        this.itemIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5));
    
    }

}
