package wintercraft.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import wintercraft.Wintercraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorSanta extends ItemArmor {

	public String armorNamePrefix;
	public ArmorSanta(ArmorMaterial par2EnumArmorMaterial,
			int par3, int par4, String armornamePrefix) {
		super(par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(Wintercraft.WintercraftTab);
		armorNamePrefix = armornamePrefix;
	}
  
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot,
	String type) {
	if (stack.getItem() == WinterItems.santaSuit|| stack.getItem() == WinterItems.santaBoots) {
	return "wintercraft:textures/armor/santa_1.png";
	}
	if (stack.getItem() == WinterItems.santaPants) {
	return "wintercraft:textures/armor/santa_2.png";
	}
	return null;
	}
	 
	 @Override
	 public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
	     
	     if (player.getCurrentArmor(3) != null && player.getCurrentArmor(2) != null && player.getCurrentArmor(1) != null && player.getCurrentArmor(0) != null) {
	     	   ItemStack helmet = player.getCurrentArmor(3);
	     	   ItemStack plate = player.getCurrentArmor(2);
	     	   ItemStack legs = player.getCurrentArmor(1);
	     	   ItemStack boots = player.getCurrentArmor(0);
	     	   
	     	   if (helmet.getItem() == WinterItems.santaHat && plate.getItem() == WinterItems.santaSuit && legs.getItem() == WinterItems.santaPants && boots.getItem() == WinterItems.santaBoots) {
	     		  WinterItems.santaArmour = true;
	     	   } 
	     	 
	     	  } else {WinterItems.santaArmour = false;}
	     
	 }
	 
	 
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IIconRegister par1IconRegister)
	    {
	        this.itemIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5));
	    }
	    



	}

