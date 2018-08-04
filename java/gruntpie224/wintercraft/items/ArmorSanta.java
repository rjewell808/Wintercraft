package gruntpie224.wintercraft.items;

import javax.annotation.Nullable;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmorSanta extends ItemArmor {
	public ArmorSanta(String name, ArmorMaterial material, int par3, EntityEquipmentSlot par4) {
		super(material, par3, par4);
		this.setCreativeTab(Wintercraft.wcTab);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
		if(stack.getItem() == WinterItems.santa_helmet) {
			return "wc:textures/models/santa_hat.png";
		}
		
		if (stack.getItem() == WinterItems.santa_plate || stack.getItem() == WinterItems.santa_boots) 
		{
			return "wc:textures/armor/santa_1.png";
		}
		
		if (stack.getItem() == WinterItems.santa_legs) 
		{
			return "wc:textures/armor/santa_2.png";
		}
		return null;
	}
	
	@Override
	@Nullable
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default)
    {
		ModelBiped armorModel = null;
		if(itemStack != null){
			if(itemStack.getItem() instanceof ArmorSanta && itemStack.getItem() == WinterItems.santa_helmet){
				EntityEquipmentSlot type = ((ItemArmor)itemStack.getItem()).armorType;
				
				if(type == EntityEquipmentSlot.HEAD){
				    armorModel = Wintercraft.proxy.getArmorModel(0);
				}else{
				    armorModel = Wintercraft.proxy.getArmorModel(1);
				}
				if(armorModel != null){
					armorModel.bipedHead.showModel = (armorSlot.getSlotIndex() == 0);
					armorModel.isSneak = entityLiving.isSneaking();
					armorModel.isRiding = entityLiving.isRiding();
					armorModel.isChild = entityLiving.isChild();
					
					return armorModel;
				}
			}		
		}
		return null;
	}
}
