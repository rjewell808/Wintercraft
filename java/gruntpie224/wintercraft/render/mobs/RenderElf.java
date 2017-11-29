package gruntpie224.wintercraft.render.mobs;

import gruntpie224.wintercraft.entity.passive.EntityElf;
import gruntpie224.wintercraft.render.models.ModelElf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;


public class RenderElf extends RenderLiving {

	protected ModelElf model;
	
	public RenderElf(ModelBase par1ModelBase, float par2){
		super(Minecraft.getMinecraft().getRenderManager(),par1ModelBase, par2);
		model = ((ModelElf)mainModel);
		
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("wc:textures/models/elf.png");
	}

}