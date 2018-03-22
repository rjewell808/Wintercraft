package gruntpie224.wintercraft.items;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.WintercraftReference;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBasic extends Item{
	public ItemBasic(String name){
		super();
		this.setCreativeTab(Wintercraft.wcTab);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
