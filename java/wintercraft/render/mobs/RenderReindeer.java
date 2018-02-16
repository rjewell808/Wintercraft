package wintercraft.render.mobs;


import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

public class RenderReindeer extends RenderLiving {

	private static final ResourceLocation saddledPigTextures = new ResourceLocation("wintercraft:textures/models/reindeer_saddle.png");
    private static final ResourceLocation pigTextures = new ResourceLocation("textures/entity/pig/pig.png");
	protected ModelReindeer model;
	
	 public RenderReindeer(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
	    {	
		super(par1ModelBase, par3);
		model = ((ModelReindeer)mainModel);
		this.setRenderPassModel(par2ModelBase);
		
	}
	
	public void renderGoblin(EntityReindeer entity, double par2, double par4, double par6, float par8, float par9){
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	protected int renderSaddledReindeer(EntityReindeer par1EntityPig, int par2, float par3)
    {
        if (par2 == 0 && par1EntityPig.getSaddled())
        {
            this.bindTexture(saddledPigTextures);
            return 1;
        }
        else
        {
            return -1;
        }
    }
	
	 protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3)
	    {
	        return this.renderSaddledReindeer((EntityReindeer)par1EntityLivingBase, par2, par3);
	    }

	
	public void doRenderLiving(EntityLiving par1EntityLiving, double par2, double par4, double par6, float par8, float par9){
		renderGoblin((EntityReindeer)par1EntityLiving, par2, par4, par6, par8, par9);
	}
	
	@Override
	public void doRender(Entity entity, double d0, double d1, double d2,float f, float f1) 
	{
		renderGoblin((EntityReindeer)entity, d0, d1, d2, f, f1);
	}

	
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return new ResourceLocation("Wintercraft:textures/models/reindeer.png");
	}

}