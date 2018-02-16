package wintercraft.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import wintercraft.Wintercraft;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ArmorIceSkates extends ItemArmor {

	public String armorNamePrefix;
	private int tickTimer;
	public ArmorIceSkates(ArmorMaterial par2EnumArmorMaterial,
			int par3, int par4, String armornamePrefix) {
		super(par2EnumArmorMaterial, par3, par4);
		//this.setCreativeTab(Wintercraft.WintercraftTab);
		armorNamePrefix = armornamePrefix;
		this.setCreativeTab(Wintercraft.WintercraftTab);
	}
	
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
	{
		par3List.add("\u00a77\u00a7oMakes walking on ice a breeze!");
    }
    
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
	if (stack.getItem() == WinterItems.iceSkates) {
		return "wintercraft:textures/armor/iceSkates.png";
	}
		return null;
	}
	 
	 @Override
	 public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack){
	     if (player.getCurrentArmor(0) != null) {
	     	   ItemStack boots = player.getCurrentArmor(0);
	     	   
	     	   if (boots.getItem() == WinterItems.iceSkates) {
	     		   if(world.getBlock((int)player.posX, (int)player.posY-1, (int)player.posZ) == Blocks.ice || world.getBlock((int)player.posX, (int)player.posY-1, (int)player.posZ) == Blocks.packed_ice){
	     			   player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1 * 20, 5));    
	     			   if(tickTimer >= 100){
	     				   itemStack.damageItem(1, player);
	     				   tickTimer = 0;
	     			   }
	     			   tickTimer++;
	     		   }else{
	     			   player.clearActivePotions();
	     		   }
	     	   }
	     }
	     
	 }
	    @SideOnly(Side.CLIENT)
	    public void registerIcons(IIconRegister par1IconRegister)
	    {
	        this.itemIcon = par1IconRegister.registerIcon(Wintercraft.modid + ":" + this.getUnlocalizedName().substring(5));
	    }
	}

