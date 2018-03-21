package gruntpie224.wintercraft.blocks;

import gruntpie224.wintercraft.Wintercraft;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockBasic extends Block{
	public BlockBasic(String name, Material material)
	{
		super(material);
		this.setCreativeTab(Wintercraft.wcTab);
		this.setUnlocalizedName(name);
		this.setRegistryName(name);
	}
	
	@SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "inventory"));
    }
}
