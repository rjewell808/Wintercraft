package gruntpie224.wintercraft.items;

import java.util.List;

import javax.annotation.Nullable;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmorAntlers extends ItemArmor{
	public ArmorAntlers(String name, ArmorMaterial material, int par3, EntityEquipmentSlot par4)
	{
		super(material, par3, par4);
		this.setCreativeTab(Wintercraft.wcTab);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
    {
		if (stack.getItem() == WinterItems.antlers) 
		{
			return "wc:textures/models/antlers.png";
		}
		return null;
	}
	
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add("\u00a77\u00a7oWear them on your head!");
    }
	
	@Override
	@Nullable
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, net.minecraft.client.model.ModelBiped _default)
    {
		ModelBiped armorModel = null;
		if(itemStack != null){
			if(itemStack.getItem() instanceof ArmorAntlers){
				EntityEquipmentSlot type = ((ItemArmor)itemStack.getItem()).armorType;
				
				if(type == EntityEquipmentSlot.HEAD){
				    armorModel = Wintercraft.proxy.getArmorModel(2);
				}else{
				    armorModel = Wintercraft.proxy.getArmorModel(3);
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
