package gruntpie224.wintercraft.items;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterItems;

public class ArmorAntlerHat extends ItemArmor {

	public ArmorAntlerHat(ArmorMaterial par2EnumArmorMaterial,int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(Wintercraft.wintercraftTab);
	}
	  
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
		par3List.add("\u00a77\u00a7oWear them on your head!");
    }
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == WinterItems.antlers) 
		{
			return "wc:textures/models/reindeer.png";
		}
		return null;
	}

	    

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
	
		ModelBiped armorModel = null;
		if(itemStack != null){
			if(itemStack.getItem() instanceof ArmorAntlerHat){
				int type = ((ItemArmor)itemStack.getItem()).armorType;
				
				if(type == 1 || type == 3){
				    armorModel = Wintercraft.proxy.getArmorModel(2);
				}else{
				    armorModel = Wintercraft.proxy.getArmorModel(3);
				}
				if(armorModel != null){
					armorModel.bipedHead.showModel = armorSlot == 0;
					armorModel.isSneak = entityLiving.isSneaking();
					armorModel.isRiding = entityLiving.isRiding();
					armorModel.isChild = entityLiving.isChild();
					armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0;
					if(entityLiving instanceof EntityPlayer){
						armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
					}
					return armorModel;
				}
			}		
		}
		return null;
	}
}

