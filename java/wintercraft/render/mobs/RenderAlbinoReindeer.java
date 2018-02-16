package wintercraft.render.mobs;


import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import wintercraft.entity.monster.EntityAlbinoReindeer;
import wintercraft.entity.passive.EntityPolarBear;
import wintercraft.entity.passive.EntityReindeer;
import wintercraft.render.models.ModelPolarBear;
import wintercraft.render.models.ModelReindeer;
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
		super(par1ModelBase, par3);
		model = ((ModelReindeer)mainModel);
		
	}
	
	public void renderGoblin(EntityAlbinoReindeer entity, double par2, double par4, double par6, float par8, float par9){
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
    {
        this.scaleSpider((EntityAlbinoReindeer)par1EntityLivingBase, par2);
    }
	
    protected void scaleSpider(EntityAlbinoReindeer par1EntityCaveSpider, float par2)
    {
        GL11.glScalef(2.0F, 2.0F, 2.0F);
    }

	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
		renderGoblin((EntityAlbinoReindeer)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2,float f, float f1) 
	{
		renderGoblin((EntityAlbinoReindeer)entity, d0, d1, d2, f, f1);
	}

	
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("Wintercraft:textures/models/albinoReindeer.png");
	}

}