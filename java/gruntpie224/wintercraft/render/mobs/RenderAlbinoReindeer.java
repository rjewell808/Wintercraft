package gruntpie224.wintercraft.render.mobs;


import org.lwjgl.opengl.GL11;

import gruntpie224.wintercraft.entity.monster.EntityAlbinoReindeer;
import gruntpie224.wintercraft.render.models.ModelReindeer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;

public class RenderAlbinoReindeer extends RenderLiving {

	protected ModelReindeer model;
	
	 public RenderAlbinoReindeer(ModelBase par1ModelBase, float par3)
	    {	
		super(Minecraft.getMinecraft().getRenderManager(),par1ModelBase, par3);
		model = ((ModelReindeer)mainModel);
		
	}
	
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityAlbinoReindeer)par1EntityLivingBase, par2);
    }
	
    protected void scaleSpider(EntityAlbinoReindeer par1EntityCaveSpider, float par2)
    {
        GL11.glScalef(2.0F, 2.0F, 2.0F);
    }
	
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("wc:textures/models/albinoReindeer.png");
	}

}