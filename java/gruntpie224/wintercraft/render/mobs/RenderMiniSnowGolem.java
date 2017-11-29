package gruntpie224.wintercraft.render.mobs;

import gruntpie224.wintercraft.entity.monster.EntityMiniSnowGolem;
import gruntpie224.wintercraft.render.models.ModelMiniSnowGolem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;


public class RenderMiniSnowGolem extends RenderLiving {

	protected ModelMiniSnowGolem model;
	
	public RenderMiniSnowGolem(ModelBase par1ModelBase, float par2){
		super(Minecraft.getMinecraft().getRenderManager(),par1ModelBase, par2);
		model = ((ModelMiniSnowGolem)mainModel);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("wc:textures/models/miniSnowGolem.png");
	}

}