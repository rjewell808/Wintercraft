package gruntpie224.wintercraft.items;

import java.util.List;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.blocks.BlockOrnamentRare;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemOrnamentRare extends ItemBlock{
	public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockOrnamentRare.EnumType.class);   
	private String name;
	
	public ItemOrnamentRare(String name, Block candle)
	{
		super(candle);
	    this.setHasSubtypes(true);
	    this.setMaxDamage(0);
	    this.setUnlocalizedName(name);
	    this.setCreativeTab(Wintercraft.wcTab);
	    this.name = name;
	}
	
	public int getMetadata(int damage)
    {
        return damage;
    }
	
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int x = 0; x < names.length; x++)
	    {
	        par3List.add(new ItemStack(this, 1, x));
	    }
	    
	}	
	
	public static final String[] names = new String[] {
			"_creeper", 
			"_enderman", 
			"_blaze"
			};
	
	public String getUnlocalizedName(ItemStack stack)
	{
	    int i = MathHelper.clamp(stack.getItemDamage(), 0, 16);
	    return "item." + name + names[i];
	}
	
	public static void registerRender(Item item, int meta, String name) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(name, "inventory"));
	}
}