package gruntpie224.wintercraft.render.mobs;

import gruntpie224.wintercraft.entity.passive.EntitySnowMan;
import gruntpie224.wintercraft.render.models.ModelSnowManPet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class RenderSnowManPet extends RenderLiving {

	protected ModelSnowManPet model;
	
	public RenderSnowManPet(ModelBase par1ModelBase, float par2){
		super(Minecraft.getMinecraft().getRenderManager(),par1ModelBase, par2);
		model = ((ModelSnowManPet)mainModel);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("wc:textures/models/snowManPet.png");
	}

}