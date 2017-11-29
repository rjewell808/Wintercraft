package gruntpie224.wintercraft.items;

import gruntpie224.wintercraft.Wintercraft;
import gruntpie224.wintercraft.helper.ConnectionHandler;
import gruntpie224.wintercraft.helper.config.ConfigHandler;
import gruntpie224.wintercraft.init.WinterItems;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ArmorSantaHat extends ItemArmor {

	public ArmorSantaHat(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
		super(par2EnumArmorMaterial, par3, par4);
		this.setCreativeTab(Wintercraft.wintercraftTab);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() == WinterItems.santa_helmet) {
			if(ConnectionHandler.userSpecial && ConfigHandler.winterBetaHat){
				return "wc:textures/models/santaHat_2.png";
			}else{
				return "wc:textures/models/santaHat.png";
			}
		}
		return null;
	}
	    

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
	
		ModelBiped armorModel = null;
		if(itemStack != null)
		{
			if(itemStack.getItem() instanceof ArmorSantaHat)
			{
				int type = ((ItemArmor)itemStack.getItem()).armorType;
				
				if(type == 1 || type == 3)
				{
				    armorModel = Wintercraft.proxy.getArmorModel(0);
				}
				else
				{
				    armorModel = Wintercraft.proxy.getArmorModel(1);
				}
				
				if(armorModel != null)
				{
					armorModel.bipedHead.showModel = armorSlot == 0;
					armorModel.isSneak = entityLiving.isSneaking();
					armorModel.isRiding = entityLiving.isRiding();
					armorModel.isChild = entityLiving.isChild();
					armorModel.heldItemRight = entityLiving.getEquipmentInSlot(0) != null ? 1 :0;
					
					if(entityLiving instanceof EntityPlayer)
					{
						armorModel.aimedBow =((EntityPlayer)entityLiving).getItemInUseDuration() > 2;
					}
					
					return armorModel;
				}
			}	
		}
		return null;
	}
}

