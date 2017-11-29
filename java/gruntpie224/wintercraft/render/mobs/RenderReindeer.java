package gruntpie224.wintercraft.render.mobs;


import gruntpie224.wintercraft.entity.passive.EntityReindeer;
import gruntpie224.wintercraft.render.mobs.layer.LayerSaddle;
import gruntpie224.wintercraft.render.models.ModelReindeer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderReindeer extends RenderLiving {
	
	private static final ResourceLocation mobTextures = new ResourceLocation("wc:textures/models/reindeer.png");
	
	public RenderReindeer(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {	
		super(Minecraft.getMinecraft().getRenderManager(),par1ModelBase, par3);
		this.addLayer(new LayerSaddle(this));
	}
	
	protected ResourceLocation func_180583_a(EntityReindeer p_180583_1_)
    {
        return mobTextures;
    }
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return this.func_180583_a((EntityReindeer)entity);
	}

}